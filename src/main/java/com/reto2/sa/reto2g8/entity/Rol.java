/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Table(name="rol")
public class Rol implements Serializable {
   // @JsonIgnore
    @Id
   // @GeneratedValue
    private int id_rol;
    private String nomrol;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="rol")
    @JsonIgnoreProperties("rol")
    private List<Empleado> empleados;
    
 }
