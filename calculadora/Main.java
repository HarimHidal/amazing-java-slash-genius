// package com.up;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Inicio inicio = new Inicio("Calculadora");
        inicio.mostrarPantalla();

        Historial h = new Historial();
        h.sobreescribirHistorial("Contador: Numero1 Operador Numero2 = Resultado");

        String mensaje = "CALCULADORA:\n" +
                "Esta es una calculadora simple que soporta\n" +
                "únicamente operaciones entre dos números.";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

