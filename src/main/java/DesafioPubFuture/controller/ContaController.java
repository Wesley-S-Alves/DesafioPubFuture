package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.Conta;

import java.sql.SQLException;

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
}
