package org.example;

/**
 * Excepción no verificada que se lanza cuando se intenta realizar una operación
 * sobre una reunión que aún no ha sido iniciada.
 *
 * @author Francisco Fuentealba
 */

public class ReunionNoIniciadaException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code ReunionNoIniciadaException}
     * con un mensaje de error predeterminado.
     */

    public ReunionNoIniciadaException() {
        super("No se ha iniciado la reunion.");
    }
}
