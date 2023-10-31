/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Rodrigo
 */
public class Transportista extends Empleado{
    private Vehiculo vehiculo;

    public Transportista(String cuil, int id, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, id, username, password, email, nombres, apellidos, dni, telefono, direccion);
        this.vehiculo = null;
    }
    
    //setters & getters

    public Vehiculo consultarVehiculo() {
        return vehiculo;
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
