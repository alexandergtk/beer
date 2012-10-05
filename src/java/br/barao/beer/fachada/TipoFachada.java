/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.fachada;

import br.barao.beer.database.TipoDAO;
import br.barao.beer.entidade.Tipo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lucas
 */
@Stateless
public class TipoFachada {

    @EJB
    private TipoDAO tipoDAO;

    /**
     * @param tipo 
     * Metodos Adicionar, Excluir, Listar 
     * (Falta o alterar)
     */
    public void excluir(Tipo tipo) {
        tipoDAO.excluir(tipo);
    }

    public void adicionar(Tipo tipo) {
        tipoDAO.adicionar(tipo);
    }

    public List<Tipo> listar() {
        return tipoDAO.recuperarTodos();
    }
}
