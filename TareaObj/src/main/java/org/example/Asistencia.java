package org.example;

public class Asistencia{
    private Invitable inv;
    public Asistencia(Invitable inv) {
        this.inv = inv;
    }

    public Invitable getAsistente(){
        return inv;
    }
    public void setAsistente(Invitable e){
        this.inv = e;
    }

    @Override
    public String toString() {
        return "Asistencia de: " + inv.getNombre();
    }
}
