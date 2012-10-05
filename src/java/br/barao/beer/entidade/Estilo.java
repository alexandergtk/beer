/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.barao.beer.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "estilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilo.findAll", query = "SELECT e FROM Estilo e"),
    @NamedQuery(name = "Estilo.findByIdEstilo", query = "SELECT e FROM Estilo e WHERE e.idEstilo = :idEstilo"),
    @NamedQuery(name = "Estilo.findByDescricao", query = "SELECT e FROM Estilo e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Estilo.findByTeor", query = "SELECT e FROM Estilo e WHERE e.teor = :teor")})
    //@NamedQuery(name = "Estilo.findByPais", query = "SELECT e FROM Estilo e WHERE e.pais = :pais")})
public class Estilo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estilo", nullable = true)
    @SequenceGenerator(name="Estilo_Generator", sequenceName="sequence_estilo", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Estilo_Generator")
    private Integer idEstilo;
    @Column(name = "descricao", nullable = true, length = 255)
    private String descricao;
    @Column(name = "teor", nullable = true, length = 255)
    private String teor;
    
    public Estilo() {
        
    }
    
    public Estilo(Integer idEstilo) {
        this.idEstilo = idEstilo;
    }

    public Estilo(Integer idEstilo,String descricao,String teor){
        this.idEstilo = idEstilo;
        this.descricao = descricao;
        this.teor = teor;
    }
    
    public Integer getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(Integer idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getTeor() {
        return teor;
    }

    public void setTeor(String teor) {
        this.teor = teor;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstilo != null ? idEstilo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Estilo)) {
            return false;
        }
        Estilo other = (Estilo) object;
        if ((this.idEstilo == null && other.idEstilo != null) || (this.idEstilo != null && !this.idEstilo.equals(other.idEstilo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.barao.beer.entidade.Estilo[ idEstilo=" + idEstilo + " ]";
    }
    
}
