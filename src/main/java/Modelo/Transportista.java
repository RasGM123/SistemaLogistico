/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Rodrigo
 */

@Entity
public class Transportista extends Empleado{
    @OneToOne
    private Vehiculo vehiculoAsignado;

    public Transportista() {
    }

    public Transportista(String cuil, String username, String password, String email, String nombres, String apellidos, String dni, String telefono, String direccion) {
        super(cuil, username, password, email, nombres, apellidos, dni, telefono, direccion);
        
        this.vehiculoAsignado = null;
    }
    
    //Setters

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }
    
    //Getters

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }
}
