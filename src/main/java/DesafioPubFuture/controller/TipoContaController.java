package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoConta;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoContaController {
    public boolean cadastraTipoConta(String nome, Integer idInstFinanceira)
        throws ExceptionDAO, SQLException {
        if(nome!=null && idInstFinanceira !=null){
            TipoConta tipoConta = new TipoConta(nome, idInstFinanceira);
            tipoConta.cadastraTipoConta(tipoConta);
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<TipoConta> consultaTipoConta(String nome)
            throws SQLException, ExceptionDAO{
        return new TipoConta().consultaTipoConta(nome);
    }
    
    public boolean alteraTipoConta(Integer id, String nome, Integer idInstFinanceira)
        throws SQLException, ExceptionDAO {
        if(nome!= null){
            TipoConta tipoConta = new TipoConta(nome, idInstFinanceira);
            tipoConta.setId(id);
            tipoConta.alteraTipoConta(tipoConta);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deletaTipoConta(Integer id)throws SQLException, ExceptionDAO{
        if(id==0){
            return false;
        }else{
            TipoConta tipoConta = new TipoConta();
            tipoConta.setId(id);
            tipoConta.deletaTipoConta(tipoConta);
            return true;
        }
    }
}
