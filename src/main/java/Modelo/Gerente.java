/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo
 */

public class Gerente extends Administrativo implements PerfilGerente{
    public Gerente() {
    }

    public Gerente(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, username, password, email, nombres, apellidos, dni, telefono, direccion);
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
        
        /*
            GENERRAR ID
        */
        transportista.setId(generarId(transportista));
        
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
        
        /*
            GENERRAR ID
        */
        vehiculo.setId(generarId(vehiculo));
        
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
        
        /*
            GENERRAR ID
        */
        ruta.setId(generarId(ruta));
        
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
        
        /*
            GENERRAR ID
        */
        proveedor.setId(generarId(proveedor));
        
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
    public void editarProveedor(Proveedor proveedor, String cuit, String nombre, String telefono, String direccion){
        proveedor.setCuit(cuit);
        proveedor.setNombre(nombre);
        proveedor.setTelefono(telefono);
        proveedor.setDireccion(direccion);
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
        /*
            GENERRAR ID
        */
        evaluacion.setId(generarId(evaluacion));
        
        proveedor.agregarEvaluacion(evaluacion);
    }
    
    @Override
    public List<Evaluacion> listarEvaluaciones(Proveedor proveedor){
        return proveedor.getEvaluaciones();
    }
    
    @Override
    public void agregarContrato(Proveedor proveedor, Contrato contrato){
        /*
            GENERRAR ID
        */
        contrato.setId(generarId(contrato));
        
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
        
        /*
            GENERRAR ID
        */
        almacen.setId(generarId(almacen));
        
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
        
        /*
            GENERRAR ID
        */
        producto.setId(generarId(producto));
        
        productos.add(producto);
    }
    
