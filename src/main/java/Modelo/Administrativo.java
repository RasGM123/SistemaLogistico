/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.TipoProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Transient;

/**
 *
 * @author Gustavo
 */
public class Administrativo extends Empleado implements PerfilAdministrativo{
    @Transient
    protected Sistema sistema = null;

    public Administrativo() {
    }

    public Administrativo(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, username, password, email, nombres, apellidos, dni, telefono, direccion);
    }
    
    /*
        CRUD Cliente
    */

    @Override
    public Cliente buscarClientePorDni(String dni) {
        Map<String, Usuario> usuarios = sistema.getUsuarios();
        
        for(Usuario u:usuarios.values()){
            if(u instanceof Cliente cliente){
                if(cliente.getDni().equals(dni)){
                    return cliente;
                }
            }
        }
        
        return null;
    }

    @Override
    public List<Cliente> buscarClientePorApellido(String apellido) {
        Map<String, Usuario> usuarios = sistema.getUsuarios();
        List<Cliente> lista = new ArrayList();
        
        for(Usuario u:usuarios.values()){
            if(u instanceof Cliente cliente){
                if(cliente.getApellidos().equalsIgnoreCase(apellido)){
                    lista.add(cliente);
                }
            }
        }
        
        return lista;
    }
    
    @Override
    public List<Cliente> listarClientes() {
        Map<String, Usuario> usuarios = sistema.getUsuarios();
        List<Cliente> lista = new ArrayList();
        
        for(Usuario u:usuarios.values()){
            if(u instanceof Cliente cliente){
                lista.add(cliente);
            }
        }
        
        return lista;
    }
    
    
    
    /*
        CRUD Pedido
    */
    
    @Override
    public void crearPedido(Cliente cliente, Pedido pedido) throws Exception{
        Map<Integer, Pedido> pedidos = sistema.getPedidos();
        List<Pedido> pedidosCliente = cliente.getPedidos();
        
        if(existePedido(pedido)){
            throw new Exception("Ya existe un pedido con el ID "+pedido.getId()+" cargado en el sistema.");
        }
        
        /*
            GENERRAR ID
        */
        pedido.setId(generarId(pedido));
        
        //Se agrega el Pedido al Sistema
        pedidos.put(pedido.getId(), pedido);
        
        //Se agrega el Pedido al Cliente
        pedidosCliente.add(pedido);
    }
    
    //Busca 1 Pedido de 1 Cliente especifico con el id del Pedido como criterio
    @Override
    public Pedido buscarPedido(Cliente cliente, int idPedido){
        return cliente.buscarPedido(idPedido);
    }

    //Busca 1 Pedido en todo el sistema
    @Override
    public Pedido buscarPedidoEnSistema(int idPedido){
        Map<Integer, Pedido> pedidosSistema = sistema.getPedidos();
        
        return pedidosSistema.get(idPedido);
    }
    
    @Override
    public List<Pedido> listarPedidosCliente(Cliente cliente){
        return cliente.listarPedidos();
    }
    
    //Retorna una lista de los Pedidos de todos los Clientes en el Sistema
    @Override
    public List<Pedido> listarPedidosSistema(){
        Map<Integer, Pedido> pedidosSistema = sistema.getPedidos();
        List<Pedido> lista = new ArrayList(pedidosSistema.values());
        
        return lista;
    }
    
    //Se cambian solo la lista de productos del Pedido
    @Override
    public void editarPedido(Pedido pedido, List<RenglonPedido> renglones){
        pedido.setRenglones(renglones);
    }
    
    @Override
    public void borrarPedido(Cliente cliente, Pedido pedido) throws Exception{
        Map<Integer, Pedido> pedidosSistema = sistema.getPedidos();
        List<Pedido> pedidosCliente = cliente.getPedidos();
        
        if(!existePedido(pedido)){
            throw new Exception("El pedido que desea borrar no está cargado en el sistema.");
        }
        
        //Se borra el Pedido del Sistema
        pedidosSistema.remove(pedido.getId());
        //Se borra el Pedido del Cliente
        pedidosCliente.remove(pedido);
    }
    
    public boolean existePedido(Pedido pedido){
        Map<Integer, Pedido> pedidosSistema = sistema.getPedidos();
        
        return pedidosSistema.containsKey(pedido.getId());
    }
    
    //Otras operaciones relacionadas con Pedido
    
    @Override
    public void cambiarEstado(Pedido pedido, String estado){
        pedido.setEstado(estado);
    }
    
    @Override
    public void asignarRuta(Pedido pedido, Ruta ruta){
        pedido.setRuta(ruta);
    }
    
    @Override
    public void asignarTransportista(Pedido pedido, Transportista transportista){
        pedido.setTransportista(transportista);
    }
    
    @Override
    public Remito generarRemito(Pedido pedido){
        return pedido.generarRemito();
    }
    
    //Funciones relacionadas con mensajeria
    @Override
    public void responderTicket(Ticket ticket, String respuesta) {
        ticket.setRespuesta(respuesta);
    }

    @Override
    public Ticket buscarTicket(int idIicket) {
        List<Ticket> tickets = sistema.getTickets();
        
        for(Ticket t:tickets){
            if(t.getId() == idIicket){
                return t;
            }
        }
        
        return null;
    }

    @Override
    public List<Ticket> listarTodosLosTickets() {
        return sistema.getTickets();
    }

    @Override
    public List<Ticket> listarTicketsPendientes() {
        List<Ticket> tickets = sistema.getTickets();
        List<Ticket> pendientes = new ArrayList();
        
        for(Ticket t:tickets){
            if(t.getRespuesta() == null){
                pendientes.add(t);
            }
        }
        
        return pendientes;
    }

    @Override
    public List<Ticket> listarTicketsSolucionados() {
        List<Ticket> tickets = sistema.getTickets();
        List<Ticket> solucionados = new ArrayList();
        
        for(Ticket t:tickets){
            if(t.getRespuesta() != null){
                solucionados.add(t);
            }
        }
        
        return solucionados;
    }
    
    /*
        CRUD Transportista
    */
    
    @Override
    public Transportista buscarTransportista(String dni){
        List<Transportista> transportistas = sistema.getTransportistas();
        
        for(Transportista t:transportistas){
            if(t.getDni().equals(dni)){
                return t;
            }
        }
        
        return null;
    }
    
    //Devuelve una lista de los Transportistas por nombre y apellido
    @Override
    public List<Transportista> buscarTransportista(String nombres, String apellidos){
        List<Transportista> transportistas = sistema.getTransportistas();
        List<Transportista> lista = new ArrayList();
        
        for(Transportista t:transportistas){
            if(t.getNombres().equalsIgnoreCase(nombres) || t.getApellidos().equalsIgnoreCase(apellidos)){
                lista.add(t);
            }
        }
        
        return lista;
    }
    
    @Override
    public List<Transportista> listarTransportistas(){
        return sistema.getTransportistas();
    }
    
    //Operaciones con Transportista
    
    @Override
    public void asignarVehiculo(Transportista transportista, Vehiculo vehiculo){
        transportista.setVehiculoAsignado(vehiculo);
    }
    
    /*
        CRUD Vehiculo
    */
    
    @Override
    public Vehiculo buscarVehiculoPorDominio(String dominio){
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        
        for(Vehiculo v:vehiculos){
            if(v.getDominio().equalsIgnoreCase(dominio)){
                return v;
            }
        }
        
        return null;
    }
    
    @Override
    public List<Vehiculo> buscarVehiculosPorMarca(String marca){
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        List<Vehiculo> lista = new ArrayList();
        
        for(Vehiculo v:vehiculos){
            if(v.getMarca().equalsIgnoreCase(marca)){
                lista.add(v);
            }
        }
        
        return lista;
    }
    
    @Override
    public List<Vehiculo> buscarVehiculosPorModelo(String modelo){
        List<Vehiculo> vehiculos = sistema.getVehiculos();
        List<Vehiculo> lista = new ArrayList();
        
        for(Vehiculo v:vehiculos){
            if(v.getModelo().equalsIgnoreCase(modelo)){
                lista.add(v);
            }
        }
        
        return lista;
    }
    
    @Override
    public List<Vehiculo> listarVehiculo(){
        return sistema.getVehiculos();
    }
    
    /*
        CRUD Ruta
    */
    
    @Override
    public Ruta buscarRuta(String destino){
        List<Ruta> rutas = sistema.getRutas();
        
        for(Ruta r:rutas){
            if(r.getDestino().equalsIgnoreCase(destino)){
                return r;
            }
        }
        
        return null;
    }
    
    @Override
    public List<Ruta> listarRutas(){
        return sistema.getRutas();
    }
    
    /*
        CRUD Almacen
    */

    @Override
    public Almacen buscarAlmacen(String nombre) {
        List<Almacen> almacenes = sistema.getAlmacenes();
        
        for(Almacen a:almacenes){
            if(a.getNombreSucursal().equalsIgnoreCase(nombre)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Almacen> listarAlmacenes() {
        return sistema.getAlmacenes();
    }
    
    /*
        CRUD Producto
    */
    
    public Producto buscarProducto(String nombre){
        List<Producto> productos = sistema.getProductos();
        
        for(Producto p:productos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        
        return null;
    }
    
    @Override
    public List<Producto> listarProductos(){
        return sistema.getProductos();
    }
    
    /*
        CRUD TipoProducto
    */
    
    @Override
    public TipoProducto buscarTipoProducto(String nombre){
        List<TipoProducto> tipos = sistema.getTiposDeProductos();
        
        for(TipoProducto t:tipos){
            if(t.getNombre().equalsIgnoreCase(nombre)){
                return t;
            }
        }
        
        return null;
    }
    
    @Override
    public List<TipoProducto> listarTipoProducto(){
        TipoProductoDAO dao = new TipoProductoDAO();
        
        return dao.listar();
        
        //return sistema.getTiposDeProductos();
    }
    
    //Gestion Almacen
    @Override
    public void agregarProducto(Almacen almacen, Producto producto, int cantidad) throws Exception {
        almacen.agregarProducto(producto, cantidad);
    }

    @Override
    public RenglonInventario buscarProductoEnAlmacen(Almacen almacen, Producto producto) {
        return almacen.buscarRenglon(producto);
    }

    @Override
    public List<RenglonInventario> listarProductos(Almacen almacen) {
        return almacen.getRenglones();
    }
    
    @Override
    public void cambiarCantidadProducto(Almacen almacen, Producto producto, int cantidad) throws Exception{
        almacen.cambiarCantidadProducto(producto, cantidad);
    }

    @Override
    public void borrarProducto(Almacen almacen, Producto producto) throws Exception {
        almacen.borrarProducto(producto);
    }
    
    /*
        Login
    */
    public void conectar(Sistema sistema){
        this.sistema = sistema;
    }
    
    //Metodo que se llama al cerrar sesion
    public void desconectar(){
        this.sistema = null;
    }
    
    //SACAR DESPUES DE IMPLEMENTAR PERSISTENCIA
    public int generarId(Object o){
        return o.hashCode();
    }
}
