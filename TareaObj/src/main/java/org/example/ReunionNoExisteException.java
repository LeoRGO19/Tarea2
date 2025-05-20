package org.example;

public class ReunionNoExisteException extends RuntimeException {
    public ReunionNoExisteException() {
        super("Error: la reunión no se creó.");
    }
}
