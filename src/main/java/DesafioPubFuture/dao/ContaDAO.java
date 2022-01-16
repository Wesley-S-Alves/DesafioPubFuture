package DesafioPubFuture.dao;

import DesafioPubFuture.model.Conta;
import DesafioPubFuture.model.InstFinanceira;
import DesafioPubFuture.model.TipoConta;
import java.sql.*;
import java.util.ArrayList;

public class ContaDAO {
    public void cadastraConta(Conta conta)
            throws ExceptionDAO, SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO Conta (Saldo, Nome, TipoConta)" +
                "VALUES (?,?,?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, conta.getSaldo());
            stmt.setString(2, conta.getNome());
            stmt.setInt(3, conta.getTipoConta().getId());
            stmt.executeUpdate();

        } catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar a conta: " + e);
        }finally{
            try {if(stmt != null){ stmt.close();}
            }catch(SQLException  e){
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try{if(conn != null){conn.close();}

            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conex√£o: " + e);
            }


        }

    }
    
    public ArrayList<Conta> consultaConta(String nome)throws SQLException, ExceptionDAO{
        
        String sql  =" select co.Id, co.Saldo, co.Nome, tc.Nome as 'TipoConta',"
                + " inf.Nome 'InstFinanceira' from Conta co, TipoConta tc,"
                + " InstFinanceira inf where co.TipoConta = tc.Id and tc.InstFinanceira"
                + " = inf.Id and co.Nome like '%" + nome + "%';";
        ArrayList<Conta> contas = new ArrayList<>();
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                Conta conta = new Conta();
                conta.setId(rs.getInt("Id"));
                conta.setSaldo(rs.getDouble("Saldo"));
                conta.setNome(rs.getString("Nome"));
                TipoConta tipoConta = new TipoConta();
                tipoConta.setNome(rs.getString("TipoConta"));
                InstFinanceira instFinanceira = new InstFinanceira();
                instFinanceira.setNome(rs.getString("InstFinanceira"));
                tipoConta.setInstFinanceira(instFinanceira);
                conta.setTipoConta(tipoConta);
                contas.add(conta);
            }     
        }
        conn.close();
        stmt.close();
        return contas;
    }
    
    public void alteraConta (Conta conta)throws ExceptionDAO, SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "Update Conta set Saldo = ?, Nome = ?, TipoConta = ? where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, conta.getSaldo());
            stmt.setString(2, conta.getNome());
            stmt.setInt(3, conta.getTipoConta().getId());
            stmt.setInt(4, conta.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar a conta: " + e);
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
    
    
   public void deletaConta(Conta conta)throws SQLException,ExceptionDAO{
       PreparedStatement stmt = null;
       Connection conn = null;
       String sql = "delete from Conta where Id = ?";
       
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao deletar conta: " + e);
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
