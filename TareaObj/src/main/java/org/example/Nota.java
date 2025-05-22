package org.example;

import java.time.LocalDateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Representa una nota con contenido textual y una marca de tiempo.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class Nota {
    private String contenido;
    private LocalDateTime tiempo;

    /**
     * Crea una nueva nota con el contenido y la hora especificada.
     *
     * @param oracion1 el contenido textual de la nota.
     * @param tiempo el instante en el que se crea o registra la nota.
     */

    public Nota(String oracion1, Instant tiempo){
        this.contenido = oracion1;
        this.tiempo = LocalDateTime.ofInstant(tiempo, ZoneId.systemDefault());
    }

    /**
     * Establece el contenido de la nota.
     *
     * @param oracion el nuevo contenido textual de la nota.
     */

    public void setNota (String oracion){
        this.contenido = oracion;
    }

    /**
     * Obtiene la fecha y hora de la nota en formato legible (normal).
     *
     * @return una cadena con la fecha y hora en el formato {@code "yyyy-MM-dd HH:mm:ss"}.
     */

    public String getFecha(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return tiempo.format(formatter);
    }

    /**
     * Obtiene el contenido de la nota.
     *
     * @return el contenido textual de la nota.
     */

    public String getNota(){
        return contenido;
    }

    /**
     * String que devuelve el contenido de la nota y el tiempo de la misma.
     *
     * @return una cadena que incluye el contenido de la nota y su fecha y hora.
     */

    @Override
    public String toString() {
        return "Contenido de nota: "+ contenido + " hora y fecha de la nota: " + tiempo;
    }
}
