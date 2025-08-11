package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.model.JogoBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarExpansao extends JPanel{
    private JPanel panel1;
    private JTable table1;
    private JButton voltarButton;
    private JButton inserirExpansaoButton;
    private JButton verDetalhesDaExpansaoButton;
    private JButton deletarExpansaoButton;

    public GerenciarExpansao(JogoBase jogoBase) {
        // Adiciona o panel1 (criado pelo GUI Designer) a este JPanel
        this.setLayout(new java.awt.BorderLayout());
        this.add(panel1, java.awt.BorderLayout.CENTER);

        // Configura modelo inicial da tabela
        String[] colunas = {"ID", "Nome da Expansão", "Descrição"};
        Object[][] dados = {
                {1, "Expansão 1", "Expansão contém novas cartas"},
                {2, "Expansão 2", "Expansão contém novos personagens e novas cartas"}
        };
        table1.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));

        inserirExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verDetalhesDaExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deletarExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetalhesJogos detalhesJogos = new DetalhesJogos(jogoBase);
                Main.updateFrameWithNewPanel(detalhesJogos.getPanel1());
            }
        });
    }
}
