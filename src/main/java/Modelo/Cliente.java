/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rodrigo
 */

public class Cliente extends Usuario implements PerfilCliente{
    private List<String> preferencias;
    private List<Pedido> pedidos;
    private List<Ticket> tickets;
    
    private Sistema sistema;

    public Cliente() {
    }

    public Cliente(String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(username, password, email, nombres, apellidos, dni, telefono, direccion);
        
        this.preferencias = new ArrayList();
        this.pedidos = new ArrayList();
        this.tickets = new ArrayList();
        this.sistema = null;
    }
    
    //Funcionalidades

    @Override
    public List<Pedido> listarPedidos() {
        return getPedidos();
    }

    @Override
    public List<Pedido> listarPedidos(LocalDate inicio, LocalDate fin) throws Exception {
        List<Pedido> pedidos = getPedidos();
        LocalDate fecha;
        List<Pedido> lista = new ArrayList();
        
        for(Pedido p:pedidos){
            fecha = p.getFechaCreacion().toLocalDate();
            
            if(estaEntre(fecha, inicio, fin)){
                lista.add(p);
            }
        }
        
        return lista;
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

    @Override
    public Pedido buscarPedido(int idPedido) {
        if(pedidos.isEmpty()){
            return null;
        }
        
        for(Pedido p:pedidos){
            if(p.getId() == idPedido){
                return p;
            }
        }
        
        return null;
    }

    @Override
    public String consultarEstado(Pedido pedido) {
        return pedido.getEstado();
    }

    @Override
    public List<Movimiento> listarMovimientos(Pedido pedido) {
        List<Movimiento> movimientos = pedido.getMovimientos();
        
        movimientos.sort((Movimiento a, Movimiento b) -> -1*a.getFecha().compareTo(b.getFecha()));
        
        return movimientos;
    }
    
    //Funcionalidad mensajeria

    @Override
    public void crearTicket(String motivo, String reclamo) {
        Ticket ticket = new Ticket(motivo, reclamo);
        
        ticket.setId(ticket.hashCode());
        
        this.sistema.getTickets().add(ticket);
        
        this.tickets.add(ticket);
    }

    @Override
    public List<Ticket> listarTickets() {
        return this.getTickets();
    }

    @Override
    public Ticket buscarTicket(int idTicket) {
        for(Ticket t:this.tickets){
            if(t.getId() == idTicket){
                return t;
            }
        }
        
        return null;
    }
    
    //devuelve la lista de tipos de producto mas pedidos por el cliente con una cantidad maxima de cantidadPreferencias
    //tomando en cuenta los mas recientes pedidos hasta una cantidadPedidos
    public void determinarPreferencias(int cantidadPedidos, int cantidadPreferencias) throws Exception{
        
        if(pedidos.isEmpty()){
            throw new Exception("El cliente todavía no ha cargado pedidos.");
        }
        
        List<String> resultado = new ArrayList();
        //String = nombre del tipo de producto , Integer = numero de apariciones
        Map<String,Integer> listaPreferencias = new HashMap();
        List<Pedido> ultimosPedidos = listarUltimosPedidos(cantidadPedidos);
        String tipoProducto;
        
        //recorre los ultimos X pedidos del cliente  para conocer sus preferencias
        //cuenta el número de incidencias de los TiposDeProducto
        for(Pedido pedido:ultimosPedidos){
            //recorre renglones del pedido
            for(RenglonPedido renglon:pedido.getRenglones()){
                tipoProducto = renglon.getProducto().getTipoProducto().getNombre();
                
                if(listaPreferencias.containsKey(tipoProducto)){
                    
                    //Si la preferencia existe en el mapa, se incrementa su numero de incidencias en 1
                    listaPreferencias.put(tipoProducto, listaPreferencias.get(tipoProducto)+1);
                }else{
                    
                    //Si la preferencia NO existe en el mapa, se agrega el tipo de producto con cantidad de incidencias = 1
                    listaPreferencias.put(tipoProducto, 1);
                }
            }
        }
        
        if(listaPreferencias.size()>cantidadPreferencias){
            
        }else{
            resultado.addAll((Collection<? extends String>) listaPreferencias);
        }
        
        this.preferencias = resultado;
    }
    
    //devuelve los ultimmos X pedidos mas recientes
    public List<Pedido> listarUltimosPedidos(int cantidad){
        List<Pedido> listaPedidos = new ArrayList();
        
        listaPedidos.addAll(this.pedidos);
        
        //se ordena por fecha la lista de pedidos (mas reciente primero)
        listaPedidos.sort((Pedido a, Pedido b) -> -1*a.getFechaCreacion().compareTo(b.getFechaCreacion()));
        
        if(listaPedidos.size()<=cantidad){
            return listaPedidos;
        }
        
        //se quitan los elementos que exceden la cantidad 
        listaPedidos = listaPedidos.subList(0, cantidad-1);
        
        return listaPedidos;
    }
    
    /*
        LOGIN
    */
    
    public void conectar(Sistema sistema){
        this.sistema = sistema;
    }
    
    //Metodo que se llama al cerrar sesion
    public void desconectar(){
        this.sistema = null;
    }
    
    //Setters

    public void setPreferencias(List<String> preferencias) {
        this.preferencias = preferencias;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    //Getters

    public List<String> getPreferencias() {
        return preferencias;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    private List<Ticket> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
