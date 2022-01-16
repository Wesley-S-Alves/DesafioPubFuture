package DesafioPubFuture.dao;

import DesafioPubFuture.model.TipoDespesa;

import java.sql.*;
import java.util.ArrayList;

public class TipoDespesaDAO {
    
    public void cadastraTipoDespesa(TipoDespesa tipoDespesa)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO TipoDespesa (Nome) VALUES(?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoDespesa.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao cadastrar o tipo de Despesa: " + e);
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
    
    
    public ArrayList<TipoDespesa> consultaTipoDespesa(String nome) throws  ExceptionDAO, SQLException {
       String sql= "Select * from TipoDespesa where Nome like '%" + nome + "%';";
       ArrayList<TipoDespesa> tipos = new ArrayList<>();
       Connection conn = new ConnectionMVC().getConnection();
       PreparedStatement stmt = conn.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       
       if (rs!=null){
           while(rs.next()){
               TipoDespesa tipoDespesa = new TipoDespesa();
               tipoDespesa.setId(rs.getInt("Id"));
               tipoDespesa.setNome(rs.getString("Nome"));
               tipos.add(tipoDespesa);
           }
       }
       conn.close();
       stmt.close();
    return tipos;
   }
    
    public void alteraTipoDespesa (TipoDespesa tipoDespesa)throws ExceptionDAO, SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql  ="Update TipoDespesa set Nome = ? where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoDespesa.getNome());
            stmt.setInt(2, tipoDespesa.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar o tipo de despesa: " + e);
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
       
    public void deletaTipoDespesa(TipoDespesa tipoDespesa)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "Delete from TipoDespesa where Id = (?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tipoDespesa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao apagar o tipo de Despesa: " + e);
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


