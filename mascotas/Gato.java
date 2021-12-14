package com.up;

public class Gato extends AbsMascota{


    @Override
    public void mostrar_alimento() {
        String comida = "ALIMENTO DE GATO: croquetas de pescado.";
        System.out.println(comida);
    }

}
