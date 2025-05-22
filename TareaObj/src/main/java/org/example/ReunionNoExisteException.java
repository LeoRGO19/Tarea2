package org.example;

/**
 * Excepción no verificada que se lanza cuando se intenta acceder a una reunión que no ha sido creada.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class ReunionNoExisteException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code ReunionNoExisteException} con un mensaje de error predeterminado.
     */

    public ReunionNoExisteException() {
        super("Error: la reunión no se creó.");
    }
}
