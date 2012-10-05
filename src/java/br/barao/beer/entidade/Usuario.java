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
 * @author Alexander
 *
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT us FROM Usuario us"),
    @NamedQuery(name = "Tipo.findByIdUsuario", query = "SELECT us FROM Tipo us WHERE us.idUsuario = :idUsuario"),
    @NamedQuery(name = "Tipo.findByNome", query = "SELECT us FROM Usuario us WHERE us.nome = :nome")})

public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo", nullable = true)
    @SequenceGenerator(name="Tipo_Generator", sequenceName="sequence_tipo", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Tipo_Generator")
    private Integer idTipo;
    
    @Column(name = "nome", nullable = true, length = 255)
    private String nome;


    public Usuario() {}

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }*/