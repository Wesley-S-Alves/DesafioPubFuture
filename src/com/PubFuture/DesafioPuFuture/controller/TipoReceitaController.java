package controller;

import dao.ExceptionDAO;
import model.TipoReceita;

import java.sql.SQLException;

public class TipoReceitaController (TipoReceita tipoReceita){

    public boolean cadastraTipoReceita(String nome)throws SQLException, ExceptionDAO{
        if(nome!=null){
            TipoReceita tipoReceita = new TipoReceita(nome);
            tipoReceita.cadastraTipoReceita(tipoReceita);
            return true;
        }else{
            return false;}
    }
}
