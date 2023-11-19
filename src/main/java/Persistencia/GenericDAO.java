/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 * @param <T>
 */

public abstract class GenericDAO <T> {
    private Class<T> clase;

    public GenericDAO(Class<T> tipo) {
        this.clase = tipo;
    }

    public void crear(Object entidad) {
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em != null){
                em.getTransaction().rollback();
            }
            
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public T buscarPorId(long id){
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            
            return em.find(clase, id);
        } catch (Exception e) {
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public List<T> listar(){
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            
            return em.createQuery("FROM "+clase.getSimpleName()+" T").getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public void editar(Object entidad) {
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em != null){
                em.getTransaction().rollback();
            }
            
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public void borrar(int id) {
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            
            T entidad = em.getReference(clase, id);
            
            em.remove(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em != null){
                em.getTransaction().rollback();
            }
            
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
            
    private EntityManager getEntityManager(){
        return ConexionDB.getEntityManagerFactory().createEntityManager();
    }
}
