/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.MB;

import br.barao.beer.entidade.Origem;
import br.barao.beer.fachada.OrigemFachada;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * @author Lucas
 */
@ManagedBean(name = "origemMB")
@SessionScoped
public class OrigemMB{

    private Origem origem;
    private ListDataModel origens;
    
    @EJB
    private OrigemFachada origemFachada;

    public OrigemMB(){
        origem = new Origem();
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public ListDataModel getOrigens() {
        return origens;
    }

    public String adicionar() {
        try {
            origemFachada.adicionar(this.getOrigem());
            this.recuperarOrigens();
            return "Certo";
        } catch (Exception e) {
            return "Erro";
        }
    }

    public String excluir() {
        origemFachada.excluir(this.getOrigem());
        this.recuperarOrigens();
        return "/mensagem/ListarMensagens";
    }
    
    public String listar(){
        this.recuperarOrigens();
        return "ok";
    }

    private void recuperarOrigem() {
        this.origem = (Origem) this.origens.getRowData();
    }

    private void recuperarOrigens() {
        this.origens = new ListDataModel(origemFachada.listar());
    }
    
    /*public String montarPaginaParaInsercaoOrigem(){
        this.origem = new Origem();
        return "/origem/InserirOrigem";   
    }*/
}
