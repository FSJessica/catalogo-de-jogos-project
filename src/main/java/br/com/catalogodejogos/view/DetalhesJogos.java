package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.model.JogoBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static br.com.catalogodejogos.infra.DataBaseConnection.getconnection;
import static br.com.catalogodejogos.util.Constants.jogoBase;

public class DetalhesJogos extends JPanel{

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
    private JButton GerenciarExpansaoButton;

    public JPanel getPanel1(){
        return panel1;
    }
    //identificador do tipo de operação
    public DetalhesJogos () {
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
                try{
                    //Atualizar os valores no objeto jogoBase
                    jogoBase.setNome(nomeTextField.getText());
                    jogoBase.setDescricaoJogo(descricaoTextField.getText());
                    jogoBase.setImagem(imagemTextField.getText().getBytes());
                    jogoBase.setQtdMinJogador(Integer.parseInt(qtdMinJogadorTextField.getText()));
                    jogoBase.setQtdMaxJogador(Integer.parseInt(qtdMaxJogadorTextField.getText()));
                    jogoBase.setDetalheQtdJogador(detalheQtdJogadorTextField.getText());
                    jogoBase.setIdadeMin(Integer.parseInt(idadeMinTextField.getText()));
                    jogoBase.setDetalheIdadeMin(detalheIdadeMinTextField.getText());
                    jogoBase.setDuracaoMinPrtd(Integer.parseInt(duracaoMinPrtdTextField.getText()));
                    jogoBase.setDuracaoMaxPrtd(Integer.parseInt(duracaoMaxPrtdTextField.getText()));
                    jogoBase.setDetalheDuracaoPrtd(detalheDuracaoPrtdTextField.getText());
                    jogoBase.setComentarios(comentariosTextField.getText());

                    var dao = new JogoBaseDAO();
                    dao.atualizar(jogoBase);

                    JOptionPane.showMessageDialog(null, "Jogo atualizado!");

                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());

                }
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
        GerenciarExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarExpansao gerenciarExpansao = new GerenciarExpansao();
                Main.updateFrameWithNewPanel(gerenciarExpansao);

            }
        });
    }
}
