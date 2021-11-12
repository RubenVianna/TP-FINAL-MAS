/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author RUBEN
 */
@Entity
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EstadoVenta estadoVenta;
    
    @ManyToOne
    private CotizadorKilometraje cotizadorKilometraje;
    
    @ManyToOne
    private CotizadorAntiguedad cotizadorAntiguedad;
    
    @ManyToOne
    private AutomovilUsado autoUsado;
    
    @ManyToOne
    private MedioPago medioPago;
    
    @Basic
    private Date fecha;
    
    @ManyToMany 
    private List<Requisito>requisitos;

    public Venta() {
    }

    public Venta(EstadoVenta estadoVenta, CotizadorKilometraje cotizador, CotizadorAntiguedad coti, AutomovilUsado autoUsado, MedioPago medioPago) {
        this.estadoVenta = estadoVenta;
        this.cotizadorKilometraje = cotizador;
        this.cotizadorAntiguedad = coti;
        this.autoUsado = autoUsado;
        this.medioPago = medioPago;
    }

    public Venta(EstadoVenta estadoVenta, CotizadorKilometraje cotizadorKilometraje, CotizadorAntiguedad cotizadorAntiguedad, AutomovilUsado autoUsado, MedioPago medioPago, List<Requisito> requisitos) {
        this.estadoVenta = estadoVenta;
        this.cotizadorKilometraje = cotizadorKilometraje;
        this.cotizadorAntiguedad = cotizadorAntiguedad;
        this.autoUsado = autoUsado;
        this.medioPago = medioPago;
        this.requisitos = requisitos;
    }

        public Venta(EstadoVenta estadoVenta, CotizadorKilometraje cotizadorKilometraje, CotizadorAntiguedad cotizadorAntiguedad, AutomovilUsado autoUsado, List<Requisito> requisitos) {
        this.estadoVenta = estadoVenta;
        this.cotizadorKilometraje = cotizadorKilometraje;
        this.cotizadorAntiguedad = cotizadorAntiguedad;
        this.autoUsado = autoUsado;
        this.requisitos = requisitos;
    }
    
    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    
    
    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public CotizadorKilometraje getCotizadorKilometraje() {
        return cotizadorKilometraje;
    }

    public void setCotizadorKilometraje(CotizadorKilometraje cotizadorKilometraje) {
        this.cotizadorKilometraje = cotizadorKilometraje;
    }

    public CotizadorAntiguedad getCotizadorAntiguedad() {
        return cotizadorAntiguedad;
    }

    public void setCotizadorAntiguedad(CotizadorAntiguedad cotizadorAntiguedad) {
        this.cotizadorAntiguedad = cotizadorAntiguedad;
    }

  

    public AutomovilUsado getAutoUsado() {
        return autoUsado;
    }

    public void setAutoUsado(AutomovilUsado autoUsado) {
        this.autoUsado = autoUsado;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ id=" + id + " ]";
    }
    
}
