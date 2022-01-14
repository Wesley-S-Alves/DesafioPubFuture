package controller;

import dao.ExceptionDAO;
import model.TipoConta;

import java.sql.SQLException;

public class TipoContaController {
    public boolean cadastraTipoConta(String nome, Integer idInstFinanceira)
        throws ExceptionDAO, SQLException {
        if(nome!=null && idInstFinanceira !=null){
            TipoConta tipoConta = new TipoConta();
            tipoConta.cadastraTipoConta(tipoConta);
            return true;
        }else{
            return false;
        }
    }
}
