package DesafioPubFuture.dao;

import DesafioPubFuture.model.TipoReceita;
import java.sql.*;

public class TipoReceitaDAO {
    public void cadastraTipoReceita(TipoReceita tipoReceita)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO TipoReceita (Nome) VALUES(?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoReceita.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao cadastrar o tipo de receita: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO(
                        "Erro ao fechar o Statement: " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO(
                        "Erro ao fechar a conexão: " + e);

            }
        }

    }
}
