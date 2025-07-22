package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.com.catalogodejogos.view.MainPanel.updateFrameWithNewPanel;

public class VerListaJogos extends JPanel {
    private JTable table1;
    private JPanel panel1;
    private JButton maisDetalhesButton;
    private JButton voltarButton;

    public VerListaJogos(){
        //criando array de string para funcionar como o cabeçalho da tabela.
        String [] cabecalho = new String[][]{
                {"Jogo 1", "party game"},
                {"Jogo 2", "Estratégia"},
                {"Jogo 3", "Cooperativo"}
        };

        //
        DefaultTableModel model = new DefaultTableModel(dados, cabecalho){
            public boolean isCellEditable(int column, int row) {return false; }
        };
        table1.setModel(model);
        maisDetalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(mainPanel);
            }
        });
        // No TabelaPanel.form está a visualização gráfica de como o painel irá se comportar. Depois disso
        // chamo o método da classe main para atualizar o frame com o meu novo painel.
        updateFrameWithNewPanel(VerListaJogos);
    }
}
