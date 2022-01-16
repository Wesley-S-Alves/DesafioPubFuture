package DesafioPubFuture.dao;

import DesafioPubFuture.model.InstFinanceira;
import DesafioPubFuture.model.TipoConta;

import java.sql.*;
import java.util.ArrayList;

public class TipoContaDAO {
    public void cadastraTipoConta(TipoConta tipoConta)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO TipoConta (Nome, InstFinanceira) VALUES(?,?);";

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
                        "Erro ao fechar a conex√£o: " + e);

            }
        }

    }
    
    public ArrayList<TipoConta> consultaTipoConta(String nome)
            throws SQLException, ExceptionDAO{
        String sql = "select tc.Id , tc.Nome, ins.Nome as"
                + " 'InstFinanceira' from TipoConta tc, "
                + "InstFinanceira ins where ins.Id = tc.InstFinanceira "
                + "and tc.nome like '%" + nome + "%'";
        ArrayList<TipoConta> tipoContas = new ArrayList<>();
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                TipoConta tipoConta = new TipoConta();
                tipoConta.setId(rs.getInt("Id"));
                tipoConta.setNome(rs.getString("Nome"));
                InstFinanceira instFinanceira = new InstFinanceira();
                instFinanceira.setNome(rs.getString("InstFinanceira"));
                tipoConta.setInstFinanceira(instFinanceira);
                tipoContas.add(tipoConta);
            
            }
        }
        conn.close();
        stmt.close();
    return tipoContas;
    }
    
    public void alteraTipoConta(TipoConta tipoConta)throws SQLException,ExceptionDAO{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "Update TipoConta set Nome = ?, InstFinanceira = ? where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoConta.getNome());
            stmt.setInt(2, tipoConta.getInstFinanceira().getId());
            stmt.setInt(3, tipoConta.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar o tipo da conta: " + e);
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
    
    public void deletaTipoConta(TipoConta tipoConta)throws SQLException, ExceptionDAO{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "delete from TipoConta where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tipoConta.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao deletar o tipo da conta: " + e);
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

