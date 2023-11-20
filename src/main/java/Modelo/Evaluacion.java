/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rodrigo
 */

@Entity
public class Evaluacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fecha;
    private int puntuacion;
    private String comentario;

    public Evaluacion() {
    }

    public Evaluacion(LocalDate fecha, int puntuacion, String comentario) {
        this.fecha = fecha;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", fecha=" + fecha + ", puntuacion=" + puntuacion + ", comentario=" + comentario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + this.puntuacion;
        hash = 23 * hash + Objects.hashCode(this.comentario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evaluacion other = (Evaluacion) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }
}
