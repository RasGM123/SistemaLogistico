/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Prueba {
    public static void main(String[] args){
        try {
            Sistema sistema = Sistema.iniciar();
            
            int codigo;
            
            Usuario miUsuario = new Transportista("32", "ras", "123", "ras@gmail.com", "ras", "ras", "123456", "123456", "calle 888");
                   
            sistema.crearUsuario(miUsuario);
            
            codigo = sistema.obtenerCodigoUsuario(miUsuario);
            
            System.out.print("Codigo = "+codigo);
            
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
