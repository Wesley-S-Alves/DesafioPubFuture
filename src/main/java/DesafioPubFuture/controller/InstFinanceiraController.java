package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.InstFinanceira;

import java.sql.SQLException;

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
}