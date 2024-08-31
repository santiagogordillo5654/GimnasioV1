package org.example;

public class Entrenamiento {
    private String id;
    private TiposDeEntrenamiento tipo; // Cambiado de String a TipoEntrenamiento
    private int duracion;
    private int caloriasQuemadas;
    private Usuario usuario;

    public Entrenamiento(String id, TiposDeEntrenamiento tipo, int duracion, int caloriasQuemadas, Usuario usuario) {
        this.id = id;
        this.tipo = tipo;
        this.duracion = duracion;
        this.caloriasQuemadas = caloriasQuemadas;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public TiposDeEntrenamiento getTipo() { // Cambiado el tipo de retorno a TipoEntrenamiento
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}

