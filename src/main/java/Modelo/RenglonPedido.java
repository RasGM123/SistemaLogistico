/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Gustavo
 */

@Entity
public class RenglonPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    @OneToOne (fetch = FetchType.EAGER)
    private Producto producto;

    public RenglonPedido() {
    }

    public RenglonPedido(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "RenglonPedido{" + "id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.cantidad;
        hash = 59 * hash + Objects.hashCode(this.producto);
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
        final RenglonPedido other = (RenglonPedido) obj;
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
