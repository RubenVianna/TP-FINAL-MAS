/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Persistencia.ControladorPersistencia;
import controlador.Controlador;
import modelo.*;
import vista.MenuPrincipal;

/**
 *
 * @author Usuario
 */
public class main {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        Cliente c5 = new Cliente(123, "Marcos", "Perez", "3765-346578", "calle 321");
        controlador.persistirCliente(c5);

        TipoCompra t1 = new TipoCompra("Compra directa");
        TipoCompra t2 = new TipoCompra("Plan de pago");

        controlador.persistirTipoCompra(t1);
        controlador.persistirTipoCompra(t2);

        MedioPago mp = new MedioPago("Efectivo");
        MedioPago mp2 = new MedioPago("Debito");
        MedioPago mp3 = new MedioPago("Credito");
        MedioPago mp4 = new MedioPago("MercadoPago");
        MedioPago mp5 = new MedioPago("Cheque");

        controlador.persistirMedioPago(mp);
        controlador.persistirMedioPago(mp2);
        controlador.persistirMedioPago(mp3);

        controlador.persistirMedioPago(mp4);

        controlador.persistirMedioPago(mp5);

        Marca marca1 = new Marca("Chevrolet");
        Marca marca2 = new Marca("Toyota");
        Marca marca3 = new Marca("volkswagen");

        controlador.persistirMarca(marca1);
        controlador.persistirMarca(marca2);
        controlador.persistirMarca(marca3);

        Modelo mod1 = new Modelo("Cruze", marca1);
        Modelo mod2 = new Modelo("Sonic", marca1);
        Modelo mod3 = new Modelo("Onix", marca1);

        controlador.persistirModelo(mod1);
        controlador.persistirModelo(mod2);
        controlador.persistirModelo(mod3);

        Modelo mod4 = new Modelo("Corolla", marca2);
        Modelo mod5 = new Modelo("Etios", marca2);

        controlador.persistirModelo(mod4);
        controlador.persistirModelo(mod5);

        Automovil auto1 = new Automovil(mod1, "2020", (float) 2000000.00, 1);
        Automovil auto2 = new Automovil(mod1, "2021", (float) 3000000.00, 1);
        Automovil auto3 = new Automovil(mod2, "2020", (float) 1000000.00, 1);

        controlador.persistirAutomovil(auto1);
        controlador.persistirAutomovil(auto2);
        controlador.persistirAutomovil(auto3);

        PlanDePago plan1 = new PlanDePago("Plan 1", 6, (float) 0.1);

        PlanDePago plan2 = new PlanDePago("Plan 2", 12, (float) 0.2);

        PlanDePago plan3 = new PlanDePago("Plan 3", 18, (float) 0.35);

        controlador.persistirPlanDePago(plan1);
        controlador.persistirPlanDePago(plan2);
        controlador.persistirPlanDePago(plan3);

        EstadoCuota et = new EstadoCuota("Pagada");
        EstadoCuota et1 = new EstadoCuota("No pagada");

        controlador.persistirEstadoCuota(et);
        controlador.persistirEstadoCuota(et1);

        CotizadorKilometraje ck = new CotizadorKilometraje(0.000005f);
        CotizadorAntiguedad ca = new CotizadorAntiguedad(0.05f);

        controlador.persistirCotizadorAntiguedad(ca);
        controlador.persistirCotizadorKilometraje(ck);

        EstadoTurno esta = new EstadoTurno("Disponible");
        EstadoTurno esta2 = new EstadoTurno("Ocupado");

        controlador.persistirEstadoTurno(esta);
        controlador.persistirEstadoTurno(esta2);

        Requisito req = new Requisito("Patente al dia");
        Requisito req2 = new Requisito("Poliza de seguro vigente");
        Requisito req3 = new Requisito("VTV aprobada");
        Requisito req4 = new Requisito("Ser de Boca");

        controlador.persistirRequisito(req);
        controlador.persistirRequisito(req2);
        controlador.persistirRequisito(req3);
        controlador.persistirRequisito(req4);
        
        EstadoVenta estav = new EstadoVenta ("En proceso");
        EstadoVenta estav2 = new EstadoVenta ("Concretada");
        EstadoVenta estav3 = new EstadoVenta ("Cancelada");
        
        controlador.persistirEstadoVenta(estav);
        controlador.persistirEstadoVenta(estav2);
        controlador.persistirEstadoVenta(estav3);


        
        controlador.cargar2Turnos();
        
        EstadoVTV etv = new EstadoVTV ("Aprobado");
        EstadoVTV etv2 = new EstadoVTV ("Desaprobado");
        EstadoVTV etv3 = new EstadoVTV ("Pendiente");
        
        controlador.persistirEstadoEstadoVtv(etv);
         controlador.persistirEstadoEstadoVtv(etv2);
        controlador.persistirEstadoEstadoVtv(etv3);
        
        MenuPrincipal menu = new MenuPrincipal(controlador);
        menu.setVisible(true);

    }
}
