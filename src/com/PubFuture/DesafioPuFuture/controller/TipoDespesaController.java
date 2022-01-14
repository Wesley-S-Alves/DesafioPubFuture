package controller;

import dao.ExceptionDAO;
import model.TipoDespesa;

import java.sql.SQLException;

public class TipoDespesaController {

    public boolean cadastraTipoDespesa(String nome)throws ExceptionDAO, SQLException {
        if (nome!=null){
            TipoDespesa tipoDespesa = new TipoDespesa();
            tipoDespesa.cadastraTipoDespesa(tipoDespesa);
            return true;
        }else{
            return false;
        }
    }
}
