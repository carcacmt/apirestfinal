/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Departamento;
import com.reto2.sa.reto2g8.repository.DepartamentoRepository;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DepartamentoService {
      @Autowired
    private DepartamentoRepository repository;
    
    public Departamento saveDepartamento(Departamento departamento){
       return repository.save(departamento);
    }
    
    public List<Departamento> getDepartamentos(){
        return repository.findAll();
   
    }
    
    public List<Departamento> getDepartamentosAsc(){
        return repository.findAllAsc();
   
    }
    
    public Departamento getDepartamentoById(int id){
        return repository.findById(id).orElse(null);
    }
    
      
    public String deleteDepartamento(int id){
        repository.deleteById(id);
        return "departamento removido "+id;
    }
    
    public Departamento updateDepartamento(Departamento departamento){
        Departamento existingDepartamento=repository.findById(departamento.getId_dep()).orElse(null);
       existingDepartamento.setNomdep(departamento.getNomdep());  
       existingDepartamento.setStartDate(departamento.getStartDate());
       existingDepartamento.setEndDate(departamento.getEndDate());
       return repository.save(existingDepartamento);
       
        
    }
    
    public List<Departamento> fechaDepartamento(Calendar inicio,Calendar fin){
        return repository.fechaDepartamento(inicio, fin);
   }
    
    public long countDepartamento(){
        return repository.count();
    } 
    
    
    
    
}
