package br.com.catalogodejogos.app;

import br.com.catalogodejogos.infra.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestarTabelas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = DataBaseConnection.getconnection();

        if (conexao != null) {
            try {
                Statement stmt = conexao.createStatement();

                String sql = """
                    SELECT table_name
                    FROM information_schema.tables
                    WHERE table_schema = 'public'
                      AND table_type = 'BASE TABLE';
                    """;

                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("Tabelas existentes:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("table_name"));
                }

                rs.close();
                stmt.close();
                conexao.close();

            } catch (SQLException e) {
                System.out.println("Erro ao listar tabelas: " + e.getMessage());
            }
        }
    }
}


