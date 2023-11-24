/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.AdministrativoDAO;
import Persistencia.AlmacenDAO;
import Persistencia.ClienteDAO;
import Persistencia.ContratoDAO;
import Persistencia.EvaluacionDAO;
import Persistencia.GerenteDAO;
import Persistencia.OrdenDeCompraDAO;
import Persistencia.ProductoDAO;
import Persistencia.ProveedorDAO;
import Persistencia.TipoProductoDAO;
import Persistencia.RutaDAO;
import Persistencia.TransportistaDAO;
import Persistencia.VehiculoDAO;
import java.time.LocalDate;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;

/**
 *
 * @author Gustavo
 */

@Entity
public class Gerente extends Administrativo implements PerfilGerente{
    public Gerente() {
    }

    public Gerente(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, username, password, email, nombres, apellidos, dni, telefono, direccion);
    }
    
    /*
        CRUD Usuario
    */

    @Override
    public void crearUsuario(Usuario usuario) throws Exception {
        String clase = usuario.getClass().getSimpleName();
        
        sistema.crearUsuario(usuario);
        
        switch (clase){
            case "Cliente":
                ClienteDAO daoCliente = new ClienteDAO();
                daoCliente.crear(usuario);
                break;
            case "Administrativo":
                AdministrativoDAO daoAdministrativo = new AdministrativoDAO();
                daoAdministrativo.crear(usuario);
                break;
            case "Gerente":
                GerenteDAO daoGerente = new GerenteDAO();
                daoGerente.crear(usuario);
                break;
            case "Transportista":
                TransportistaDAO daoTransportista = new TransportistaDAO();
                daoTransportista.crear(usuario);
                break;
        }
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        return sistema.buscarUsuario(usuario.getUsername());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return sistema.listarUsuarios();
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        String clase = usuario.getClass().getSimpleName();
        
        switch (clase){
            case "Cliente":
                ClienteDAO daoCliente = new ClienteDAO();
                daoCliente.editar(usuario);
                break;
            case "Administrativo":
                AdministrativoDAO daoAdministrativo = new AdministrativoDAO();
                daoAdministrativo.editar(usuario);
                break;
            case "Gerente":
                GerenteDAO daoGerente = new GerenteDAO();
                daoGerente.editar(usuario);
                break;
            case "Transportista":
                TransportistaDAO daoTransportista = new TransportistaDAO();
                daoTransportista.editar(usuario);
                break;
        }
    }

    @Override
    public void borrarUsuario(Usuario usuario) throws Exception {
        String clase = usuario.getClass().getSimpleName();
        
        sistema.borrarUsuario(usuario);
        
        switch (clase){
            case "Cliente":
                ClienteDAO daoCliente = new ClienteDAO();
                daoCliente.borrar(usuario.getId());
                break;
            case "Administrativo":
                AdministrativoDAO daoAdministrativo = new AdministrativoDAO();
                daoAdministrativo.borrar(usuario.getId());
                break;
            case "Gerente":
                GerenteDAO daoGerente = new GerenteDAO();
                daoGerente.borrar(usuario.getId());
                break;
            case "Transportista":
                TransportistaDAO daoTranportista = new TransportistaDAO();
                daoTranportista.editar(usuario);
                break;
        }
    }
    
    /*
        CRUD Vehiculo
    */
    
    @Override
    public void crearVehiculo(Vehiculo vehiculo) throws Exception{
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        VehiculoDAO dao = new VehiculoDAO();
        
        if(existeVehiculo(vehiculo)){
            throw new Exception("El vehículo "+vehiculo.getDominio()+" ya está cargado en el sistema");
        }
        
        vehiculos.add(vehiculo);
        
        dao.crear(vehiculo);
    }
    
    @Override
    public void editarVehiculo(Vehiculo vehiculo, String marca, String modelo, String dominio, int capacidadDeCarga){
        VehiculoDAO dao = new VehiculoDAO();
        
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setDominio(dominio);
        vehiculo.setCapacidadCarga(capacidadDeCarga);
        
        dao.editar(vehiculo);
    }
    
    @Override
    public void borrarVehiculo(Vehiculo vehiculo) throws Exception{
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        VehiculoDAO dao = new VehiculoDAO();
        
        if(!existeVehiculo(vehiculo)){
            throw new Exception("El vehículo que desea borrar no está cargado en el sistema.");
        }
        
        vehiculos.remove(vehiculo);
        
        dao.borrar(vehiculo.getId());
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
        RutaDAO dao = new RutaDAO();
        
        if(existeRuta(ruta)){
            throw new Exception("La ruta "+ruta.getDestino()+" -> "+ruta.getDestino()+" ya está cargada en el sistema.");
        }
        
        rutas.add(ruta);
        
        dao.crear(ruta);
    }
    
    @Override
    public void editarRuta(Ruta ruta, String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada){
        RutaDAO dao = new RutaDAO();
        
        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setFechaSalida(fechaSalida);
        ruta.setFechaLlegada(fechaLlegada);
        
        dao.editar(ruta);
    }
    
    @Override
    public void borrarRuta(Ruta ruta) throws Exception{
        List<Ruta> rutas = sistema.getRutas();
        RutaDAO dao = new RutaDAO();
        
        if(!existeRuta(ruta)){
            throw new Exception("La ruta que desea borrar no está cargada en el sistema");
        }
        
        rutas.remove(ruta);
        
        dao.borrar(ruta.getId());
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
        ProveedorDAO dao = new ProveedorDAO();
        
        if(existeProveedor(proveedor)){
            throw new Exception("El proveedor "+proveedor.getNombre()+" ya está cargado en el sistema.");
        }
        
        proveedores.add(proveedor);
        
        dao.crear(proveedor);
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
    public void editarProveedor(Proveedor proveedor, String cuit, String nombre, String email, String telefono, String direccion){
        ProveedorDAO dao = new ProveedorDAO();
        
        proveedor.setCuit(cuit);
        proveedor.setNombre(nombre);
        proveedor.setEmail(email);
        proveedor.setTelefono(telefono);
        proveedor.setDireccion(direccion);
        
        dao.editar(proveedor);
    }
    
    @Override
    public void borrarProveedor(Proveedor proveedor) throws Exception{
        List<Proveedor> proveedores = sistema.getProveedores();
        ProveedorDAO dao = new ProveedorDAO();
        
        if(!existeProveedor(proveedor)){
            throw new Exception("El proveedor que desea borrar no está cargado en el sistema.");
        }
        
        //Se borran los Contratos del Proveedor
        proveedor.getContratos().clear();
        //Se borran las Evaluaciones del Proveedor
        proveedor.getEvaluaciones().clear();
        proveedores.remove(proveedor);
        
        dao.borrar(proveedor.getId());
    }
    
    public boolean existeProveedor(Proveedor proveedor){
        List<Proveedor> proveedores = sistema.getProveedores();
        
        return proveedores.contains(proveedor);
    }
    
    //Operaciones con Proveedor
    
    @Override
    public void agregarEvaluacion(Proveedor proveedor, Evaluacion evaluacion){
        ProveedorDAO daoProveedor = new ProveedorDAO();
        EvaluacionDAO daoEvaluacion = new EvaluacionDAO();
        
        proveedor.agregarEvaluacion(evaluacion);
        
        daoEvaluacion.crear(evaluacion);
        daoProveedor.editar(proveedor);
    }
    
    @Override
    public List<Evaluacion> listarEvaluaciones(Proveedor proveedor){
        return proveedor.getEvaluaciones();
    }
    
    @Override
    public void agregarContrato(Proveedor proveedor, Contrato contrato){
        ProveedorDAO daoProveedor = new ProveedorDAO();
        ContratoDAO daoContrato = new ContratoDAO();
        
        proveedor.agregarContrato(contrato);
        
        daoContrato.crear(contrato);
        daoProveedor.editar(proveedor);
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
        AlmacenDAO dao = new AlmacenDAO();
        
        if(existeAlmacen(almacen)){
            throw new Exception("El almacen "+almacen.getNombreSucursal()+" ya está cargado en el sistema.");
        }
        
        almacenes.add(almacen);
        
        dao.crear(almacen);
    }
    
    @Override
    public void editarAlmacen(Almacen almacen, String nombre, boolean esCentroDistribucion, String direccion){
        AlmacenDAO dao = new AlmacenDAO();
        
        almacen.setNombreSucursal(nombre);
        almacen.setEsCentroDistribucion(esCentroDistribucion);
        almacen.setDireccion(direccion);
        
        dao.editar(almacen);
    }
    
    @Override
    public void borrarAlmacen(Almacen almacen) throws Exception{
        List<Almacen> almacenes = sistema.getAlmacenes();
        AlmacenDAO dao = new AlmacenDAO();
        
        if(!existeAlmacen(almacen)){
            throw new Exception("El almacen que quiere borrar no está cargado en el sistema.");
        }
        
        //Se borran el inventario del Almacen antes de borrar
        almacen.getRenglones().clear();
        //Se borra el Almacen del Sistema
        almacenes.remove(almacen);
        
        dao.borrar(almacen.getId());
    }
    
    public boolean existeAlmacen(Almacen almacen){
        List<Almacen> almacenes = sistema.getAlmacenes();
        
        return almacenes.contains(almacen);
    }
    
    //CRUD OrdenDeCompra

    @Override
    public void crearOrdenDeCompra(OrdenDeCompra orden) throws Exception{
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        OrdenDeCompraDAO dao = new OrdenDeCompraDAO();
        
        if(existeOrdenDeCompra(orden)){
            throw new Exception("Ya existe una orden de compra con el ID "+orden.getId()+" cargada en el sistema.");
        }
        
        ordenes.add(orden);
        
        dao.crear(orden);
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
        OrdenDeCompraDAO dao = new OrdenDeCompraDAO();
        
        orden.setProveedor(proveedor);
        orden.setRenglones(renglones);
        
        dao.editar(orden);
    }

    @Override
    public void borrarOrdenDeCompra(OrdenDeCompra orden) throws Exception {
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        OrdenDeCompraDAO dao = new OrdenDeCompraDAO();
        
        if(!existeOrdenDeCompra(orden)){
            throw new Exception("La orden de compra que desea borrar no está cargada en el sistema");
        }
        
        ordenes.remove(orden);
        
        dao.borrar(orden.getId());
    }
    
    public boolean existeOrdenDeCompra(OrdenDeCompra orden){
        List<OrdenDeCompra> ordenesDeCompra = sistema.getOrdenesDeCompra();
        
        return ordenesDeCompra.contains(orden);
    }
    
    //Otras operaciones con OrdenDeCompra

    @Override
    public void establecerEntregaOrdenDeCompra(OrdenDeCompra orden, LocalDate fechaEntrega) throws Exception{
        OrdenDeCompraDAO dao = new OrdenDeCompraDAO();
        
        orden.establecerEntrega(fechaEntrega);
        
        dao.editar(orden);
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
                if(estaDentroRangoFechas(pedido.getFechaCreacion(), inicio, fin)){
                    
                    //Cantidad del Producto en el Pedido
                    cantidad = pedido.obtenerCantidadProducto(producto);
                    
                    if(cantidad > 0){
                        listado.put(producto, listado.get(producto)+cantidad);
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
            if(estaDentroRangoFechas(p.getFechaCreacion(), inicio, fin) && p.getEstado().equalsIgnoreCase("Entregado")){
                
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
    public Map<Proveedor, Float> listarProveedoresPorTiempoDeEntrega(LocalDate inicio, LocalDate fin) throws Exception {
        List<OrdenDeCompra> ordenes = sistema.getOrdenesDeCompra();
        Map<Proveedor, Float> tiemposEntrega = new HashMap();
        Map<Proveedor, Float> cantidadOrdenes = new HashMap();
        
        float demora;
        float tiempoPromedio;
        
        for(OrdenDeCompra o:ordenes){
            
            //Se comprueba que la OrdenDeCompra haya sido entregada
            if(estaDentroRangoFechas(o.getFechaEmision(), inicio, fin) && o.getFechaEntrega() != null){
                
                //Diferencia en HORAS entre la fecha de emision y la fecha de entrega de una orden de trabajo
                demora = Duration.between(o.getFechaEmision(), o.getFechaEntrega()).toHours();
                
                if(tiemposEntrega.containsKey(o.getProveedor())){
                    tiemposEntrega.put(o.getProveedor(), tiemposEntrega.get(o.getProveedor())+demora);
                    
                    cantidadOrdenes.put(o.getProveedor(), cantidadOrdenes.get(o.getProveedor())+1);
                }else{
                    tiemposEntrega.put(o.getProveedor(), demora);
                    
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
    
    //Devuelve la cantidad de Usuario Clientes registrados comprendido entre 2 fechas
    @Override
    public int contarClientesRegistrados(LocalDate inicio, LocalDate fin) throws Exception {
        List<Cliente> clientes = sistema.getClientes();
        
        int contador = 0;
        
        for(Cliente c:clientes){
            
            if(estaDentroRangoFechas(c.getFechaCreacion().toLocalDate(), inicio, fin)){
                contador++;
            }
        }
        
        return contador;
    }
    
    private boolean estaDentroRangoFechas(LocalDate fecha, LocalDate inicio, LocalDate fin) throws Exception{
        if(inicio.isAfter(fin)){
            throw new Exception("La fecha de inicio debe ser menor o igual a la fecha fin.");
        }
        
        if(fin.isBefore(inicio)){
            throw new Exception("La fecha de fin debe ser mayor o igual a la fecha inicio.");
        }
        
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }
    
    @Override
    public double calcularPromedioPedidos(LocalDate inicio, LocalDate fin) throws Exception{
        List<Cliente> clientes = sistema.getClientes();
        double cantidadTotalPedidos = 0;
        int cantidadClientes = clientes.size();
        
        if(cantidadClientes == 0){
            throw new Exception("El sistema no tiene cargado clientes.");
        }
        
        for(Cliente c:clientes){
            
            cantidadTotalPedidos += c.listarPedidos(inicio, fin).size();
        }
        
        return cantidadTotalPedidos/cantidadClientes;
    }
}