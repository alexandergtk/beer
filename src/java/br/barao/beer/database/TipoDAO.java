/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.database;

import br.barao.beer.entidade.Tipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucas
 */
@Stateless
public class TipoDAO {

    @PersistenceContext
    private EntityManager em;

    public void adicionar(Tipo tipo) {
        try {
            em.merge(tipo);
            em.persist(tipo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void excluir(Tipo tipo) {
        Tipo tipoASerExcluido = em.merge(tipo);
        em.remove(tipoASerExcluido);
    }

    public List<Tipo> recuperarTodos() {
        return em.createQuery("SELECT ti FROM Tipo AS ti ORDER BY ti.idTipo").getResultList();
    }

    public Tipo recuperarPorId(Integer id) {
        return em.find(Tipo.class, id);
    }
}
