/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Pedido {
    private int id;
    private LocalDateTime fechaCreacion;
    private String estado;

    private Ruta ruta;
    private Transportista transportista;
    private List<RenglonPedido> renglones;
    private List<Movimiento> movimientos;
    
    //cuando se crea el Pedido el estado inicial es "Preparandose"
    //el Transportista y el Remito se asignan despues de la creacion mediante un usuario Administrativo/Gerente
    public Pedido(int id, LocalDateTime fechaCreacion, Ruta ruta, List<RenglonPedido> renglones) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = "Preparándose";
        this.ruta = ruta;
        this.transportista = null;
        this.renglones = renglones;
        this.movimientos = new ArrayList();
    }
    
    //Funcionalidades
    
    public void asignarTransportista(Transportista transportista){
        
        //Si el Pedido tiene un Transportista cuando se intenta asignarle uno, se cambia el Transportista anterior por el nuevo
        if(this.transportista!=null){
            Vehiculo vehiculo = this.getTransportista().consultarVehiculo();
            
            //Se libera el Vehiculo del Transportista anterior
            this.transportista.asignarVehiculo(null);
            
            //Se asigna el Transportista nuevo al Pedido
            this.setTransportista(transportista);
            
            //Se asigna el Vehiculo al nuevo Transportista
            transportista.asignarVehiculo(vehiculo);
        }
        
        this.transportista = transportista;
    }

    public Remito generarRemito() {
        return new Remito(this.getFechaCreacion(), LocalDateTime.now(), this.getRenglones());
    }
    
    public void cambiarEstado(String estado){
        movimientos.add(new Movimiento(this.getId(), LocalDateTime.now(), estado));
        
        this.setEstado(estado);
    }
    
    public int obtenerCantidadProducto(Producto producto){
        
        for(RenglonPedido r:renglones){
            if(r.getProducto().equals(producto))
                return r.getCantidad();
        }
        
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.id == other.id;
    }

  //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public List<RenglonPedido> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonPedido> renglones) {
        this.renglones = renglones;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
