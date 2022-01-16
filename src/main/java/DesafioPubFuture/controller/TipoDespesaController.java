package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoDespesa;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDespesaController {

    public boolean cadastraTipoDespesa(String nome)throws ExceptionDAO, SQLException {
        if (nome!=null){
            TipoDespesa tipoDespesa = new TipoDespesa(nome);
            tipoDespesa.cadastraTipoDespesa(tipoDespesa);
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<TipoDespesa> consultaTipoDespesa(String nome)throws SQLException, ExceptionDAO {
            return new TipoDespesa().consultaTipoDespesa(nome);
    }
    
    public boolean alteraTipoDespesa(Integer id, String nome)throws SQLException, ExceptionDAO{
        if(nome!=null){
            TipoDespesa tipoDespesa = new TipoDespesa(nome);
            tipoDespesa.setId(id);
            tipoDespesa.alteraTipoDespesa(tipoDespesa);
            return true;
        }else{
            return false;}
    }
    
    public boolean deletaTipoDespesa(Integer id)throws SQLException, ExceptionDAO{
        if(id == 0 ){
            return false;
        }else{
            TipoDespesa tipoDespesa = new TipoDespesa();
            tipoDespesa.setId(id);
            tipoDespesa.deletaTipoDespesa(tipoDespesa);
            return true;
        }
    }
}
