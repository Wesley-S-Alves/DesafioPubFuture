package model;
import dao.ContaDAO;
import dao.ExceptionDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Conta {

    private Integer id;
    private double saldo;
    private String nome;
    private TipoConta tipoConta;
    private ArrayList<Despesa> despesa = new ArrayList<Despesa>();
    private ArrayList<Receita> receita = new ArrayList<Receita>();

    public Conta(){}

    public Conta(double saldo, String nome, Integer idTipoConta){
        this.saldo = saldo;
        this.nome = nome;
        TipoConta tipoConta = new TipoConta();
        tipoConta.setId(idTipoConta);
        this.tipoConta = tipoConta;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public ArrayList<Despesa> getDespesa() {
        return despesa;
    }

    public void setDespesa(ArrayList<Despesa> despesa) {
        this.despesa = despesa;
    }

    public ArrayList<Receita> getReceita() {
        return receita;
    }

    public void setReceita(ArrayList<Receita> receita) {
        this.receita = receita;
    }

    public void cadastraConta(Conta conta)throws  SQLException, ExceptionDAO{
        new ContaDAO().cadastraConta(conta);
    }
}

