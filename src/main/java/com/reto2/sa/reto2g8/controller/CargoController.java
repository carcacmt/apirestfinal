/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Cargo;
import com.reto2.sa.reto2g8.service.CargoService;
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
@RequestMapping("/api/Cargo/")   
public class CargoController {
    
    @Autowired
    private CargoService service;
    
    @GetMapping("/all")    
    public List<Cargo> findAllCargos(){
        return service.getCargos();
    }
    
    @GetMapping("{id}")    
    public Cargo findCargosId(@PathVariable int id){
        return service.getCargoById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addCargo(@RequestBody Cargo cargo){
        service.saveCargo(cargo);
        return ResponseEntity.status(201).build();
    }
        
    @PutMapping("/update")
       public ResponseEntity updateCargo(@RequestBody Cargo cargo){
       service.updateCargo(cargo);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("{id}")
      public ResponseEntity deleteCargo(@PathVariable int id){
           service.deleteCargo(id);
           return ResponseEntity.status(204).build();
      }
    
}
