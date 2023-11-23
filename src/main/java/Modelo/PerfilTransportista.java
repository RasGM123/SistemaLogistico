/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo
 */

public interface PerfilTransportista {
    //CRUD Transportista
    public void actualizarInformacionCuenta();
    
    //Operaciones con Pedido
    public Pedido buscarPedido(int id);
    public void entregarPedido(Pedido pedido);
}
