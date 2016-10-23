package br.com.fa7.airplanetickets.modelo.entidades;

import br.com.fa7.airplanetickets.modelo.enumeracoes.RelactionamentoContatoEmergencia;
import br.com.fa7.airplanetickets.modelo.enumeracoes.TipoDocumento;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "passageiro")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Passageiro extends Pessoa {

    private static final long serialVersionUID = 6882115490287337078L;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    @Basic(optional = false)
    protected Date dataNascimento;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "tipoDocumento")
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento")
    @Basic(optional = false)
    private String documento;

    @Column(name = "nomeContatoEmergencia")
    @Basic(optional = false)
    private String nomeContatoEmergencia;

    @Column(name = "relactionamentoContatoEmergencia")
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private RelactionamentoContatoEmergencia relactionamentoContatoEmergencia;

    public Passageiro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeContatoEmergencia() {
        return nomeContatoEmergencia;
    }

    public void setNomeContatoEmergencia(String nomeContatoEmergencia) {
        this.nomeContatoEmergencia = nomeContatoEmergencia;
    }

    public RelactionamentoContatoEmergencia getRelactionamentoContatoEmergencia() {
        return relactionamentoContatoEmergencia;
    }

    public void setRelactionamentoContatoEmergencia(RelactionamentoContatoEmergencia relactionamentoContatoEmergencia) {
        this.relactionamentoContatoEmergencia = relactionamentoContatoEmergencia;
    }

}