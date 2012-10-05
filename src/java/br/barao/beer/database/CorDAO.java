/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.database;

import br.barao.beer.entidade.Cor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucas
 */
@Stateless
public class CorDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    //@Override
    public void adicionar(Cor cor) {
     try{
        em.merge(cor);
        em.persist(cor);
     }catch(Exception e){
         e.getMessage();
     }    
    }   
    
    public void excluir(Cor cor){
        Cor corASerExcluido = em.merge(cor);
        em.remove(corASerExcluido);
    }
    
    public List<Cor> recuperarTodos() {
        return em.createQuery("from Cor").getResultList();
    }
}
