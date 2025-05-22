package org.example;

/**
 * Representa a una persona externa a la organización que puede ser invitada a reuniones.
 * Implementa la interfaz {@link Invitable}.
 *
 * @author Leonardo Guerrero.
 */

public class PersonaExterna implements Invitable{
    private String nombre;
    private String apellidos;
    private String correo;

    /**
     * Crea una nueva instancia de {@code PersonaExterna} con los datos especificados.
     *
     * @param nombre el nombre de la persona.
     * @param apellidos los apellidos de la persona.
     * @param correo el correo electrónico de la persona.
     */

    public PersonaExterna(String nombre, String apellidos, String correo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Envía una invitación a la persona externa, mostrando un mensaje por consola.
     */

    @Override
    public void invitar() {
        System.out.println("La invitación a sido enviada a: " + nombre + " " + apellidos + " " + " correo: " + correo);;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre el nuevo nombre.
     */

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos los nuevos apellidos.
     */

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo el nuevo correo.
     */

    public void setCorreo(String correo){
        this.correo = correo;
    }

    /**
     * Devuelve los apellidos de la persona.
     *
     * @return los apellidos.
     */

    public String getApellidos(){
        return apellidos;
    }

    /**
     * Devuelve el correo electrónico de la persona.
     *
     * @return el correo.
     */

    public String getCorreo(){
        return correo;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return el nombre.
     */

    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve un String con los datos de la persona externa.
     *
     * @return una cadena con los datos de la persona.
     */

    @Override
    public String toString(){
        return "Persona de nombre:" + nombre + " apellidos: " + apellidos + " con el correo: " + correo;
    }
}
