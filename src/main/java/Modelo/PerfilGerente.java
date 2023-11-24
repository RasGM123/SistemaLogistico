/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo
 */

public interface PerfilGerente {
    
    //CRUD Usuario
    public void crearUsuario(Usuario usuario) throws Exception;
    public Usuario buscarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public void editarUsuario(Usuario usuario);
    public void borrarUsuario(Usuario usuario) throws Exception;
    
    //CRUD Vehiculo
    public void crearVehiculo(Vehiculo vehiculo) throws Exception;
    public void editarVehiculo(Vehiculo vehiculo, String marca, String modelo, String dominio, int capacidadDeCarga);
    public void borrarVehiculo(Vehiculo vehiculo) throws Exception;
    
    //CRUD Ruta
    public void crearRuta(Ruta ruta) throws Exception;
    public void editarRuta(Ruta ruta, String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada);
    public void borrarRuta(Ruta ruta) throws Exception;
    
    //CRUD Proveedor
    public void crearProveedor(Proveedor proveedor) throws Exception;
    public Proveedor buscarProveedor(String nombre);
    public List<Proveedor> listarProveedores();
    public void editarProveedor(Proveedor proveedor, String cuit, String nombre, String email, String telefono, String direccion);
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
    
    //CRUD OrdenDeCompra
    public void crearOrdenDeCompra(OrdenDeCompra orden) throws Exception;
    public OrdenDeCompra buscarOrdenDeCompra(int idOrdenDeCompra);
    public List<OrdenDeCompra> listarOrdenesDeCompra();
    public void editarOrdenDeCompra(OrdenDeCompra orden, Proveedor proveedor, List<RenglonOrdenDeCompra> renglones);
    public void borrarOrdenDeCompra(OrdenDeCompra orden) throws Exception;
    //Otras operaciones con OrdenDeCompra
    public void establecerEntregaOrdenDeCompra(OrdenDeCompra orden, LocalDate fechaEntrega) throws Exception;
    
    //Generacion de informes
    //Numero de veces que se pidieron los Productos comprendido entre 2 fechas
    //KEY = Producto, VALUE = cantidad
    public Map<Producto, Integer> listarProductosPorPedidos(LocalDate inicio, LocalDate fin) throws Exception;
    //Listado de Tranportitastas y su cantidad de entregas en comprendidas entre 2 fechas
    //KEY = Transportista, VALUE = cantidad de entregas
    public Map<Transportista, Integer> listarTransportistasPorEntregas(LocalDate inicio, LocalDate fin) throws Exception;
    //Devuelve un mapa donde KEY = Proveedor, VALUE = tiempo promedio de entrega comprendido entre 2 fechas
    public Map<Proveedor, Float> listarProveedoresPorTiempoDeEntrega(LocalDate inicio, LocalDate fin) throws Exception;
    //Cantidad de usuarios registrados comprendido entre 2 fechas
    public int contarClientesRegistrados(LocalDate inicio, LocalDate fin) throws Exception;
    //Cantidad promedio de Pedidos por Cliente
    public double calcularPromedioPedidos(LocalDate inicio, LocalDate fin) throws Exception;
}