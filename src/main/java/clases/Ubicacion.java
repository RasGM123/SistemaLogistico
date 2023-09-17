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
public class Ubicacion {

  private int id;
  private String nombre;
  private List<Producto> productos;
  
  public void agregarProducto() {

  }

  public void eliminarProducto() {  

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

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos; 
  }

}
