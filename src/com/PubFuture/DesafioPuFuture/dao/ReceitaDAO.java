package dao;
import java.sql.*;
import model.Receita;

public class ReceitaDAO {
    public void cadastraReceita(Receita receita)
        throws ExceptionDAO,SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO Receita (Valor, TipoReceita," +
                " Conta, Descricao, DataRecebimento," +
                " DataRecebimentoEsperado) VALUES (?,?,?,?,?,?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);

        }
    }

}
