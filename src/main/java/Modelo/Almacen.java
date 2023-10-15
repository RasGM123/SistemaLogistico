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

    public Almacen(int id, String nombre, boolean esCentroDistribucion, String direccion) {
        this.id = id;
        this.nombreSucursal = nombre;
        this.esCentroDistribucion = esCentroDistribucion;
        this.direccion = direccion;
        this.renglones = new ArrayList();
    }

    //Funcionalidades
    
    public void agregarProducto(Producto producto, int cantidad) throws Exception{
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            renglones.add(new RenglonInventario(this.getId(), cantidad, producto));
        }else{
            renglon.setCantidad(renglon.getCantidad()+cantidad);
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
    
    public List<RenglonInventario> listarProductos(){
        return renglones;
    }
    
    public void cambiarCantidadProducto(Producto producto, int cantidad) throws Exception{
        if(cantidad<0){
            throw new Exception("La cantidad de un producto no puede ser menor a 0.");
        }
        
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            throw new Exception("Este producto no fue cargado al almacen.");
        }else{
            renglon.setCantidad(cantidad);
        }
    }
    
    public void borrarProducto(Producto producto) throws Exception{
        RenglonInventario renglon = buscarRenglon(producto);
        
        if(renglon == null){
            throw new Exception("Este almacen no tiene el producto "+producto.getNombre()+" cargado.");
        }
        
        renglones.remove(renglon);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombreSucursal);
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
        return Objects.equals(this.nombreSucursal, other.nombreSucursal);
    }
    
    //setters & getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
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

    public List<RenglonInventario> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonInventario> renglones) {
        this.renglones = renglones;
    }
}
