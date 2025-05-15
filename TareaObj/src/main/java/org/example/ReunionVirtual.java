package org.example;

public class ReunionVirtual extends Reunion{

    private String enlace;

    public ReunionVirtual(String enlaceReunion,Empleado organizador, String fechaReunion, int tiempoReunion){
        super(organizador,fechaReunion,tiempoReunion);
        this.enlace = enlaceReunion;
    }
    public String devolverN(){
        return "El enlace es: " + enlace;
    }


}
