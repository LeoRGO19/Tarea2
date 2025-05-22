package org.example;

/**
 * Enumeración que representa los tipos posibles de reuniones.
 * Cada tipo está asociado a un valor numérico.
 *
 * @author Francisco Fuentealba
 */

public enum TipoReunion {

    /** Reunión técnica. */
    TECNICA(1),

    /** Reunión de marketing. */

    MARKETING(2),

    /** Otro tipo de reunión. */
    OTRO(3);

    private int valor;

    /**
     * Constructor que asigna un valor entero a cada tipo de reunión.
     *
     * @param i el valor numérico asociado al tipo de reunión.
     */

    TipoReunion(int i){
        this.valor = i;
    }

    /**
     * Método que devuelve el tipo de reunión correspondiente al numéro proporcionado.
     *
     * @param valorBuscado el valor entero del tipo de reunión.
     * @return el {@code TipoReunion} correspondiente, o {@code null} si no se encuentra coincidencia.
     */

    public static TipoReunion obtenerTipo(int valorBuscado) {
        for (TipoReunion tipo : TipoReunion.values()) {
            if (tipo.valor == valorBuscado) {
                return tipo;
            }
        }
        return null;
    }
}
