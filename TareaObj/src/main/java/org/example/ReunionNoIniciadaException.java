package org.example;

public class ReunionNoIniciadaException extends RuntimeException {
    public ReunionNoIniciadaException() {
        super("No se ha iniciado la reunion.");
    }
}
