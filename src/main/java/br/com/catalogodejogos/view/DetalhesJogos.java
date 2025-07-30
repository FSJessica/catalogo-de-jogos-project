package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.model.JogoBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DetalhesJogos {

    private JPanel panel1;
    private JButton salvarButton;
    private JButton voltarButton;
    private JTextField nomeTextField;
    private JTextField descricaoTextField;
    private JTextField imagemTextField;
    private JTextField qtdMinJogadorTextField;
    private JTextField qtdMaxJogadorTextField;
    private JTextField detalheQtdJogadorTextField;
    private JTextField idadeMinTextField;
    private JTextField detalheIdadeMinTextField;
    private JTextField duracaoMinPrtdTextField;
    private JTextField duracaoMaxPrtdTextField;
    private JTextField detalheDuracaoPrtdTextField;
    private JTextField comentariosTextField;

    public JPanel getPanel1(){
        return panel1;
    }
    //identificador do tipo de operação
    public DetalhesJogos (JogoBase jogoBase) {
        System.err.println(jogoBase);
        nomeTextField.setText(jogoBase.getNome());
        descricaoTextField.setText(jogoBase.getDescricaoJogo());
        imagemTextField.setText(Arrays.toString(jogoBase.getImagem()));
        qtdMinJogadorTextField.setText("" + jogoBase.getQtdMinJogador());
        qtdMaxJogadorTextField.setText("" + jogoBase.getQtdMaxJogador());
        detalheQtdJogadorTextField.setText(jogoBase.getDetalheQtdJogador());
        idadeMinTextField.setText("" + jogoBase.getIdadeMin());
        detalheIdadeMinTextField.setText(jogoBase.getDetalheIdadeMin());
        duracaoMinPrtdTextField.setText("" + jogoBase.getDuracaoMinPrtd());
        duracaoMaxPrtdTextField.setText("" + jogoBase.getDuracaoMaxPrtd());
        detalheDuracaoPrtdTextField.setText(jogoBase.getDetalheDuracaoPrtd());
        comentariosTextField.setText(jogoBase.getComentarios());



        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeTextField.getText();
                StringBuilder sb = new StringBuilder();

                // recuperar informação do textField
                sb.append ("Você digitou '" + nomeTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + descricaoTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + imagemTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + qtdMinJogadorTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + qtdMaxJogadorTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + detalheQtdJogadorTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + idadeMinTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + detalheIdadeMinTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + duracaoMinPrtdTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + duracaoMaxPrtdTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + detalheDuracaoPrtdTextField.getText() + "' no texto.");
                sb.append ("Você digitou '" + comentariosTextField.getText() + "' no texto.");


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
