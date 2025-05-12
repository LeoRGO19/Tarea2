package org.example;

public class ReunionVirtual extends Reunion{

    private String enlace;

    public ReunionVirtual(String enlaceReunion){
        this.enlace = enlaceReunion;
    }
    public String devolverN(){
        return "El enlace es: " + enlace;
    }


}
