package DesafioPubFuture.dao;
import java.sql.*;
import DesafioPubFuture.model.Receita;

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
            stmt.setDouble(1, receita.getValor());
            stmt.setInt(2, receita.getTipoReceita().getId());
            stmt.setInt(3,receita.getConta().getId());
            stmt.setString(4, receita.getDescricao());
            stmt.setDate(5, new Date(receita.getDataRecebimento().getTime()));
            stmt.setDate(6, new Date(receita.getDataRecebimentoEsperado().getTime()));
            stmt.executeUpdate();

        }catch (SQLException e){
                throw new ExceptionDAO(
                        "Erro ao cadastrar a receita: " + e);
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


