package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.Despesa;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DespesaController {

    public boolean cadastraDespesa(Double valor, Integer idTipoDespesa,
                                   Integer idConta, String descricao,
                                   String dataPagamento, String dataPagamentoEsperado)
            throws ExceptionDAO, SQLException, ParseException {
        if (valor > 0 && idTipoDespesa != null && idConta != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date pagamento = sdf.parse(dataPagamento);
            Date esperado = sdf.parse(dataPagamentoEsperado);
            Despesa despesa = new Despesa(valor, idTipoDespesa, idConta,
                    descricao, pagamento, esperado);
            despesa.cadastraDespesa(despesa);
            return true;
        } else {
            return false;
        }

    }
    
    public ArrayList<Despesa> consultaDespesa(String descricao)
            throws SQLException, ExceptionDAO{
        return new Despesa().consultaDespesa(descricao);
    }
    
    public boolean alteraDespesa(Integer id, double valor, Integer idTipoDespesa,
            Integer idConta, String descricao, String dataPagamento, String dataPagamentoEsperado)
    throws SQLException, ExceptionDAO, ParseException{
        if(valor > 0 && idConta != null && idTipoDespesa != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date pagamento = sdf.parse(dataPagamento);
            Date esperado = sdf.parse(dataPagamentoEsperado);
            Despesa despesa = new Despesa(valor, idTipoDespesa, idConta, descricao, pagamento, esperado);
            despesa.setId(id);
            despesa.alteraDespesa(despesa);
            return true;
        }else{
            return false;
        }
    }    
    
    
    public boolean deletaDespesa(Integer id)throws SQLException, ExceptionDAO{
        if (id == 0){
            return false;
        }else{
            Despesa despesa = new Despesa();
            despesa.setId(id);
            despesa.deleteDespesa(despesa);
            return true;
        }
    }
}