/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo
 */
public interface PerfilGerente {
    
    //CRUD Transportista
    public void crearTransportista(Transportista transportista) throws Exception;
    public void editarTransportista(Transportista transportista, String cuil, String nombre, String apellido, String dni, String telefono, String direccion);
    public void borrarTransportista(Transportista transportista) throws Exception;
    
    //CRUD Vehiculo
    public void crearVehiculo(Vehiculo vehiculo) throws Exception;
    public void editarVehiculo(Vehiculo vehiculo, String marca, String modelo, String dominio, int capacidadDeCarga);
    public void borrarVehiculo(Vehiculo vehiculo) throws Exception;
    
    //CRUD Ruta
    public void crearRuta(Ruta ruta) throws Exception;
    public void editarRuta(Ruta ruta, String origen, String destino, LocalDateTime fechaSalida, LocalDateTime fechaLlegada);
    public void borrarRuta(Ruta ruta) throws Exception;
    
    //CRUD Proveedor
    public void crearProveedor(Proveedor proveedor) throws Exception;
    public Proveedor buscarProveedor(String nombre);
    public List<Proveedor> listarProveedores();
    public void editarProveedor(Proveedor proveedor, String cuit, String nombre, String telefono, String direccion);
    public void borrarProveedor(Proveedor proveedor) throws Exception;
    
    //Operaciones con Proveedor
    public void agregarEvaluacion(Proveedor proveedor, Evaluacion evaluacion);
    public List<Evaluacion> listarEvaluaciones(Proveedor proveedor);
    public void agregarContrato(Proveedor proveedor, Contrato contrato);
    public List<Contrato> listarContratos(Proveedor proveedor);
    
    //CRUD Almacen
    public void crearAlmacen(Almacen almacen) throws Exception;
    public void editarAlmacen(Almacen almacen, String nombre, boolean esCentroDistribucion, String direccion);
    public void borrarAlmacen(Almacen almacen) throws Exception;
    
    //CRUD Producto
    public void crearProducto(Producto producto) throws Exception;
    public void editarProducto(Producto producto, String nombre, TipoProducto tipo);
    public void borrarProducto(Producto producto) throws Exception;
    
    //CRUD TipoProducto
    public void crearTipoDeProducto(TipoProducto tipo) throws Exception;
    public void editarTipoProducto(TipoProducto tipo, String nombre);
    public void borrarTipoDeProducto(TipoProducto tipo) throws Exception;
    
    //CRUD OrdenDeCompra
    public void crearOrdenDeCompra(OrdenDeCompra orden) throws Exception;
    public OrdenDeCompra buscarOrdenDeCompra(int idOrdenDeCompra);
    public List<OrdenDeCompra> listarOrdenesDeCompra();
    public void editarOrdenDeCompra(OrdenDeCompra orden, Proveedor proveedor, List<RenglonOrdenDeCompra> renglones);
    public void borrarOrdenDeCompra(OrdenDeCompra orden) throws Exception;
    //Otras operaciones con OrdenDeCompra
    public void establecerEntregaOrdenDeCompra(OrdenDeCompra orden, LocalDateTime fechaEntrega) throws Exception;
    
    //Generacion de informes
    //Numero de veces que se pidieron los Productos comprendido entre 2 fechas
    //KEY = Producto, VALUE = cantidad
    public Map<Producto, Integer> listarProductosPorPedidos(LocalDate inicio, LocalDate fin) throws Exception;
    //Listado de Tranportitastas y su cantidad de entregas en comprendidas entre 2 fechas
    //KEY = Transportista, VALUE = cantidad de entregas
    public Map<Transportista, Integer> listarTransportistasPorEntregas(LocalDate inicio, LocalDate fin) throws Exception;
    //Devuelve un mapa donde KEY = Proveedor, VALUE = tiempo promedio de entrega comprendido entre 2 fechas
    public Map<Proveedor, Float> listarProveedoresPorEntregas(LocalDate inicio, LocalDate fin);
    //Cantidad de usuarios registrados comprendido entre 2 fechas
    public int numeroUsuariosRegistrados(LocalDate inicio, LocalDate fin) throws Exception;
    //Cantidad promedio de Pedidos por Cliente
    public double promedioPedidos(LocalDate inicio, LocalDate fin) throws Exception;
}