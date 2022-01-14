package model;

import dao.ExceptionDAO;

import java.sql.SQLException;
import java.util.Date;

public class Despesa {
    private Integer id;
    private Double valor;
    private TipoDespesa tipoDespesa;
    private Conta conta;
    private String descricao;
    private Date dataPagamento;
    private Date dataPagamentoEsperado;

    public Despesa(){}

    public Despesa(Double valor, Integer idTipoDespesa, Integer idConta,
                   String descricao, Date dataPagamento, Date dataPagamentoEsperado){
        this.valor = valor;
        TipoDespesa tipoDespesa = new TipoDespesa();
        tipoDespesa.setId(idTipoDespesa);
        this.tipoDespesa = tipoDespesa;
        Conta conta = new Conta();
        conta.setId(idConta);
        this.conta = conta;
        this.descricao = descricao;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public void cadastraDespesa(Despesa despesa)
            throws ExceptionDAO, SQLException {
        new DespesaDAO().cadastraDespesa(despesa);
    }
}