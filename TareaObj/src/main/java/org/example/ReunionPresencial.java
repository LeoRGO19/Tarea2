package org.example;

import java.time.Duration;

public class ReunionPresencial extends Reunion{

    private String sala;

    public ReunionPresencial(String salaReunion,Empleado organizador, String fechaReunion, int tiempoReunion){
        super(organizador,fechaReunion,tiempoReunion);
        this.sala = salaReunion;
    }


    public String devolverN(){
        return "La sala es: " + sala;
    }
}
