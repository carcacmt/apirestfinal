/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author DELL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Empleado")
public class Empleado implements Serializable {

    @Id
   // @GeneratedValue
    private int id_emp;
    private String nombre;
    /*
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date fecha;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date hora;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechora;
    private Calendar startdate;
    private String state="created";
    */ 
    @ManyToOne
    @JoinColumn(name = "cargo_id_cargo")
    @JsonIgnoreProperties("empleados")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "rol_id_rol")
    @JsonIgnoreProperties("empleados")
    private Rol rol;
  
    
 }
