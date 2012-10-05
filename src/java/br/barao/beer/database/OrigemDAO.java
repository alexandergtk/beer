/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.database;

import br.barao.beer.entidade.Origem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucas
 */
@Stateless
public class OrigemDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    //@Override
    public void adicionar(Origem origem) {
     try{
        em.merge(origem);
        em.persist(origem);
     }catch(Exception e){
         e.getMessage();
     }    
    }   
    
    public void excluir(Origem origem){
        Origem origemASerExcluido = em.merge(origem);
        em.remove(origemASerExcluido);
    }
    
    public List<Origem> recuperarTodos() {
        return em.createQuery("from Origem").getResultList();
    }
}
