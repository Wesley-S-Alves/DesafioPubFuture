package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.InstFinanceira;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstFinanceiraController {
    public boolean cadastraInstFinanceira(String nome)throws ExceptionDAO, SQLException{
        if(nome!=null){
            InstFinanceira instFinanceira = new InstFinanceira(nome);
            instFinanceira.cadastraInstFinanceira(instFinanceira);
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<InstFinanceira> consultaInstFinanceira(String nome) throws SQLException, ExceptionDAO{
        return new InstFinanceira().consultaInstFinanceira(nome);
    }
    
    public boolean alteraInstFinanceira(Integer id, String nome)throws SQLException, ExceptionDAO{
        if(nome!=null){
            InstFinanceira instFinanceira = new InstFinanceira(nome);
            instFinanceira.setId(id);
            instFinanceira.alteraInstFinanceira(instFinanceira);
            return true;
        }else{
            return false;}
    }
    
    public boolean deletaInstFinanceira(Integer id)throws SQLException, ExceptionDAO{
        if(id == 0 ){
            return false;
        }else{
            InstFinanceira instFinanceira = new InstFinanceira();
            instFinanceira.setId(id);
            instFinanceira.deletaInstFinanceira(instFinanceira);
            return true;
        }
    }
}
