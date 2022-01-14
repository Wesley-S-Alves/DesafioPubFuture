package DesafioPubFuture.dao;

import DesafioPubFuture.model.Despesa;

import java.sql.*;

public class DespesaDAO {
    public void cadastraDespesa(Despesa despesa
    ) throws ExceptionDAO, SQLException{
        PreparedStatement stmt =null;
        Connection conn= null;
        String sql = "INSERT INTO Despesa (Valor, TipoDepesa," +
                " Conta, Descricao, dataPagamento, dataPagamentoEsperado) " +
                "VALUES (?,?,?,?,?,?);";
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, despesa.getValor());
            stmt.setInt(2, despesa.getTipoDespesa().getId());
            stmt.setInt(3, despesa.getConta().getId());
            stmt.setString(4, despesa.getDescricao());
            stmt.setDate(5, new Date(despesa.getDataPagamento().getTime()));
            stmt.setDate(6, new Date(despesa.getDataPagamentoEsperado().getTime()));
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new ExceptionDAO(
                    "Erro ao cadastrar a despesa: " + e);
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


