/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Persistencia.ControladorPersistencia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.*;

import vista.MenuPrincipal;

/**
 *
 * @author Usuario
 */
public class Controlador {
    
    private MenuPrincipal menu;
    
    private ControladorPersistencia controladorPersistencia;

    public Controlador(MenuPrincipal menu, ControladorPersistencia cp) {
        this.menu = menu;
        this.controladorPersistencia = cp;
    }
    
    
    public Controlador() {
            
        controladorPersistencia = new ControladorPersistencia();
    
    }
    
    //ABML CLIENTE
    public void persistirCliente (Cliente cli){
        this.controladorPersistencia.persistirCliente(cli);
    }
    
    public void actualizarCliente (Cliente cli){
        this.controladorPersistencia.actualizarCliente(cli);
    }
    
    public void eliminarCliente (Cliente cli){
        this.controladorPersistencia.actualizarCliente(cli);
    }
    
    public Cliente buscarCliente (int dni){
       Cliente cli = null;
       cli= this.controladorPersistencia.buscarCliente(dni);
       return cli;
    }
    
     //ABML TipoCompra
    public void persistirTipoCompra (TipoCompra tp){
        this.controladorPersistencia.persistirTipoCompra(tp);
    }
    
    public void actualizarTipoCompra (TipoCompra tp){
        this.controladorPersistencia.actualizarTipoCompra(tp);
    }
    
    public void eliminarTipoCompra (TipoCompra tp){
        this.controladorPersistencia.actualizarTipoCompra(tp);
    }
    
    public TipoCompra buscarTipoCompra (String nombre){
       TipoCompra tp = null;
       tp= this.controladorPersistencia.buscarTipoCompra(nombre);
       return tp;
    }
    
    
     //ABML Automovil
    public void persistirAutomovil (Automovil auto){
        this.controladorPersistencia.persistirAutomovil(auto);
    }
    
        public Automovil buscarAutomovil (Long id){
       Automovil auto = null;
       auto= this.controladorPersistencia.buscarAutomovil(id);
       return auto;
    }
    
    public void actualizarAutomovil (Automovil auto){
        this.controladorPersistencia.actualizarAutomovil(auto);
    }
    
    public void eliminarAutomovil (Automovil auto){
        this.controladorPersistencia.actualizarAutomovil(auto);
    }
    

    
    public Automovil buscarAutomovil (Modelo modelo, String year) {
        Automovil auto = this.controladorPersistencia.buscarAutomovil(modelo, year);
        return auto;
    }
    
    
    public List<Automovil> ListarAutomoviles () {
        List<Automovil> autos = this.controladorPersistencia.ListarAutomoviles();
        return autos;
    }
    
    public List<Automovil> ListarAutomoviles (Marca marca) {
        List<Automovil> autos = this.controladorPersistencia.ListarAutomoviles(marca);
        return autos;
    }
    
     public List<Automovil> ListarAutomoviles (Modelo modelo) {
        List<Automovil> autos = this.controladorPersistencia.ListarAutomoviles(modelo);
        return autos;
    }
    
  
     
    public List<TipoCompra> ListarTiposCompra () {
        List<TipoCompra> tipos = this.controladorPersistencia.ListarTiposCompra();
        return tipos;
    }   
    
     public List<Vtv> ListarVtvsDelDia () {
        Calendar cal = Calendar.getInstance();
         List<Vtv> vtvs = null;
         
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MONTH, ERROR_MESSAGE);
        Date fecha1 = cal.getTime();
//        fecha1.setMonth(7);
//        fecha1.setDate(1);
//        fecha1.setYear(2021);
//        fecha1.setHours(0);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, (dia+1));
        Date fecha2 = cal.getTime();
//        Date fecha2 = fecha1;
//        fecha2.setDate(fecha1.getDate()+1);
        System.out.println("Fecha hoy: "+fecha1);
        System.out.println("Fecha mañana: "+fecha2);
        vtvs= this.controladorPersistencia.ListarVtvs(fecha1, fecha2);
       
   
        
