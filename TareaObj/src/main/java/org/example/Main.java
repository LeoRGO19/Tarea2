package org.example;

import java.time.*;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
        Empleado leo = new Empleado("Leo", "Guerrero", "123", "leoth159@gmal.com", "informática");
        Empleado rafa = new Empleado("Rafa", "Ortega", "222", "leoth159@gmal.com", "informática");
        System.out.println(leo);
        Departamento n = new Departamento("Informática");
        n.addEmpleado(leo);
        n.addEmpleado(rafa);
        System.out.println(n);
        Nota prueba = new Nota("Nota n°1");
        Retraso prueba1 =  new Retraso(leo, Instant.now());
        System.out.println(prueba);
        System.out.println(prueba1);
    }
}