/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rodrigo
 */

public class Almacen {
    private int id;
    private String nombreSucursal;
    private boolean esCentroDistribucion;
    private String direccion;
    private List<RenglonInventario> renglones;

    public Almacen() {
    }

    public Almacen(String nombre, boolean esCentroDistribucion, String direccion) {
        this.nombreSucursal = nombre;
        this.esCentroDistribucion = esCentroDistribucion;
        this.direccion = direccion;
        this.renglones = new ArrayList();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombreSucursal);
        hash = 97 * hash + (this.esCentroDistribucion ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.direccion);
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
        final Almacen other = (Almacen) obj;
        return this.id == other.id;
    }

    //Funcionalidades
    
    public void agregarProducto(Producto producto, int cantidad) throws Exception{
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            renglones.add(new RenglonInventario(cantidad, producto));
        }else{
            renglon.cambiarCantidad(renglon.getCantidad()+cantidad);
        }
    }
    
    public RenglonInventario buscarRenglon(Producto producto){
        
        for(RenglonInventario renglon:renglones){
            if(renglon.getProducto().equals(producto)){
                return renglon;
            }
        }
        
        return null;
    }
    
    public void cambiarCantidadProducto(Producto producto, int cantidad) throws Exception{
        if(cantidad<0){
            throw new Exception("La cantidad de un producto no puede ser menor a 0.");
        }
        
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            throw new Exception("Este producto no fue cargado al almacen.");
        }else{
            renglon.cambiarCantidad(cantidad);
        }
    }
    
    public void borrarProducto(Producto producto) throws Exception{
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            throw new Exception("Este almacen no tiene el producto "+producto.getNombre()+" cargado.");
        }
        
        renglones.remove(renglon);
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public void setEsCentroDistribucion(boolean esCentroDistribucion) {
        this.esCentroDistribucion = esCentroDistribucion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRenglones(List<RenglonInventario> renglones) {
        this.renglones = renglones;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public boolean isEsCentroDistribucion() {
        return esCentroDistribucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<RenglonInventario> getRenglones() {
        return renglones;
    }
}
