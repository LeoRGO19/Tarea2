package org.example;

public class TipoReunionInvalidoException extends Exception {
    public TipoReunionInvalidoException() {
        super("Error, tipo de reunión no válido");
    }
}
