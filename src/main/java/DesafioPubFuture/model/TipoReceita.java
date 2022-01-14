package DesafioPubFuture.model;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.dao.TipoReceitaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoReceita {
    private Integer id;
    private String nome;
    private ArrayList<Receita> receita = new ArrayList<Receita>();

    public TipoReceita(){}

    public TipoReceita(String nome){this.nome = nome;}

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

    public ArrayList<Receita> getReceita() {
        return receita;
    }

    public void setReceita(ArrayList<Receita> receita) {
        this.receita = receita;
    }

    public void cadastraTipoReceita(TipoReceita tipoReceita)throws ExceptionDAO, SQLException{
        new TipoReceitaDAO().cadastraTipoReceita(tipoReceita);
    }
}
