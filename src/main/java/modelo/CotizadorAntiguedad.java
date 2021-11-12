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

/**
 *
 * @author Usuario
 */
@Entity
public class CotizadorAntiguedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private float descuentoForYear;

    public CotizadorAntiguedad() {
    }

    
    
    public CotizadorAntiguedad(float descuentoForYear) {
        this.descuentoForYear = descuentoForYear;
    }

    
    
    
    public float getDescuentoForYear() {
        return descuentoForYear;
    }

    public void setDescuentoForYear(float descuentoForYear) {
        this.descuentoForYear = descuentoForYear;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizadorAntiguedad)) {
            return false;
        }
        CotizadorAntiguedad other = (CotizadorAntiguedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CotizadorAntiguedad[ id=" + id + " ]";
    }
    
}
