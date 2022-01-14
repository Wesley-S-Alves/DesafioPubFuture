package DesafioPubFuture.dao;

import DesafioPubFuture.model.TipoConta;

import java.sql.*;

public class TipoContaDAO {
    public void cadastraTipoConta(TipoConta tipoConta)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO TipoConta (Nome) VALUES(?,?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoConta.getNome());
            stmt.setInt(2, tipoConta.getInstFinanceira().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao cadastrar o tipo de conta: " + e);
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

