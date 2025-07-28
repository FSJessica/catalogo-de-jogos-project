package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.JogoBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class CadastroDeJogosFormularios {
    private JTextField nomeTextField;
    private JTextField descricaoJogoTextField;
    private JSpinner quantidadeMinimaJogadorSpinner;
    private JSpinner quantidadeMaximaJogadorSpinner;
    private JTextField detalhesQuantidadeJogadorTextField;
    private JSpinner idadeMinimaSpinner;
    private JTextField detalheIdadeMínimaTextField;
    private JSpinner duracaoMinimaPartidaSpinner;
    private JSpinner duracaoMaximaPartidaSpinner;
    private JTextField detalheDuracaoPartidaTextField;
    private JTextField comentariosExtrasTextField;
    private JButton buscarNosArquivosButton;
    private JButton processarButton;
    private JPanel rootPanel;
    private JButton voltarButton;


    public CadastroDeJogosFormularios(){
        processarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();

//                // recuperar informação do textField
//                sb.append ("Você digitou '" + nomeTextField.getText() + "' no texto.");
//                sb.append ("Você digitou '" + descricaoJogoTextField.getText() + "' no texto.");
//                sb.append ("Você digitou '" + detalhesQuantidadeJogadorTextField.getText() + "' no texto.");
//                sb.append ("Você digitou '" + detalheIdadeMínimaTextField.getText() + "' no texto.");
//                sb.append ("Você digitou '" + detalheDuracaoPartidaTextField.getText() + "' no texto.");
//                sb.append ("Você digitou '" + comentariosExtrasTextField.getText() + "' no texto.");
//
//                //recuperar valor do spinner
//                sb.append("Você colocou o número'" + quantidadeMinimaJogadorSpinner.getValue() + "' no spinner.");
//                sb.append("Você colocou o número'" + quantidadeMaximaJogadorSpinner.getValue() + "' no spinner.");
//                sb.append("Você colocou o número'" + idadeMinimaSpinner.getValue() + "' no spinner.");
//                sb.append("Você colocou o número'" + duracaoMinimaPartidaSpinner.getValue() + "' no spinner.");
//                sb.append("Você colocou o número'" + duracaoMaximaPartidaSpinner.getValue() + "' no spinner.");

                JogoBase jogoBase = new JogoBase();
                jogoBase.setNome(nomeTextField.getText());
                jogoBase.setDescricaoJogo(descricaoJogoTextField.getText());
                jogoBase.setDetalheQtdJogador(detalhesQuantidadeJogadorTextField.getText());
                jogoBase.setDetalheIdadeMin(detalheIdadeMínimaTextField.getText());
                jogoBase.setDetalheDuracaoPrtd(detalheDuracaoPartidaTextField.getText());
                jogoBase.setComentarios(comentariosExtrasTextField.getText());

                jogoBase.setQtdMinJogador((int) quantidadeMinimaJogadorSpinner.getValue());
                jogoBase.setQtdMaxJogador((int) quantidadeMaximaJogadorSpinner.getValue());
                jogoBase.setIdadeMin((int) idadeMinimaSpinner.getValue());
                jogoBase.setDuracaoMinPrtd((int) duracaoMinimaPartidaSpinner.getValue());
                jogoBase.setDuracaoMaxPrtd((int) duracaoMaximaPartidaSpinner.getValue());


                try {
                    Connection conexao = DataBaseConnection.getconnection();
                    JogoBaseDAO dao = new JogoBaseDAO(conexao);
                    dao.criar(jogoBase);
                    JOptionPane.showMessageDialog(null, sb.toString(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, sb.toString(), "O cadastro falhou", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(ex);

                }
            }
        });

        //botão de procurar aquivos
        buscarNosArquivosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bucar arquivos pressionado!");
            }
        });

        //botão de voltar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(mainPanel);
            }
        });
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
