/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Gustavo
 */
public class RenglonInventario {
    private int id;
    private int cantidad;
    private Producto producto;

    public RenglonInventario() {
    }

    public RenglonInventario(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    //Funcionalidades
    
    public void cambiarCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.cantidad;
        hash = 43 * hash + Objects.hashCode(this.producto);
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
        final RenglonInventario other = (RenglonInventario) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
}
