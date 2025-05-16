package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.attribute.RuntimeInvisibleAnnotationsAttribute;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;
import java.time.*;

public abstract class Reunion {
    private Date fecha;
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

    public Reunion(Empleado organizador, String fechaReunion, int tiempoReunion, int tipo){
        this.organizador = organizador;
        this.tipo = tipo;
        this.horaPrevista = LocalDateTime.parse(fechaReunion);
        this.duracionPrevista = horaPrevista.plus(Duration.ofMinutes(tiempoReunion));
        System.out.println(horaPrevista);
        System.out.println(duracionPrevista);
        fecha = new Date();
        invitados = new ArrayList<>();
        asistentes = new ArrayList<>();
        notas = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.ausentes = new ArrayList<>();
        LocalDate fechalocal = fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


    public void agregarInvitado(Invitable invitado) throws InvitacionRepetidaException{
        try{
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Invitable> obtenerAsistencias() {
        try{
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
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
            if (TipoReunion.obtenerTipo(tipo) == null) {
                throw new ReunionNoExisteException();
            } else {
                if (horaInicio != null && horaFin != null) {
                    Duration diferencia = Duration.between(inicio, Final); //Me falta ver como poner tiempos especificos
                    return (float) diferencia.toSeconds();
                }
                return 0;
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    public void iniciar(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null) {
                throw new ReunionNoExisteException();
            } else {
                horaInicio = Instant.now();
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void finalizar(){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null) {
                throw new ReunionNoExisteException();
            } else {
                horaFin = Instant.now();
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public String toString() {
        return devolverN() + " organizada por: " + organizador.getNombre();
    }
    public String devolverN(){
        return null;
    }
    public void addNota(Nota e){
        try{
            if (TipoReunion.obtenerTipo(tipo) == null) {
                throw new ReunionNoExisteException();
            } else {
                notas.add(e);
            }
        }catch (ReunionNoExisteException ex){
            System.out.println(ex.getMessage());
        }
    }

}
