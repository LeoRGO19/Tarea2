package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    private Retraso retraso;

    @BeforeEach
    void setUp() {
        Empleado leo = new Empleado("Leo", "Guerrero", "123", "leoth159@gmal.com", "Informatica");
        Instant llegadaEmpleado = LocalDateTime.of(2024, 5, 20, 9, 15, 30)
                .atZone(ZoneId.systemDefault()).toInstant();
        retraso = new Retraso(leo, llegadaEmpleado);
    }

    @Test
    void testGetHora() {
        assertEquals("09:15:30", retraso.getHora());
    }
}
