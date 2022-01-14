package controller;

import dao.ExceptionDAO;
import model.Despesa;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DespesaController {

    public boolean cadastraDespesa(Double valor, Integer idTipoReceita,
                                   Integer idConta, String descricao,
                                   String dataPagamento, String dataPagamentoEsperado)
            throws ExceptionDAO, SQLException, ParseException {
        if (valor > 0 && idTipoReceita != null && idConta != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date pagamento = sdf.parse(dataPagamento);
            Date esperado = sdf.parse(dataPagamentoEsperado);
            Despesa despesa = new Despesa(valor, idTipoReceita, idConta,
                    descricao, pagamento, esperado);
            despesa.cadastraDespesa(despesa);
            return true;
        } else {
            return false;
        }


    }
}
