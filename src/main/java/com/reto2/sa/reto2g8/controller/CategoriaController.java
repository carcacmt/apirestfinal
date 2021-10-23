/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Categoria;
import com.reto2.sa.reto2g8.service.CategoriaService;
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
@RequestMapping("/api/categoria/")   
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;
    
    @GetMapping("/all")    
    public List<Categoria> findAllCategorias(){
        return service.getCategorias();
    }
    
    @GetMapping("/{id}")    
    public Categoria findCategoriasId(@PathVariable int id){
        return service.getCategoriaById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addCategoria(@RequestBody Categoria categoria){
        service.saveCategoria(categoria);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateCategoria(@RequestBody Categoria categoria){
       service.updateCategoria(categoria);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteCategoria(@PathVariable int id){
           service.deleteCategoria(id);
           return ResponseEntity.status(204).build();
      }
    
}
