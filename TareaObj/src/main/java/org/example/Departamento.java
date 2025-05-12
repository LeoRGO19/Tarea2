package org.example;

public class Departamento implements Invitable{
    private String nombre;

    public Departamento(){


    }
    public int obtenerCantidadEmpleados(){
        return 0;
    }
    @Override
    public void invitar() {
        System.out.println("Invitando desde el departamento");
    }
    @Override
    public String toString() {
        return nombre;
    }
}
