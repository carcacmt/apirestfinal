/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Categoria;
import com.reto2.sa.reto2g8.entity.Categoria;
import com.reto2.sa.reto2g8.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CategoriaService {
      @Autowired
    private CategoriaRepository repository;
    
    public Categoria saveCategoria(Categoria categoria){
        return repository.save(categoria);
    }
    
    public List<Categoria> getCategorias(){
        return repository.findAll();
    }
    
    public Categoria getCategoriaById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteCategoria(int id){
        repository.deleteById(id);
        return "producto removido "+id;
    }
    
    public Categoria updateCategoria(Categoria categoria){
        Categoria existingCategoria=repository.
                findById(categoria.getId()).orElse(null);
       existingCategoria.setNomcategoria(categoria.getNomcategoria());
       return repository.save(existingCategoria);
       
        
    }
}
