package DesafioPubFuture.controller;

import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.Receita;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceitaController {

    public boolean cadastraReceita(Double valor, Integer idTipoReceita,
                                   Integer idConta, String descricao,
                                   String dataRecebimento, String dataRecebimentoEsperado)
    throws ExceptionDAO, SQLException, ParseException {
        if(valor >0 && idTipoReceita!=null && idConta!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date recebimento= sdf.parse(dataRecebimento);
            Date esperado = sdf.parse(dataRecebimentoEsperado);
            Receita receita = new Receita(valor, idTipoReceita, idConta,
                    descricao, recebimento, esperado);
            receita.cadastraReceita(receita);
            return true;
        }else{
            return false;
        }

    }
    
    public ArrayList<Receita> consultaReceita(String descricao)
            throws SQLException, ExceptionDAO{
        return new Receita().consultaReceita(descricao);
    }
    
    public boolean alteraReceita(Integer id, double valor, Integer idTipoReceita,
            Integer idConta, String descricao, String dataRecebimento, String dataRecebimentoEsperado)
    throws SQLException, ExceptionDAO, ParseException{
        if(valor > 0 && idConta != null && idTipoReceita != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date recebimento = sdf.parse(dataRecebimento);
            Date esperado = sdf.parse(dataRecebimentoEsperado);
            Receita receita = new Receita(valor, idTipoReceita, idConta, descricao, recebimento, esperado);
            receita.setId(id);
            receita.alteraReceita(receita);
            return true;
        }else{
            return false;
        }
    }    
    
    
    public boolean deletaReceita(Integer id)throws SQLException, ExceptionDAO{
        if (id == 0){
            return false;
        }else{
            Receita receita = new Receita();
            receita.setId(id);
            receita.deleteReceita(receita);
            return true;
        }
    }
}
