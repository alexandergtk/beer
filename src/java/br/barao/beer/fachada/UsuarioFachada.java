/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.fachada;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import java.util.List;

/**
 *
 * @author Alexander
 *
@Stateless
public class UsuarioFachada {
    
    @EJB
    private Usuario usuarioDAO;
    
    
    public void excluir(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }
    
    public void adicionar(Usuario usuario) {
        usuarioDAO.adicionar(usuario);
    }
    
    public List<Usuario> listar() {
        return usuarioDAO.recuperarTodos();
    }
    
}*/
