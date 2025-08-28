package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.ExpansaoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static br.com.catalogodejogos.infra.DataBaseConnection.getconnection;
import static br.com.catalogodejogos.util.Constants.jogoBase;
import static br.com.catalogodejogos.util.Constants.expansao;


public class DetalhesExpansao extends JPanel{
    private JPanel panel1;
    private JTextField nomeExpsTextField;
    private JTextField descricaoExpsTextField;
    private JButton buscarImagemButton;
    private JSpinner qtdMinJogadorExpsSpinner;
    private JSpinner qtdMaxJogadorExpsSpinner;
    private JTextField detalheQtdJogadorExpsTextField;
    private JSpinner idadeMinJogadorExpsSpinner;
    private JTextField detalheIdadeMinExpsTextField;
    private JSpinner duracaoMinPrtdExpsSpinner;
    private JSpinner duracaoMaxPrtdExpsSpinner;
    private JTextField detalhesDuracaoPrtdExpsTextField;
    private JButton salvarEdiçõesButton;
    private JButton voltarButton;

    public JPanel getPanel1() {
        return panel1;
    }


    public DetalhesExpansao() {
        //identificador do tipo de operação
        System.err.println(expansao);
        nomeExpsTextField.setText(expansao.getNomeExps());
        descricaoExpsTextField.setText(expansao.getDescricaoExps());
        buscarImagemButton.setText(Arrays.toString(expansao.getImagemExps()));
        qtdMinJogadorExpsSpinner.setValue(expansao.getQtdMinJogadorExps());
        qtdMaxJogadorExpsSpinner.setValue(expansao.getQtdMaxJogadorExps());
        detalheQtdJogadorExpsTextField.setText(expansao.getDetalheQtdJogadorExps());
        idadeMinJogadorExpsSpinner.setValue(expansao.getIdadeMinExps());
        detalheIdadeMinExpsTextField.setText(expansao.getDetalheIdadeMinExps());
        duracaoMinPrtdExpsSpinner.setValue(expansao.getDuracaoMinPrtdExps());
        duracaoMaxPrtdExpsSpinner.setValue(expansao.getDuracaoMaxPrtdExps());
        detalhesDuracaoPrtdExpsTextField.setText(expansao.getDetalheDuracaoPrtdExps());



        buscarImagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        salvarEdiçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //Atualizar os valores no objeto jogoBase
                    expansao.setNomeExps(nomeExpsTextField.getText());
                    expansao.setDescricaoExps(descricaoExpsTextField.getText());
                    expansao.setImagemExps(buscarImagemButton.getText().getBytes());
                    expansao.setQtdMinJogadorExps((int)qtdMinJogadorExpsSpinner.getValue());
                    expansao.setQtdMaxJogadorExps((int) qtdMaxJogadorExpsSpinner.getValue());
                    expansao.setDetalheQtdJogadorExps(detalheQtdJogadorExpsTextField.getText());
                    expansao.setIdadeMinExps((int)idadeMinJogadorExpsSpinner.getValue());
                    expansao.setDetalheIdadeMinExps(detalheIdadeMinExpsTextField.getText());
                    expansao.setDuracaoMinPrtdExps((int)duracaoMinPrtdExpsSpinner.getValue());
                    expansao.setDuracaoMaxPrtdExps((int)duracaoMaxPrtdExpsSpinner.getValue());
                    expansao.setDetalheDuracaoPrtdExps(detalhesDuracaoPrtdExpsTextField.getText());

                    var dao = new ExpansaoDAO();
                    dao.atualizar(expansao);

                    JOptionPane.showMessageDialog(null, "Jogo atualizado!");

                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());

                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarExpansao gerenciarExpansao = new GerenciarExpansao();
                Main.updateFrameWithNewPanel(gerenciarExpansao.getPanel1());
            }
        });
    }

}
