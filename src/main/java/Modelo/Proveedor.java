/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Rodrigo
 */

@Entity
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cuit;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    @OneToMany
    private List<Contrato> contratos;
    @OneToMany
    private List<Evaluacion> evaluaciones;

    public Proveedor() {
    }

    public Proveedor(String cuit, String nombre, String email, String telefono, String direccion) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contratos = new ArrayList();
        this.evaluaciones = new ArrayList();
    }
    
    
    
    //Funcionalidades
    
    public void agregarContrato(Contrato contrato){
        contratos.add(contrato);
    }
    
    public void agregarEvaluacion(Evaluacion evaluacion){
        evaluaciones.add(evaluacion);
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", cuit=" + cuit + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.cuit);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.telefono);
        hash = 23 * hash + Objects.hashCode(this.direccion);
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
        final Proveedor other = (Proveedor) obj;
        return this.id == other.id;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getCuit() {
        return cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
}
