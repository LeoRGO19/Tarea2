package org.example;

public class Asistencia{
    private Invitable empleado;
    public Asistencia(Invitable empleado) {
        this.empleado = empleado;
    }

    public Invitable getEmpleado(){
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
