package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import static br.com.catalogodejogos.app.Main.frame;

public class MainPanel extends JPanel{
    private JButton cadastrarUmNovoJogoButton;
    private JButton verListaDeJogosButton;

    public MainPanel() {
        // Inicializando os botões
        cadastrarUmNovoJogoButton = new JButton("Cadastrar um novo jogo");
        verListaDeJogosButton = new JButton("Ver lista de jogos");

        //adicionar ação aos botões
        cadastrarUmNovoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ação do botão
                CadastroDeJogosFormularios formulario = new CadastroDeJogosFormularios();
                Main.updateFrameWithNewPanel(formulario.getRootPanel());
            }
        });
        verListaDeJogosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ação do botão
                JOptionPane.showMessageDialog(null, "Ver lista de jogos clicado!");
            }
        });

        setLayout(new FlowLayout());
        add(cadastrarUmNovoJogoButton);
        add(verListaDeJogosButton);
    }
    public static void updateFrameWithNewPanel (JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }
}
