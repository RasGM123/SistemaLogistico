/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Persistencia.PedidoDAO;
import Persistencia.TransportistaDAO;
import java.time.LocalDate;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Rodrigo
 */

@Entity
public class Transportista extends Empleado implements PerfilTransportista{
    @OneToOne (fetch = FetchType.EAGER)
    private Vehiculo vehiculoAsignado;
    
    @Transient
    protected Sistema sistema = null;

    public Transportista() {
    }

    public Transportista(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, username, password, email, nombres, apellidos, dni, telefono, direccion);
        
        this.vehiculoAsignado = null;
    }
    
    //Funcionalidades
    
    
    //CRUD Transportista
    @Override
    public void actualizarInformacionCuenta() {
        TransportistaDAO dao = new TransportistaDAO();
        
        dao.editar(this);
    }

    //Operaciones con Pedido
    @Override
    public Pedido buscarPedido(int id) {
        Map<Integer, Pedido> pedidos = sistema.getPedidos();
        
        return pedidos.get(id);
    }

    @Override
    public void entregarPedido(Pedido pedido) {
        Movimiento movimiento = new Movimiento(LocalDate.now(), "Se entregó el pedido "+pedido.getId()+".");
        PedidoDAO dao = new PedidoDAO();
        
        pedido.getMovimientos().add(movimiento);
        pedido.setEstado("Entregado");
        
        dao.editar(pedido);
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
    
    //Setters

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }
    
    //Getters

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }
}
