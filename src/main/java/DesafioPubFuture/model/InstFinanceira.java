package DesafioPubFuture.model;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.dao.InstFinanceiraDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstFinanceira {
    private Integer id;
    private String nome;
    private ArrayList<TipoConta> tipoConta = new ArrayList<TipoConta>();

    public InstFinanceira(){}

    public InstFinanceira(String nome){this.nome = nome;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<TipoConta> getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(ArrayList<TipoConta> tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void cadastraInstFinanceira(InstFinanceira instFinanceira)
            throws ExceptionDAO, SQLException{
        new InstFinanceiraDAO().cadastraInstFinanceira(instFinanceira);
    }
    
    public ArrayList<InstFinanceira> consultaInstFinanceira(String nome) throws ExceptionDAO, SQLException {
        return new InstFinanceiraDAO().consultaInstFinanceira(nome);
    }
    
    public void alteraInstFinanceira(InstFinanceira instFinanceira) throws ExceptionDAO,SQLException{
        new InstFinanceiraDAO().alteraInstFinanceira(instFinanceira);
    }
    
    public void deletaInstFinanceira (InstFinanceira instFinanceira)throws ExceptionDAO, SQLException{
        new InstFinanceiraDAO().deletaInstFinanceira(instFinanceira);
    }
}
