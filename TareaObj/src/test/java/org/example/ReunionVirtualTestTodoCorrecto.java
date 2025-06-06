package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

class ReunionVirtualTestTodoCorrecto {


    @BeforeEach
    void setUp() throws TipoReunionInvalidoException, InvitacionRepetidaException {
        Departamento n = new Departamento("Informática");
        Empleado leo = new Empleado("Leo", "Guerrero", "123", "leoth159@gmal.com", n.getNombre());
        Reunion reunion = new ReunionVirtual("WWW.DOOTEST.COM", leo, "2025-05-21T14:30", 45, 1);
        reunion.iniciar();
        System.out.println(reunion);
        Empleado rafa = new Empleado("Rafa", "Ortega", "222", "leoth159@gmal.com", n.getNombre());
        Empleado martin = new Empleado("Martin", "Henriquez", "202", "martin@gmal.com", n.getNombre());
        Empleado maria = new Empleado("Maria", "Juana", "153", "maria159@gmal.com", n.getNombre());

        n.addEmpleado(leo);
        n.addEmpleado(rafa);
        n.addEmpleado(maria);
        n.addEmpleado(martin);
        System.out.println(n);

        //prueba agregar a la lista de invitados
        reunion.agregarInvitado(n);
        /*
        reunion.agregarInvitado(leo);
        reunion.agregarInvitado(rafa);
        reunion.agregarInvitado(maria);
        reunion.agregarInvitado(martin);
        */

        Instant tiempo_martin = Instant.now().plusSeconds(650);
        reunion.agregarAsistente(leo, Instant.now());
        reunion.agregarAsistente(rafa, Instant.now());
        reunion.agregarAsistente(martin, tiempo_martin);
        Nota n1 = new Nota("contenido de la nota 1", Instant.now());
        Nota n2 = new Nota("contenido de la nota 2", tiempo_martin);
        reunion.addNota(n1);
        reunion.addNota(n2);
        Instant tiempof = Instant.now().plusSeconds(10861);
        reunion.finalizar(tiempof);
        ArrayList<Invitable> prueba2 = reunion.obtenerAsistencias();
        reunion.generarInforme("C:/Users/Canito301/Desktop/Tarea2DOO/informe.txt");
        // System.out.println(prueba2);
        //  System.out.println(reunion.obtenerTotalAsistencia());
        System.out.println(reunion.obtenerPorcentajeAsistencia());
        System.out.println(reunion.obtenerAusencias());
        // System.out.println(reunion.obtenerRetrasos());
        // System.out.println(reunion.getInvitados());

        Instant ahora = Instant.now();
        Instant enUnaHora = ahora.plus(Duration.ofHours(1));
        System.out.println(reunion.calcularTiempoReal(ahora, enUnaHora));

    }
    @Test
    void Finalizar() {

    }





    @Test
    void iniciar() {
    }
}