package org.example;

/**
 * Excepción verificada que se lanza cuando se intenta crear o procesar
 * una reunión con un tipo no válido.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class TipoReunionInvalidoException extends Exception {

    /**
     * Crea una nueva instancia de {@code TipoReunionInvalidoException}
     * con un mensaje de error predeterminado.
     */

    public TipoReunionInvalidoException() {
        super("Error, tipo de reunión no válido.");
    }
}
