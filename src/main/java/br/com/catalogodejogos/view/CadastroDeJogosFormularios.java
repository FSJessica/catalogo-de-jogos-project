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
                // Validação de campos obrigatórios:
                String nome = nomeTextField.getText().trim();
                String descricao = descricaoJogoTextField.getText().trim();

                if (nome.isEmpty()){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome' é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (descricao.isEmpty()){
                    JOptionPane.showMessageDialog(null, "O campo 'Descrição' é obrigatório!", "Erro",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int qtdMinJog = (Integer) quantidadeMinimaJogadorSpinner.getValue();
                int qtdMaxJog = (Integer) quantidadeMaximaJogadorSpinner.getValue();
                int idadeMin = (Integer) idadeMinimaSpinner.getValue();
                int duracaoMin = (Integer) duracaoMinimaPartidaSpinner.getValue();
                int duracaoMax = (Integer) duracaoMaximaPartidaSpinner.getValue();

                if (qtdMinJog <= 0 || qtdMaxJog <= 0 || idadeMin <= 0 || duracaoMin <= 0 || duracaoMax <= 0) {
                    JOptionPane.showMessageDialog(null, "Valores numéricos não podem ser zero ou negativos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (qtdMinJog > qtdMaxJog){
                    JOptionPane.showMessageDialog(null,"Quantidade mínima de jogadores não pode ser maior que a quantidade máxima de jogadores", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (duracaoMin > duracaoMax){
                    JOptionPane.showMessageDialog(null,"Duração mínima da partida não pode ser maior que a duração máxima da partida", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }




                StringBuilder sb = new StringBuilder();



//              Construção do objeto:
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
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Cadastro falhou!", "Informações", JOptionPane.INFORMATION_MESSAGE);
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
