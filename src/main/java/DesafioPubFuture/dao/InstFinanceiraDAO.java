package DesafioPubFuture.dao;

import DesafioPubFuture.model.InstFinanceira;
import DesafioPubFuture.model.TipoDespesa;

import java.sql.*;
import java.util.ArrayList;

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
                "Erro ao cadastrar a InstituiÃ§Ã£o Financeira: " + e);
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
    
    public ArrayList<InstFinanceira> consultaInstFinanceira(String nome) throws SQLException, ExceptionDAO{
        String sql = "Select * From InstFinanceira where Nome like '%" + nome + "%';";
        ArrayList<InstFinanceira> insts = new ArrayList<>();
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                InstFinanceira instFinanceira = new InstFinanceira();
                instFinanceira.setId(rs.getInt("Id"));
                instFinanceira.setNome(rs.getString("Nome"));
                insts.add(instFinanceira);
            }
        }
        conn.close();
        stmt.close();
    return insts;
    }
    
    public void alteraInstFinanceira (InstFinanceira instFinanceira)throws ExceptionDAO, SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql  ="Update InstFinanceira set Nome = ? where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, instFinanceira.getNome());
            stmt.setInt(2, instFinanceira.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar a instituição financeira: " + e);
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
       
    public void deletaInstFinanceira(InstFinanceira instFinanceira)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "Delete from InstFinanceira where Id = (?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, instFinanceira.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao apagar a instituição financeira: " + e);
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
