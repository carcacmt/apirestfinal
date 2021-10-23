/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Calendar;
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
@Table(name="departamento")
public class Departamento implements Serializable {

    @Id
   // @GeneratedValue
    private int id_dep;
    private String nomdep;
    private Calendar startDate;
    private Calendar endDate;
    private String status="createad";
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="departamento")
    @JsonIgnoreProperties("departamento")
    private List<Cargo> cargos;
 }
