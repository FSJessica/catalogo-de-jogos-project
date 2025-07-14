package br.com.catalogodejogos.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoDeJogosGui extends JFrame {
    private JPanel panelMain;
    private JButton cadastrarNovoJogoButton;
    private JButton verJogosCadastradosButton;
    private JPanel panelConteudo;

    private CardLayout layoutConteudo;
    private JPanel telaCadastro;
    private JPanel telaListagem;

    //Construtor principal
    public CatalogoDeJogosGui() {
        setContentPane(panelMain);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        //configurando o layout manualmente
        panelConteudo.setLayout(new CardLayout());
        //guardar cardlayout numa variavel
        layoutConteudo = (CardLayout) panelConteudo.getLayout();
        //Criar e adicionar subtelas com nomes
        inicializarSubtelas();

        //Listener do botão de cadastro
        cadastrarNovoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutConteudo.show(panelConteudo, "cadastro"); //mostrar tela de cadastro
            }
        });
        verJogosCadastradosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutConteudo.show(panelConteudo,"lista"); //mostra tela de lista

            }
        });
    }

    //métod que cria os painéis que vão aparecer no CardLayout
    private void inicializarSubtelas(){
        telaCadastro = new JPanel();
        telaCadastro.add(new JLabel("\uD83C\uDFB2 Tela de Cadastro para novo jogo."));

        telaListagem = new JPanel();
        telaListagem.add(new JLabel("\uD83E\uDDE9 Lista de Jogos Cadastrados."));

        //adiciona ao painel que usa CardLayout, com "nomes" para alterar depois.
        panelConteudo.add(telaCadastro, "cadastro");
        panelConteudo.add(telaListagem, "lista");

//        //abrir isso em um JFrame
//        public JPanel getPanel() {
//            return panelMain;
//        }
    }
}
