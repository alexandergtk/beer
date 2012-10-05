/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.MB;

import br.barao.beer.entidade.Estilo;
import br.barao.beer.fachada.EstiloFachada;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * @author Lucas
 */
@ManagedBean(name = "estiloMB")
@SessionScoped
public class EstiloMB{

    private Estilo estilo;
    private ListDataModel estilos;
    
    @EJB
    private EstiloFachada estiloFachada;
    
    
    public EstiloMB(){
        estilo = new Estilo();
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public ListDataModel getEstilos() {
        return estilos;
    }

    public void setestilos(ListDataModel estilos) {
        this.estilos = estilos;
    }

    public String adicionar() {
        try {
            estiloFachada.adicionar(this.getEstilo());
            this.recuperarEstilos();
            return "/estilo/ListarEstilo";
        } catch (Exception e) {
            return "/estilo/InserirEstilo";
        }
    }

    public String excluir() {
        estiloFachada.excluir(this.getEstilo());
        this.recuperarEstilos();
        return "/mensagem/ListarMensagens";
    }

    private void recuperarEstilo() {
        this.estilo = (Estilo) this.estilos.getRowData();
    }

    private void recuperarEstilos() {
        this.estilos = new ListDataModel(estiloFachada.listar());
    }
    
    public String montarPaginaParaInsercaoEstilo(){
        this.estilo = new Estilo();
        return "/estilo/InserirEstilo";   
    }
}
