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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="cargo")
public class Cargo implements Serializable {    
  
    @Id
   // @GeneratedValue
    private int id_cargo;
    private String nomcargo;
    private double salario;
    @ManyToOne
    @JoinColumn(name ="departamento_id_dep")
    @JsonIgnoreProperties("cargos")
    private Departamento departamento;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="cargo")
    @JsonIgnoreProperties("cargo")
    private List<Empleado> empleados;
     
}
