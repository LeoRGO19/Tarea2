package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("algo");
        Empleado ricardo = new Empleado();
        Departamento depaMate = new Departamento();
        Reunion reunion = new ReunionPresencial("cubo 3");
        Reunion reunion2 = new ReunionVirtual("www.reunion.cl");
        System.out.println(reunion);
        System.out.println(reunion2);
        System.out.println(depaMate);



    }
}