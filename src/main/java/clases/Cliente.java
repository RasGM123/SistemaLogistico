/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Cliente {

  private int id;
  private String nombre;
  private String contacto;
  private List<Pedido> historialPedidos;
  private List<String> preferencias;

  public void registrarCliente() {

  }

  public void consultarPedidos() {

  }

  public void actualizarPreferencias() {

  }

  //Getters and setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id; 
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  //etc...

}
