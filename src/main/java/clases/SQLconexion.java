/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Rodrigo
 */
public class SQLconexion {
    private String url;
    private String usuario;
    private String contrasena;
    
    public void SQLconexion(){
        this.contrasena = "*";
        this.url = "*";
        this.usuario = "*";
    }
    
    public String getUrl(){
        return url;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
}
