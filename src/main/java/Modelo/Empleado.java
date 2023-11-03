/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo
 */
public abstract class Empleado extends Usuario{
    private String cuil;

    public Empleado() {
    }

    public Empleado(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(username, password, email, nombres, apellidos, dni, telefono, direccion);
        this.cuil = cuil;
    }
    
    //Funcionalidades
    public void editarDatosPersonales(String cuil, String nombres, String apellidos, String dni, String telefono, String direccion){
        super.editarDatosPersonales(nombres, apellidos, dni, telefono, direccion);
        
        this.setCuil(cuil);
    }
    
    //Setters
    
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    //Getters

    public String getCuil() {
        return cuil;
    }
}
