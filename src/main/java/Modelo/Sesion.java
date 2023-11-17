/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Gustavo
 */
public class Sesion {
    private Usuario usuario;
    private LocalDateTime ocurrencia;

    public Sesion(Usuario usuario, LocalDateTime ocurrencia) {
        this.usuario = usuario;
        this.ocurrencia = ocurrencia;
    }
    
    //Funcionalidades
    
    public void cerrar(){
        this.usuario = null;
    }
    
    //Getters

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getOcurrencia() {
        return ocurrencia;
    }
}
