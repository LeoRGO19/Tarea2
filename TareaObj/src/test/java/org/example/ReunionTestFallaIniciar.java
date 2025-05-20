package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTestFallaIniciar {


    @BeforeEach
    void setUp() throws TipoReunionInvalidoException, InvitacionRepetidaException {
        Departamento n = new Departamento("Informática");
        Empleado leo = new Empleado("Leo", "Guerrero", "123", "leoth159@gmal.com", n.getNombre());

        Reunion reunion = new ReunionPresencial("sala1", leo, "2025-05-21T14:30", 45, 1);
        Empleado rafa = new Empleado("Rafa", "Ortega", "222", "leoth159@gmal.com", n.getNombre());
        Empleado martin = new Empleado ("Martin", "Henriquez", "202", "martin@gmal.com", n.getNombre());
        Empleado maria = new Empleado("Maria", "Juana", "153", "maria159@gmal.com", n.getNombre());
        reunion.iniciar();
        n.addEmpleado(leo);
        n.addEmpleado(rafa);
        n.addEmpleado(maria);
        n.addEmpleado(martin);
        reunion.agregarInvitado(n);
        Instant tiempo_martin = Instant.now().plusSeconds(650);
        reunion.agregarAsistente(leo, Instant.now());
        reunion.agregarAsistente(rafa,Instant.now());
        reunion.agregarAsistente(martin, tiempo_martin);

    }


    @Test
    void iniciar() {

    }

}