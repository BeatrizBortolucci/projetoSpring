package com.example.pratica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Transacao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String descricao;
        private double valor;
        private Date dataTransacao;
        private String tipoTransacao;

    public Transacao(int id, String descricao, double valor, Date dataTransacao, String tipoTransacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public Transacao(String descricao, double valor, Date dataTransacao, String tipoTransacao) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

        public Transacao() {

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_transacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", dataTransacao=" + dataTransacao +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                '}';
    }
}