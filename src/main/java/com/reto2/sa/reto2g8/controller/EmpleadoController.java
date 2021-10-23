/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Empleado;
import com.reto2.sa.reto2g8.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Empleado/")

public class EmpleadoController {
    
    @Autowired
    private EmpleadoService service;
    
    @GetMapping("/all")    
    public List<Empleado> findAllEmpleados(){
        return service.getEmpleados();
    }
    
    @GetMapping("/{id}")    
    public Empleado findEmpleadosId(@PathVariable int id){
        return service.getEmpleadoById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addEmpleado(@RequestBody Empleado empleado){
        service.saveEmpleado(empleado);
        return ResponseEntity.status(201).build();
    }
        
      
      @PutMapping("/update")
       public ResponseEntity updateEmpleado(@RequestBody Empleado empleado){
       service.updateEmpleado(empleado);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteEmpleado(@PathVariable int id){
           service.deleteEmpleado(id);
           return ResponseEntity.status(204).build();
      }
    
}
