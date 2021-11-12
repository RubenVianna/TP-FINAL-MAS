/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.Date;
import java.util.List;
import modelo.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author Julian
 */
public class ControladorPersistencia {

    private final EntityManagerFactory miFabricaDeEntidades;
    private final EntityManager em;


    public ControladorPersistencia() {
        miFabricaDeEntidades = Persistence.createEntityManagerFactory("unidadPersistenciaMetodologias");
     
        em = miFabricaDeEntidades.createEntityManager();
        //esta segunda linea no esta en el video
    }
    
    
    //ABML CLIENTE
     public void persistirCliente(Cliente unCliente){
        em.getTransaction().begin();
        em.persist(unCliente);
        em.getTransaction().commit();
    }
    
     public void actualizarCliente (Cliente cli)  {
	
		em.getTransaction().begin();
		cli = em.merge(cli);
		em.getTransaction().commit();
	
    }
   
       public void eliminarCliente (Cliente client) {
               
                em.getTransaction().begin();
		Cliente cli;
		cli = em.getReference(Cliente.class, client);
		cli.getId();			
		em.remove(cli);
		em.getTransaction().commit();
	
    }
       
       public Cliente buscarCliente (int dni){
           Cliente cli= null;
	    Query query = this.em.createQuery("SELECT c FROM Cliente c WHERE c.dni= :dni");
            query.setParameter ("dni", dni);
            List<Cliente> clientes = query.getResultList();
            if(!clientes.isEmpty()){
             cli = (Cliente) query.getSingleResult();
            }
                             
        
	return cli;
       }
       
       
        //ABML TipoCompra
     public void persistirTipoCompra(TipoCompra tp){
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
    }
    
     public void actualizarTipoCompra (TipoCompra tp)  {
	
		em.getTransaction().begin();
		tp = em.merge(tp);
		em.getTransaction().commit();
	
    }
   
       public void eliminarTipoCompra (TipoCompra tp) {
               
                em.getTransaction().begin();
		TipoCompra tipo;
		tipo = em.getReference(TipoCompra.class, tp);
		tipo.getId();			
		em.remove(tipo);
		em.getTransaction().commit();
	
    }
       
