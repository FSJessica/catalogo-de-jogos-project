package br.com.catalogodejogos.app;

import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.infra.DataBaseInitializer;
import br.com.catalogodejogos.view.MainPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static final JFrame frame = new JFrame();

    public static void main(String[] args) throws SQLException {
        // Criação dde conexão com o banco de dados
        Connection conexao = DataBaseConnection.getconnection();
        // Criação automática das tabelas ao iniciar
        DataBaseInitializer.initialize();

//        CatalogoDeJogosGui gui = new CatalogoDeJogosGui();
//        CadastroDeNovosJogos cdstr = new CadastroDeNovosJogos();


        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainPanel painel = new MainPanel();
        updateFrameWithNewPanel(painel);

        frame.setVisible(true);


        if (conexao != null){
            System.out.println("Tudo certo!");
        } else {
            System.out.println("Não foi possível conectar.");
        }


    }

    public static void updateFrameWithNewPanel (JPanel panel) {
        frame.setContentPane(panel);
        frame.update(frame.getGraphics());
        frame.revalidate();
        frame.repaint();
    }

}