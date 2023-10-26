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
            
            Usuario miUsuario = new Transportista("1122200", 4, "rodrigo", "rodrigo", "correo@correo.com", "rodrigo", "rodrigo", "222", "222", "222");
                   
            sistema.crearUsuario(miUsuario);
            
            codigo = sistema.obtenerCodigoUsuario(miUsuario);
            
            System.out.print("Codigo = "+codigo);
            
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
