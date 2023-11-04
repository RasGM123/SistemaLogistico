/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gustavo
 */
public class OrdenDeCompra {
    private int id;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaEntrega;
    private Proveedor proveedor;
    private List<RenglonOrdenDeCompra> renglones;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Proveedor proveedor, List<RenglonOrdenDeCompra> renglones) {
        this.fechaEmision = LocalDateTime.now();
        this.fechaEntrega = null;
        this.proveedor = proveedor;
        this.renglones = renglones;
    }
    
    //Funcionalidades
    
    public void establecerEntrega(LocalDateTime fechaEntrega) throws Exception{
        if(fechaEntrega.isBefore(fechaEmision)){
            throw new Exception("La fecha de entrega no puede ocurrir antes de la fecha de emisión.");
        }
        
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fechaEmision);
        hash = 59 * hash + Objects.hashCode(this.fechaEntrega);
        hash = 59 * hash + Objects.hashCode(this.proveedor);
        hash = 59 * hash + Objects.hashCode(this.renglones);
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
        final OrdenDeCompra other = (OrdenDeCompra) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setRenglones(List<RenglonOrdenDeCompra> renglones) {
        this.renglones = renglones;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<RenglonOrdenDeCompra> getRenglones() {
        return renglones;
    }
}
