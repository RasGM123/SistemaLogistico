package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
            
            //Se inicia sesion con un Usuario Gerente
            sistema.iniciarSesion("gerente", "gerente");
            Gerente gerente = (Gerente) sistema.obtenerSesion();
            
            //String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion
            Cliente cliente1 = new Cliente("pablo", "pablo", "pablo@hotmail.com", "Pablo", "Gomez", "3", "9", "Casa");
            gerente.crearUsuarioCliente(cliente1);
            
            TipoProducto tipoProducto1 = new TipoProducto("Comida");
            gerente.crearTipoProducto(tipoProducto1);
            
            Producto producto1 = new Producto("Pancho", tipoProducto1);
            gerente.crearProducto(producto1);
            
            Ruta ruta1 = new Ruta("Aca", "Alla", LocalDate.now(), LocalDate.of(2024, 12, 30));
            gerente.crearRuta(ruta1);
            
            List<RenglonPedido> renglones1 = List.of(new RenglonPedido(2, producto1));
            Pedido pedido1 = new Pedido(LocalDate.now(), ruta1, renglones1);
            gerente.crearPedido(cliente1, pedido1);
            
            //String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion
            Transportista transportista1 = new Transportista("3", "ejemplo", "ejemplo", "ejemplo@ejemplo.com", "Martin", "Carloto", "32", "990", "direccion");
            
            transportista1.setNombres("POWER RANGER");
            transportista1.actualizarInformacionCuenta();
            
            transportista1.entregarPedido(pedido1);
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