        return vtvs;
    }   
    
   
    public List<EstadoVTV> ListarEstados () {
        List<EstadoVTV> tipos = this.controladorPersistencia.ListarEstados();
        return tipos;
    }   
            
    
    public List<MedioPago> ListarMediosPago () {
        List<MedioPago> medios = this.controladorPersistencia.ListarMediosPago();
        return medios;
    } 
    
    public List<PlanDePago> ListarPlanesDePago () {
        List<PlanDePago> planes = this.controladorPersistencia.ListarPlanesDePago();
        return planes;
    } 
    
    public List<Modelo> ListarModelos (Marca marca) {
        List<Modelo> modelos = this.controladorPersistencia.ListarModelos(marca);
        return modelos;
    } 
    
    public List<Marca> ListarMarcas () {
        List<Marca> marcas = this.controladorPersistencia.ListarMarcas();
        return marcas;
    } 
    
    
     //ABML Marca
    public void persistirMarca (Marca marca){
        this.controladorPersistencia.persistirMarca(marca);
    }
    
    public void actualizarMarca (Marca marca){
        this.controladorPersistencia.actualizarMarca(marca);
    }
    
    public void eliminarMarca (Marca marca){
        this.controladorPersistencia.actualizarMarca(marca);
    }
    
     public Marca buscarMarca (String nombre){
       Marca marca = null;
       marca= this.controladorPersistencia.buscarMarca(nombre);
       return marca;
    } 
     
     
     //ABML Modelo
    public void persistirModelo(Modelo modelo){
        this.controladorPersistencia.persistirModelo(modelo);
    }
    
    public void actualizarModelo (Modelo modelo){
        this.controladorPersistencia.actualizarModelo(modelo);
    }
    
    public void eliminarModelo (Modelo modelo){
        this.controladorPersistencia.actualizarModelo(modelo);
    }
     
            
     public Modelo buscarModelo (String nombre){
       Modelo modelo = null;
       modelo= this.controladorPersistencia.buscarModelo(nombre);
       return modelo;
    } 
     
       //ABML PlanDePago
    public void persistirPlanDePago (PlanDePago plan){
        this.controladorPersistencia.persistirPlanDePago (plan);
    }
    
    public void actualizarPlanDePago (PlanDePago plan){
        this.controladorPersistencia.actualizarPlanDePago(plan);
    }
    
    public void eliminarPlanDePago (PlanDePago plan){
        this.controladorPersistencia.actualizarPlanDePago(plan);
    }
    
     public PlanDePago buscarPlanDePago (Long id){
       PlanDePago plan = null;
       plan= this.controladorPersistencia.buscarPlanDePago(id);
       return plan;
    } 
     
     public PlanDePago buscarPlanDePago (String nombre){
       PlanDePago plan = null;
       plan= this.controladorPersistencia.buscarPlanDePago(nombre);
       return plan;
    } 
     
      //ABML MedioPago
    public void persistirMedioPago (MedioPago plan){
        this.controladorPersistencia.persistirMedioPago (plan);
    }
    
    public void actualizarMedioPago (MedioPago plan){
        this.controladorPersistencia.actualizarMedioPago(plan);
    }
    
    public void eliminarMedioPago (MedioPago plan){
        this.controladorPersistencia.actualizarMedioPago(plan);
    }
    
     public MedioPago buscarMedioPago (Long id){
       MedioPago medio = null;
       medio= this.controladorPersistencia.buscarMedioPago(id);
       return medio;
    } 
     public MedioPago buscarMedioPago (String nombre){
       MedioPago plan = null;
       plan= this.controladorPersistencia.buscarMedioPago(nombre);
       return plan;
    }
     
     
     
     
     public void cargarCuotas(Adquisicion adqui, PlanDePago plan){
         EstadoCuota et1 = this.buscarEstadoCuota("No pagada");
         //borrar de aca despues estos estados cuota y poner en el main
         
         List<Cuota>cuotas = new ArrayList();
         adqui.setCuotas(cuotas);
         int cantCuotas = plan.getCantidadCuotas();
         float interes = plan.getInteres();
         float valorAuto = adqui.getAuto().getCotizacion();
         float montoTotal = valorAuto+ valorAuto * interes;
         System.out.println("Monto del auto:"+valorAuto);
         System.out.println("Monto total a pagar: "+ montoTotal);
         adqui.setMonto(montoTotal);
         
         System.out.println("adqui.getMonto() = "+adqui.getMonto());
         //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Fecha actual
        Calendar calendar = Calendar.getInstance(); 
        
        
        
        //A la fecha actual le pongo el día 1
        calendar.set(Calendar.DAY_OF_MONTH,1);
        float montoCuota = montoTotal/cantCuotas;
        for(int i=1;cantCuotas>=i;i++){
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
        Cuota cuota = new Cuota();
        cuota.setEstadoCuota(et1);
        cuota.setNroCuota(i);
        cuota.setMonto(montoCuota);
        cuota.setVencimiento(calendar.getTime());
        cuotas.add(cuota);
        this.persistirCuota(cuota);
        }
        adqui.setCuotas(cuotas);
    }
     
     
      //ABML EstadoCuota
    public void persistirEstadoCuota (EstadoCuota estado){
        this.controladorPersistencia.persistirEstadoCuota (estado);
    }
    
    public void actualizarEstadoCuota (EstadoCuota estado){
        this.controladorPersistencia.actualizarEstadoCuota(estado);
    }
    
    public void eliminarEstadoCuota (EstadoCuota estado){
        this.controladorPersistencia.actualizarEstadoCuota(estado);
    }
    
    
     public EstadoCuota buscarEstadoCuota (String nombre){
       EstadoCuota estado = null;
       estado= this.controladorPersistencia.buscarEstadoCuota(nombre);
       return estado;
    }
     
     
     
    //ABML Cuota
    public void persistirCuota (Cuota cuota){
        this.controladorPersistencia.persistirCuota (cuota);
    }
    
    public void actualizarCuota (Cuota cuota){
        this.controladorPersistencia.actualizarCuota(cuota);
    }
    
    public void eliminarCuota (Cuota cuota){
        this.controladorPersistencia.actualizarCuota(cuota);
    }
    
     public Cuota buscarCuota (Long id){
       Cuota cuota = this.controladorPersistencia.buscarCuota(id);
       return cuota;
    } 
     
     
     
       //ABML Adquisicion
    public void persistirAdquisicion(Adquisicion adq){
        this.controladorPersistencia.persistirAdquisicion (adq);
    }
    
    public void actualizarAdquisicion (Adquisicion adq){
        this.controladorPersistencia.actualizarAdquisicion(adq);
    }
    
    public void eliminarAdquisicion (Adquisicion adq){
        this.controladorPersistencia.actualizarAdquisicion(adq);
    }
    
     public Adquisicion buscarAdquisicion (Long id){
       Adquisicion adq = this.controladorPersistencia.buscarAdquisicion(id);
       return adq;
    } 
     
     
    public void persistirCotizadorAntiguedad(CotizadorAntiguedad ca){
        this.controladorPersistencia.persistirCotizadorAntiguedad (ca);
    }
    
    public void persistirCotizadorKilometraje(CotizadorKilometraje ck){
        this.controladorPersistencia.persistirCotizadorKilometraje (ck);
    }
     
    
     public CotizadorAntiguedad buscarCotizadorAntiguedad (Long id){
       CotizadorAntiguedad adq = this.controladorPersistencia.buscarCotizadorAntiguedad(id);
       return adq;
    } 
    
      public CotizadorKilometraje buscarCotizadorKilometraje (Long id){
       CotizadorKilometraje adq = this.controladorPersistencia.buscarCotizadorKilometraje(id);
       return adq;
    } 
     
     public float cotizarAuto (float monto, float kilometraje, String anio){
         CotizadorAntiguedad ca = this.buscarCotizadorAntiguedad(Long.parseLong("1"));
         CotizadorKilometraje ck = this.buscarCotizadorKilometraje(Long.parseLong("1"));
         float cotizacion=monto;
         int ban=0;
         
         if (ca == null || ck == null){
             ban=1;
             
         }
         
         if (ban==0){
               
         
         float descuentoAntiguedad;
         float descuentoKilometraje;
         Calendar cal = Calendar.getInstance();
         Date f = new Date();
         String fecha = f.toString();
         //System.out.println("fecha del new date: "+fecha);
         cal.setTime(f);
         int year = cal.get(Calendar.YEAR);
        //  System.out.println("año calculado: "+year);
         int antiguedad =  year - Integer.parseInt(anio);
        // System.out.println("antiguedad del auto: "+antiguedad);
         descuentoAntiguedad= antiguedad * ca.getDescuentoForYear() * monto;
         descuentoKilometraje = kilometraje * ck.getDescuentoPorcentaje() * monto;
        // System.out.println("cotizacion antes del descuento: "+monto);
         cotizacion -= (descuentoAntiguedad + descuentoKilometraje);
        // System.out.println("cotizacion despues del descuento: "+cotizacion);
         }
       
         
         return cotizacion;
     }
     
     
     
     //ABML EstadoTurno
    public void persistirEstadoTurno (EstadoTurno tp){
        this.controladorPersistencia.persistirEstadoTurno(tp);
    }
    
    public void actualizarEstadoTurno (EstadoTurno tp){
        this.controladorPersistencia.actualizarEstadoTurno(tp);
    }
    
    public void eliminarEstadoTurno (EstadoTurno tp){
        this.controladorPersistencia.actualizarEstadoTurno(tp);
    }
    
    public EstadoTurno buscarEstadoTurno (String nombre){
       EstadoTurno tp = null;
       tp= this.controladorPersistencia.buscarEstadoTurno(nombre);
       return tp;
    }
    
    public EstadoTurno buscarEstadoTurno (Long id){
       EstadoTurno tp = null;
       tp= this.controladorPersistencia.buscarEstadoTurno(id);
       return tp;
    }
    
    
    //ABML Turno
    public void persistirTurno (Turno turno){
        this.controladorPersistencia.persistirTurno(turno);
    }
    
    public void actualizarTurno (Turno turno){
        this.controladorPersistencia.actualizarTurno(turno);
    }
    
    public void eliminarTurno (Turno turno){
        this.controladorPersistencia.actualizarTurno(turno);
    }
    
     public Turno buscarTurno (Long id){
       Turno turno = this.controladorPersistencia.buscarTurno(id);
       return turno;
    } 
    
     public List<Turno> ListarTurnosDisponibles(){
         EstadoTurno et = this.buscarEstadoTurno("Disponible");
         List<Turno>turnos = this.controladorPersistencia.ListarTurnosDisponibles(et);
         return turnos;
     }
     
     
      //ABML Requisito
    public void persistirRequisito (Requisito  requi){
        this.controladorPersistencia.persistirRequisito (requi);
    }
     
       public List<Requisito> ListarRequisitos () {
        List<Requisito> requisitos = this.controladorPersistencia.ListarRequisitos();
        return requisitos;
    } 
       
       //ABML Empleado
    public void persistirEmpleado (Empleado emp){
        this.controladorPersistencia.persistirEmpleado(emp);
    }
    
       public void cargar2Turnos(){
           Empleado emp = new Empleado(36578960, "Mario", "Martinez", "3764-443565", "calle 1wq12");
           this.persistirEmpleado(emp);
           Calendar calendar = Calendar.getInstance(); 
           EstadoTurno et = this.buscarEstadoTurno("Disponible");
        
        
        //A la fecha actual le pongo el día 1
//        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        int hora=calendar.get(Calendar.HOUR_OF_DAY);
//        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
        
        Date fecha=(calendar.getTime());
        Turno t1 = new Turno(fecha, hora, et, emp );
        Turno t2 = new Turno(fecha, (hora+1), et, emp);
        
        this.persistirTurno(t1);
        this.persistirTurno(t2);
       }
    
       
        //ABML EstadoVenta
    public void persistirEstadoVenta (EstadoVenta ev){
        this.controladorPersistencia.persistirEstadoVenta(ev);
    }
    
    public void actualizarEstadoVenta (EstadoVenta ev){
        this.controladorPersistencia.actualizarEstadoVenta(ev);
    }
    
    //ABML Venta
    public void persistirVenta (Venta venta){
        this.controladorPersistencia.persistirVenta(venta);
    }
    
    public void actualizarVenta (Venta venta){
        this.controladorPersistencia.actualizarVenta(venta);
    }
    
    public void eliminarVenta (Venta venta){
        this.controladorPersistencia.actualizarVenta(venta);
    }
    
     public Venta buscarVenta (Long id){
       Venta venta = this.controladorPersistencia.buscarVenta(id);
       return venta;
    } 
     
     //ABML AutomovilUsado
    public void persistirAutomovilUsado (AutomovilUsado auto){
        this.controladorPersistencia.persistirAutomovilUsado(auto);
    }
    
    public void actualizarAutomovilUsado (AutomovilUsado auto){
        this.controladorPersistencia.actualizarAutomovilUsado(auto);
    }
    
    public void eliminarAutomovilUsado (AutomovilUsado auto){
        this.controladorPersistencia.actualizarAutomovilUsado(auto);
    }
    
    public AutomovilUsado buscarAutomovilUsado (Long id){
       AutomovilUsado auto = null;
       auto= this.controladorPersistencia.buscarAutomovilUsado(id);
       return auto;
    }
    
    
     public EstadoVenta buscarEstadoVenta (String nombre){
       EstadoVenta tp = null;
       tp= this.controladorPersistencia.buscarEstadoVenta(nombre);
       return tp;
    }
    
    public EstadoVenta buscarEstadoVenta (Long id){
       EstadoVenta tp = null;
       tp= this.controladorPersistencia.buscarEstadoVenta(id);
       return tp;
    }
    
         //ABML VTV
    public void persistirVtv (Vtv vtv){
        this.controladorPersistencia.persistirVtv(vtv);
    }
    
       public void actualizarVtv (Vtv vtv){
        this.controladorPersistencia.actualizarVtv(vtv);
    }
    
        public Vtv buscarVtv (Long id){
       Vtv vtv = null;
       vtv= this.controladorPersistencia.buscarVtv(id);
       return vtv;
    }
 
       //ABML EstadoVtv
    public void persistirEstadoEstadoVtv (EstadoVTV ev){
        this.controladorPersistencia.persistirEstadoVtv(ev);
    }
    public EstadoVTV buscarEstadoVtv (Long id){
       EstadoVTV vtv = null;
       vtv= this.controladorPersistencia.buscarEstadoVtv(id);
       return vtv;
    }
    
     public EstadoVTV buscarEstadoVTV(String nombre){
       EstadoVTV tp = null;
       tp= this.controladorPersistencia.buscarEstadoVTV(nombre);
       return tp;
    }
    
}
