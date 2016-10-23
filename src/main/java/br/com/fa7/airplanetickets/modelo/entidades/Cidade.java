package br.com.fa7.airplanetickets.modelo.entidades;

import br.com.fa7.airplanetickets.modelo.enumeracoes.Estado;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade extends BaseModel {

    private static final long serialVersionUID = 7970712038357421892L;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private Estado estado;

    public Cidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
