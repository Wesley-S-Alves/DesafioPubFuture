package DesafioPubFuture.model;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.dao.ReceitaDAO;

import java.sql.SQLException;
import java.util.Date;

public class Receita {
    private Integer id;
    private double valor;
    private TipoReceita tipoReceita;
    private Conta conta;
    private String descricao;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;

    public Receita(){}

    public Receita(double valor, Integer idTipoReceita, Integer idConta,
                   String descricao, Date dataRecebimento, Date dataRecebimentoEsperado){
        this.valor = valor;
        TipoReceita tipoReceita = new TipoReceita();
        tipoReceita.setId(idTipoReceita);
        this.tipoReceita = tipoReceita;
        Conta conta = new Conta();
        conta.setId(idConta);
        this.descricao = descricao;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public void cadastraReceita(Receita receita)throws ExceptionDAO, SQLException{
        new ReceitaDAO().cadastraReceita(receita);
    }
}
