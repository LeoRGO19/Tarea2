package org.example;

/**
 * Excepción no verificada que se lanza cuando se intenta acceder o procesar
 * información de una reunión que aún no ha finalizado.
 *
 * @author Francisco Fuentealba
 */

public class ReunionNoFinalizadaException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code ReunionNoFinalizadaException}
     * con un mensaje de error predeterminado.
     */

    public ReunionNoFinalizadaException() {
        super("Reunion no finalizada aun.");
    }
}
