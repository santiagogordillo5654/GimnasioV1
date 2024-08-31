package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gimnasio gimnasio = new Gimnasio();
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("Menú principal:");
                System.out.println("1. Registrar usuario");
                System.out.println("2. Reservar clase");
                System.out.println("3. Actualizar datos de usuario");
                System.out.println("4. Eliminar usuario");
                System.out.println("5. Buscar clase");
                System.out.println("6. Consultar disponibilidad de clases");
                System.out.println("7. Registrar entrenamiento");
                System.out.println("8. Consultar historial de entrenamientos");
                System.out.println("9. Generar reporte");
                System.out.println("10. Crear clase");
                System.out.println("11. Crear entrenador");
                System.out.println("12. Salir");

                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Solicitar datos para registrar usuario
                        System.out.print("Ingrese el ID del usuario: ");
                        String idUsuario = scanner.nextLine();
                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombreUsuario = scanner.nextLine();
                        System.out.print("Ingrese la dirección del usuario: ");
                        String direccionUsuario = scanner.nextLine();
                        System.out.print("Ingrese el teléfono del usuario: ");
                        String telefonoUsuario = scanner.nextLine();
                        System.out.print("Ingrese el correo del usuario: ");
                        String correoUsuario = scanner.nextLine();
                        System.out.print("Ingrese la contraseña del usuario: ");
                        String contrasenaUsuario = scanner.nextLine();

                        gimnasio.registrarUsuario(idUsuario, nombreUsuario, direccionUsuario, telefonoUsuario, correoUsuario, contrasenaUsuario);
                        break;

                    case 2:
                        // Solicitar datos para reservar clase
                        System.out.print("Ingrese su ID de usuario: ");
                        String idUsuarioReserva = scanner.nextLine();
                        System.out.print("Ingrese el ID de la clase que desea reservar: ");
                        String idClaseReserva = scanner.nextLine();

                        gimnasio.reservarClase(idUsuarioReserva, idClaseReserva);
                        break;

                    case 3:
                        // Solicitar datos para actualizar datos de usuario
                        System.out.print("Ingrese el ID del usuario a actualizar: ");
                        String idUsuarioActualizar = scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre del usuario: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese la nueva dirección del usuario: ");
                        String nuevaDireccion = scanner.nextLine();
                        System.out.print("Ingrese el nuevo teléfono del usuario: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.print("Ingrese el nuevo correo del usuario: ");
                        String nuevoCorreo = scanner.nextLine();

                        gimnasio.actualizarDatosUsuario(idUsuarioActualizar, nuevoNombre, nuevaDireccion, nuevoTelefono, nuevoCorreo);
                        break;

                    case 4:
                        // Solicitar datos para eliminar usuario
                        System.out.print("Ingrese el ID del usuario a eliminar: ");
                        String idUsuarioEliminar = scanner.nextLine();

                        gimnasio.eliminarUsuario(idUsuarioEliminar);
                        break;

                    case 5:
                        // Solicitar datos para buscar clase
                        System.out.print("Ingrese el ID de la clase a buscar: ");
                        String idClaseBuscar = scanner.nextLine();

                        gimnasio.buscarClase(idClaseBuscar);
                        break;

                    case 6:
                        gimnasio.consultarDisponibilidadDeClases();
                        break;

                    case 7:
                        // Solicitar datos para registrar entrenamiento
                        System.out.println("Seleccione el tipo de entrenamiento:");
                        for (TiposDeEntrenamiento tipo : TiposDeEntrenamiento.values()) {
                            System.out.println((tipo.ordinal() + 1) + ". " + tipo.getDescripcion());
                        }

                        int tipoSeleccionado = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        System.out.print("Ingrese el ID del entrenamiento: ");
                        String idEntrenamiento = scanner.nextLine();
                        System.out.print("Ingrese la duración del entrenamiento en minutos: ");
                        int duracionEntrenamiento = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese el ID del usuario: ");
                        String idUsuarioEntrenamiento = scanner.nextLine();

                        gimnasio.registrarEntrenamiento(idEntrenamiento, tipoSeleccionado, duracionEntrenamiento, idUsuarioEntrenamiento);
                        break;

                    case 8:
                        gimnasio.consultarHistorialEntrenamientos();
                        break;

                    case 9:
                        gimnasio.generarReporte();
                        break;

                    case 10:
                        System.out.print("Ingrese el ID de la clase: ");
                        String idClase = scanner.nextLine();

                        System.out.println("Seleccione el tipo de clase:");
                        for (TiposDeClases tipo : TiposDeClases.values()) {
                            System.out.println((tipo.ordinal() + 1) + ". " + tipo.getNombre());
                        }

                        int tipoClaseSeleccionado = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        TiposDeClases tipoClase = TiposDeClases.values()[tipoClaseSeleccionado - 1];

                        System.out.print("Ingrese el horario de la clase: ");
                        String horarioClase = scanner.nextLine();
                        System.out.print("Ingrese la capacidad de la clase: ");
                        int capacidadClase = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese el ID del entrenador: ");
                        String idEntrenadorClase = scanner.nextLine();

                        gimnasio.crearClase(idClase, tipoClase, horarioClase, capacidadClase, idEntrenadorClase);
                        break;

                    case 11:
                        // Solicitar datos para crear entrenador
                        System.out.print("Ingrese el ID del entrenador: ");
                        String idEntrenador = scanner.nextLine();
                        System.out.print("Ingrese el nombre del entrenador: ");
                        String nombreEntrenador = scanner.nextLine();
                        System.out.print("Ingrese la especialidad del entrenador: ");
                        String especialidadEntrenador = scanner.nextLine();

                        gimnasio.crearEntrenador(idEntrenador, nombreEntrenador, especialidadEntrenador);
                        break;


                    case 12:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
