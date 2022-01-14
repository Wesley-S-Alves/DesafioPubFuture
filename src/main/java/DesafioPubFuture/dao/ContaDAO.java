package DesafioPubFuture.dao;

import DesafioPubFuture.model.Conta;
import java.sql.*;

public class ContaDAO {
    public void cadastraConta(Conta conta)
            throws ExceptionDAO, SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO Conta(Saldo, Nome, TipoConta" +
                "VALUES (?,?,?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, conta.getSaldo());
            stmt.setString(2, conta.getNome());
            stmt.setInt(3, conta.getTipoConta().getId());
            stmt.executeUpdate();

        } catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar o tipo de institui��o: " + e);
        }finally{
            try {if(stmt != null){ stmt.close();}
            }catch(SQLException  e){
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try{if(conn != null){conn.close();}

            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }


        }

    }
}

