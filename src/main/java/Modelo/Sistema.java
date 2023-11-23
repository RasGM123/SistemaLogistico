/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.AdministrativoDAO;
import Persistencia.AlmacenDAO;
import Persistencia.ClienteDAO;
import Persistencia.GerenteDAO;
import Persistencia.OrdenDeCompraDAO;
import Persistencia.PedidoDAO;
import Persistencia.ProductoDAO;
import Persistencia.ProveedorDAO;
import Persistencia.RutaDAO;
import Persistencia.TicketDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Persistencia.TipoProductoDAO;
import Persistencia.TransportistaDAO;
import Persistencia.VehiculoDAO;

/**
 *
 * @author Gustavo
 */

public final class Sistema {
    //Sistema es SINGLETON
    private static Sistema instancia;
    
    //Clave = nombre usuario
    private Map<String,Usuario> usuarios;
    //Clave = id Pedido
    private Map<Integer,Pedido> pedidos;
    private List<Vehiculo> vehiculos;
    private List<Ruta> rutas;
    private List<Producto> productos;
    private List<TipoProducto> tiposDeProductos;
    private List<Almacen> almacenes;
    private List<OrdenDeCompra> ordenesDeCompra;
    private List<Proveedor> proveedores;
    private List<Ticket> tickets;
    
    private Sesion sesion;
    
    public static Sistema iniciar() throws Exception{
        if(instancia == null){
            instancia = new Sistema();
        }
        
        return instancia;
    }
    
    private Sistema() throws Exception{
        this.usuarios = new HashMap();
        this.pedidos = new HashMap();
        this.vehiculos = new ArrayList();
        this.rutas = new ArrayList();
        this.productos = new ArrayList();
        this.tiposDeProductos = new ArrayList();
        this.almacenes = new ArrayList();
        this.ordenesDeCompra = new ArrayList();
        this.proveedores = new ArrayList();
        this.tickets = new ArrayList();
        
        //El Sistema no tiene iniciada la Sesion al crearse
        this.sesion = null;
        
        cargarDB();
    }
    
    private void cargarDB() throws Exception{
        ClienteDAO daoCliente = new ClienteDAO();
        AdministrativoDAO daoAdministrativo = new AdministrativoDAO();
        GerenteDAO daoGerente = new GerenteDAO();
        TransportistaDAO daoTransportista = new TransportistaDAO();
        
        PedidoDAO daoPedido = new PedidoDAO();
        VehiculoDAO daoVehiculo = new VehiculoDAO();
        RutaDAO daoRuta = new RutaDAO();
        ProductoDAO daoProducto = new ProductoDAO();
        TipoProductoDAO daoTipoProducto = new TipoProductoDAO();
        AlmacenDAO daoAlmacen = new AlmacenDAO();
        OrdenDeCompraDAO daoOrdenDeCompra = new OrdenDeCompraDAO();
        ProveedorDAO daoProveedor = new ProveedorDAO();
        TicketDAO daoTicket = new TicketDAO();
        
        //se crea un Usuario Gerente para probar el sistema
        crearUsuario(new Gerente("993300022200", "gerente", "gerente", "elon@musk.com", "Elon", "Mosquito", "33000222", "3788 671100", "CASA"));
        
        //se crea un Usuario Administrativo para probar el sistema
        crearUsuario(new Administrativo("119900022299", "administrativo", "administrativo", "marcos@gmail.com", "Marcos", "Zuck", "99000222", "3700 991100", "MARTE"));
        
        //se crea un Usuario Cliente para probar el sistema
        crearUsuario(new Cliente("cliente", "cliente", "jorgito@outlook.com", "Jorge", "Smith", "20111999", "3764 001122", "Argentina"));
        
        //Se crea un Usuario Transportista para probar el sistema
        crearUsuario(new Transportista("111100022299", "transportista", "transportista", "carlos@gmail.com", "Carlos", "Perez", "11000222", "3700 771100", "JUPITER"));
        
        //Carga de la base de datos
        List<Cliente> listaClientes = daoCliente.listar();
        for(Cliente c:listaClientes){
            this.usuarios.put(c.getUsername(), c);
        }
        
        List<Administrativo> listaAdministrativos = daoAdministrativo.listar();
        for(Administrativo a:listaAdministrativos){
            this.usuarios.put(a.getUsername(), a);
        }
        
        List<Gerente> listaGerentes = daoGerente.listar();
        for(Gerente g:listaGerentes){
            this.usuarios.put(g.getUsername(), g);
        }
        
        List<Transportista> listaTransportistas = daoTransportista.listar();
        for(Transportista t:listaTransportistas){
            this.usuarios.put(t.getUsername(), t);
        }
        
        List<Pedido> listaPedidos = daoPedido.listar();
        for(Pedido p:listaPedidos){
            this.pedidos.put(p.getId(), p);
        }
        
        this.vehiculos.addAll(daoVehiculo.listar());
        this.rutas.addAll(daoRuta.listar());
        this.productos.addAll(daoProducto.listar());
        this.tiposDeProductos.addAll(daoTipoProducto.listar());
        this.almacenes.addAll(daoAlmacen.listar());
        this.ordenesDeCompra.addAll(daoOrdenDeCompra.listar());
        this.proveedores.addAll(daoProveedor.listar());
        this.tickets.addAll(daoTicket.listar());
    }
    
