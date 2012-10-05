/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.MB;

import br.barao.beer.entidade.Cor;
import br.barao.beer.fachada.CorFachada;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * @author Lucas
 */
@ManagedBean(name = "corMB")
@SessionScoped
public class CorMB{

    private Cor cor;
    private ListDataModel cores;
    
    @EJB
    private CorFachada corFachada;
    
    
    public CorMB(){
        cor = new Cor();
    }

    public Cor getCor() {
        return cor;
    }

    public void setEstilo(Cor cor) {
        this.cor = cor;
    }

    public ListDataModel getCores() {
        return cores;
    }

    public void setcores(ListDataModel cores) {
        this.cores = cores;
    }

    public String adicionar() {
        try {
            corFachada.adicionar(this.getCor());
            this.recuperarCores();
            return "/cor/ListarCor";
        } catch (Exception e) {
            return "/cor/InserirCor";
        }
    }

    public String excluir() {
        corFachada.excluir(this.getCor());
        this.recuperarCores();
        return "/mensagem/ListarMensagens";
    }

    private void recuperarCor() {
        this.cor = (Cor) this.cores.getRowData();
    }

    private void recuperarCores() {
        this.cores = new ListDataModel(corFachada.listar());
    }
    
    public String montarPaginaParaInsercaoCor(){
        this.cor = new Cor();
        return "/cor/InserirCor";   
    }
}
