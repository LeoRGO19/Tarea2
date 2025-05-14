package org.example;

public class Asistencia{
    private Empleado empleado;
    public Asistencia(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado(){
        return empleado;
    }
    public void setEmpleado(Empleado e){
        this.empleado = e;
    }

    @Override
    public String toString() {
        return "Asistencia de: " + empleado.getNombre();
    }
}
