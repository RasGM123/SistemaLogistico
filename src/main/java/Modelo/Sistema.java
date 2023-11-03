/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo
 */
public final class Sistema {
    //Sistema es SINGLETON
    private static Sistema instancia;
    //Clave = dni
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
        
        cargarDatos();
    }
    
    //Carga algunos datos en el Sistema para poder probarlo
    public void cargarDatos() throws Exception{
        //se crea un Usuario Gerente para probar el sistema
        crearUsuario(new Gerente("993300022200", "gerente", "gerente", "elon@musk.com", "Elon", "Mosquito", "33000222", "3788 671100", "CASA"));
        
        //se crea un Usuario Administrativo para probar el sistema
        crearUsuario(new Administrativo("119900022299", "empleado", "empleado", "marcos@gmail.com", "Marcos", "Zuck", "99000222", "3700 991100", "MARTE"));
        
        //se crea un Usuario Cliente para probar el sistema
        crearUsuario(new Cliente("cliente", "cliente", "jorgito@outlook.com", "Jorge", "Smith", "20111999", "3764 001122", "Argentina"));
        
    }
    
    //Funcionalidades
    
    /*
        ABM Usuario
    */
    
    //Crea un usuario y lo agrega al Sistema si no existe
    public void crearUsuario(Usuario usuario) throws Exception{
        if(existeUsuario(usuario)){
            throw new Exception("El nombre de usuario "+usuario.getUsername()+" no está disponible.");
        }
        
        if(existeCorreo(usuario.getEmail())){
            throw new Exception("El correo "+usuario.getEmail()+" no está disponible.");
        }
        
        usuario.setId(generarId(usuario));
        
        usuarios.put(usuario.getUsername(), usuario);
    }
    
    public Usuario buscarUsuario(String username) throws Exception{
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
    
    public List<Usuario> listarUsuarios() throws Exception{
        if(usuarios.isEmpty()){
            throw new Exception("El sistema no tiene ningún usuario cargado.");
        }
        
        List<Usuario> lista = new ArrayList();
        Iterator iter = usuarios.entrySet().iterator();
        Usuario usuario;
        
        //Se recorre el Mapa que contiene lo usuarios y se los agrega a la Lista
        while(iter.hasNext()){
            usuario = (Usuario) iter.next();
            
            lista.add(usuario);
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
    
    public boolean existeUsuario(Usuario usuario) throws Exception{
        if(usuarios.isEmpty()){
            return false;
        }
        
        return usuarios.containsKey(usuario.getUsername());
    }
    
    public boolean existeUsuario(String username) throws Exception{
        if(usuarios.isEmpty()){
            return false;
        }
        
        return usuarios.containsKey(username);
    }
    
    /*
        LOGIN
    */
    
    //Se debe iniciar sesion, luego 
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
        
        //Si es un UsuarioAdministrativo o UsuarioGerente se conecta a todo el Sistema
        //el UsuarioCliente solo conoce sus Pedidos
        if(usuario instanceof Administrativo usuarioAdministrativo){
            usuarioAdministrativo.conectar(this);
        }
        
        this.sesion = new Sesion(usuario, LocalDateTime.now());
    }
    
    public void cerrarSesion() throws Exception{
        if(sesion==null){
            throw new Exception("Usted no ha iniciado sesión.");
        }
        
        Usuario usuario = sesion.getUsuario();
        
        if(usuario instanceof Administrativo usuarioAdministrativo){
            usuarioAdministrativo.desconectar();
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
    
    //Implementacion pendiente...
    public String hashPassword(String password){
        return password;
    }
    
    //getters & setters

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<String, Cliente> getClientes() {
        Map<String, Cliente> clientes = new HashMap();
        Cliente cliente;
        Iterator iter = clientes.entrySet().iterator();
        
        while(iter.hasNext()){
            cliente = (Cliente)iter.next();
            
            if(cliente instanceof Cliente){
                clientes.put(cliente.getDni(), cliente);
            }
        }
        
        return clientes;
    }

    public Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public Map<String, Transportista> getTransportistas() {
        Map<String, Transportista> transportistas = new HashMap();
        Transportista transportista;
        Iterator iter = transportistas.entrySet().iterator();
        
        while(iter.hasNext()){
            transportista = (Transportista)iter.next();
            
            if(transportista instanceof Transportista){
                transportistas.put(transportista.getDni(), transportista);
            }
        }
        
        return transportistas;
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
        return tickets;
    }
    
    //SACAR DESPUES DE IMPLMENTAR PERSISTENCIA
    public int generarId(Object o){
        return o.hashCode();
    }
}

