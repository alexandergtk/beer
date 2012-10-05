/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.database;

import br.barao.beer.entidade.Estilo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucas
 */
@Stateless
public class EstiloDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    //@Override
    public void adicionar(Estilo estilo) {
     try{
        em.merge(estilo);
        em.persist(estilo);
     }catch(Exception e){
         e.getMessage();
     }    
    }   
    
    public void excluir(Estilo estilo){
        Estilo estiloASerExcluido = em.merge(estilo);
        em.remove(estiloASerExcluido);
    }
    
    public List<Estilo> recuperarTodos() {
        return em.createQuery("from Estilo").getResultList();
    }
}
