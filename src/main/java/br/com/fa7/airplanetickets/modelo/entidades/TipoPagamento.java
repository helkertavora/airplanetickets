package br.com.fa7.airplanetickets.modelo.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento extends BaseModel {

    private static final long serialVersionUID = -8484901536236342916L;

    @Column(name = "descricao")
    @Basic(optional = false)
    private String descricao;

    public TipoPagamento() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
