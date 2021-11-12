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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author RUBEN
 */
@Entity
public class Vtv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private AutomovilUsado autoUsado;
    
    @Basic
    private String motivoParaDesaprobar;
    
    @ManyToOne
    private EstadoVTV estadoVTV;
    
    @OneToOne
    private Turno turno;

    public Vtv() {
    }

    public String getMotivoParaDesaprobar() {
        return motivoParaDesaprobar;
    }

    public void setMotivoParaDesaprobar(String motivoParaDesaprobar) {
        this.motivoParaDesaprobar = motivoParaDesaprobar;
    }

    
    public Vtv(AutomovilUsado autoUsado, EstadoVTV estadoVTV, Turno turno) {
        this.autoUsado = autoUsado;
        this.estadoVTV = estadoVTV;
        this.turno = turno;
    }

    public AutomovilUsado getAutoUsado() {
        return autoUsado;
    }

    public void setAutoUsado(AutomovilUsado autoUsado) {
        this.autoUsado = autoUsado;
    }

    public EstadoVTV getEstadoVTV() {
        return estadoVTV;
    }

    public void setEstadoVTV(EstadoVTV estadoVTV) {
        this.estadoVTV = estadoVTV;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
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
        if (!(object instanceof Vtv)) {
            return false;
        }
        Vtv other = (Vtv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vtv[ id=" + id + " ]";
    }
    
}
