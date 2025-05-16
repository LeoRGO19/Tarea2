package org.example;

public enum TipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);
    private int valor;
    TipoReunion(int i){
        this.valor = i;
    }
    public static TipoReunion obtenerTipo(int valorBuscado) {
        for (TipoReunion tipo : TipoReunion.values()) {
            if (tipo.valor == valorBuscado) {
                return tipo;
            }
        }
        return null;
    }
}
