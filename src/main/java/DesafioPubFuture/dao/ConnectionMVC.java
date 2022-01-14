package DesafioPubFuture.dao;

import java.sql.*;
;

public class ConnectionMVC {

    public Connection getConnection(){
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) { e.printStackTrace();
        } try {
            conn = DriverManager.getConnection("jdbc:sqlite:ControleFinanceiro.db");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

}

