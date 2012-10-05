/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexander
 *
@Stateless
public class UsuarioDAO {
    
    @PersistenceContext
    private EntityManager em;
    
        public void adicionar(Usuario usuario) {
        try {
            em.merge(usuario);
            em.persist(usuario);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void excluir(Usuario usuario) {
        Usuario usuarioASerExcluido = em.merge(usuario);
        em.remove(usuarioASerExcluido);
    }

    public List<Usuario> recuperarTodos() {
        return em.createQuery("SELECT us FROM Usuario AS us ORDER BY ti.idUsuario").getResultList();
    }

    public Usuario recuperarPorId(Integer id) {
        return em.find(Usuario.class, id);
    }
}

    
}*/
