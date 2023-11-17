/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Rodrigo
 */

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaCreacion;
    private String estado;
    @OneToOne
    private Ruta ruta;
    @OneToOne
    private Transportista transportista;
    @OneToMany
    private List<RenglonPedido> renglones;
    @OneToMany
    private List<Movimiento> movimientos;

    public Pedido() {
    }
    
    public Pedido(LocalDate fechaCreacion, Ruta ruta, List<RenglonPedido> renglones) {
        this.fechaCreacion = fechaCreacion;
        this.estado = "Preparándose";
        this.ruta = ruta;
        this.transportista = null;
        this.renglones = renglones;
        this.movimientos = new ArrayList();
    }
    
    //Funcionalidades

    public Remito generarRemito() {
        return new Remito(this.id, this.getFechaCreacion(), LocalDate.now(), this.getRenglones());
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 31 * hash + Objects.hashCode(this.ruta);
        hash = 31 * hash + Objects.hashCode(this.renglones);
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
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        Movimiento movimiento = new Movimiento(LocalDate.now(), estado);
        
        //Se genera un nuevo Movimiento cada vez que cambia el estado del Pedido
        movimientos.add(movimiento);
        
        this.estado = estado;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void setTransportista(Transportista transportista) {
        //Si el Pedido tiene un Transportista, se cambia el Transportista anterior por el nuevo
        if(this.transportista!=null){
            
            //Vehiculo que tenía asignado el Transportista anterior
            Vehiculo vehiculo = this.getTransportista().getVehiculoAsignado();
            
            //Se libera el Vehiculo del Transportista anterior
            this.transportista.setVehiculoAsignado(null);
            
            //Se asigna el Transportista nuevo al Pedido
            this.transportista = transportista;
            
            //Se asigna el Vehiculo al nuevo Transportista
            transportista.setVehiculoAsignado(vehiculo);
        }
        
        this.transportista = transportista;
    }

    public void setRenglones(List<RenglonPedido> renglones) {
        this.renglones = renglones;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    //Getters

    public int getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public List<RenglonPedido> getRenglones() {
        return renglones;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
}
