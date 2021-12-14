// package com.up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Inicio extends JFrame {

    private JTextField txtField;
    private JButton btnAC;
    private JButton btnHistorial;
    private JButton btn7;
    private JButton btn5;
    private JButton btn8;
    private JButton btn9;
    private JButton btnSuma;
    private JButton btnResta;
    private JButton btn6;
    private JButton btn4;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnMultiplicar;
    private JButton btnPunto;
    private JButton btn0;
    private JButton btnIgual;
    private JButton btnDivision;
    private JPanel Panel;
    private JButton btnDEL;
    char operacion = 'N';
    double numeroA, numeroB, resultado = 0;
    int contador = 1;

    // constructores

    public Inicio () {
        // constructor vacío
    }

    public Inicio(String titulo){
        super(titulo);

        // action listeners para todos los botones del GUI

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "1");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "2");
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "3");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "4");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "5");
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "6");
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "7");
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "8");
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "9");
            }
        });

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "0");
            }
        });

        btnPunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + ".");
            }
        });

        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "+");
                operacion = 'S';
            }
        });

        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "-");
                operacion = 'R';
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "x");
                operacion = 'M';
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(txtField.getText() + "/");
                operacion = 'D';
            }
        });

        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText("");
            }
        });

        btnDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtField.getText().length() > 0){
                    // después de validar que hay un caracter, se usa el método deleteCharAt
                    // de la clase StringBuilder para remover el último caracter del string.
                    StringBuilder sb = new StringBuilder(txtField.getText());
                    sb.deleteCharAt(txtField.getText().length() - 1);
                    txtField.setText(sb.toString());
                }
            }
        });

        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historial h = new Historial();
                h.mostrarPopUp();
            }
        });

    }

    // métodos

    public void mostrarPantalla(){
        setContentPane(Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,250);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void calcularResultado(){

        try{
            String texto = txtField.getText();
            String[] numeros = texto.split("[+\\-x/]");
            numeroA = Double.parseDouble(numeros[0]);
            numeroB = Double.parseDouble(numeros[1]);
        }catch (Exception ex){
            txtField.setText("MATH ERROR...");
            ex.fillInStackTrace();
        }

        switch (operacion){
            case 'S': // suma
                resultado = numeroA + numeroB;
                txtField.setText(Double.toString(resultado));
                operacion = '+';
                break;
            case 'R': // resta
                resultado = numeroA - numeroB;
                txtField.setText(Double.toString(resultado));
                operacion = '-';
                break;
            case 'M': // multiplicación
                resultado = numeroA * numeroB;
                txtField.setText(Double.toString(resultado));
                operacion = '*';
                break;
            case 'D': // división
                resultado = numeroA / numeroB;
                txtField.setText(Double.toString(resultado));
                operacion = '/';
                break;
            default:
                txtField.setText("MATH ERROR...");
        }

        // grabar resultado en Historial.txt

        FileWriter archivo = null;
        PrintWriter pw = null;
        try {
            archivo = new FileWriter("src/Historial.txt", true);
            pw = new PrintWriter(archivo);
            String linea = "\n" + (contador++) + "," + numeroA + "," + operacion + "," + numeroB + "," + resultado;
            pw.print(linea);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "ERROR: El archivo \"Historial.txt\" no se encontró.");
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
        numeroA = 0;
        numeroB = 0;
    }
}

