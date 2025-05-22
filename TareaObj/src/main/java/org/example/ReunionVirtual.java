package org.example;

/**
 * Representa una reunión virtual. Extiende la clase {@link Reunion}.
 * Incluye un enlace para acceder a la reunión y validación del tipo de reunión.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class ReunionVirtual extends Reunion{

    private String enlace;
    private int tipoInt;

    /**
     * Crea una nueva instancia de {@code ReunionVirtual}.
     *
     * @param enlaceReunion el enlace virtual de la reunión.
     * @param organizador el empleado que organiza la reunión.
     * @param fechaReunion la fecha programada de la reunión en formato {@code yyyy-MM-dd HH:mm}.
     * @param tiempoReunion la duración de la reunión en minutos.
     * @param tipo el tipo de reunión.
     * @throws TipoReunionInvalidoException si el tipo de reunión no es válido.
     */

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

    /**
     * Devuelve una descripción de la reunión virtual indicando el tipo y el enlace si es válido.
     *
     * @return un String con la información de la reunión o un mensaje de error si el tipo es inválido.
     */

    public String devolverN(){
        if (tipoInt != -1) {
            return "Reunion " + TipoReunion.obtenerTipo(tipoInt) + " en enlace: " + enlace;
        } else {
            return "Reunion de tipo inválido" ;
        }
    }


}
