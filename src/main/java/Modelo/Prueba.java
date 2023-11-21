package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
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
            
            //String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion
            Cliente cliente1 = new Cliente("pablo", "pablo", "pablo@hotmail.com", "Pablo", "Gomez", "3", "9", "Casa");
            //String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion
            Administrativo administrativo1 = new Administrativo("3", "jorge", "jorge", "jorge@gmail.com", "Jorge", "Pinochet", "2", "9", "Lejos");
            Gerente gerente2 = new Gerente("8", "marcos", "marcos", "marcos100@gmail.com", "Marcos", "Polo", "1", "33", "Muy lejos");
            
            
            gerente1.crearUsuario(cliente1);
            gerente1.crearUsuario(administrativo1);
            gerente1.crearUsuario(gerente2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
