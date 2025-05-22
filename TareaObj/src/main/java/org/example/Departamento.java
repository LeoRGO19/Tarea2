package org.example;

import java.util.ArrayList;

/**
 * Representa un departamento que puede ser invitado a una reunión
 * y contiene una lista de empleados.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;

    /**
     * Crea un nuevo departamento con nombre especificado.
     *
     * @param nombreDepartamento el nombre del departamento.
     */

    public Departamento(String nombreDepartamento){
        this.empleados = new ArrayList<>();
        this.nombre = nombreDepartamento;
    }

    /**
     * Establece un nombre para el departamento.
     *
     * @param nuevo el nuevo nombre del departamento.
     */

    public void setNombre(String nuevo){
        this.nombre = nuevo;
    }
    @Override


    public String getNombre(){
        return nombre;
    }

    /**
     * Método para obtener la cantidad de empleados en el departamento.
     *
     * @return el número de empleados.
     */

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Método para agregar un empleado al departamento.
     *
     * @param e el empleado a agregar.
     */

    public void addEmpleado(Empleado e){
        empleados.add(e);
    }

    /**
     * Obtiene la lista de empleados que pertenecen al departamento.
     *
     * @return una lista de objetos {@code Empleado}.
     */

    public ArrayList<Empleado> obtenerListaDepartamento(){
        return empleados;
    }

    /**
     * Invita al departamento a una reunión, y extiende la invitación a cada uno de sus empleados.
     */

    @Override
    public void invitar() {
        System.out.println("Departamento " + nombre + " ha sido invitado a la reunión: \n");
        for (Empleado e : empleados) {
            e.invitar();
        }
    }

    /**
     * toString para observar que devuelva todo correctamente.
     *
     * @return una cadena con el nombre del departamento, la cantidad de empleados
     * y la lista de empleados.
     */

    @Override
    public String toString() {
        return "Departamento: " + nombre + "\nTotal de empleados: " + empleados.size() + "\n" + empleados;
    }
}
