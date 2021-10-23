/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.repository;

import com.reto2.sa.reto2g8.entity.Departamento;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DELL
 */
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer>{
    
   @Query("SELECT d FROM Departamento d WHERE startDate BETWEEN ?1 AND ?2")
    List<Departamento> fechaDepartamento(Calendar inicio, Calendar fin);
   
    @Query("SELECT d FROM Departamento d order by id_dep desc")
    List<Departamento> findAllAsc();
 

}
