/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Producto;
import com.reto2.sa.reto2g8.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ProductoService {
      @Autowired
    private ProductoRepository repository;
    
    public Producto saveProduct(Producto product){
       return repository.save(product);
    }
    
    public List<Producto> getProducts(){
        return repository.findAll();
    }
    
    public Producto getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "producto removido "+id;
    }
    
    public Producto updateProduct(Producto product){
        Producto existingProduct=repository.findById(product.getId()).orElse(null);
       existingProduct.setNombre(product.getNombre());
       existingProduct.setInventario(product.getInventario());
       existingProduct.setPrecio(product.getPrecio());
       return repository.save(existingProduct);
       
        
    }
}
