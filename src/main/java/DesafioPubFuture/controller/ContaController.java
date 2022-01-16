package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.Conta;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaController {

    public boolean cadastraConta(Double saldo, String nome, Integer idTipoConta)
            throws SQLException, ExceptionDAO {
        if(nome!=null && idTipoConta!=null){
            Conta conta = new Conta(saldo, nome, idTipoConta);
            conta.cadastraConta(conta);
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Conta> consultaConta(String nome)
            throws SQLException, ExceptionDAO{
        return new Conta().consultaConta(nome);
    }
    
    public boolean alteraConta(Integer id, Double saldo, String nome, Integer idTipoConta)
            throws SQLException, ExceptionDAO {
        if(nome!=null && idTipoConta!=null){
            Conta conta = new Conta(saldo, nome, idTipoConta);
            conta.setId(id);
            conta.alteraConta(conta);
            return true;
        }else{
            return false;
        }    
    }
    
    public boolean deletaConta(Integer id)throws SQLException, ExceptionDAO{
        if (id == 0){
            return false;
        }else{
            Conta conta = new Conta();
            conta.setId(id);
            conta.deletaConta(conta);
            return true;
        }
    }

}
    
