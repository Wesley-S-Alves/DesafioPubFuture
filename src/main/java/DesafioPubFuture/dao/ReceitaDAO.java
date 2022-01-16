package DesafioPubFuture.dao;
import DesafioPubFuture.model.Conta;
import DesafioPubFuture.model.Despesa;
import java.sql.*;
import DesafioPubFuture.model.Receita;
import DesafioPubFuture.model.TipoDespesa;
import DesafioPubFuture.model.TipoReceita;
import java.util.ArrayList;

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
                            "Erro ao fechar a conex√£o: " + e);
                }
        }
    }
   
    public ArrayList<Receita> consultaReceita(String descricao)
            throws SQLException, ExceptionDAO{
        String sql = "SELECT re.Id, re.Valor, tr.Nome as 'TipoReceita',"
                + " co.Nome as 'Conta', re.Descricao, re.DataRecebimento, re.DataRecebimentoEsperado"
                + " from Receita re, TipoReceita tr, Conta co where"
                + " re.Conta = co.Id AND re.TipoReceita = tr.Id and re.Descricao like'%" + descricao +"%';";
        ArrayList<Receita> receitas = new ArrayList<>();
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                Receita receita = new Receita();
                receita.setId(rs.getInt("Id"));
                receita.setValor(rs.getDouble("Valor"));
                TipoReceita tipoReceita = new TipoReceita();
                tipoReceita.setNome(rs.getString("TipoReceita"));
                Conta conta = new Conta();
                conta.setNome(rs.getString("Conta"));
                receita.setDescricao(rs.getString("Descricao"));
                receita.setDataRecebimento(rs.getDate("DataRecebimento"));
                receita.setDataRecebimentoEsperado(rs.getDate("DataRecebimentoEsperado"));
                receita.setTipoReceita(tipoReceita);
                receita.setConta(conta);
                receitas.add(receita);
                
                
            }
        }
        conn.close();
        stmt.close();
        return receitas;
    }
    
    public void alteraReceita(Receita receita)throws SQLException, ExceptionDAO{
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "update Receita set Valor = ?, TipoDespesa = ?, Conta = ?, Descricao = ? "
                + "DataRecebimento = ?, DataRecebimentoEsperado = ? where Id = ?";
        
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, receita.getValor());
            stmt.setInt(2, receita.getTipoReceita().getId());
            stmt.setInt(3, receita.getConta().getId());
            stmt.setString(4, receita.getDescricao());
            stmt.setDate(5, new Date(receita.getDataRecebimento().getTime()));
            stmt.setDate(6, new Date(receita.getDataRecebimentoEsperado().getTime()));
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao alterar a receita: " + e);
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
    
    public void deletaReceita(Receita receita)throws SQLException, ExceptionDAO{
       PreparedStatement stmt = null;
       Connection conn = null;
       String sql = "delete from Receita where Id = ?";
       
        try {
            conn = new ConnectionMVC().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, receita.getId());
            stmt.executeUpdate();
        } catch  (SQLException e) {
            throw new ExceptionDAO(
                    "Erro ao deletar receita: " + e);
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


