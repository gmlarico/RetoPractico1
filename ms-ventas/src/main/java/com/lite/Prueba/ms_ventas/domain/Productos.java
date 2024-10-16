package com.lite.Prueba.ms_ventas.domain;

import lombok.Data;

@Data //Esto sirve para automatizar get set
public class Productos {
    private int id;
    private String nombre;
    private double precio;

    public Productos() {

    }

    // Constructor
    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}
