package com.up;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int opciones2 = 1, opciones = 1;

        Scanner sc;

        List<AbsMascota> lista_mascotas = new ArrayList<>();

        do {
            System.out.println("\nSelecciona la opción deseada:");
            System.out.println("1 --> Dar de alta una mascota");
            System.out.println("0 --> Salir y mostrar datos");

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
                    System.out.println("\nSelecciona la opción deseada:");
                    System.out.println("1 --> Perro");
                    System.out.println("0 --> Gato");

                    try {
                        sc = new Scanner(System.in);
                        System.out.print("\nIntroduce un numero: ");
                        opciones2 = sc.nextInt();

                    } catch (InputMismatchException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                        System.out.println("Vuelve a introducir una opción válida.");
                        continue;
                    }

                    if (opciones2 == 1) {

                        AbsMascota perro = new Perro();

                        try {

                            sc = new Scanner(System.in);

                            System.out.print("\nNombre del perro: ");
                            perro.setNombre(sc.next());

                            System.out.print("Edad del perro: ");
                            perro.setEdad(sc.nextInt());

                            System.out.print("Raza del perro: ");
                            perro.setRaza(sc.next());

                            lista_mascotas.add(perro);
                            break;

                        } catch (InputMismatchException ex) {
                            System.out.println("ERROR: " + ex.getMessage());
                            System.out.println("Vuelve a introducir una opción válida.");
                        }


                    } else if (opciones2 == 0) {

                        AbsMascota gato = new Gato();

                        try {

                            sc = new Scanner(System.in);

                            System.out.print("\nNombre del gato: ");
                            gato.setNombre(sc.next());

                            System.out.print("Edad del gato: ");
                            gato.setEdad(sc.nextInt());

                            System.out.print("Raza del gato: ");
                            gato.setRaza(sc.next());

                            lista_mascotas.add(gato);
                            break;

                        } catch (InputMismatchException ex) {
                            System.out.println("ERROR: " + ex.getMessage());
                            System.out.println("Vuelve a introducir una opción válida.");
                        }

                    }

                } while (true);

            } else if (opciones == 0){

                System.out.println("\nINFORMACIÓN DE LAS MASCOTAS REGISTRADAS:");
                    int contador = 1;
                    for (AbsMascota m : lista_mascotas){
                        System.out.println(contador + " --> " + "(Nombre, Edad, Raza) " + m.getNombre() + ", " + m.getEdad() + ", " + m.getRaza());
                        m.mostrar_alimento();
                        contador++;
                    }
            }

        } while (opciones == 1);
    }
}
