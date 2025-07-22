package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalhesJogos {
    private JPanel panel1;
    private JButton editarButton;
    private JButton deletarButton;
    private JButton salvarButton;
    private JButton voltarButton;
    private JTextField xadrezTextField;
    private JTextField jogoDeEstratégiaTextField;
    private JTextField imagemTextField;
    private JTextField a2TextField;
    private JTextField a2TextField1;
    private JTextField jogoPermiteApenas2TextField;
    private JTextField a7TextField;
    private JTextField nãoHáDetalhesTextField;
    private JTextField a20MinutosTextField;
    private JTextField a40MinutosTextField;
    private JTextField duraçãoVariávelDependendoDosTextField;
    private JTextField semCmentáriosExtrasTextField;

    public JPanel getPanel1(){
        return panel1;
    }
    //identificador do tipo de operação
    public DetalhesJogos() {
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //botão voltar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerListaJogos listaPanel = new VerListaJogos();
                Main.updateFrameWithNewPanel(listaPanel);
            }
        });
    }
}
