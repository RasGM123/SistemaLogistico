/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface PerfilCliente {
    
    public List<Pedido> listarPedidos();
    
    public Pedido buscarPedido(int idPedido);
}
