package org.example;

import java.time.Duration;

public class ReunionPresencial extends Reunion{

    private String sala;
    private int tipoInt;

    public ReunionPresencial(String salaReunion,Empleado organizador, String fechaReunion, int tiempoReunion, int tipo) throws TipoReunionInvalidoException{
        super(organizador,fechaReunion,tiempoReunion, tipo, salaReunion);
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

        this.sala = salaReunion;
    }

    public String devolverN(){
        if (tipoInt != -1) {
            return "Reunion " + TipoReunion.obtenerTipo(tipoInt) + " en sala: " + sala;
        } else {
            return "Reunion de tipo inválido" ;
        }
    }
}
