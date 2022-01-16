package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoReceita;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoReceitaController {

    public boolean cadastraTipoReceita(String nome)throws SQLException, ExceptionDAO{
        if(nome!=null){
            TipoReceita tipoReceita = new TipoReceita(nome);
            tipoReceita.cadastraTipoReceita(tipoReceita);
            return true;
        }else{
            return false;}
    }
    
    public ArrayList<TipoReceita> consultaTipoReceita(String nome) throws SQLException,ExceptionDAO {
        return new TipoReceita().consultaTipoReceita(nome);
    }
    
    public boolean alteraTipoReceita(Integer id, String nome)throws SQLException, ExceptionDAO{
        if(nome!=null){
            TipoReceita tipoReceita = new TipoReceita(nome);
            tipoReceita.setId(id);
            tipoReceita.alteraTipoReceita(tipoReceita);
            return true;
        }else{
            return false;}
    }
    
    public boolean deletaTipoReceita(Integer id)throws SQLException, ExceptionDAO{
        if(id == 0 ){
            return false;
        }else{
            TipoReceita tipoReceita = new TipoReceita();
            tipoReceita.setId(id);
            tipoReceita.deletaTipoReceita(tipoReceita);
            return true;
        }
    }
}
