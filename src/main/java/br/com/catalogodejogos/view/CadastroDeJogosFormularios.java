package br.com.catalogodejogos.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeJogosFormularios {
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField3;
    private JSpinner spinner3;
    private JTextField textField4;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JTextField textField5;
    private JTextField textField6;
    private JButton buscarNosArquivosButton;
    private JButton processarButton;
    private JPanel rootPanel;


    public CadastroDeJogosFormularios(){
        processarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();

                // recuperar informação do textField
                sb.append ("Você digitou '" + textField1.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField2.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField3.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField4.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField5.getText() + "' no texto.");
                sb.append ("Você digitou '" + textField6.getText() + "' no texto.");

                //recuperar valor do spinner
                sb.append("Você colocou o número'" + spinner1.getValue() + "' no spinner.");
                sb.append("Você colocou o número'" + spinner2.getValue() + "' no spinner.");
                sb.append("Você colocou o número'" + spinner3.getValue() + "' no spinner.");
                sb.append("Você colocou o número'" + spinner4.getValue() + "' no spinner.");
                sb.append("Você colocou o número'" + spinner5.getValue() + "' no spinner.");

                //botão de procurar aquivos
                buscarNosArquivosButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Bucar arquivos pressionado!");
                    }
                });
            }
        });
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
