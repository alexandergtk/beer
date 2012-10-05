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
@Table(name = "cor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cor.findAll", query = "SELECT c FROM Cor c"),
    @NamedQuery(name = "Cor.findByIdCor", query = "SELECT c FROM Cor c WHERE c.idCor = :idCor"),
    @NamedQuery(name = "Cor.findByDescricao", query = "SELECT c FROM Cor c WHERE c.descricao = :descricao")})
    //@NamedQuery(name = "Cor.findByPais", query = "SELECT e FROM Estilo e WHERE e.pais = :pais")})
public class Cor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cor", nullable = true)
    @SequenceGenerator(name="Cor_Generator", sequenceName="sequence_cor", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Cor_Generator")
    private Integer idCor;
    @Column(name = "descricao", nullable = true, length = 255)
    private String descricao;
    
    public Cor() {
        
    }
    
    public Cor(Integer idCor) {
        this.idCor = idCor;
    }

    public Cor(Integer idCor,String descricao){
        this.idCor = idCor;
        this.descricao = descricao;
    }
    
    public Integer getIdCor() {
        return idCor;
    }

    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCor != null ? idCor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cor)) {
            return false;
        }
        Cor other = (Cor) object;
        if ((this.idCor == null && other.idCor != null) || (this.idCor != null && !this.idCor.equals(other.idCor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.barao.beer.entidade.Cor[ idCor=" + idCor + " ]";
    }
    
}
