/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gustavo
 */
public class ConexionDB {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_postgresql");
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
