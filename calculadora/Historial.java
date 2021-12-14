// package com.up;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Historial {


    public void mostrarPopUp() {
        JOptionPane.showMessageDialog(null, leerHistorial());
    }

    public String leerHistorial (){

        String mostrar = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        List<String[]> arreglo = new ArrayList<>();

        try {
            archivo = new File("src/Historial.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ( (linea = br.readLine()) != null ){
                String[] linea_arreglo = linea.split(",");
                arreglo.add(linea_arreglo);
            }
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El archivo \"Historial.txt\" no se encontró.");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "ERROR: Fue imposible leer el archivo \"Historial.txt\"");
        }

        for (String[] elemento : arreglo){
            int i = 0;
            for (String n : elemento){
                if (i == 0){
                    mostrar += n + ": ";
                } else if(i == 3) {
                    mostrar += n + " = ";
                } else{
                    mostrar += n + " ";
                }
                i++;
            }
            mostrar += "\n";
        }

        return mostrar;
    }


    public void sobreescribirHistorial(String contenido) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try {
            archivo = new FileWriter("src/Historial.txt", false);
            pw = new PrintWriter(archivo);
            pw.print(contenido);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: El archivo \"Historial.txt\" no se encontró.");
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }

}

