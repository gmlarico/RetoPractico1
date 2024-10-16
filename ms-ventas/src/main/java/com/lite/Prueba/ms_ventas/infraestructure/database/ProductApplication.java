package com.lite.Prueba.ms_ventas.infraestructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductApplication extends JpaRepository<ProductosDT, Long> {
    
}
