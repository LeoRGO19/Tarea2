package org.example;

import java.time.LocalDateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Nota {
    private String contenido;
    private LocalDateTime tiempo;

    public Nota(String oracion1, Instant tiempo){
        this.contenido = oracion1;
        this.tiempo = LocalDateTime.ofInstant(tiempo, ZoneId.systemDefault());


    }
    public void setNota (String oracion){
        this.contenido = oracion;
    }
    public String getFecha(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return tiempo.format(formatter);
    }
    public String getNota(){
        return contenido;
    }

    @Override
    public String toString() {
        return "Contenido de nota: "+ contenido + " hora y fecha de la nota: " + tiempo;
    }
}
