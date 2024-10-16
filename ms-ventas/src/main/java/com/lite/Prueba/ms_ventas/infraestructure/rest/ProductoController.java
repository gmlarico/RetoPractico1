package com.lite.Prueba.ms_ventas.infraestructure.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.Prueba.ms_ventas.infraestructure.database.ProductApplication;
import com.lite.Prueba.ms_ventas.infraestructure.database.ProductosDT;
import com.lite.Prueba.ms_ventas.infraestructure.exception.ProductNotFoundException;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    

    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductApplication productApplication;

    @GetMapping("/")
    public List<ProductosDT> getProductos() {
        return productApplication.findAll();
    }

    @GetMapping("/{id}") 
    public ProductosDT getProductById(@PathVariable Long id) { 
        return productApplication.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id)); 
    } 

    @PostMapping 
    public ProductosDT createProduct(@RequestBody ProductosDT product) { 
        return productApplication.save(product); 
    } 

    @PutMapping("/{id}") 
       public ProductosDT updateProduct(@PathVariable Long id, @RequestBody ProductosDT productDetails) { 
        ProductosDT product = productApplication.findById(id) 
                   .orElseThrow(() -> new ProductNotFoundException(id)); 
 
           product.setNombre(productDetails.getNombre()); 
           product.setPrecio(productDetails.getPrecio()); 
           product.setCantidad(productDetails.getCantidad()); 
 
           return productApplication.save(product); 
       }

    @DeleteMapping("/{id}") 
    public String deleteProduct(@PathVariable Long id) { 
        ProductosDT product = productApplication.findById(id).orElseThrow(() -> new ProductNotFoundException(id)); 
        productApplication.delete(product); 
        return "Product " + id + " deleted successfully!"; 
       } 
       
}
