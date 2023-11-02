/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Rodrigo
 */

public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String dominio;
    private int capacidadCarga;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String dominio, int capacidadCarga) {
        this.marca = marca;
        this.modelo = modelo;
        this.dominio = dominio;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dominio);
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
        final Vehiculo other = (Vehiculo) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }
}