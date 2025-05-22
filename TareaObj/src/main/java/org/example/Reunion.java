package org.example;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ArrayList;
import java.time.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Clase abstracta que representa una reunión genérica. Contiene lógica común
 * para reuniones presenciales y virtuales, como la gestión de invitados,
 * asistencias, ausencias, retrasos y generación de informes.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public abstract class Reunion {
    //private Date fecha;
    private LocalDateTime horaPrevista;
    private LocalDateTime duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private ArrayList<Invitacion> invitaciones; //Lista de invitaciones.
    private ArrayList<Invitable> invitados;   //Lista invitados
    private ArrayList<Asistencia> asistentes; //Lista de asistentes
    private ArrayList<Invitable> ausentes;    //Lista de ausentes
    private ArrayList<Nota> notas;
    private Empleado organizador;
    private int tipo;
    private String sala_o_enlace;
    private LocalDate fechalocal;
    private boolean finalizada = true;
    private boolean iniciada = false;

    /**
     * Constructor para crear una reunión.
     *
     * @param organizador el empleado que organiza la reunión.
     * @param fechaReunion la fecha y hora previstas en formato "yyyy-MM-ddTHH:mm".
     * @param tiempoReunion duración estimada en minutos.
     * @param tipo tipo de reunión.
     * @param sala_enlace nombre de sala o enlace (según sea presencial o virtual).
     */

    public Reunion(Empleado organizador, String fechaReunion, int tiempoReunion, int tipo, String sala_enlace){
        this.sala_o_enlace = sala_enlace;
        this.organizador = organizador;
        this.tipo = tipo;
        this.horaPrevista = LocalDateTime.parse(fechaReunion);
        this.duracionPrevista = horaPrevista.plus(Duration.ofMinutes(tiempoReunion));
        this.fechalocal =  LocalDate.parse(fechaReunion.substring(0, 10));
        //this.fecha = Date.from(horaPrevista.atZone(ZoneId.systemDefault()).toInstant());
        invitados = new ArrayList<>();
        asistentes = new ArrayList<>();
        notas = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.ausentes = new ArrayList<>();
        /*
        this.fechalocal = fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();*/
    }

    /**
     * Devuelve la fecha de la reunión en formato yyyy-MM-dd.
     *
     * @return fecha establecida.
     */

    public String getFecha(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechalocal.format(formatter);
    }

    /**
     * Establece una nueva fecha para la reunión.
     * @param fecha nueva fecha en formato yyyy-MM-dd.
     */

    public void setFecha(String fecha){
        this.fechalocal =  LocalDate.parse(fecha.substring(0, 10));;
    }

    /**
     * Agrega un invitado a la reunión. También maneja departamentos.
     * @param invitado objeto que implementa la interfaz {@code Invitable}.
     * @throws InvitacionRepetidaException si el invitado ya está registrado.
     */

    public void agregarInvitado(Invitable invitado) throws InvitacionRepetidaException{
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                if (invitado instanceof Departamento) {
                    Departamento departamento = (Departamento) invitado;
                    for(Empleado e: (departamento.obtenerListaDepartamento())){
                        if (invitados.contains(e)) {
                            try {
                                throw new InvitacionRepetidaException(e.getNombre());
                            } catch (InvitacionRepetidaException ex) {
                                System.out.println(ex.getMessage());
                            }
                        } else {
                            invitados.add(e);
                            invitaciones.add(new Invitacion(Instant.now(), e));
                            ausentes.add(e);
                            e.invitar();
                        }
                    }
                } else {
                    if (invitados.contains(invitado)) {
                        try {
                            throw new InvitacionRepetidaException(invitado.getNombre());
                        } catch (InvitacionRepetidaException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        invitados.add(invitado);
                        invitaciones.add(new Invitacion(Instant.now(), invitado));
                        ausentes.add(invitado);
                        invitado.invitar();
                    }
                }
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Devuelve la lista de invitados de la reunión.
     * @return lista de invitados o null si la reunión es inválida.
     */

    public ArrayList<Invitable> getInvitados() {
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                return invitados;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Registra un asistente, marcando si llegó con retraso.
     * @param invitado persona invitada.
     * @param tiempo_Entrada instante en que llegó.
     */

    public void agregarAsistente(Invitable invitado,Instant tiempo_Entrada){
        try{
            if (horaInicio ==null) {
                throw new ReunionNoIniciadaException();
            }
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                if (!invitados.contains(invitado)) {
                    System.out.println("El invitado " + invitado.getNombre() + " no está registrado como invitado en la reunión.");
                } else {
                    Asistencia persona;
                    if (tiempo_Entrada.isAfter(horaInicio.plus(Duration.ofMinutes(10)))){
                        persona = new Retraso(invitado, tiempo_Entrada);
                    }
                    else {
                        persona = new Asistencia(invitado);
                    }
                    asistentes.add(persona);
                    ausentes.remove(invitado);
                }
            }
        }catch (ReunionNoIniciadaException | ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Obtiene la lista de asistentes.
     *
     * @return lista de asistentes.
     */

    public ArrayList<Invitable> obtenerAsistencias() {
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                ArrayList<Invitable> presentes = new ArrayList<>();
                for (Asistencia a : asistentes) {
                    presentes.add(a.getAsistente());
                }
                return presentes;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }

    /**
     * Devuelve la lista de ausentes.
     *
     * @return La lista de ausentes.
     */

    public ArrayList<Invitable> obtenerAusencias(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                return ausentes;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }


    /**
     * Devuelve los asistentes que llegaron con retraso.
     *
     * @return Lista de asistentes con retraso.
     */

    public ArrayList<Invitable> obtenerRetrasos(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                ArrayList<Invitable> atrasados = new ArrayList<>();
                for (Asistencia a : asistentes){
                    if (a instanceof Retraso){
                        atrasados.add(a.getAsistente());
                    }
                }
                return atrasados;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Devuelve el total de asistentes registrados.
     *
     * @return Cantidad de asistentes.
     */

    public int obtenerTotalAsistencia(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                return asistentes.size();
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return -1;
        }

    }

    /**
     * Devuelve el porcentaje de asistencia respecto a los invitados.
     *
     * @return porcentaje (%) de asistencia de los invitados.
     */

    public float obtenerPorcentajeAsistencia(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                System.out.println(asistentes);
                System.out.println(invitados);
                return ((float)asistentes.size() /(float)invitados.size())*100; //* puse por 100 por el porcentaje *
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return -1;
        }

    }


    /**
     * Calcula la duración real de la reunión en segundos.
     *
     * @param inicio Tiempo de inicio de la reunión.
     * @param Final Tiempo de Finalización de la reunión
     *
     * @return Tiempo real de la reunión.
     */

    public float calcularTiempoReal(Instant inicio, Instant Final){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            }
            if (horaFin ==null){
                throw new ReunionNoFinalizadaException();
            }

            else {
                if (horaInicio != null && horaFin != null) {
                    Duration diferencia = Duration.between(inicio, Final); //Me falta ver como poner tiempos especificos
                    return (float) diferencia.toSeconds();
                }
                return 0;
            }
        }catch (ReunionNoExisteException | ReunionNoFinalizadaException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    /**
     * Marca la reunión como iniciada.
     */

    public void iniciar(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                finalizada = false;
                horaInicio = Instant.now();
                iniciada = true;


            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Marca la reunión como finalizada.
     * @param horafinal instante final de la reunión.
     */

    public void finalizar(Instant horafinal){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                iniciada = false;
                horaFin = horafinal;
                finalizada = true;

            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }


    /**
     * Devuelve un String con la reunión y su organizador.
     */

    @Override
    public String toString() {
        if (organizador != null) {
            return devolverN() + " organizada por: " + organizador.getNombre();
        }
        else{
            return "Reunion inválida";
        }
    }

    /**
     * Método abstracto para obtener una descripción de la reunión.
     *
     * @return Retornará con polimorfismo sala o enlace, dependiendo el tipo de reunión.
     */

    public String devolverN(){
        return null;
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param e Nota y su contenido.
     */

    public void addNota(Nota e){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                notas.add(e);
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Genera un informe detallado de la reunión en un archivo de texto.
     * @param rutaArchivo ubicación del archivo de salida.
     * @throws ReunionNoIniciadaException si la reunión no ha comenzado.
     */

    public void generarInforme(String rutaArchivo) throws ReunionNoIniciadaException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (BufferedWriter file = new BufferedWriter(new FileWriter(rutaArchivo))) {
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null){
                throw new ReunionNoExisteException();
            }
            file.write("===== INFORME DE REUNIÓN =====\n");
            file.write("Fecha prevista: " + horaPrevista.toLocalDate() + "\n");
            file.write("Hora prevista de inicio: " + horaPrevista.toLocalTime() + "\n");
            file.write("Hora prevista de fin: " + duracionPrevista.toLocalTime() + "\n");
            file.write("\nFecha actual: " + this.getFecha() + "\n\n");

            if (horaInicio != null){
                LocalTime horaInicioLocal = horaInicio.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
                String inicio = horaInicioLocal.format(formatter);
                file.write("Hora de inicio real: " + inicio + "\n");
            }
            else{
                throw new ReunionNoIniciadaException();
            }
            if (finalizada == true && horaFin != null) {
                LocalTime horaFinalLocal = horaFin.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
                String fin = horaFinalLocal.format(formatter);
                Duration duracionReal = Duration.between(horaInicio, horaFin);
                file.write("Hora de fin real: " + fin + "\n");
                file.write("Duración real: " + duracionReal.toHours() + " horas, "+ duracionReal.toMinutesPart() +" minutos y " + duracionReal.toSecondsPart() + " segundos \n");
            }

            file.write("Tipo de reunión: " + TipoReunion.obtenerTipo(tipo) + "\n");

            if (this instanceof ReunionPresencial) {
                file.write("Sala: " + sala_o_enlace + "\n");
            } else if (this instanceof ReunionVirtual) {
                file.write("Enlace: " + sala_o_enlace + "\n");
            }

            file.write("\n--- Participantes ---\n");
            for (Asistencia a : asistentes) {
                String tipoAsistencia;
                if(a instanceof Retraso) {
                    tipoAsistencia = " (Con retraso)" + ((Retraso) a).getHora();
                } else {
                    tipoAsistencia = "";
                }
                file.write("- " + a.getAsistente().getNombre() + tipoAsistencia + "\n");
            }

            file.write("\n--- Ausentes ---\n");
            for (Invitable i : ausentes) {
                file.write("- " + i.getNombre() + "\n");
            }

            file.write("\n--- Notas ---\n");
            for (Nota nota : notas) {
                file.write("[" + nota.getFecha().toString() + "] " + nota.getNota() + "\n");
            }

            file.write("===============================\n");
        } catch (IOException |ReunionNoExisteException e) {
            System.err.println("Error al escribir el informe: " + e.getMessage());
        }
    }
}
