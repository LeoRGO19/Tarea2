package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    private Empleado empleado;
    private Retraso retraso;
    private Instant llegadaEmpleado;

    @BeforeEach
    void setUp() {
        llegadaEmpleado = LocalDateTime.of(2024, 5, 20, 9, 15, 30)
                .atZone(ZoneId.systemDefault()).toInstant();
        retraso = new Retraso(empleado, llegadaEmpleado);
    }
    @Test
    void testGetHora() {
        assertEquals("09:15:30", retraso.getHora());
    }
}
