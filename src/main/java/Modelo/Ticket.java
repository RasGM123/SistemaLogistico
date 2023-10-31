/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo
 */
public class Ticket {
    private int id;
    private String motivo;
    private String reclamo;
    private String respuesta;

    public Ticket(int id, String motivo, String reclamo) {
        this.id = id;
        this.motivo = motivo;
        this.reclamo = reclamo;
        this.respuesta = null;
    }
    
    //Funcionalidades
    
    public void responderTicket(String mensaje){
        this.respuesta = mensaje;
    }
    
    //Setters & getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
