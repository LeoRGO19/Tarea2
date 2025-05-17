package org.example;

import java.lang.reflect.Array;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvitacionRepetidaException, TipoReunionInvalidoException {
        /*
        System.out.println("algo");
        Empleado ricardo = new Empleado();
        Departamento depaMate = new Departamento();
        Reunion reunion = new ReunionPresencial("cubo 3");
        Reunion reunion2 = new ReunionVirtual("www.reunion.cl");
        System.out.println(reunion);
        System.out.println(reunion2);
        System.out.println(depaMate);
        
        Date fecha = new Date();
        LocalDate fechalocal = fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        System.out.println(fecha);
        System.out.println(fechalocal);
        System.out.println();
        Instant hora = Instant.now();
        System.out.println(hora);
        LocalTime horalocal = hora.atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println(horalocal);*/
        Departamento n = new Departamento("Informática");
        Empleado leo = new Empleado("Leo", "Guerrero", "123", "leoth159@gmal.com", n.getNombre());

        Reunion reunion = new ReunionPresencial("sala1", leo, "2025-05-21T14:30", 45, 1);
        reunion.iniciar();
        System.out.println(reunion);
        Empleado rafa = new Empleado("Rafa", "Ortega", "222", "leoth159@gmal.com", n.getNombre());
        Empleado martin = new Empleado ("Martin", "Henriquez", "202", "martin@gmal.com", n.getNombre());
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
        reunion.agregarAsistente(rafa,Instant.now());
        reunion.agregarAsistente(martin, tiempo_martin);
        Nota n1 = new Nota("contenido de la nota 1",Instant.now());
        Nota n2 = new Nota("contenido de la nota 2",tiempo_martin);
        reunion.addNota(n1);
        reunion.addNota(n2);
        Instant tiempof = Instant.now().plusSeconds(1000);
        reunion.finalizar(tiempof);
        ArrayList<Invitable> prueba2 = reunion.obtenerAsistencias();
        reunion.generarInforme("C:/Users/Leorg/OneDrive/Escritorio/Tarea2/informe.txt");
       // System.out.println(prueba2);
      //  System.out.println(reunion.obtenerTotalAsistencia());
        System.out.println(reunion.obtenerPorcentajeAsistencia());
       System.out.println(reunion.obtenerAusencias());
       // System.out.println(reunion.obtenerRetrasos());
       // System.out.println(reunion.getInvitados());

        Instant ahora = Instant.now();
        Instant enUnaHora = ahora.plus(Duration.ofHours(1));
        System.out.println(reunion.calcularTiempoReal(ahora,enUnaHora));
    }
}