package org.example;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Retraso extends Asistencia{
    private Instant hora;
    private LocalTime horalocal;
    Retraso(Invitable empleado, Instant hora){
        super(empleado);
        this.hora = hora;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
    }
    public String getHora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horalocal.format(formatter);
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Retraso de " + getAsistente().getNombre() + ": Llegó a las " + horalocal;
    }
}
