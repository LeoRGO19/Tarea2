package org.example;

public class ReunionPresencial extends Reunion{

    private String sala;

    public ReunionPresencial(String salaReunion){
        this.sala = salaReunion;
    }


    public String devolverN(){
        return "La sala es: " + sala;
    }
}
