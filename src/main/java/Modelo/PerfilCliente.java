/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface PerfilCliente {
    
    public List<Pedido> listarPedidos();
    public List<Pedido> listarPedidos(LocalDate inicio, LocalDate fin) throws Exception;
    public Pedido buscarPedido(int idPedido);
    public String consultarEstado(Pedido pedido);
    public List<Movimiento> listarMovimientos(Pedido pedido);
}