    @Override
    public void editarProducto(Producto producto, String nombre, TipoProducto tipo){
        producto.setNombre(nombre);
        producto.setTipoProducto(tipo);
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
        
        /*
            GENERRAR ID
        */
        tipo.setId(generarId(tipo));
        
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
    
    //CRUD OrdenDeCompra

    @Override
    public void crearOrdenDeCompra(OrdenDeCompra orden) throws Exception{
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        
        if(existeOrdenDeCompra(orden)){
            throw new Exception("Ya existe una orden de compra con el ID "+orden.getId()+" cargada en el sistema.");
        }
        
        /*
            GENERRAR ID
        */
        orden.setId(generarId(orden));
        
        ordenes.add(orden);
    }

    @Override
    public OrdenDeCompra buscarOrdenDeCompra(int idOrdenDeCompra) {
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        
        for(OrdenDeCompra o:ordenes){
            if(o.getId() == idOrdenDeCompra){
                return o;
            }
        }
        
        return null;
    }

    @Override
    public List<OrdenDeCompra> listarOrdenesDeCompra() {
        return sistema.getOrdenesDeCompra();
    }

    @Override
    public void editarOrdenDeCompra(OrdenDeCompra orden, Proveedor proveedor, List<RenglonOrdenDeCompra> renglones) {
        orden.setProveedor(proveedor);
        orden.setRenglones(renglones);
    }

    @Override
    public void borrarOrdenDeCompra(OrdenDeCompra orden) throws Exception {
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        
        if(!existeOrdenDeCompra(orden)){
            throw new Exception("La orden de compra que desea borrar no está cargada en el sistema");
        }
        
        ordenes.remove(orden);
    }
    
    public boolean existeOrdenDeCompra(OrdenDeCompra orden){
        List<OrdenDeCompra> ordenesDeCompra = sistema.getOrdenesDeCompra();
        
        return ordenesDeCompra.contains(orden);
    }
    
    //Otras operaciones con OrdenDeCompra

    @Override
    public void establecerEntregaOrdenDeCompra(OrdenDeCompra orden, LocalDateTime fechaEntrega) throws Exception{
        orden.establecerEntrega(fechaEntrega);
    }
    
    
    //Generacion de informes
    //Numero de veces que se pidieron los Prodcutos comprendido entre 2 fechas
    @Override
    public Map<Producto, Integer> listarProductosPorPedidos(LocalDate inicio, LocalDate fin) throws Exception {
        Map<Integer, Pedido> pedidos = sistema.getPedidos();
        List<Producto> productos = sistema.getProductos();
        int cantidad;
        Map<Producto, Integer> listado = new HashMap();
        
        if(productos.isEmpty()){
            throw new Exception("El sistema no tiene cargado productos.");
        }
        
        if(pedidos.isEmpty()){
            throw new Exception("El sistema no tiene cargado pedidos");
        }
        
        //Se recorren todos los Productos en el sistema
        for(Producto producto:productos){
            listado.put(producto, 0);
            
            //Se recorren todos los Pedidos en el sistema
            for(Pedido pedido:pedidos.values()){
                
                //Se verifica que el Pedido se encuentre en el rango de fecha
                if(estaEntre(pedido.getFechaCreacion().toLocalDate(), inicio, fin)){
                    
                    //Cantidad del Producto en el Pedido
                    cantidad = pedido.obtenerCantidadProducto(producto);
                    
                    if(cantidad > 0){
                        listado.put(producto, listado.get(producto));
                    }
                }
            }
        }
        
        return listado;
    }
    
    //Listado de Tranportitastas y su cantidad de entregas en comprendidas entre 2 fechas
    @Override    
    public Map<Transportista, Integer> listarTransportistasPorEntregas(LocalDate inicio, LocalDate fin) throws Exception{
        Map<Integer, Pedido> pedidos = sistema.getPedidos();
        Transportista t;
        Map<Transportista, Integer> transportistas = new HashMap();
        
        if(pedidos.isEmpty()){
            throw new Exception("El sistema no tiene cargado pedidos.");
        }
        
        for(Pedido p:pedidos.values()){
            if(estaEntre(p.getFechaCreacion().toLocalDate(), inicio, fin) && p.getEstado().equalsIgnoreCase("Entregado")){
                
                t = p.getTransportista();
                
                if(transportistas.containsKey(t)){
                    transportistas.put(t, transportistas.get(t)+1);
                }else{
                    transportistas.put(t, 1);
                }
            }
        }
        
        return transportistas;
    }
    
    @Override
    public Map<Proveedor, Float> listarProveedoresPorEntregas(LocalDate inicio, LocalDate fin) {
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        Map<Proveedor, Float> tiemposEntrega = new HashMap();
        Map<Proveedor, Float> cantidadOrdenes = new HashMap();
        
        float diferencia;
        float tiempoPromedio;
        
        for(OrdenDeCompra o:ordenes){
            
            //Se comprueba que la OrdenDeCompra haya sido entregada
            if(o.getFechaEntrega() != null){
                
                //Diferencia en HORAS entre la fecha de emision y la fecha de entrega de una orden de trabajo
                diferencia = Duration.between(o.getFechaEmision(), o.getFechaEntrega()).toHours();
                
                if(tiemposEntrega.containsKey(o.getProveedor())){
                    tiemposEntrega.put(o.getProveedor(), tiemposEntrega.get(o.getProveedor())+diferencia);
                    
                    cantidadOrdenes.put(o.getProveedor(), cantidadOrdenes.get(o.getProveedor())+1);
                }else{
                    tiemposEntrega.put(o.getProveedor(), diferencia);
                    
                    cantidadOrdenes.put(o.getProveedor(), 1f);
                }
            }
        }
        
        //Se calculan los promedios de tiempos de entrega en HORAS de los Proveedores
        for(Proveedor p:tiemposEntrega.keySet()){
            
            tiempoPromedio = tiemposEntrega.get(p)/cantidadOrdenes.get(p);
            
            tiemposEntrega.put(p, tiempoPromedio);
        }
        
        return tiemposEntrega;
    }
    

    //Cantidad de usuarios registrados
    //Devuelve la cantidad de Usuario Clientes registrados comprendido entre 2 fechas
    @Override
    public int numeroUsuariosRegistrados(LocalDate inicio, LocalDate fin) throws Exception {
        Map<String, Cliente> clientes = sistema.getClientes();
        int contador = 0;
        
        for(Cliente c:clientes.values()){
            
            if(estaEntre(c.getFechaCreacion().toLocalDate(), inicio, fin)){
                contador++;
            }
        }
        
        return contador;
    }
    
    private boolean estaEntre(LocalDate fecha, LocalDate inicio, LocalDate fin) throws Exception{
        if(inicio.isAfter(fin)){
            throw new Exception("La fecha de inicio debe ser menor o igual a la fecha fin.");
        }
        
        if(fin.isBefore(inicio)){
            throw new Exception("La fecha de fin debe ser mayor o igual a la fecha inicio.");
        }
        
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }
    
    //Cantidad promedio de Pedidos por Cliente
    //Devuelve la cantidad de promedio de Pedido de los Clientes comprendidos entre 2 fechas
    @Override
    public double promedioPedidos(LocalDate inicio, LocalDate fin) throws Exception{
        Map<String, Cliente> clientes = sistema.getClientes();
        double totalPedidos = 0;
        int cantidadClientes = clientes.size();
        
        if(cantidadClientes == 0){
            throw new Exception("El sistema no tiene cargado clientes.");
        }
        
        for(Cliente c:clientes.values()){
            
            totalPedidos += c.listarPedidos(inicio, fin).size();
        }
        
        return totalPedidos/cantidadClientes;
    }
}