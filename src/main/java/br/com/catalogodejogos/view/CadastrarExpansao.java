package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.ExpansaoDAO;
import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.Expansao;
import br.com.catalogodejogos.model.JogoBase;
import br.com.catalogodejogos.util.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class CadastrarExpansao extends JPanel{
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

    public JPanel getPanel1() {
        return panel1;
    }

    public CadastrarExpansao() {


        buscarImagemExpsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validação de campos obrigatórios:
                String nome = nomeExpansaoTextField.getText().trim();
                String descricao = descricaoExpansaoTextField.getText().trim();

                if (nome.isEmpty()){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome' é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (descricao.isEmpty()){
                    JOptionPane.showMessageDialog(null, "O campo 'Descrição' é obrigatório!", "Erro",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int qtdMinJogExps = (Integer) qtdMinJogadorExpsSpinner.getValue();
                int qtdMaxJogExps = (Integer) qtdMaxJogadorExpsSpinner.getValue();
                int idadeMinExps = (Integer) idadeMinExpsSpinner.getValue();
                int duracaoMinExps = (Integer) duracaoMinPrtdSpinner.getValue();
                int duracaoMaxExps = (Integer) duracaoMaxPrtdSpinner.getValue();

                if (qtdMinJogExps <= 0 || qtdMaxJogExps <= 0 || idadeMinExps <= 0 || duracaoMinExps <= 0 || duracaoMaxExps <= 0) {
                    JOptionPane.showMessageDialog(null, "Valores numéricos não podem ser zero ou negativos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (qtdMinJogExps > qtdMaxJogExps){
                    JOptionPane.showMessageDialog(null,"Quantidade mínima de jogadores não pode ser maior que a quantidade máxima de jogadores", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (duracaoMinExps > duracaoMaxExps){
                    JOptionPane.showMessageDialog(null,"Duração mínima da partida não pode ser maior que a duração máxima da partida", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }




                StringBuilder sb = new StringBuilder();



//              Construção do objeto:
                Expansao expansao = new Expansao();
                expansao.setNomeExps(nomeExpansaoTextField.getText());
                expansao.setDescricaoExps(descricaoExpansaoTextField.getText());
                expansao.setDetalheQtdJogadorExps(detalheQtdJogadorExpsTextField.getText());
                expansao.setDetalheIdadeMinExps(detalheIdadeMinExpsTextField.getText());
                expansao.setDetalheDuracaoPrtdExps(detalhesDuracaoPrtdTextField.getText());

                expansao.setQtdMinJogadorExps((int) qtdMinJogadorExpsSpinner.getValue());
                expansao.setQtdMaxJogadorExps((int) qtdMaxJogadorExpsSpinner.getValue());
                expansao.setIdadeMinExps((int) idadeMinExpsSpinner.getValue());
                expansao.setDuracaoMinPrtdExps((int) duracaoMinPrtdSpinner.getValue());
                expansao.setDuracaoMaxPrtdExps((int) duracaoMaxPrtdSpinner.getValue());

                // 🔹 Aqui usamos o "global"
                if (Constants.jogoBase != null) {
                    expansao.setIdJogo(Constants.jogoBase.getIdJogo());
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Nenhum jogo foi selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                try {
                    ExpansaoDAO dao = new ExpansaoDAO();
                    dao.criar(expansao);
                    JOptionPane.showMessageDialog(null, "Expansão criada com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Cadastro de expansão falhou!", "Informações", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(ex);

                }

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarExpansao gerenciarExpansao = new GerenciarExpansao();
                Main.updateFrameWithNewPanel(gerenciarExpansao);
            }
        });
    }
}
