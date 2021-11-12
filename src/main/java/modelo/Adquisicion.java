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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author RUBEN
 */
@Entity
public class Adquisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    private Date fecha;
    
    @Basic 
    private float monto;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Automovil auto;
    
    @ManyToOne
    private MedioPago medioPago;
    
    @ManyToOne
    private PlanDePago planDePago;
    
    @ManyToOne
    private TipoCompra tipoCompra;
    
    @OneToMany
    //@JoinColumn(name="cuotas_id")
    private List<Cuota> cuotas;

    public Adquisicion() {
    }

      public Adquisicion(Date fecha, Cliente cliente, Automovil auto, MedioPago medioPago, PlanDePago planDePago, TipoCompra tipoCompra) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.auto = auto;
        this.medioPago = medioPago;
        this.planDePago = planDePago;
        this.tipoCompra = tipoCompra;
        this.cuotas = null;
        
    }
    
    public Adquisicion(Date fecha, Cliente cliente, Automovil auto, MedioPago medioPago, PlanDePago planDePago, TipoCompra tipoCompra, float monto, List<Cuota> cuotas) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.auto = auto;
        this.medioPago = medioPago;
        this.planDePago = planDePago;
        this.tipoCompra = tipoCompra;
        this.monto = monto;
        this.cuotas = cuotas;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Automovil getAuto() {
        return auto;
    }

    public void setAuto(Automovil auto) {
        this.auto = auto;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public PlanDePago getPlanDePago() {
        return planDePago;
    }

    public void setPlanDePago(PlanDePago planDePago) {
        this.planDePago = planDePago;
    }

    public TipoCompra getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(TipoCompra tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
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
        if (!(object instanceof Adquisicion)) {
            return false;
        }
        Adquisicion other = (Adquisicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Adquisicion[ id=" + id + " ]";
    }
    
}
