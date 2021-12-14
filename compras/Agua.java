// package com.up;

public class Agua extends Producto{
    @Override
    public double calculartotal() {
        double t=getNumeroProductos()*5.5;
        return t;
    }
}
