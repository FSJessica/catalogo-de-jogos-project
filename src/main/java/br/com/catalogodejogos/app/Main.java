package br.com.catalogodejogos.app;

import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.infra.DataBaseInitializer;
import br.com.catalogodejogos.view.CatalogoDeJogosGui;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Criação dde conexão com o banco de dados
        Connection conexao = DataBaseConnection.getconnection();
        // Criação automática das tabelas ao iniciar
        DataBaseInitializer.initialize();

        CatalogoDeJogosGui gui = new CatalogoDeJogosGui();

        if (conexao != null){
            System.out.println("Tudo certo!");
        } else {
            System.out.println("Não foi possível conectar.");
        }
    }
}