    //Funcionalidades
    
    /*
        ABM Usuario
    */
    
    //Crea un usuario
    public void crearUsuario(Usuario usuario) throws Exception{
        if(existeUsuario(usuario)){
            throw new Exception("El nombre de usuario "+usuario.getUsername()+" no está disponible.");
        }
        
        if(existeCorreo(usuario.getEmail())){
            throw new Exception("El correo "+usuario.getEmail()+" no está disponible.");
        }
        
        usuarios.put(usuario.getUsername(), usuario);
    }
    
    public Usuario buscarUsuario(String username){
        if(!existeUsuario(username)){
            return null;
        }
        
        return usuarios.get(username);
    }
    
    public Usuario buscarUsuarioPorDni(String dni){
        for(Usuario u:this.usuarios.values()){
            if(u.getDni().equals(dni)){
                return u;
            }
        }
        
        return null;
    }
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = new ArrayList();
        
        for(Usuario u:usuarios.values()){
            lista.add(u);
        }
        
        return lista;
    }
    
    public void borrarUsuario(Usuario usuario) throws Exception{
        if(!existeUsuario(usuario)){
            throw new Exception("El usuario que quiere borrar no existe en el sistema.");
        }
        
        //Se cierra Sesion si el Usuario que tiene la sesion iniciada coincide con el Usuario que se quiere borrar
        if(sesion.getUsuario().equals(usuario)){
            cerrarSesion();
        }
        
        usuarios.remove(usuario.getDni());
    }
    
    public boolean existeCorreo(String correo) throws Exception{
        if(usuarios.isEmpty()){
            return false;
        }
        
        for(Usuario u:usuarios.values()){
            if(u.getEmail().equals(correo)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean existeUsuario(Usuario usuario){
        if(usuarios.isEmpty()){
            return false;
        }
        
        return usuarios.containsKey(usuario.getUsername());
    }
    
    public boolean existeUsuario(String username){
        if(usuarios.isEmpty()){
            return false;
        }
        
        return usuarios.containsKey(username);
    }
    
    /*
        LOGIN
    */
    
    public void iniciarSesion(String username, String password) throws Exception{
        if(!existeUsuario(username)){
            throw new Exception("El usuario no existe en el sistema.");
        }
        
        String passwordEnSistema = usuarios.get(username).getPassword();
        String passwordEnLogin = password;
        
        //Se comparan ambas contraseñas
        if(!passwordEnSistema.equals(passwordEnLogin)){
            throw new Exception("Contraseña incorrecta.");
        }
        
        //Si las contraseñas coinciden se retorna el usuario 
        Usuario usuario = usuarios.get(username);
        
        if(usuario instanceof Cliente cliente){
            cliente.conectar(this);
        }else{
            if(usuario instanceof Administrativo usuarioAdministrativo){
                usuarioAdministrativo.conectar(this);
            }else{
                if(usuario instanceof Gerente usuarioGerente){
                    usuarioGerente.conectar(this);
                }else{
                    if(usuarios instanceof Transportista usuarioTransportista){
                        usuarioTransportista.conectar(this);
                    }
                }
            }
        }
        
        this.sesion = new Sesion(usuario, LocalDateTime.now());
    }
    
    public void cerrarSesion() throws Exception{
        if(sesion==null){
            throw new Exception("Usted no ha iniciado sesión.");
        }
        
        Usuario usuario = sesion.getUsuario();
        
        if(usuario instanceof Cliente cliente){
            cliente.desconectar();
        }else{
            if(usuario instanceof Administrativo usuarioAdministrativo){
                usuarioAdministrativo.desconectar();
            }else{
                if(usuario instanceof Gerente usuarioGerente){
                    usuarioGerente.desconectar();
                }else{
                    if(usuario instanceof Transportista usuarioTransportista){
                        usuarioTransportista.desconectar();
                    }
                }
            }
        }
        
        sesion.cerrar();
    }
    
    //Devuelve un Usuario si se inició sesión correctamente, caso contrario devuelve null
    public Usuario obtenerSesion(){
        return this.sesion.getUsuario();
    }
    
    //Devuelve un entero segun el tipo de Usuario
    // 1 = Cliente, 2 = Gerente, 3 = Administrativo, 4 = Transportista
    public int obtenerCodigoUsuario(Usuario usuario){
        if(usuario instanceof Cliente){
            return 1;
        }else{
            if(usuario instanceof Gerente){
                return 2;
            }else{
                if(usuario instanceof Administrativo){
                    return 3;
                }
            }
            
        }
        
        //Codigo Transportista
        return 4;
    }
    
    //getters & setters

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Cliente> getClientes() {
        List<Cliente> lista = new ArrayList();
        
        for(Usuario u:getUsuarios().values()){
            if(u instanceof Cliente cliente){
                lista.add(cliente);
            }
        }
        
        return lista;
    }

    public Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public List<Transportista> getTransportistas() {
        List<Transportista> lista = new ArrayList();
        
        for(Usuario u:getUsuarios().values()){
            if(u instanceof Transportista transportista){
                lista.add(transportista);
            }
        }
        
        return lista;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<TipoProducto> getTiposDeProductos() {
        return tiposDeProductos;
    }

    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public List<OrdenDeCompra> getOrdenesDeCompra() {
        return ordenesDeCompra;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}

