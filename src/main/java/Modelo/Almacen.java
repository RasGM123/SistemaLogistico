/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author Rodrigo
 */
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Almacen {
    private int id;
    private boolean esCentroDistribucion;
    private String direccion;
    private Map<Producto, Integer> existencias;

    public Almacen(int id, boolean esCentroDistribucion, String direccion) {
        this.id = id;
        this.esCentroDistribucion = esCentroDistribucion;
        this.direccion = direccion;
        this.existencias = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEsCentroDistribucion() {
        return esCentroDistribucion;
    }

    public void setEsCentroDistribucion(boolean esCentroDistribucion) {
        this.esCentroDistribucion = esCentroDistribucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean tieneProducto(Producto producto) {
        return existencias.containsKey(producto);
    }

    public void aumentarCantidadProducto(Producto producto, int cantidad) {
        if (existencias.containsKey(producto)) {
            int cantidadActual = existencias.get(producto);
            existencias.put(producto, cantidadActual + cantidad);
        } else {
            existencias.put(producto, cantidad);
        }
    }

    public void restarCantidadProducto(Producto producto, int cantidad) {
        if (existencias.containsKey(producto)) {
            int cantidadActual = existencias.get(producto);
            if (cantidadActual >= cantidad) {
                existencias.put(producto, cantidadActual - cantidad);
            } else {
                System.out.println("No hay suficientes existencias del producto " + producto.getNombre());
            }
        } else {
            System.out.println("No hay existencias del producto " + producto.getNombre());
        }
    }

    public void gestionarPedido() {
        // Lógica para gestionar un pedido
    }

    public void cargarOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        // Lógica para cargar una orden de compra
    }

    public void gestionarExistencias() {
        
    }
}

