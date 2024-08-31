package org.example;

public class Entrenador extends Usuario {
        private String especialidad;

        public Entrenador(String id, String nombre, String especialidad) {
            super(id, nombre, "", "", "", ""); // Ajusta el constructor según tu diseño
            this.especialidad = especialidad;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

    }

