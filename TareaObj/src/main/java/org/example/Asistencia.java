package org.example;

/**
 * Representa la asistencia de una persona que implementa la interfaz {@code Invitable}.
 *
 * @author Leonardo Guerrero
 */

public class Asistencia{
    private Invitable inv;

    /**
     * Crea una nueva instancia de {@code Asistencia} con el invitado especificado.
     *
     * @param inv la persona que asiste, debe implementar la interfaz {@code Invitable}.
     */

    public Asistencia(Invitable inv) {
        this.inv = inv;
    }

    /**
     * Obtiene el asistente registrado.
     *
     * @return el objeto {@code Invitable} que representa al asistente.
     */

    public Invitable getAsistente(){
        return inv;
    }

    /**
     * Establece o actualiza el asistente.
     *
     * @param e el nuevo objeto {@code Invitable} que representará al asistente.
     */

    public void setAsistente(Invitable e){
        this.inv = e;
    }



    /**
     * Devuelve un string para comprobar asistencia de quién se registró.
     *
     * @return una cadena con el formato "Asistencia de: [nombre]", donde [nombre] es el nombre del asistente.
     */

    @Override
    public String toString() {
        return "Asistencia de: " + inv.getNombre();
    }
}
