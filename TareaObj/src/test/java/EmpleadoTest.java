import org.example.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Leonardo", "Guerrero", "011", "LeoGuerrero@gmail.com", "Sistemas");
    }

    @Test
    //Aunque no lo pida, quería comprobar que los getters y setters estaban funcionando bien, incluso
    //despues de cambiar el valor de las cosas, como nombre por ejemplo.

    void testGettersAndSetters() {

        assertEquals("Leonardo", empleado.getNombre());
        assertEquals("Guerrero", empleado.getApellidos());
        assertEquals("011", empleado.getId());
        assertEquals("LeoGuerrero@gmail.com", empleado.getCorreo());
        assertEquals("Sistemas", empleado.getDepartamento());

        empleado.setNombre("Martin");
        assertEquals("Martin", empleado.getNombre());
    }

    @Test

    //Este solo lo haré para ver si se envía el mensaje del toString correctamente
    void testToString() {
        Empleado emp = new Empleado("Francisco", "Fuentealba", "010", "ffuentealba@gmail.com", "Informatica");
        String texto = emp.toString();
        assertTrue(texto.contains("Francisco Fuentealba"));
        assertTrue(texto.contains("id: 010"));
    }
}