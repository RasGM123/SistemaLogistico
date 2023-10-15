/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo
 */

public class Gerente extends Administrativo implements PerfilGerente{

    public Gerente(String cuil, int id, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, id, username, password, email, nombres, apellidos, dni, telefono, direccion);
    }
    
    /*
        CRUD Transportista
    */
    
    @Override
    public void crearTransportista(Transportista transportista) throws Exception{
        Map<String, Transportista> tranportistas = sistema.getTransportistas();
        Map<String, Usuario> usuarios = sistema.getUsuarios();
        
        if(existeTransportista(transportista)){
            throw new Exception("El transportista "+transportista.getCuil()+" ya está cargado en el sistema");
        }
        
        usuarios.put(transportista.getDni(), transportista);
        tranportistas.put(transportista.getDni(), transportista);
    }
    
    @Override
    public void editarTransportista(Transportista transportista,String cuil, String nombre, String apellido, String dni, String telefono, String direccion){
        transportista.editarDatosPersonales(cuil, nombre, apellido, dni, telefono, direccion);
    }
    
    @Override
    public void borrarTransportista(Transportista transportista) throws Exception{
        Map<String, Transportista> transportistas = sistema.getTransportistas();
        Map<String, Usuario> usuarios = sistema.getUsuarios();
        
        if(!existeTransportista(transportista)){
            throw new Exception("El tranportista que desea borrar no está cargado en el sistema.");
        }
        
        transportistas.remove(transportista.getDni());
        usuarios.remove(transportista.getDni());
    }
    
    public boolean existeTransportista(Transportista transportista){
        Map<String, Transportista> transportistas = sistema.getTransportistas();
        
        return transportistas.containsKey(transportista.getDni());
    }
    
    /*
        CRUD Vehiculo
    */
    
    @Override
    public void crearVehiculo(Vehiculo vehiculo) throws Exception{
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        
        if(existeVehiculo(vehiculo)){
            throw new Exception("El vehículo "+vehiculo.getDominio()+" ya está cargado en el sistema");
        }
        
        vehiculos.add(vehiculo);
    }
    
    @Override
    public void editarVehiculo(Vehiculo vehiculo, String marca, String modelo, String dominio, int capacidadDeCarga){
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setDominio(dominio);
        vehiculo.setCapacidadCarga(capacidadDeCarga);
    }
    
    @Override
    public void borrarVehiculo(Vehiculo vehiculo) throws Exception{
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        
        if(!existeVehiculo(vehiculo)){
            throw new Exception("El vehículo que desea borrar no está cargado en el sistema.");
        }
        
        vehiculos.remove(vehiculo);
    }
    
    public boolean existeVehiculo(Vehiculo vehiculo){
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        
        return vehiculos.contains(vehiculo);
    }
    
    /*
        CRUD Ruta
    */
    
    @Override
    public void crearRuta(Ruta ruta) throws Exception{
        List<Ruta> rutas = sistema.getRutas();
        
        if(existeRuta(ruta)){
            throw new Exception("La ruta "+ruta.getDestino()+" -> "+ruta.getDestino()+" ya está cargada en el sistema.");
        }
        
        rutas.add(ruta);
    }
    
    @Override
    public void editarRuta(Ruta ruta, String origen, String destino, LocalDateTime fechaSalida, LocalDateTime fechaLlegada){
        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setFechaSalida(fechaSalida);
        ruta.setFechaLlegada(fechaLlegada);
    }
    
    @Override
    public void borrarRuta(Ruta ruta) throws Exception{
        List<Ruta> rutas = sistema.getRutas();
        
        if(!existeRuta(ruta)){
            throw new Exception("La ruta que desea borrar no está cargada en el sistema");
        }
        
        rutas.remove(ruta);
    }
    
    public boolean existeRuta(Ruta ruta){
        List<Ruta> rutas = sistema.getRutas();
        
        return rutas.contains(ruta);
    }
    
    /*
        CRUD Proveedor
    */
    
    @Override
    public void crearProveedor(Proveedor proveedor) throws Exception{
        List<Proveedor> proveedores = sistema.getProveedores();
        
        if(existeProveedor(proveedor)){
            throw new Exception("El proveedor "+proveedor.getNombre()+" ya está cargado en el sistema.");
        }
        
        proveedores.add(proveedor);
    }
    
    @Override
    public Proveedor buscarProveedor(String nombre){
        List<Proveedor> proveedores = sistema.getProveedores();
        
        for(Proveedor p:proveedores){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        
        return null;
    }
    
    @Override
    public List<Proveedor> listarProveedores(){
        return sistema.getProveedores();
    }
    
    @Override
    public void editarProveedor(Proveedor proveedor, String nombre, String cuit){
        proveedor.setNombre(nombre);
        proveedor.setCuit(cuit);
    }
    
    @Override
    public void borrarProveedor(Proveedor proveedor) throws Exception{
        List<Proveedor> proveedores = sistema.getProveedores();
        
        if(!existeProveedor(proveedor)){
            throw new Exception("El proveedor que desea borrar no está cargado en el sistema.");
        }
        
        //Se borran los Contratos del Proveedor
        proveedor.getContratos().clear();
        //Se borran las Evaluaciones del Proveedor
        proveedor.getEvaluaciones().clear();
        
        proveedores.remove(proveedor);
    }
    
    public boolean existeProveedor(Proveedor proveedor){
        List<Proveedor> proveedores = sistema.getProveedores();
        
        return proveedores.contains(proveedor);
    }
    
    //Otras operaciones con Proveedor
    
    @Override
    public void agregarEvaluacion(Proveedor proveedor, Evaluacion evaluacion){
        proveedor.agregarEvaluacion(evaluacion);
    }
    
    @Override
    public List<Evaluacion> listarEvaluaciones(Proveedor proveedor){
        return proveedor.getEvaluaciones();
    }
    
    @Override
    public void agregarContrato(Proveedor proveedor, Contrato contrato){
        proveedor.agregarContrato(contrato);
    }
    
    @Override
    public List<Contrato> listarContratos(Proveedor proveedor){
        return proveedor.getContratos();
    }
    
    /*
        CRUD Almacen
    */
    
    @Override
    public void crearAlmacen(Almacen almacen) throws Exception{
        List<Almacen> almacenes = sistema.getAlmacenes();
        
        if(existeAlmacen(almacen)){
            throw new Exception("El almacen "+almacen.getNombreSucursal()+" ya está cargado en el sistema.");
        }
        
        almacenes.add(almacen);
    }
    
    @Override
    public void editarAlmacen(Almacen almacen, String nombre, boolean esCentroDistribucion, String direccion){
        almacen.setNombreSucursal(nombre);
        almacen.setEsCentroDistribucion(esCentroDistribucion);
        almacen.setDireccion(direccion);
    }
    
    @Override
    public void borrarAlmacen(Almacen almacen) throws Exception{
        List<Almacen> almacenes = sistema.getAlmacenes();
        
        if(!existeAlmacen(almacen)){
            throw new Exception("El almacen que quiere borrar no está cargado en el sistema.");
        }
        
        //Se borran el inventario del Almacen antes de borrar
        almacen.getRenglones().clear();
        //Se borra el Almacen del Sistema
        almacenes.remove(almacen);
    }
    
    public boolean existeAlmacen(Almacen almacen){
        List<Almacen> almacenes = sistema.getAlmacenes();
        
        return almacenes.contains(almacen);
    }
    
    /*
        CRUD Producto
    */
    
    @Override
    public void crearProducto(Producto producto) throws Exception{
        List<Producto> productos = sistema.getProductos();
        
        if(existeProducto(producto)){
            throw new Exception("El producto "+producto.getNombre()+" ya está cargado en el sistema.");
        }
        
        productos.add(producto);
    }
    
    @Override
    public void editarProducto(Producto producto, String nombre, TipoProducto tp){
        producto.setNombre(nombre);
        producto.setTipoProducto(tp);
    }
    
    @Override
    public void borrarProducto(Producto producto) throws Exception{
        List<Producto> productos = sistema.getProductos();
        
        if(!existeProducto(producto)){
            throw new Exception("El producto que desea borrar no está cargado en el sistema.");
        }
        
        productos.remove(producto);
    }
    
    public boolean existeProducto(Producto producto){
        List<Producto> productos = sistema.getProductos();
        
        return productos.contains(producto);
    }
    
    /*
        AMB TipoDeProducto
     */
    
    @Override
    public void crearTipoDeProducto(TipoProducto tipo) throws Exception{
        List<TipoProducto> tipos = sistema.getTiposDeProductos();
        
        if(existeTipoProducto(tipo)){
            throw new Exception("Ya existe un tipo de producto con el nombre "+tipo.getNombre()+".");
        }
        
        tipos.add(tipo);
    }
    
    @Override
    public void editarTipoProducto(TipoProducto tipo, String nombre){
        tipo.setNombre(nombre);
    }
    
    @Override
    public void borrarTipoDeProducto(TipoProducto tipo) throws Exception{
        List<TipoProducto> tipos = sistema.getTiposDeProductos();
        
        if(!existeTipoProducto(tipo)){
            throw new Exception("El tipo de producto que desea borrar no está cargado en el sistema.");
        }
        
        if(estaTipoProductoEnUso(tipo)){
            throw new Exception("No se puede borrar un tipo de producto que esté siendo usado en algún producto.");
        }
        
        tipos.remove(tipo);
    }
    
    public boolean existeTipoProducto(TipoProducto tipo){
        List<TipoProducto> tipos = sistema.getTiposDeProductos();
        
        return tipos.contains(tipo);
    }
    
    //Se verifica si al menos 1 Producto tiene relacion con un TipoProducto
    public boolean estaTipoProductoEnUso(TipoProducto tipo){
        List<Producto> productos = sistema.getProductos();
        
        for(Producto p:productos){
            if(p.getTipoProducto().equals(tipo)){
                return true;
            }
        }
        
        return false;
    }
}