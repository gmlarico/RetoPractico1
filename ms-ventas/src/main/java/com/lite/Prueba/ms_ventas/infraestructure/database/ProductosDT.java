package com.lite.Prueba.ms_ventas.infraestructure.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Esto sirve para automatizar get set
@Entity //para la implementacion como dataset
public class ProductosDT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private Integer cantidad;
}
