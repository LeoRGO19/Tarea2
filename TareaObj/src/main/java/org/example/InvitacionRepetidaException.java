package org.example;

public class InvitacionRepetidaException extends Exception {
    public InvitacionRepetidaException(String nombre) {
        super("La persona " + nombre + " ya ha sido invitada");
    }
}
