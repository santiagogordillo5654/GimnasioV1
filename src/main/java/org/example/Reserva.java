package org.example;
import java.util.Date;

public class Reserva {

        private Clase clase;
        private Usuario usuario;
        private Date fechaReserva;

        // Constructor
        public Reserva(Clase clase, Usuario usuario, Date fechaReserva) {
            this.clase = clase;
            this.usuario = usuario;
            this.fechaReserva = fechaReserva;
        }

        // Getters
        public Clase getClase() {
            return clase;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        // Método para cancelar la reserva y aumentar la capacidad de la clase
        public void cancelarReserva() {
            clase.incrementarCapacidad();
        }

    public Date getFechaReserva() {
        return fechaReserva;
    }
}
