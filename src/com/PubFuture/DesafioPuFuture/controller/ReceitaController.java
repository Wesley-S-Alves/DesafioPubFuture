package controller;

import dao.ExceptionDAO;
import model.Receita;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
