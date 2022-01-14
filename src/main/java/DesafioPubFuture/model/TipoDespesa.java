package DesafioPubFuture.model;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.dao.TipoDespesaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDespesa {
    private Integer id;
    private String nome;
    private ArrayList<Despesa> despesa = new ArrayList<Despesa>();

    public TipoDespesa(){}

    public TipoDespesa(String nome){this.nome = nome;}

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

    public ArrayList<Despesa> getDespesa() {
        return despesa;
    }

    public void setDespesa(ArrayList<Despesa> despesa) {
        this.despesa = despesa;
    }

    public void cadastraTipoDespesa(TipoDespesa tipoDespesa)throws ExceptionDAO, SQLException {
        new TipoDespesaDAO().cadastraTipoDespesa(tipoDespesa);
    }
}
