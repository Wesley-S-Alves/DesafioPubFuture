package dao;

import model.InstFinanceira;

import java.sql.*;

public class InstFinanceiraDAO {
    public void cadastraInstFinanceira(InstFinanceira instFinanceira)
        throws ExceptionDAO, SQLException{

    String sql = "INSERT INTO InstFinanceira (Nome) VALUES (?);";
    PreparedStatement stmt = null;
    Connection conn = null;

    try{
        conn = new ConnectionMVC().getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, instFinanceira.getNome());
        stmt.executeUpdate();
    }catch (SQLException e){
        throw new ExceptionDAO(
                "Erro ao cadastrar a Instituição Financeira: " + e);
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
