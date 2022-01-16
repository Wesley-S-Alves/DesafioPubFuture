package DesafioPubFuture.dao;

import DesafioPubFuture.model.Conta;
import DesafioPubFuture.model.Despesa;
import DesafioPubFuture.model.TipoDespesa;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DespesaDAO {
    public void cadastraDespesa(Despesa despesa
    ) throws ExceptionDAO, SQLException{
        PreparedStatement stmt =null;
        Connection conn= null;
        String sql = "INSERT INTO Despesa (Valor, TipoDespesa," +
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
                        "Erro ao fechar a conex√£o: " + e);
            }
        }
    }
    
    public ArrayList<Despesa> consultaDespesa(String descricao)
            throws SQLException, ExceptionDAO{
        
        String sql = "SELECT de.Id, de.Valor, td.Nome as 'TipoDespesa',"
                + " co.Nome as 'Conta', de.Descricao, de.DataPagamento, de.DataPagamentoEsperado"
                + " from Despesa de, TipoDespesa td, Conta co where"
                + " de.Conta = co.Id AND de.TipoDespesa = td.Id and de.Descricao like'%" + descricao + "%'";
        ArrayList<Despesa> despesas = new ArrayList<>();
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("Id"));
                despesa.setValor(rs.getDouble("Valor"));
                TipoDespesa tipoDespesa = new TipoDespesa();
                tipoDespesa.setNome(rs.getString("TipoDespesa"));
                Conta conta = new Conta();
                conta.setNome(rs.getString("Conta"));
                despesa.setDescricao(rs.getString("Descricao"));
                despesa.setDataPagamento(rs.getDate("DataPagamentoEsperado"));
                despesa.setDataPagamentoEsperado(rs.getDate("DataPagamentoEsperado"));
                despesa.setTipoDespesa(tipoDespesa);
                despesa.setConta(conta);
                despesas.add(despesa);
                
                
            }
        }
        conn.close();
        stmt.close();
        return despesas;
    }
    
    public void alteraDespesa(Despesa despesa)throws SQLException, ExceptionDAO{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "update Despesa set Valor = ?, TipoDespesa = ?, Conta = ?, Descricao = ? "
                + "DataPagamento = ?, DataPagamentoEsperado = ? where Id = ?";
        
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
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar a despesa: " + e);
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
                        "Erro ao fechar a conex„o: " + e);

            }
        }
    }
    
    public void deletaDespesa(Despesa despesa)throws SQLException, ExceptionDAO{
       PreparedStatement stmt = null;
       Connection conn = null;
       String sql = "delete from Despesa where Id = ?";
       
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, despesa.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao deletar despesa: " + e);
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
                        "Erro ao fechar a conex„o: " + e);

            }
        }
    }      
}


