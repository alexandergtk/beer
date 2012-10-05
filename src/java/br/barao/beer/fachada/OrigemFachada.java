/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.fachada;

import br.barao.beer.database.OrigemDAO;
import br.barao.beer.entidade.Origem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lucas
 */
@Stateless
public class OrigemFachada {

   @EJB
   private OrigemDAO origemDAO;

   public void excluir(Origem origem) {
        origemDAO.excluir(origem);
    }
       
    public void adicionar(Origem origem) {
        origemDAO.adicionar(origem);
    }
       
    public List<Origem> listar() {
        return origemDAO.recuperarTodos();
    }
}
