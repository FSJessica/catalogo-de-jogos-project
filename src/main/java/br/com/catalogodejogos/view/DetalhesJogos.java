package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalhesJogos {

    private JPanel panel1;
    private JButton salvarButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;

    public JPanel getPanel1(){
        return panel1;
    }
    //identificador do tipo de operação
    public DetalhesJogos (String nomeJogo, String tipoJogo) {

        textField1.setText(nomeJogo);
        textField2.setText(tipoJogo);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.getText();
                StringBuilder sb = new StringBuilder();

                // recuperar informação do textField
                sb.append ("Você digitou '" + textField1.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField2.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField3.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField4.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField5.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField6.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField7.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField8.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField9.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField10.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField11.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField12.getText() + "' no texto.");


                // exibir resultado
                JOptionPane.showMessageDialog(null, sb.toString(), "Informações do Jogo", JOptionPane.INFORMATION_MESSAGE);

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
