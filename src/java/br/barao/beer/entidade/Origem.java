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
@Table(name = "origem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Origem.findAll", query = "SELECT o FROM Origem o"),
    @NamedQuery(name = "Origem.findByIdOrigem", query = "SELECT o FROM Origem o WHERE o.idOrigem = :idOrigem"),
    @NamedQuery(name = "Origem.findByCidade", query = "SELECT o FROM Origem o WHERE o.cidade = :cidade"),
    @NamedQuery(name = "Origem.findByRegiao", query = "SELECT o FROM Origem o WHERE o.regiao = :regiao"),
    @NamedQuery(name = "Origem.findByPais", query = "SELECT o FROM Origem o WHERE o.pais = :pais")})
public class Origem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_origem", nullable = true)
    @SequenceGenerator(name="Origem_Generator", sequenceName="sequence_origem", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Origem_Generator")
    private Integer idOrigem;
    @Column(name = "cidade", nullable = true, length = 255)
    private String cidade;
    @Column(name = "regiao", nullable = true, length = 255)
    private String regiao;
    @Column(name = "pais", nullable = true, length = 255)
    private String pais;

    public Origem() {
        
    }
    
    public Origem(Integer idOrigem) {
        this.idOrigem = idOrigem;
    }

    public Origem(Integer idOrigem,String cidade,String regiao,String pais){
        this.idOrigem = idOrigem;
        this.cidade = cidade;
        this.regiao = regiao;
        this.pais = pais;
    }
    
    public Integer getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Integer idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrigem != null ? idOrigem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Origem)) {
            return false;
        }
        Origem other = (Origem) object;
        if ((this.idOrigem == null && other.idOrigem != null) || (this.idOrigem != null && !this.idOrigem.equals(other.idOrigem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.barao.beer.entidade.Origem[ idOrigem=" + idOrigem + " ]";
    }
    
}
