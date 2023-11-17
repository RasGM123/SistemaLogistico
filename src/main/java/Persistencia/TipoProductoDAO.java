/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.TipoProducto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class TipoProductoDAO {
    
    public void crear(TipoProducto tipoProducto) throws Exception{
        EntityManager em = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoProducto);
            em.getTransaction().commit();
        }catch (Exception e){
            if(em != null){
                em.getTransaction().rollback();
            }
            
            throw e;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public TipoProducto buscar(String nombre) throws Exception{
        EntityManager em = null;
        TipoProducto tipoProducto = null;
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("FROM TipoProducto TP WHERE TP.nombre = :nombreTipoProducto");
            query.setParameter("nombreTipoProducto", nombre);
            tipoProducto = (TipoProducto) query.getSingleResult();
        }catch (Exception e){
            if(em != null){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            if(em != null){
                em.close();
            }
        }
        
        return tipoProducto;
    }
    
    public List<TipoProducto> listar() throws Exception{
        EntityManager em = null;
        List<TipoProducto> lista = new ArrayList();
        
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("FROM TipoProducto TP");
            
            lista = query.getResultList();
        }catch (Exception e){
            if(em != null){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            if(em != null){
                em.close();
            }
        }
        
        return lista;
    }
    
    public void editar(TipoProducto tipoProducto){
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(tipoProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em != null){
                em.getTransaction().rollback();
            }
            
            throw e;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void borrar(TipoProducto tipoProducto){
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoProducto tp = em.getReference(TipoProducto.class, tipoProducto.getId());
            em.remove(tp);
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
