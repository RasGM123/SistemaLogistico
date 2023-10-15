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

    public Empleado(String cuil, int id, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(id, username, password, email, nombres, apellidos, dni, telefono, direccion);
        this.cuil = cuil;
    }
    
    //Funcionalidades
    public void editarDatosPersonales(String cuil, String nombres, String apellidos, String dni, String telefono, String direccion){
        super.editarDatosPersonales(nombres, apellidos, dni, telefono, direccion);
        
        this.setCuil(cuil);
    }
    
    //setters & getters

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
}
