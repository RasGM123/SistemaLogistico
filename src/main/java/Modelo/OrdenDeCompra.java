/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class OrdenDeCompra {
    private int id;
    private LocalDateTime fecha;
    
    private Proveedor proveedor;
    private List<RenglonOrdenDeCompra> renglones;

    public OrdenDeCompra(int id, Proveedor proveedor, List<RenglonOrdenDeCompra> renglones) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.proveedor = proveedor;
        this.renglones = renglones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
    
    //setters & getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<RenglonOrdenDeCompra> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonOrdenDeCompra> renglones) {
        this.renglones = renglones;
    }
}
