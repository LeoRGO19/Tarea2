package org.example;

import java.util.Date;
import java.util.List;
import java.time.*;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    public Reunion(){
        fecha = new Date();
        LocalDate fechalocal = fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

    }
    public List<Asistencia> obtenerAsistencias(){
        return null;
    }
    public List<Asistencia> obtenerAusencias(){
        return null;
    }
    public List<Asistencia> obtenerRetrasos(){
        return null;
    }
    public int obtenerTotalAsistencia(){
        return 0;
    }
    public float obtenerPorcentajeAsistencia(){
        return 0;
    }
    public float calcularTiempoReal(){
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
