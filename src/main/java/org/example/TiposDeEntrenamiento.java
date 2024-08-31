package org.example;

public enum TiposDeEntrenamiento {
    SENTADILLAS("Sentadillas (cuádriceps)"),
    ZANCADAS("Zancadas o desplantes (cuádriceps)"),
    PESO_MUERTO("Peso muerto (isquiotibiales)"),
    HIP_THRUST("Hip thrust (glúteos)"),
    PRESS_BANCA("Press de banca (pecho)"),
    FONDOS("Fondos (pecho)"),
    DOMINADAS("Dominadas (espalda)");

    private final String descripcion;

    TiposDeEntrenamiento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
