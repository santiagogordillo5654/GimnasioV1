import org.example.Entrenador;
import org.example.Gimnasio;
import org.example.Usuario;
import org.example.Clase;
import org.example.TiposDeClases;
import org.example.TiposDeEntrenamiento;
import org.example.Reserva;
import org.example.Entrenamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class GimnasioTest {

    @Test
    public void registrarUsuario_exitoso() throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        // Registrar un usuario
        gimnasio.registrarUsuario("1", "Juan", "Dirección 1", "123456789", "juan@mail.com", "password");

        // Buscar usuario para verificar si fue registrado
        Usuario usuario = gimnasio.buscarUsuario("1");
        assertNotNull(usuario, "El usuario debería estar registrado.");
        assertEquals("Juan", usuario.getNombre(), "El nombre del usuario debería ser Juan.");
    }


    @Test
    public void reservarClase_claseNoEncontrada() throws Exception {
        Gimnasio gimnasio = new Gimnasio();
        Usuario usuario = new Usuario("1", "Juan", "Dirección 1", "123456789", "juan@mail.com", "password");
        gimnasio.registrarUsuario("1", "Juan", "Dirección 1", "123456789", "juan@mail.com", "password");

        // Intentar reservar una clase que no existe
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gimnasio.reservarClase("1", "999");
        });

        assertEquals("Clase no encontrada", exception.getMessage(), "El mensaje de error debería indicar que la clase no fue encontrada.");
    }

    @Test
    public void actualizarDatosUsuario_exitoso() throws Exception {
        Gimnasio gimnasio = new Gimnasio();
        gimnasio.registrarUsuario("1", "Juan", "Dirección 1", "123456789", "juan@mail.com", "password");

        gimnasio.actualizarDatosUsuario("1", "Juan Actualizado", "Nueva Dirección", "987654321", "juanactualizado@mail.com");

        Usuario usuario = gimnasio.buscarUsuario("1");
        assertEquals("Juan Actualizado", usuario.getNombre(), "El nombre del usuario debería ser Juan Actualizado.");
        assertEquals("Nueva Dirección", usuario.getDireccion(), "La dirección del usuario debería ser Nueva Dirección.");
    }

    @Test
    public void actualizarDatosUsuario_noEncontrado() throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        // Intentar actualizar un usuario que no existe
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gimnasio.actualizarDatosUsuario("999", "Juan Actualizado", "Nueva Dirección", "987654321", "juanactualizado@mail.com");
        });

        assertEquals("Usuario no encontrado", exception.getMessage(), "El mensaje de error debería indicar que el usuario no fue encontrado.");
    }

    @Test
    public void crearEntrenador_exitoso() throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        // Crear un entrenador
        assertDoesNotThrow(() -> gimnasio.crearEntrenador("12", "Pedro", "especialidad"));

        // Intentar crear un entrenador con el mismo ID
        Exception exception = assertThrows(Exception.class, () -> gimnasio.crearEntrenador("12", "Pedro", "especialidad"));
        assertEquals("El id dado ya existe", exception.getMessage(), "El mensaje de error debería indicar ID duplicado.");
    }

    @Test
    public void eliminarUsuario_exitoso() throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        // Configuración inicial
        gimnasio.registrarUsuario("1", "Juan", "Direccion 123", "123456789", "juan@example.com", "password");

        // Eliminar usuario
        assertDoesNotThrow(() -> gimnasio.eliminarUsuario("1"));

        // Verificar que el usuario haya sido eliminado
        Usuario usuario = gimnasio.buscarUsuario("1");
        assertNull(usuario, "El usuario debería haber sido eliminado.");
    }
    @Test
    public void registrarUsuario_idDuplicado() throws Exception {
        Gimnasio gimnasio = new Gimnasio();

        // Registrar un usuario
        gimnasio.registrarUsuario("1", "Juan", "Direccion 123", "123456789", "juan@example.com", "password");

        // Intentar registrar otro usuario con el mismo ID
        Exception exception = assertThrows(Exception.class, () -> gimnasio.registrarUsuario("1", "Pedro", "Direccion 456", "987654321", "pedro@example.com", "password"));
        assertEquals("El ID dado ya existe.", exception.getMessage(), "El mensaje de error debería indicar ID duplicado.");
    }
}