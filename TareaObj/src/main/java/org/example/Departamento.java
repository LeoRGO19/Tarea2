package org.example;

import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;
    public Departamento(String nombreDepartamento){
        this.empleados = new ArrayList<>();
        this.nombre = nombreDepartamento;
    }
    public void setNombreDepartamento(String nuevo){
        this.nombre = nuevo;
    }
    public String getNombreDepartamento(){
        return nombre;
    }
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }
    public void addEmpleado(Empleado e){
        empleados.add(e);
    }
    /*
    @Override
    public void invitar() {
        for (Empleado e : empleados) {
            e.invitar();
        }
    }*/

    @Override
    public void invitar() {
        System.out.println("Departamento " + nombre + " ha sido invitado a la reunión");
    }
    @Override
    public String toString() {
        return "Departamento: " + nombre + "\nTotal de empleados: " + empleados.size() + "\n" + empleados;
    }
}
