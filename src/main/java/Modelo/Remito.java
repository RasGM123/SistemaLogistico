/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Gustavo
 */
class Remito {
    private LocalDateTime fechaCreacionPedido;
    private LocalDateTime fechaEntrega;
    private List<RenglonPedido> renglones;

    public Remito(LocalDateTime fechaCreacionPedido, LocalDateTime fechaEntrega, List<RenglonPedido> renglones) {
        this.fechaCreacionPedido = fechaCreacionPedido;
        this.fechaEntrega = fechaEntrega;
        this.renglones = renglones;
    }
    
    //setters & getters

    public LocalDateTime getFechaCreacionPedido() {
        return fechaCreacionPedido;
    }

    public void setFechaCreacionPedido(LocalDateTime fechaCreacionPedido) {
        this.fechaCreacionPedido = fechaCreacionPedido;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<RenglonPedido> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonPedido> renglones) {
        this.renglones = renglones;
    }
}
