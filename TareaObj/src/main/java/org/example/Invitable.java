package org.example;
import java.util.ArrayList;

/**
 * Interfaz que representa una entidad que puede ser invitada a una reunión.
 * Puede ser implementada por empleados, departamentos, u otras personas externas.
 *
 * @author Francisco Fuentealba
 * @author Leonardo Guerrero
 */

public interface Invitable {

    /**
     * Método por defecto para invitar a la entidad.
     * Se sobreescribe en otras clases para definir un comportamiento específico.
     */

    public default void invitar() {
    }

    /**
     * Obtiene el nombre del invitado (Departamento o persona).
     * @return el nombre del departamento o de la persona.
     */

    public String getNombre();
}
