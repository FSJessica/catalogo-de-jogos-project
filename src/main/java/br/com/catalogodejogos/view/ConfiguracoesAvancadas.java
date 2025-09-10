package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfiguracoesAvancadas extends JPanel{

    private JPanel panel1;
    private JTextField novaDificuldadeTextField;
    private JTextField novoModoJogoTextField;
    private JTextField novoTipoJogoTextField;
    private JButton salvarButton;
    private JButton voltarButton;
    private JPanel rootPanel;

    public ConfiguracoesAvancadas() {
        this.setLayout(new java.awt.BorderLayout());
        this.add(panel1, java.awt.BorderLayout.CENTER);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(mainPanel);
            }
        });
    }
}
