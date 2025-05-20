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
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getCorreo(){
        return correo;
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
