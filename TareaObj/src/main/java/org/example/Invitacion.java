package org.example;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Invitacion {
    private Instant hora;
    private LocalTime horalocal;
    public Invitacion (Instant horaActual){

        this.hora = horaActual;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }
    public Instant getHora(){
        return hora;
    }



    @Override
    public String toString() {
        return "Invitacion enviada a las " + horalocal + " horas";
    }
}
