package org.example;
import java.time.*;
import java.time.temporal.ChronoUnit;


/**
 * Representa una invitación enviada a una entidad que implementa {@code Invitable}.
 * La invitación almacena la hora exacta de envío y la persona o departamento invitado.
 *
 * @author Francisco Fuentealba
 */

public class Invitacion {
    private Instant hora;
    private LocalTime horalocal;
    private Invitable persona;

    /**
     * Crea una nueva invitación con la hora especificada y la persona a invitar.
     * La hora local se calcula a partir de la zona horaria del sistema y se trunca a segundos para mayor precisión.
     *
     * @param horaActual el instante en que se envía la invitación.
     * @param persona la entidad que será invitada.
     */

    public Invitacion (Instant horaActual, Invitable persona){

        this.hora = horaActual;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
        this.persona = persona;
    }

    /**
     * Establece la hora específica en que se envió la invitación.
     *
     * @param hora el nuevo {@code Instant} que representa la hora de envío.
     */

    public void setHora(Instant hora){
        this.hora = hora;
    }

    /**
     * Retorna la hora a la que se envió la invitación.
     * @return un {@code Instant} que representa la hora en que se envió la invitación.
     */

    public Instant getHora(){
        return hora;
    }

    /**
     * Establece la persona o entidad invitada.
     *
     * @param invitado la nueva entidad que será invitada.
     */

    public void setPersona (Invitable invitado){
        this.persona = invitado;
    }

    /**
     * Obtiene la persona o entidad invitada.
     *
     * @return el objeto {@code Invitable} que representa al invitado.
     */

    public Invitable getPersona (){
        return persona;
    }

    /**
     * toString para observar que devuelva todo correctamente, se usó override.
     *
     * @return una cadena con el formato: "Invitacion enviada a [persona] a las [hora] horas".
     */

    @Override
    public String toString() {
        return "Invitacion enviada a " + persona + " a las " + horalocal + " horas";
    }
}
