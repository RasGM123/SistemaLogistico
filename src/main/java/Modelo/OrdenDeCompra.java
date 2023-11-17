/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
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
 * @author Gustavo
 */

@Entity
public class OrdenDeCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaEmision;
    private LocalDate fechaEntrega;
    @OneToOne
    private Proveedor proveedor;
    @OneToMany
    private List<RenglonOrdenDeCompra> renglones;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Proveedor proveedor, List<RenglonOrdenDeCompra> renglones) {
        this.fechaEmision = LocalDate.now();
        this.fechaEntrega = null;
        this.proveedor = proveedor;
        this.renglones = renglones;
    }
    
    //Funcionalidades
    
    public void establecerEntrega(LocalDate fechaEntrega) throws Exception{
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

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<RenglonOrdenDeCompra> getRenglones() {
        return renglones;
    }
}
