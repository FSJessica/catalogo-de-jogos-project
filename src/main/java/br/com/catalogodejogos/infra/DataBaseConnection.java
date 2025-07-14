package br.com.catalogodejogos.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/db_ctlg_jogo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static Connection getconnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

