package org.example;


public class PersonaExterna implements Invitable{
    private String nombre;
    private String apellidos;
    private String correo;
    public PersonaExterna(String nombre, String apellidos, String correo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }
    @Override
    public void invitar() {
        System.out.println("La invitación a sido enviada a: " + nombre + " " + apellidos + " " + " correo: " + correo);;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString(){
        return "Persona de nombre:" + nombre + " apellidos: " + apellidos + " con el correo: " + correo;
    }
}
