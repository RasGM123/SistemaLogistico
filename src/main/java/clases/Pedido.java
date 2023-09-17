/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Pedido {

  private int id;
  private Date fechaCreacion;
  private String estado;
  private Ruta ruta;
  private Transportista transportista;
  private List<DocumentoTransporte> documentosTransporte; 
  private Inventario inventario;
  private CargaDescarga cargaDescarga;

  public void crearPedido() {

  }

  public void actualizarEstado() {

  }

  public void generarDocumentosTransporte() {

  }

  //Getters and setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  //etc

}
