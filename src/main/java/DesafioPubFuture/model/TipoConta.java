package DesafioPubFuture.model;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.dao.TipoContaDAO;

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

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public ArrayList<TipoConta> consultaTipoConta (String nome) throws ExceptionDAO,SQLException{
        return new TipoContaDAO().consultaTipoConta(nome);
    }
    
    public void alteraTipoConta(TipoConta tipoConta)throws ExceptionDAO, SQLException{
        new TipoContaDAO().alteraTipoConta(tipoConta);
    }
    
    public void deletaTipoConta(TipoConta tipoConta)throws ExceptionDAO, SQLException{
        new TipoContaDAO().deletaTipoConta(tipoConta);
    }
}
