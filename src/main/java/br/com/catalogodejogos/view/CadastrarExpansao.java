package br.com.catalogodejogos.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarExpansao {
    private JPanel panel1;
    private JTextField nomeExpansaoTextField;
    private JTextField descricaoExpansaoTextField;
    private JButton buscarImagemExpsButton;
    private JSpinner qtdMinJogadorExpsSpinner;
    private JSpinner qtdMaxJogadorExpsSpinner;
    private JTextField detalheQtdJogadorExpsTextField;
    private JSpinner idadeMinExpsSpinner;
    private JTextField detalheIdadeMinExpsTextField;
    private JSpinner duracaoMinPrtdSpinner;
    private JSpinner duracaoMaxPrtdSpinner;
    private JTextField detalhesDuracaoPrtdTextField;
    private JButton salvarButton;
    private JButton voltarButton;

    public CadastrarExpansao() {
        buscarImagemExpsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
