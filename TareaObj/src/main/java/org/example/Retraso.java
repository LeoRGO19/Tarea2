package org.example;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Retraso extends Asistencia{
    private Instant hora;
    LocalTime horalocal;
    Retraso(Empleado empleado, Instant hora){
        super(empleado);
        this.hora = hora;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
    }
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Retraso de " + getEmpleado().getNombre() + ": Llegó a las " + horalocal;
    }
}
