/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
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
    private Remito remito;
    private List<RenglonPedido> renglones;
    
    //cuando se crea el Pedido el estado inicial es "Preparandose"
    //el Transportista y el Remito se asignan despues de la creacion mediante un usuario Administrativo/Gerente
    public Pedido(int id, LocalDateTime fechaCreacion, Ruta ruta, List<RenglonPedido> renglones) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = "Preparándose";
        this.ruta = ruta;
        this.transportista = null;
        this.remito = null;
        this.renglones = renglones;
    }
    
    //Funcionalidades
    
    public void asignarTransportista(Transportista transportista){
        
        //Si el Pedido tiene un Transportista cuando se intenta asignarle uno, se cambia el Transportista anterior por el nuevo
        if(this.transportista!=null){
            Vehiculo vehiculo = this.getTransportista().getVehiculo();
            
            //Se libera el Vehiculo del Transportista anterior
            this.transportista.asignarVehiculo(null);
            
            //Se asigna el Transportista nuevo al Pedido
            this.setTransportista(transportista);
            
            //Se asigna el Vehiculo al nuevo Transportista
            transportista.asignarVehiculo(vehiculo);
        }
        
        this.transportista = transportista;
    }

    public void generarRemito() {
        remito = new Remito(this.id, LocalDateTime.now());
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

    public void actualizarEstado(String estado) {
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

    public Remito getRemito() {
        return remito;
    }

    public void setRemito(Remito remito) {
        this.remito = remito;
    }

    public List<RenglonPedido> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonPedido> renglones) {
        this.renglones = renglones;
    }
}
