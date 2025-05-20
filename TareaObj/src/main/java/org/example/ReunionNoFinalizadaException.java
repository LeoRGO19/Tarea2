package org.example;

public class ReunionNoFinalizadaException extends RuntimeException {
    public ReunionNoFinalizadaException() {
        super("Reunion no finalizada aun.");
    }
}
