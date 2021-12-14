// package com.up;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int cantidad, opciones = 1;

        Scanner sc;

        List<Producto> compras = new ArrayList<>();

        do {
            System.out.println("\nSelecciona la opción deseada:");
            System.out.println("1 --> Agua $7.5 (10% descuento)");
            System.out.println("2 --> Jugo $5.5");
            System.out.println("0 --> Salir");

            try {
                sc = new Scanner(System.in);
                System.out.print("\nIntroduce un numero: ");
                opciones = sc.nextInt();

            } catch (InputMismatchException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                System.out.println("Vuelve a introducir una opción válida.");
                continue;
            }

            if (opciones == 1) {

                do {
                    System.out.println("\nCuantas aguas desea comprar?");

                    try {
                        sc = new Scanner(System.in);
                        System.out.print("Introduce un numero: ");
                        cantidad = sc.nextInt();

                        Producto agua = new Agua();
                        sc = new Scanner(System.in);

                        agua.setNumeroProductos(cantidad);

                        System.out.print("Marca de la agua: ");
                        agua.setNombre(sc.next());

                        compras.add(agua);

                        break;

                    } catch (InputMismatchException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                        System.out.println("Vuelve a introducir una opción válida.");
                    }

                } while (true);

            } else if (opciones == 2) {

                do {
                    System.out.println("\nCuantos jugos desea comprar?");

                    try {
                        sc = new Scanner(System.in);
                        System.out.print("Introduce un numero: ");
                        cantidad = sc.nextInt();

                        Producto jugo = new Jugo();
                        sc = new Scanner(System.in);

                        jugo.setNumeroProductos(cantidad);

                        System.out.print("Marca del jugo: ");
                        jugo.setNombre(sc.next());

                        compras.add(jugo);

                        break;

                    } catch (InputMismatchException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                        System.out.println("Vuelve a introducir una opción válida.");
                    }

                } while (true);

                } else if (opciones == 0) {

                    System.out.println("\nINFORMACIÓN DE LAS COMPRAS:");
                    int contador = 1;

                    System.out.println("# --> Producto (Cantidad): Total a pagar.");
                    for (Producto p : compras) {
                        System.out.println(contador + " --> " + p.getNombre() + " (" + p.getNumeroProductos() + "): " + p.calculartotal());
                        contador++;
                    }
                }
            } while (opciones != 0) ;
    }
}
