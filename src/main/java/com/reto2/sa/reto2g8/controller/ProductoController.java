/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Producto;
import com.reto2.sa.reto2g8.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController
@RequestMapping("/api/producto/")   
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")    
    public List<Producto> findAllProducts(){
        return service.getProducts();
    }
    
    @GetMapping("/products/{id}")    
    public Producto findProductsId(@PathVariable int id){
        return service.getProductById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addProduct(@RequestBody Producto product){
        service.saveProduct(product);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateProduct(@RequestBody Producto product){
       service.updateProduct(product);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/delete")
      public ResponseEntity deleteProduct(@RequestBody Producto product){
           service.deleteProduct(product.getId());
           return ResponseEntity.status(204).build();
      }
    
}
