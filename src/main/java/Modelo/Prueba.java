package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
            Gerente gerente1 = (Gerente) sistema.obtenerSesion();
            
            TipoProducto tipo1 = new TipoProducto("Limpieza");
            TipoProducto tipo2 = new TipoProducto("Indumentaria");
            
            gerente1.crearTipoProducto(tipo1);
            gerente1.crearTipoProducto(tipo2);
            
            System.out.println(gerente1.listarTipoProducto());
            
            gerente1.editarTipoProducto(tipo1, "Alimentos");
            
            System.out.println(gerente1.listarTipoProducto());
            
            gerente1.borrarTipoProducto(tipo2);
            
            System.out.println(gerente1.listarTipoProducto());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
