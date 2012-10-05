/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.fachada;

import br.barao.beer.database.EstiloDAO;
import br.barao.beer.entidade.Estilo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lucas
 */
@Stateless
public class EstiloFachada {

   @EJB
   private EstiloDAO estiloDAO;

   public void excluir(Estilo estilo) {
        estiloDAO.excluir(estilo);
    }
       
    public void adicionar(Estilo estilo) {
        estiloDAO.adicionar(estilo);
    }
       
    public List<Estilo> listar() {
        return estiloDAO.recuperarTodos();
    }
}