       public TipoCompra buscarTipoCompra (String nombre){
           TipoCompra tp= null;
	    Query query = this.em.createQuery("SELECT t FROM TipoCompra t WHERE t.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<TipoCompra> tipos = query.getResultList();
            if(!tipos.isEmpty()){
             tp = (TipoCompra) query.getSingleResult();
            }
                             
        
	return tp;
       }
       
       
        //ABML Automovil
     public void persistirAutomovil(Automovil auto){
        em.getTransaction().begin();
        em.persist(auto);
        em.getTransaction().commit();
    }
    
     public void actualizarAutomovil (Automovil auto)  {
	
		em.getTransaction().begin();
		auto = em.merge(auto);
		em.getTransaction().commit();
	
    }
   
       public void eliminarAutomovil (Automovil auto) {
               
                em.getTransaction().begin();
		Automovil autito;
		autito = em.getReference(Automovil.class, auto);
		autito.getId();			
		em.remove(autito);
		em.getTransaction().commit();
	
    }
       
       public Automovil buscarAutomovil (Long id){
           Automovil auto= null;
	    Query query = this.em.createQuery("SELECT a FROM Automovil a WHERE a.id = :id");
            query.setParameter ("id", id);
            List<Automovil> autos = query.getResultList();
            if(!autos.isEmpty()){
             auto = (Automovil) query.getSingleResult();
            }
                             
        
	return auto;
       }
       
        //ABML EstadoCuota
     public void persistirEstadoCuota(EstadoCuota et){
        em.getTransaction().begin();
        em.persist(et);
        em.getTransaction().commit();
    }
    
     public void actualizarEstadoCuota (EstadoCuota ec)  {
	
		em.getTransaction().begin();
		ec = em.merge(ec);
		em.getTransaction().commit();
	
    }
   
       public void eliminarEstadoCuota(EstadoCuota et) {
               
                em.getTransaction().begin();
		EstadoCuota estado;
		estado = em.getReference(EstadoCuota.class, et);
		estado.getId();			
		em.remove(estado);
		em.getTransaction().commit();
	
    }
       
       public EstadoCuota buscarEstadoCuota (String nombre){
           EstadoCuota et= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoCuota e WHERE e.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<EstadoCuota> estados = query.getResultList();
            if(!estados.isEmpty()){
             et = (EstadoCuota) query.getSingleResult();
            }
                             
        
	return et;
       
       }
       
       
       
       //LISTADOS
       public List<Automovil> ListarAutomoviles (){
            Query query = em.createQuery("Select a FROM Automovil a ");
            List<Automovil> autos= query.getResultList();       
            return autos;
       }
       
         public List<Automovil> ListarAutomoviles (Marca marca){
            Query query = em.createQuery("Select a FROM Automovil a WHERE a.modelo.marca.id =:marca ");
            query.setParameter ("marca", marca.getId());
             List<Automovil> autos= query.getResultList();       
            return autos;
       }
         
        public List<Automovil> ListarAutomoviles (Modelo modelo){
            Query query = em.createQuery("Select a FROM Automovil a WHERE  a.modelo = :modelo ");
            
             query.setParameter("modelo", modelo);
             List<Automovil> autos= query.getResultList();       
            return autos;
       }
        
        
         public Automovil buscarAutomovil (Modelo modelo, String year){
            Automovil auto = null;
             Query query = em.createQuery("Select a FROM Automovil a WHERE a.year =:year AND a.modelo.id = :modelo AND a.year = :year ");
            query.setParameter ("year", year)
                 .setParameter ("modelo", modelo.getId());
           

             List<Automovil> autos= query.getResultList(); 
             if(!autos.isEmpty()){
             auto = (Automovil) query.getSingleResult();
            }
            return auto;
       }
       
         
       
        public List<TipoCompra> ListarTiposCompra (){
            Query query = em.createQuery("Select t FROM TipoCompra t ");
            List<TipoCompra> tipos= query.getResultList();       
            return tipos;
       }
        
        
        public List<EstadoVTV> ListarEstados (){
            Query query = em.createQuery("Select t FROM EstadoVTV t ");
            List<EstadoVTV> tipos= query.getResultList();       
            return tipos;
       }
        
        public List<Vtv> ListarVtvs (Date fecha1, Date fecha2){
            //Query query = em.createQuery("Select v FROM Vtv v WHERE v.turno.fecha>= :fecha1 AND v.turno.fecha< :fecha2 ");
            Query query = em.createQuery("Select v FROM Vtv v ");
//            query.setParameter("fecha1", fecha1)
//                 .setParameter("fecha2", fecha2);
            List<Vtv> vtvs= query.getResultList();       
            return vtvs;
       }
       
        public List<MedioPago> ListarMediosPago (){
            Query query = em.createQuery("Select m FROM MedioPago m ");
            List<MedioPago> medios= query.getResultList();       
            return medios;
       }
        
         public List<PlanDePago> ListarPlanesDePago (){
            Query query = em.createQuery("Select p FROM PlanDePago p ");
            List<PlanDePago> planes= query.getResultList();       
            return planes;
       }
        
        
        
          public List<Modelo> ListarModelos (Marca marca){
            Query query = em.createQuery("Select m FROM Modelo m WHERE m.marca.id =:marca ");
            query.setParameter ("marca", marca.getId());
            List<Modelo> modelos = query.getResultList();
            
               
            return modelos;
       }
        
        public List<Marca> ListarMarcas (){
            Query query = em.createQuery("Select m FROM Marca m ");
            List<Marca> marcas= query.getResultList();       
            return marcas;
       }
          
          
          //ABML Marca
     public void persistirMarca(Marca marca){
        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();
    }
    
     public void actualizarMarca (Marca marca)  {
	
		em.getTransaction().begin();
		marca = em.merge(marca);
		em.getTransaction().commit();
	
    }
   
       public void eliminarMarca (Marca marca) {
               
                em.getTransaction().begin();
		Marca ma;
		ma = em.getReference(Marca.class, marca);
		ma.getId();			
		em.remove(ma);
		em.getTransaction().commit();
	
    }
        
           public Marca buscarMarca (String nombre){
           Marca marca= null;
	    Query query = this.em.createQuery("SELECT m FROM Marca m WHERE m.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<Marca> marcas = query.getResultList();
            if(!marcas.isEmpty()){
             marca = (Marca) query.getSingleResult();
            }
                             
        
	return marca;
       }
           
        public void persistirCotizadorKilometraje(CotizadorKilometraje ck){
        em.getTransaction().begin();
        em.persist(ck);
        em.getTransaction().commit();
    }   
        
           public void persistirCotizadorAntiguedad(CotizadorAntiguedad ca){
        em.getTransaction().begin();
        em.persist(ca);
        em.getTransaction().commit();
    }   
           
           
            //ABML Modelo
     public void persistirModelo(Modelo modelo){
        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
    }
    
     public void actualizarModelo (Modelo modelo)  {
	
		em.getTransaction().begin();
		modelo = em.merge(modelo);
		em.getTransaction().commit();
	
    }
   
       public void eliminarModelo (Modelo modelo) {
               
                em.getTransaction().begin();
		Modelo ma;
		ma = em.getReference(Modelo.class, modelo);
		ma.getId();			
		em.remove(ma);
		em.getTransaction().commit();
	
    }
           
           
           
            public Modelo buscarModelo (String nombre){
           Modelo modelo= null;
	    Query query = this.em.createQuery("SELECT m FROM Modelo m WHERE m.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<Modelo> modelos = query.getResultList();
            if(!modelos.isEmpty()){
             modelo = (Modelo) query.getSingleResult();
            }
                             
        
	return modelo;
       }
            
            
            
              //ABML PlanDePago
     public void persistirPlanDePago(PlanDePago plan){
        em.getTransaction().begin();
        em.persist(plan);
        em.getTransaction().commit();
    }
    
     public void actualizarPlanDePago (PlanDePago plan)  {
	
		em.getTransaction().begin();
		plan = em.merge(plan);
		em.getTransaction().commit();
	
    }
   
       public void eliminarPlanDePago (PlanDePago plan) {
               
                em.getTransaction().begin();
		PlanDePago ma;
		ma = em.getReference(PlanDePago.class, plan);
		ma.getId();			
		em.remove(ma);
		em.getTransaction().commit();
	
    }
        
           public PlanDePago buscarPlanDePago (Long id){
           PlanDePago plan= null;
	    Query query = this.em.createQuery("SELECT p FROM PlanDePago p WHERE p.id =:id");
            query.setParameter ("id", id);
            List<PlanDePago> planes = query.getResultList();
            if(!planes.isEmpty()){
             plan = (PlanDePago) query.getSingleResult();
            }
                             
        
	return plan;
       }
           
           public PlanDePago buscarPlanDePago (String nombre){
           PlanDePago plan= null;
	    Query query = this.em.createQuery("SELECT p FROM PlanDePago p WHERE p.nombre =:nombre");
            query.setParameter ("nombre", nombre);
            List<PlanDePago> planes = query.getResultList();
            if(!planes.isEmpty()){
             plan = (PlanDePago) query.getSingleResult();
            }
                             
        
	return plan;
       }
           
           
           
      //ABML MedioPago
     public void persistirMedioPago(MedioPago modelo){
        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
    }
    
     public void actualizarMedioPago (MedioPago medio)  {
	
		em.getTransaction().begin();
		medio = em.merge(medio);
		em.getTransaction().commit();
	
    }
   
       public void eliminarMedioPago (MedioPago medio) {
               
                em.getTransaction().begin();
		MedioPago ma;
		ma = em.getReference(MedioPago.class, medio);
		ma.getId();			
		em.remove(ma);
		em.getTransaction().commit();
	
    }
           
           
           
            public MedioPago buscarMedioPago (String nombre){
           MedioPago medio= null;
	    Query query = this.em.createQuery("SELECT m FROM MedioPago m WHERE m.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<MedioPago> medios = query.getResultList();
            if(!medios.isEmpty()){
             medio = (MedioPago) query.getSingleResult();
            }
                             
        
	return medio;
       }
            
            public MedioPago buscarMedioPago (Long id){
           MedioPago medio= null;
	    Query query = this.em.createQuery("SELECT m FROM MedioPago m WHERE m.id= :id");
            query.setParameter ("id", id);
            List<MedioPago> medios = query.getResultList();
            if(!medios.isEmpty()){
             medio = (MedioPago) query.getSingleResult();
            }
                             
        
	return medio;
       }
            
            
                    //ABML Cuota
     public void persistirCuota(Cuota cuota){
        em.getTransaction().begin();
        em.persist(cuota);
        em.getTransaction().commit();
    }
    
     public void actualizarCuota (Cuota cuota)  {
	
		em.getTransaction().begin();
		cuota = em.merge(cuota);
		em.getTransaction().commit();
	
    }
   
       public void eliminarCuota (Cuota cuota) {
               
                em.getTransaction().begin();
		Cuota c;
		c = em.getReference(Cuota.class, cuota);
		c.getId();			
		em.remove(c);
		em.getTransaction().commit();
	
    }
       
       public Cuota buscarCuota (Long id){
           Cuota cuota= null;
	    Query query = this.em.createQuery("SELECT c FROM Cuota c WHERE c.id = :id");
            query.setParameter ("id", id);
            List<Cuota> autos = query.getResultList();
            if(!autos.isEmpty()){
             cuota = (Cuota) query.getSingleResult();
            }
                             
        
	return cuota;
       }
       
       
       
       
                       //ABML Adquisicion
     public void persistirAdquisicion(Adquisicion adq){
        em.getTransaction().begin();
        em.persist(adq);
        em.getTransaction().commit();
    }
    
     public void actualizarAdquisicion (Adquisicion adq)  {
	
		em.getTransaction().begin();
		adq = em.merge(adq);
		em.getTransaction().commit();
	
    }
   
       public void eliminarAdquisicion (Adquisicion adq) {
               
                em.getTransaction().begin();
		Adquisicion a;
		a = em.getReference(Adquisicion.class, adq);
		a.getId();			
		em.remove(a);
		em.getTransaction().commit();
	
    }
       
       public Adquisicion buscarAdquisicion (Long id){
           Adquisicion adq= null;
	    Query query = this.em.createQuery("SELECT a FROM Adquisicion a WHERE a.id = :id");
            query.setParameter ("id", id);
            List<Adquisicion> adquis = query.getResultList();
            if(!adquis.isEmpty()){
             adq = (Adquisicion) query.getSingleResult();
            }
                             
        
	return adq;
       }
       
       
          public CotizadorKilometraje buscarCotizadorKilometraje (Long id){
           CotizadorKilometraje coti= null;
	    Query query = this.em.createQuery("SELECT m FROM CotizadorKilometraje m WHERE m.id= :id");
            query.setParameter ("id", id);
            List<CotizadorKilometraje> medios = query.getResultList();
            if(!medios.isEmpty()){
             coti = (CotizadorKilometraje) query.getSingleResult();
            }
                             
        
	return coti;
       }
          
           public CotizadorAntiguedad buscarCotizadorAntiguedad (Long id){
           CotizadorAntiguedad coti= null;
	    Query query = this.em.createQuery("SELECT m FROM CotizadorAntiguedad m WHERE m.id= :id");
            query.setParameter ("id", id);
            List<CotizadorAntiguedad> medios = query.getResultList();
            if(!medios.isEmpty()){
             coti = (CotizadorAntiguedad) query.getSingleResult();
            }
                             
        
	return coti;
       }
           
           
           
           
            //ABML EstadoTurno
     public void persistirEstadoTurno(EstadoTurno tp){
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
    }
    
     public void actualizarEstadoTurno (EstadoTurno tp)  {
	
		em.getTransaction().begin();
		tp = em.merge(tp);
		em.getTransaction().commit();
	
    }
   
       public void eliminarEstadoTurno (EstadoTurno tp) {
               
                em.getTransaction().begin();
		EstadoTurno tipo;
		tipo = em.getReference(EstadoTurno.class, tp);
		tipo.getId();			
		em.remove(tipo);
		em.getTransaction().commit();
	
    }
       
       public EstadoTurno buscarEstadoTurno (String nombre){
           EstadoTurno tp= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoTurno e WHERE e.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<EstadoTurno> estados = query.getResultList();
            if(!estados.isEmpty()){
             tp = (EstadoTurno) query.getSingleResult();
            }
                             
        
	return tp;
       }
       
       public EstadoTurno buscarEstadoTurno (Long id){
           EstadoTurno tp= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoTurno e WHERE e.id =:id");
            query.setParameter ("id", id);
            List<EstadoTurno> estados = query.getResultList();
            if(!estados.isEmpty()){
             tp = (EstadoTurno) query.getSingleResult();
            }
                             
        
	return tp;
       }
           
          public List<Turno> ListarTurnosDisponibles(EstadoTurno et){
            Query query = em.createQuery("Select t FROM Turno t WHERE t.estadoTurno = :et");
            query.setParameter ("et", et);
            List<Turno> turnos= query.getResultList();       
            return turnos;
          }
          
          
                            //ABML Turno
     public void persistirTurno(Turno turno){
        em.getTransaction().begin();
        em.persist(turno);
        em.getTransaction().commit();
    }
    
     public void actualizarTurno (Turno adq)  {
	
		em.getTransaction().begin();
		adq = em.merge(adq);
		em.getTransaction().commit();
	
    }
   
       public void eliminarTurno (Turno adq) {
               
                em.getTransaction().begin();
		Turno a;
		a = em.getReference(Turno.class, adq);
		a.getId();			
		em.remove(a);
		em.getTransaction().commit();
	
    }
       
       public Turno buscarTurno (Long id){
            Turno turno= null;
	    Query query = this.em.createQuery("SELECT t FROM Turno t WHERE t.id = :id");
            query.setParameter ("id", id);
            List<Turno> turnos = query.getResultList();
            if(!turnos.isEmpty()){
             turno = (Turno) query.getSingleResult();
            }
                             
        
	return turno;
       }
    
       
       
              //ABML Requisito
     public void persistirRequisito(Requisito req){
        em.getTransaction().begin();
        em.persist(req);
        em.getTransaction().commit();
    }
          
            public List<Requisito> ListarRequisitos(){
            Query query = em.createQuery("Select r FROM Requisito r ");
            
            List<Requisito> requisitos= query.getResultList();       
            return requisitos;
          }
            
            
               //ABML Empleado
     public void persistirEmpleado(Empleado emp){
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }
    
     
     //ABML EstadoVenta
      public void persistirEstadoVenta(EstadoVenta et){
        em.getTransaction().begin();
        em.persist(et);
        em.getTransaction().commit();
    }
      
         public void actualizarEstadoVenta (EstadoVenta Eventa)  {
	
		em.getTransaction().begin();
		Eventa = em.merge(Eventa);
		em.getTransaction().commit();
	
    }
      
     
         //ABML Venta
     public void persistirVenta(Venta venta){
        em.getTransaction().begin();
        em.persist(venta);
        em.getTransaction().commit();
    }
    
     public void actualizarVenta (Venta venta)  {
	
		em.getTransaction().begin();
		venta = em.merge(venta);
		em.getTransaction().commit();
	
    }
   
       public void eliminarVenta (Venta venta) {
               
                em.getTransaction().begin();
		Venta ventita;
		ventita = em.getReference(Venta.class, venta);
		ventita.getId();			
		em.remove(ventita);
		em.getTransaction().commit();
	
    }
       
       public Venta buscarVenta (Long id){
           Venta venta= null;
	    Query query = this.em.createQuery("SELECT v FROM Venta v WHERE v.id  =:id");
            query.setParameter ("id", id);
            List<Venta> ventas = query.getResultList();
            if(!ventas.isEmpty()){
             venta = (Venta) query.getSingleResult();
            }
                             
        
	return venta;
       }
       
        //ABML AutomovilUsado
     public void persistirAutomovilUsado(AutomovilUsado auto){
        em.getTransaction().begin();
        em.persist(auto);
        em.getTransaction().commit();
    }
    
     public void actualizarAutomovilUsado (AutomovilUsado auto)  {
	
		em.getTransaction().begin();
		auto = em.merge(auto);
		em.getTransaction().commit();
	
    }
   
       public void eliminarAutomovilUsado (AutomovilUsado auto) {
               
                em.getTransaction().begin();
		AutomovilUsado autito;
		autito = em.getReference(AutomovilUsado.class, auto);
		autito.getId();			
		em.remove(autito);
		em.getTransaction().commit();
	
    }
       
       public AutomovilUsado buscarAutomovilUsado (Long id){
           AutomovilUsado auto= null;
	    Query query = this.em.createQuery("SELECT a FROM AutomovilUsado a WHERE a.id = :id");
            query.setParameter ("id", id);
            List<AutomovilUsado> autos = query.getResultList();
            if(!autos.isEmpty()){
             auto = (AutomovilUsado) query.getSingleResult();
            }
                             
        
	return auto;
       }
       
       
              public EstadoVenta buscarEstadoVenta (String nombre){
           EstadoVenta tp= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoVenta e WHERE e.nombre= :nombre");
            query.setParameter ("nombre", nombre);
            List<EstadoVenta> estados = query.getResultList();
            if(!estados.isEmpty()){
             tp = (EstadoVenta) query.getSingleResult();
            }
                             
        
	return tp;
       }
       
       public EstadoVenta buscarEstadoVenta (Long id){
           EstadoVenta tp= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoVenta e WHERE e.id =:id");
            query.setParameter ("id", id);
            List<EstadoVenta> estados = query.getResultList();
            if(!estados.isEmpty()){
             tp = (EstadoVenta) query.getSingleResult();
            }
                             
        
	return tp;
       }
       
          //ABML Vtv
     public void persistirVtv(Vtv vtv){
        em.getTransaction().begin();
        em.persist(vtv);
        em.getTransaction().commit();
    }
     
         public void actualizarVtv (Vtv vtv)  {
	
		em.getTransaction().begin();
		vtv = em.merge(vtv);
		em.getTransaction().commit();
	
    }
     
          public Vtv buscarVtv (Long id){
           Vtv vtv= null;
	    Query query = this.em.createQuery("SELECT v FROM Vtv v WHERE v.id =:id");
            query.setParameter ("id", id);
            List<Vtv> vtvs = query.getResultList();
            if(!vtvs.isEmpty()){
             vtv = (Vtv) query.getSingleResult();
            }
                             
        
	return vtv;
       }
          
            //ABML EstadoVtv
     public void persistirEstadoVtv(EstadoVTV vtv){
        em.getTransaction().begin();
        em.persist(vtv);
        em.getTransaction().commit();
    }
     
     
     
          public EstadoVTV buscarEstadoVtv (Long id){
           EstadoVTV vtv= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoVTV e WHERE e.id =:id");
            query.setParameter ("id", id);
            List<EstadoVTV> vtvs = query.getResultList();
            if(!vtvs.isEmpty()){
             vtv = (EstadoVTV) query.getSingleResult();
            }
                             
        
	return vtv;
       }
          
            public EstadoVTV buscarEstadoVTV (String nombre){
            EstadoVTV tp= null;
	    Query query = this.em.createQuery("SELECT e FROM EstadoVTV e WHERE e.nombre =:nombre");
            query.setParameter ("nombre", nombre);
            List<EstadoVTV> estados = query.getResultList();
            if(!estados.isEmpty()){
             tp = (EstadoVTV) query.getSingleResult();
            }
                             
        
	return tp;
       }
}