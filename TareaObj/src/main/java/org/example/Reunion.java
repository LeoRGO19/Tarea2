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
    public List<Asistencia> obtenerAsistencias(){

    }
    public List<Asistencia> obtenerAusencias(){

    }
    public List<Asistencia> obtenerRetrasos(){

    }
    public int obtenerTotalAsistencia(){

    }
    public float obtenerPorcentajeAsistencia(){

    }
    public float calcularTiempoReal(){

    }
    public void iniciar(){

    }
    public void finalizar(){

    }

}
