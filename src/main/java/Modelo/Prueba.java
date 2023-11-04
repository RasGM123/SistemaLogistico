package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Prueba {
    public static void main(String[] args){
        try {
            //Se inicia el sistema
            Sistema sistema = Sistema.iniciar();
            
            Cliente cliente1 = new Cliente("carlos", "carlos", "carlos@gmail.com", "Horacio", "Marquez", "40999111", "5666111999", "casa");
            
            //Se crea un Usuario Cliente
            sistema.crearUsuario(cliente1);
            
            //Se inicia sesion con un Usuario Gerente
            sistema.iniciarSesion("gerente", "gerente");
            Gerente gerente1 = (Gerente) sistema.obtenerSesion();
            
            //Se crea 1 nuevo TipoProducto
            TipoProducto tipo1 = new TipoProducto("Limpieza");
            gerente1.crearTipoDeProducto(tipo1);
            
            //Se crea 1 nuevo Producto
            Producto producto1 = new Producto("Lavandina Ayudin 500ml", tipo1);
            gerente1.crearProducto(producto1);
            
            //Se crae 1 nuevo RenglonPedido
            RenglonPedido reglon1 = new RenglonPedido(4, producto1);
            List<RenglonPedido> renglones = new ArrayList();
            renglones.add(reglon1);
            
            //Se crea 1 nueva Ruta
            Ruta ruta1 = new Ruta("Almacen", "Casa", LocalDateTime.now(), LocalDateTime.of(2023, 11, 10, 10, 00));
            gerente1.crearRuta(ruta1);
            
            Pedido pedido1 = new Pedido(LocalDateTime.now(), ruta1, renglones);
            
            gerente1.crearPedido(cliente1, pedido1);
            
            //gerente1.crearPedido(cliente1, pedido);
            
            System.out.println("Cantida de pedidos = "+gerente1.listarPedidosCliente(cliente1).size());
            System.out.println(gerente1.listarPedidosCliente(cliente1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
