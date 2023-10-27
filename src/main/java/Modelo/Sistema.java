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
    //Clave = dni
    private Map<String,Cliente> clientes;
    //Clave = id Pedido
    private Map<Integer,Pedido> pedidos;
    //Clave = dni
    private Map<String,Transportista> transportistas;
    private List<Vehiculo> vehiculos;
    private List<Ruta> rutas;
    private List<Producto> productos;
    private List<TipoProducto> tiposDeProductos;
    private List<Almacen> almacenes;
    private List<OrdenDeCompra> ordenesDeCompra;
    private List<Proveedor> proveedores;
    
    private Sesion sesion;
    
    public static Sistema iniciar() throws Exception{
        if(instancia == null){
            instancia = new Sistema();
        }
        
        return instancia;
    }
    
    private Sistema() throws Exception{
        this.usuarios = new HashMap();
        this.clientes = new HashMap();
        this.pedidos = new HashMap();
        this.transportistas = new HashMap();
        this.vehiculos = new ArrayList();
        this.rutas = new ArrayList();
        this.productos = new ArrayList();
        this.tiposDeProductos = new ArrayList();
        this.almacenes = new ArrayList();
        this.ordenesDeCompra = new ArrayList();
        this.proveedores = new ArrayList();
        
        //El Sistema no tiene iniciada la Sesion al crearse
        this.sesion = null;
        
        cargarDatos();
    }
    
    //Funcionalidades
    
    
    //Carga algunos datos en el Sistema para poder probarlo
    public void cargarDatos() throws Exception{
        //se crea un Usuario Gerente para probar el sistema
        crearUsuario(new Gerente("113300022299", 1, "gerente", "gerente", "elon@musk.com", "Elon", "Mosquito", "33000222", "3788 671100", "CASA"));
        
        //se crea un Usuario Administrativo para probar el sistema
        crearUsuario(new Administrativo("119900022299", 2, "empleado", "empleado", "marcos@gmail.com", "Marcos", "Zuck", "99000222", "3700 991100", "MARTE"));
        
        //se crea un Usuario Cliente para probar el sistema
        crearUsuario(new Cliente(3, "cliente", "cliente", "jorgito@outlook.com", "Jorge", "Smith", "20111999", "3764 001122", "Argentina"));
        
    }
    
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
        
        usuarios.put(usuario.getUsername(), usuario);
    }
    
    public Usuario buscarUsuario(String username) throws Exception{
        if(usuarios.isEmpty()){
            throw new Exception("El sistema no tiene ningún usuario cargado.");
        }
        
        if(!existeUsuario(username)){
            return null;
        }
        
        return usuarios.get(username);
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
    
    //Se permite editar solo email y password del Usuario
    public void editarUsuario(Usuario usuario, String email, String password) throws Exception{
        if(!existeUsuario(usuario)){
            throw new Exception("El usuario que quiere editar  no existe.");
        }
        
        usuario.setEmail(email);
        usuario.setPassword(password);
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
        
        sesion.setUsuario(null);
    }
    
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
        return clientes;
    }

    public Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public Map<String, Transportista> getTransportistas() {
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
}

