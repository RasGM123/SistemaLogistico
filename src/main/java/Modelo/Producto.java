/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.ProductoDAO;
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
 * @author Rodrigo
 */

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToOne (fetch = FetchType.EAGER)
    private TipoProducto tipoProducto;

    public Producto() {
    }

    public Producto(String nombre, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", tipoProducto=" + tipoProducto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.tipoProducto);
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
        final Producto other = (Producto) obj;
        return this.id == other.id;
    }
    
    public void actualizar(){
        ProductoDAO dao = new ProductoDAO();
        dao.editar(this);
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
}
