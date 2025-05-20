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
    public String getFecha(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechalocal.format(formatter);
    }
    public void setFecha(String fecha){
        this.fechalocal =  LocalDate.parse(fecha.substring(0, 10));;
    }
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

    public ArrayList<Invitable> obtenerAsistencias() {
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                ArrayList<Invitable> presentes = new ArrayList<>();
                for (Asistencia a : asistentes) {
                    presentes.add(a.getEmpleado());
                }
                return presentes;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }
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

    public ArrayList<Invitable> obtenerRetrasos(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null||sala_o_enlace == null||organizador == null) {
                throw new ReunionNoExisteException();
            } else {
                ArrayList<Invitable> atrasados = new ArrayList<>();
                for (Asistencia a : asistentes){
                    if (a instanceof Retraso){
                        atrasados.add(a.getEmpleado());
                    }
                }
                return atrasados;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
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
    @Override
    public String toString() {
        if (organizador != null) {
            return devolverN() + " organizada por: " + organizador.getNombre();
        }
        else{
            return "Reunion inválida";
        }
    }
    public String devolverN(){
        return null;
    }
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
                file.write("- " + a.getEmpleado().getNombre() + tipoAsistencia + "\n");
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
