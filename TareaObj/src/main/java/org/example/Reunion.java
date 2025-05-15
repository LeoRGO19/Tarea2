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

    public Reunion(Empleado organizador, String fechaReunion, int tiempoReunion){
        this.organizador = organizador;
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


    public void agregarInvitado(Invitable invitado){
        invitados.add(invitado);                                     //Agrega el invitado a la lista.
        invitaciones.add(new Invitacion(Instant.now(), invitado));    //agrega la invitacion a la lista.
        invitado.invitar();                                           //manda la invitacion
        ausentes.add(invitado);
    }
    public ArrayList<Invitable> getInvitados() {
        return invitados;
    }
    public void agregarAsistente(Invitable invitado,Instant tiempo_Entrada) {
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


    public ArrayList<Invitable> obtenerAsistencias() {
        ArrayList<Invitable> presentes = new ArrayList<>();
        for (Asistencia a : asistentes) {
            presentes.add(a.getEmpleado());
        }
        return presentes;
    }
    public ArrayList<Invitable> obtenerAusencias(){
        return ausentes;
    }

    public ArrayList<Invitable> obtenerRetrasos(){
        ArrayList<Invitable> atrasados = new ArrayList<>();
        for (Asistencia a : asistentes){
            if (a instanceof Retraso){
                atrasados.add(a.getEmpleado());
            }
        }
        return atrasados;
    }
    public int obtenerTotalAsistencia(){
        return asistentes.size();
    }
    public float obtenerPorcentajeAsistencia(){
        System.out.println(asistentes);
        System.out.println(invitados);
        return ((float)asistentes.size() /(float)invitados.size())*100; //* puse por 100 por el porcentaje *
    }
    public float calcularTiempoReal(Instant inicio, Instant Final){
        if (horaInicio != null && horaFin != null) {
            Duration diferencia = Duration.between(inicio, Final); //Me falta ver como poner tiempos especificos
            return (float) diferencia.toSeconds();
        }
        return 0;
    }
    public void iniciar(){
        horaInicio = Instant.now();
    }
    public void finalizar(){
        horaFin = Instant.now();
    }
    @Override
    public String toString() {
        return devolverN();
    }
    public String devolverN(){
        return null;
    }

}
