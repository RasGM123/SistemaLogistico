/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface PerfilAdministrativo {
    
    //CRUD Administrativo
    public void actualizarInformacionCuenta() throws Exception;
    
    //CRUD Cliente
    public void crearUsuarioCliente(Cliente cliente) throws Exception;
    public Cliente buscarClientePorDni(String dni);
    public List<Cliente> buscarClientePorApellido(String apellido);
    public List<Cliente> listarClientes();
    
    //CRUD Pedido
    public void crearPedido(Cliente cliente, Pedido pedido) throws Exception;
    public Pedido buscarPedido(Cliente cliente, int idPedido);
    public Pedido buscarPedidoEnSistema(int idPedido);
    public List<Pedido> listarPedidosCliente(Cliente cliente);
    public List<Pedido> listarPedidosSistema();
    public void editarPedido(Pedido pedido, List<RenglonPedido> renglones);
    public void borrarPedido(Cliente cliente, Pedido pedido) throws Exception;
    
    //Otras operaciones con Pedido
    public void cambiarEstadoPedido(Pedido pedido, String estado, String detalle);
    public void asignarRuta(Pedido pedido, Ruta ruta);
    public void asignarTransportista(Pedido pedido, Transportista transportista);
    public Remito generarRemito(Pedido pedido);
    
    //Funciones relacionadas con mensajeria
    public void responderTicket(Ticket ticket, String respuesta);
    public Ticket buscarTicket(int idIicket);
    public List<Ticket> listarTodosLosTickets();
    public List<Ticket> listarTicketsPendientes();
    public List<Ticket> listarTicketsSolucionados();
    
    //CRUD Transportista
    public Transportista buscarTransportista(String dni);
    public List<Transportista> buscarTransportista(String nombres, String apellidos);
    public List<Transportista> listarTransportistas();
    
    //CRUD Vehiculo
    public Vehiculo buscarVehiculoPorDominio(String dominio);
    public List<Vehiculo> buscarVehiculosPorMarca(String marca);
    public List<Vehiculo> buscarVehiculosPorModelo(String modelo);
    public List<Vehiculo> listarVehiculo();
    
    //CRUD Ruta
    public Ruta buscarRuta(String destino);
    public List<Ruta> listarRutas();
    
    //Operaciones con Transportista
    public void asignarVehiculo(Transportista transportista, Vehiculo vehiculo);
    
    //CRUD Almacen
    public Almacen buscarAlmacen(String nombre);
    public List<Almacen> listarAlmacenes();
    
    //Gestion Almacen
    public void agregarProducto(Almacen almacen, Producto producto, int cantidad) throws Exception;
    public RenglonInventario buscarProductoEnAlmacen(Almacen almacen, Producto producto);
    public List<RenglonInventario> listarProductosEnAlmacen(Almacen almacen);
    public void cambiarCantidadProducto(Almacen almacen, Producto producto, int cantidad) throws Exception;
    public void borrarProductoDeAlmacen(Almacen almacen, Producto producto) throws Exception;
    
    //CRUD Producto
    public void crearProducto(Producto producto) throws Exception;
    public Producto buscarProducto(String nombre);
    public List<Producto> listarProductos();
    public void editarProducto(Producto producto, String nombre, TipoProducto tipo);
    public void borrarProducto(Producto producto) throws Exception;
    
    //CRUD TipoProducto
    public void crearTipoProducto(TipoProducto tipoProducto) throws Exception;
    public TipoProducto buscarTipoProducto(String nombre);
    public List<TipoProducto> listarTipoProducto();
    public void editarTipoProducto(TipoProducto tipoProducto, String nombre);
    public void borrarTipoProducto(TipoProducto tipoProducto) throws Exception;
}
