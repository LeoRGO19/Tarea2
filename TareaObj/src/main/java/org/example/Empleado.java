package org.example;

public class Empleado implements Invitable{

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;
    public Empleado(String nombre, String apellidos, String id, String correo, String departamento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.correo = correo;
        this.departamento = departamento;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    @Override
    public String toString(){
        return "Empleado: " + nombre + " " + apellidos + " id: " + id + " correo: " + correo + " Dpto: " + departamento + "\n";
    }

    @Override
    public void invitar(){
        System.out.println("El empleado " + nombre + " " + apellidos + " de id: " + id + " ha sido invitado a la reunión");
    }
}
