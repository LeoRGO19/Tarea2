package org.example;

public class Nota {

    private String contenido;

    public Nota(String oracion1){
        this.contenido = oracion1;
    }
    public void setNota (String oracion){
        this.contenido = oracion;
    }
    public String getNota(){
        return contenido;
    }

    @Override
    public String toString() {
        return "Contenido de nota: "+ contenido;
    }
}
