/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author Usuario
 */
@Entity
//@Table(name = "Cotizador")

public class CotizadorKilometraje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

       
    @Basic
    private float descuentoPorcentaje;
    
    
    
     

    public CotizadorKilometraje() {
    }

    public CotizadorKilometraje(float descuentoPorcentaje ) {
        /*descuentoPorcentaje es el porcentaje que se descuenta de la cotizacion
        
        */
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    

    
     
     public float getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(float descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

  

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
