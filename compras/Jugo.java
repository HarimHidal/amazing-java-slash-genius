// package com.up;

public class Jugo extends Producto{
    @Override
    public double calculartotal() {
        double p=getNumeroProductos()*7.5;
        double d= p*.1;
        double t= p-d;
        return t;
    }
}
