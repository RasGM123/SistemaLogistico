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
            
            /*
            Ruta ruta1 = new Ruta("Aca", "Alla", LocalDate.now(), LocalDate.of(2023, 12, 10));
            gerente.crearRuta(ruta1);
            
            TipoProducto tipo1 = new TipoProducto("Lacteos");
            gerente.crearTipoProducto(tipo1);
            
            Producto producto1 = new Producto("Yogur", tipo1);
            gerente.crearProducto(producto1);
            
            List<RenglonPedido> renglones = new ArrayList(List.of(new RenglonPedido(1, producto1)));
            Pedido pedido1 = new Pedido(LocalDate.now(), ruta1, renglones);
            gerente.crearPedido(cliente1, pedido1);
            
            gerente.borrarPedido(cliente1, pedido1);
            */
            
            gerente.borrarUsuario(cliente1);
            
            gerente.crearUsuario(cliente1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
