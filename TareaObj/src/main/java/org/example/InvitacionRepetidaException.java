package org.example;

/**
 * Excepción que se lanza cuando se intenta invitar a una persona que ya ha sido invitada.
 *
 * @author Leonardo Guerrero
 */

public class InvitacionRepetidaException extends Exception {

    /**
     * Crea una nueva excepción con un mensaje que indica que la persona ya ha sido invitada.
     *
     * @param nombre el nombre de la persona que ya fue invitada.
     */

    public InvitacionRepetidaException(String nombre) {
        super("La persona " + nombre + " ya ha sido invitada");
    }
}
