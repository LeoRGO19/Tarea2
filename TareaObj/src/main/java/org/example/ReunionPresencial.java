package org.example;

import java.time.Duration;

/**
 * Representa una reunión presencial. Extiende la clase {@link Reunion}.
 * Incluye la sala donde se llevará a cabo la reunión y validación del tipo.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class ReunionPresencial extends Reunion{

    private String sala;
    private int tipoInt;

    /**
     * Crea una nueva instancia de {@code ReunionPresencial}.
     *
     * @param salaReunion el nombre o identificador de la sala donde se realizará la reunión.
     * @param organizador el empleado que organiza la reunión.
     * @param fechaReunion la fecha programada de la reunión en formato {@code yyyy-MM-dd HH:mm}.
     * @param tiempoReunion la duración de la reunión en minutos.
     * @param tipo el tipo de reunión representado por un número entero.
     * @throws TipoReunionInvalidoException si el tipo de reunión no es válido.
     */

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

    /**
     * Devuelve una descripción de la reunión presencial indicando el tipo y la sala si es válido.
     *
     * @return un String con la información de la reunión o un mensaje de error si el tipo es inválido.
     */

    public String devolverN(){
        if (tipoInt != -1) {
            return "Reunion " + TipoReunion.obtenerTipo(tipoInt) + " en sala: " + sala;
        } else {
            return "Reunion de tipo inválido" ;
        }
    }
}
