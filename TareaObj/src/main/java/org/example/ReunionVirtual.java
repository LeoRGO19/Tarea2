package org.example;

public class ReunionVirtual extends Reunion{

    private String enlace;
    private int tipoInt;
    public ReunionVirtual(String enlaceReunion,Empleado organizador, String fechaReunion, int tiempoReunion, int tipo) throws TipoReunionInvalidoException{
        super(organizador,fechaReunion,tiempoReunion, tipo, enlaceReunion);
        try{
            TipoReunion tipoValido = TipoReunion.obtenerTipo(tipo);
            if (tipoValido == null) {
                throw new TipoReunionInvalidoException();
            }
            this.tipoInt = tipo;
        } catch (TipoReunionInvalidoException e) {
            System.err.println(e.getMessage());
            this.tipoInt = -1;
        }
        this.enlace = enlaceReunion;
    }

    public String devolverN(){
        if (tipoInt != -1) {
            return "Reunion " + TipoReunion.obtenerTipo(tipoInt) + " en enlace: " + enlace;
        } else {
            return "Reunion de tipo inválido" ;
        }
    }


}
