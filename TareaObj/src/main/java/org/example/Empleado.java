package org.example;

/**
 * Representa a un empleado dentro de una organización.
 * Implementa la interfaz {@link Invitable} para poder ser invitado a reuniones.
 *
 * @author Leonardo Guerrero
 */

public class Empleado implements Invitable{

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;

    /**
     * Crea una nueva instancia de {@code Empleado} con los datos especificados.
     *
     * @param nombre el nombre del empleado.
     * @param apellidos los apellidos del empleado.
     * @param id el identificador único del empleado.
     * @param correo el correo electrónico del empleado.
     * @param departamento el departamento al que pertenece el empleado.
     */

    public Empleado(String nombre, String apellidos, String id, String correo, String departamento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.correo = correo;
        this.departamento = departamento;
    }

    /**
     * Devuelve el ID del empleado.
     *
     * @return el ID.
     */

    public String getId(){
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id el nuevo ID.
     */

    public void setId(String id){
        this.id = id;
    }

    /**
     * Devuelve los apellidos del empleado.
     *
     * @return los apellidos.
     */

    public String getApellidos(){
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos los nuevos apellidos.
     */

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return el nombre.
     */

    public String getNombre(){
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre el nuevo nombre.
     */

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo electrónico del empleado.
     *
     * @return el correo.
     */

    public String getCorreo(){
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo el nuevo correo.
     */

    public void setCorreo(String correo){
        this.correo = correo;
    }

    /**
     * Devuelve el nombre del departamento al que pertenece el empleado.
     *
     * @return el departamento.
     */

    public String getDepartamento(){
        return departamento;
    }

    /**
     * Establece el departamento del empleado.
     *
     * @param departamento el nuevo departamento.
     */

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    /**
     * Devuelve un String con los datos del empleado.
     *
     * @return los datos del empleado como String.
     */

    @Override
    public String toString(){
        return "\n Empleado: " + nombre + " " + apellidos + " id: " + id + " correo: " + correo + " Dpto: " + departamento ;
    }

    /**
     * Muestra un mensaje diciendo que el empleado ha sido invitado a una reunión.
     */

    @Override
    public void invitar(){
        System.out.println("El empleado " + nombre + " " + apellidos + " de id: " + id + " ha sido invitado a la reunión");
    }

}
