/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Contrato;
import Modelo.Evaluacion;
import Modelo.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class ProveedorDAO extends GenericDAO <Proveedor> {
    
    public ProveedorDAO() {
        super(Proveedor.class);
    }
    
    public List<Evaluacion> listarEvaluaciones(int idProveedor){
        EntityManager em = null;
        
        try {
            em = super.getEntityManager();
            
            if(em.createQuery("FROM proveedor_evaluacion PE").getResultList().isEmpty()){
                System.out.println("NO EXISTE LA TABLA PROVEEDOR_EVALUACION");
            }else{
                System.out.println("EXISTE LA TABLA PROVEEDOR_EVALUACION");
            }
            
            /*
            Query query = em.createQuery("FROM Evaluacion E INNER JOIN "
                                        + "(FROM proveedor_evaluacion P_E WHERE P_E.proveedor_id = :idProveedor) P_E "
                                        + "ON E.id = P_E.evaluaciones_id");
            query.setParameter("idProveedor", idProveedor);
            
            return query.getResultList();
            */
            
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public List<Contrato> listarContratos(){
        EntityManager em = null;
        
        try {
            em = super.getEntityManager();
            Query query = em.createQuery("");
            
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
