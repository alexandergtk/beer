/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.fachada;

import br.barao.beer.database.CorDAO;
import br.barao.beer.entidade.Cor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lucas
 */
@Stateless
public class CorFachada {

   @EJB
   private CorDAO corDAO;

   public void excluir(Cor cor) {
        corDAO.excluir(cor);
    }
       
    public void adicionar(Cor cor) {
        corDAO.adicionar(cor);
    }
       
    public List<Cor> listar() {
        return corDAO.recuperarTodos();
    }
}
