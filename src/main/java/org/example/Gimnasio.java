package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Gimnasio {
    private List<Usuario> usuarios;
    private List<Clase> clases;
    private List<Entrenamiento> entrenamientos;
    private List<Entrenador> entrenadores;

    public Gimnasio() {
        this.usuarios = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.entrenamientos = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    public Usuario buscarUsuario(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }


    public void registrarUsuario(String id, String nombre, String direccion, String telefono, String correo, String contrasena) throws Exception {
        Usuario usuario = new Usuario(id, nombre, direccion, telefono, correo, contrasena);
        if (buscarUsuario(usuario.getId()) != null) {
            throw new Exception("El ID dado ya existe.");
        }

        usuarios.add(usuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    public void reservarClase(String idUsuario, String idClase) {
        Clase claseSeleccionada = clases.stream()
                .filter(clase -> clase.getId().equals(idClase))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (claseSeleccionada.getCapacidad() > 0) {
            Reserva reserva = new Reserva(claseSeleccionada, usuario, new Date());
            claseSeleccionada.setCapacidad(claseSeleccionada.getCapacidad() - 1);
            System.out.println("Reserva realizada con éxito para la clase: " + claseSeleccionada.getTipoClase());
        } else {
            System.out.println("No hay capacidad disponible para esta clase.");
        }
    }

    public void actualizarDatosUsuario(String idUsuario, String nombre, String direccion, String telefono, String correo) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        usuario.actualizarDatos(nombre, direccion, telefono, correo);
        System.out.println("Datos del usuario actualizados exitosamente.");
    }

    public void eliminarUsuario(String idUsuario) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        usuarios.remove(usuario);
        System.out.println("Usuario eliminado exitosamente.");
    }

    public void buscarClase(String idClase) {
        Clase clase = clases.stream()
                .filter(c -> c.getId().equals(idClase))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        System.out.println("Clase encontrada: " + clase.getTipoClase());
    }

    public void consultarDisponibilidadDeClases() {
        if (clases.isEmpty()) {
            System.out.println("No hay clases disponibles.");
            return;
        }

        for (Clase clase : clases) {
            if (clase.getCapacidad() > 0) {
                System.out.println("ID: " + clase.getId() + ", Tipo: " + clase.getTipoClase() + ", Horario: " + clase.getHorario() + ", Capacidad: " + clase.getCapacidad());
            }
        }
    }


    public void registrarEntrenamiento(String idEntrenamiento, int tipoSeleccionado, int duracion, String idUsuario) {
        TiposDeEntrenamiento tipo = TiposDeEntrenamiento.values()[tipoSeleccionado - 1];
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        int caloriasQuemadas = duracion * 3;
        Entrenamiento entrenamiento = new Entrenamiento(idEntrenamiento, tipo, duracion, caloriasQuemadas, usuario);
        entrenamientos.add(entrenamiento);
        System.out.println("Entrenamiento registrado exitosamente.");
    }

    public void consultarHistorialEntrenamientos() {
        if (entrenamientos.isEmpty()) {
            System.out.println("No hay entrenamientos registrados.");
        } else {
            System.out.println("Historial de entrenamientos:");
            entrenamientos.forEach(entrenamiento -> {
                System.out.println("ID: " + entrenamiento.getId() + ", Tipo: " + entrenamiento.getTipo() +
                        ", Duración: " + entrenamiento.getDuracion() + " minutos, Calorías quemadas: " +
                        entrenamiento.getCaloriasQuemadas() + " cal, Usuario: " + entrenamiento.getUsuario().getNombre());
            });
        }
    }

    public void generarReporte() {
        System.out.println("Generando reporte...");
        System.out.println("Total de usuarios: " + usuarios.size());
        System.out.println("Total de clases: " + clases.size());
        System.out.println("Total de entrenamientos: " + entrenamientos.size());
    }

    public void crearClase(String id, TiposDeClases tipoClase, String horario, int capacidad, String idEntrenador) throws Exception {
        Entrenador entrenador = buscarEntrenador(idEntrenador);

        if (entrenador == null) {
            throw new Exception("El ID del entrenador no existe, debe crear el entrenador desde el menú.");
        }

        Clase nuevaClase = new Clase(id, tipoClase, horario, capacidad, new Date(), new Date(), "Disponible", entrenador);
        clases.add(nuevaClase);
        System.out.println("Clase creada con éxito.");
    }

    public Entrenador buscarEntrenador(String idEntrenador) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId().equals(idEntrenador)) {
                return entrenador;
            }
        }
        return null;
    }

    public void crearEntrenador(String id, String nombre, String especialidad) throws Exception {
        Entrenador entrenador = new Entrenador(id, nombre, especialidad);

        if (buscarEntrenador(id) != null) {
            throw new Exception("El id dado ya existe");
        }

        // Agregar el entrenador a la lista
        entrenadores.add(entrenador);
        System.out.println("El entrenador fue creado con éxito");
    }

    public void mostrarEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Entrenadores registrados:");
            entrenadores.forEach(entrenador -> {
                System.out.println("ID: " + entrenador.getId() + ", Nombre: " + entrenador.getNombre() + ", Especialidad: " + entrenador.getEspecialidad());
            });
        }
    }


    public Collection<Clase> getClases() {

        return List.of();
    }
}