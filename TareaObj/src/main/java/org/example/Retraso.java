package org.example;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Representa un caso de asistencia con retraso a una reunión.
 * Extiende la clase {@link Asistencia} e incluye la hora exacta de llegada.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public class Retraso extends Asistencia{
    private Instant hora;
    private LocalTime horalocal;

    /**
     * Crea un nuevo objeto {@code Retraso} con el asistente y la hora de llegada especificados.
     * La hora se convierte a la hora local del sistema y se trunca a segundos.
     *
     * @param empleado el invitado que llegó con retraso.
     * @param hora el instante en que llegó.
     */

    Retraso(Invitable empleado, Instant hora){
        super(empleado);
        this.hora = hora;
        this.horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.SECONDS);
    }

    /**
     * Obtiene la hora local en formato normal (HH:mm:ss) en la que se registró el retraso.
     *
     * @return un String con la hora de llegada.
     */

    public String getHora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horalocal.format(formatter);
    }

    /**
     * Establece un nuevo instante como hora de llegada con retraso.
     * Nota: no actualiza el valor de {@code horalocal}.
     *
     * @param hora el nuevo instante de llegada.
     */

    public void setHora(Instant hora){
        this.hora = hora;
    }

    /**
     * Devuelve un String con la persona que llegó con retraso y la hora.
     *
     * @return una cadena con el nombre del asistente y la hora de llegada.
     */

    @Override
    public String toString() {
        return "Retraso de " + getAsistente().getNombre() + ": Llegó a las " + horalocal;
    }
}
