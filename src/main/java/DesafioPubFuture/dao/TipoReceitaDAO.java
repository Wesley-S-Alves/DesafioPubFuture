package DesafioPubFuture.dao;

import DesafioPubFuture.model.TipoReceita;
import java.sql.*;
import java.util.ArrayList;

public class TipoReceitaDAO {
    public void cadastraTipoReceita(TipoReceita tipoReceita)
            throws ExceptionDAO, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO TipoReceita (Nome) VALUES(?);";

        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoReceita.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao cadastrar o tipo de receita: " + e);
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
    
   public ArrayList<TipoReceita> consultaTipoReceita(String nome) throws  ExceptionDAO, SQLException {
       String sql= "Select * from TipoReceita where Nome like '%" + nome + "%' ORDER BY Id;";
       ArrayList<TipoReceita> tipos = null;
       Connection conn = new ConnectionMVC().getConnection();
       PreparedStatement stmt = conn.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery(sql);
       
       if (rs!=null){
           while(rs.next()){
               TipoReceita tipoReceita = new TipoReceita();
               tipoReceita.setNome(rs.getString("Nome"));
               tipos.add(tipoReceita);
           }
       }
       conn.close();
       stmt.close();
    return tipos;
   }
}
