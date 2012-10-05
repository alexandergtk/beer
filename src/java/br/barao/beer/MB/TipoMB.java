/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.MB;

import br.barao.beer.entidade.Tipo;
import br.barao.beer.fachada.TipoFachada;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 * @author Lucas
 */
@ManagedBean(name = "tipoMB")
@SessionScoped
public class TipoMB{

    private Tipo tipo;
    private ListDataModel tipos;
    
    @EJB
    private TipoFachada tipoFachada;
    
    public TipoMB(){
        this.tipo = new Tipo();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void seTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ListDataModel getTipos() {
        return tipos;
    }

    public String adicionar() {
        try {
            tipoFachada.adicionar(this.getTipo());
            this.recuperarTipos();
            return "Informação inserida com sucesso";
        } catch (Exception e) {
            return "Error ao inserir!";
        }
    }

    public String excluir() {
        tipoFachada.excluir(this.getTipo());
        this.recuperarTipos();
        return "/mensagem/ListarMensagens";
    }
    
    public String listar(){
        this.recuperarTipos();
        return "Lista recuperada com sucesso";
    }

    /*private void recuperarTipo() {
        this.tipo = (Tipo) this.tipos.getRowData();
    }*/

    private void recuperarTipos() {
        this.tipos = new ListDataModel(tipoFachada.listar());
    }
}
