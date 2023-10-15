/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Rodrigo
 */
public class Evaluacion {

  private int id;
  private LocalDateTime fecha;
  private int puntuacion;
  private String comentario;
  
  private Proveedor proveedor;

    public Evaluacion(int id, int puntuacion, String comentario, Proveedor proveedor) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.proveedor = proveedor;
    }

  //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
