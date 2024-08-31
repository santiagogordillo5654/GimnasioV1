package org.example;

import java.util.Date;

public class Clase {
    private String id;
    private TiposDeClases tipoClase;
    private String horario;
    private int capacidad;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private Entrenador entrenador;

    public Clase(String id, TiposDeClases tipoClase, String horario, int capacidad, Date fechaInicio, Date fechaFin, String estado, Entrenador entrenador) {
        this.id = id;
        this.tipoClase = tipoClase;
        this.horario = horario;
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.entrenador = entrenador;
    }

    public String getId() {
        return id;
    }

    public TiposDeClases getTipoClase() {
        return tipoClase;
    }

    public String getHorario() {
        return horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    // Método para incrementar la capacidad de la clase
    public void incrementarCapacidad() {
        this.capacidad++;
    }

}
