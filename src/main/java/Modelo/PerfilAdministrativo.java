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
    
    //CRUD Pedido
    public void crearPedido(Cliente cliente, Pedido pedido) throws Exception;
    public Pedido buscarPedido(Cliente cliente, int idPedido);
    public Pedido buscarPedidoEnSistema(int idPedido);
    public List<Pedido> listarPedidosCliente(Cliente cliente);
    public List<Pedido> listarPedidosSistema();
    public void editarPedido(Pedido pedido, List<RenglonPedido> renglones);
    public void borrarPedido(Cliente cliente, Pedido pedido) throws Exception;
    
    //Otras operaciones con Pedido
    public void cambiarEstado(Pedido pedido, String estado);
    public void asignarRuta(Pedido pedido, Ruta ruta);
    public void asignarTransportista(Pedido pedido, Transportista transportista);
    public void generarRemito(Pedido pedido);
    public Remito obtenerRemito(Pedido pedido);
    
    //CRUD Transportista
    public Transportista buscarTransportista(String dni);
    public Transportista buscarTransportista(String nombres, String apellidos);
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
    public RenglonInventario buscarProducto(Almacen almacen, Producto producto);
    public List<RenglonInventario> listarProductos(Almacen almacen);
    public void cambiarCantidadProducto(Almacen almacen, Producto producto, int cantidad) throws Exception;
    public void borrarProducto(Almacen almacen, Producto producto) throws Exception;
    
    //CRUD Producto
    public Producto buscarProducto(String nombre);
    public List<Producto> listarProductos();
    
    //CRUD TipoProducto
    public TipoProducto buscarTipoDeProducto(String nombre);
    public List<TipoProducto> listarTipoProducto();
}
