/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gustavo
 */

class Remito {
    private int id;
    private LocalDate fechaCreacionPedido;
    private LocalDate fechaEntrega;
    private List<RenglonPedido> renglones;

    public Remito() {
    }

    public Remito(int id, LocalDate fechaCreacionPedido, LocalDate fechaEntrega, List<RenglonPedido> renglones) {
        this.id = id;
        this.fechaCreacionPedido = fechaCreacionPedido;
        this.fechaEntrega = fechaEntrega;
        this.renglones = renglones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.fechaCreacionPedido);
        hash = 37 * hash + Objects.hashCode(this.fechaEntrega);
        hash = 37 * hash + Objects.hashCode(this.renglones);
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
        final Remito other = (Remito) obj;
        return this.id == other.id;
    }
    
    //Setters
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFechaCreacionPedido(LocalDate fechaCreacionPedido) {
        this.fechaCreacionPedido = fechaCreacionPedido;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setRenglones(List<RenglonPedido> renglones) {
        this.renglones = renglones;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public LocalDate getFechaCreacionPedido() {
        return fechaCreacionPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public List<RenglonPedido> getRenglones() {
        return renglones;
    }
}
