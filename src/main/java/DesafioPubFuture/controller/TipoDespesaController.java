package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoDespesa;

import java.sql.SQLException;

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
}