/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Gustavo
 */
public class Ticket {
    private int id;
    private String motivo;
    private String reclamo;
    private String respuesta;

    public Ticket() {
    }

    public Ticket(String motivo, String reclamo) {
        this.motivo = motivo;
        this.reclamo = reclamo;
        this.respuesta = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.motivo);
        hash = 67 * hash + Objects.hashCode(this.reclamo);
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
        final Ticket other = (Ticket) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getReclamo() {
        return reclamo;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
