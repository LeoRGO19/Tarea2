package org.example;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Invitacion {
    private Instant hora;
    private LocalTime horalocal;
    private Invitable persona;
    public Invitacion (Instant horaActual, Invitable persona){

        this.hora = horaActual;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
        this.persona = persona;
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }
    public Instant getHora(){
        return hora;
    }
    public void setPersona (Invitable invitado){
        this.persona = invitado;
    }
    public Invitable getPersona (){
        return persona;
    }

    @Override
    public String toString() {
        return "Invitacion enviada a " + persona + " a las " + horalocal + " horas";
    }
}
