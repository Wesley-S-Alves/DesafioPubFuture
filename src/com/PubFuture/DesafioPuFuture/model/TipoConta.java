package model;

import dao.ExceptionDAO;
import dao.TipoContaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoConta {

    private Integer Id;
    private String nome;
    private InstFinanceira instFinanceira;
    private ArrayList<Conta> conta = new ArrayList<Conta>();

    public TipoConta(){}

    public TipoConta(String nome, Integer idInstFinanceira){
        this.nome=  nome;
        InstFinanceira instFinanceira = new InstFinanceira();
        instFinanceira.setId(idInstFinanceira);
        this.instFinanceira = instFinanceira;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public InstFinanceira getInstFinanceira() {
        return instFinanceira;
    }

    public void setInstFinanceira(InstFinanceira instFinanceira) {
        this.instFinanceira = instFinanceira;
    }

    public ArrayList<Conta> getConta() {
        return conta;
    }

    public void setConta(ArrayList<Conta> conta) {
        this.conta = conta;
    }

    public void cadastraTipoConta(TipoConta tipoConta)throws ExceptionDAO, SQLException{
        new TipoContaDAO().cadastraTipoConta(tipoConta);
    }
}
