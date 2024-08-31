package org.example;

public enum TiposDeClases {

        SPINNING("Spinning"),
        AEROBICOS("Aeróbicos"),
        YOGA("Yoga"),
        PILATES("Pilates");

        private final String nombre;

        TiposDeClases(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
}

