package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.DificuldadeDAO;
import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.dao.ModoJogoDAO;
import br.com.catalogodejogos.dao.TipoJogoDAO;
import br.com.catalogodejogos.model.Dificuldade;
import br.com.catalogodejogos.model.JogoBase;
import br.com.catalogodejogos.model.ModoJogo;
import br.com.catalogodejogos.model.TipoJogo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
    private JLabel imagemLabel;
    private JPanel dificuldadePanel;
    private JPanel tipoJogoPanel;
    private JPanel modoJogoPanel;


    public CadastroDeJogosFormularios() {
//        DefaultListModel<JCheckBox> model = new DefaultListModel<>();


        try {
            DificuldadeDAO dao = new DificuldadeDAO();
            TipoJogoDAO tipoDao = new TipoJogoDAO();
            ModoJogoDAO modoDao = new ModoJogoDAO();

            JPanel checkPanel = new JPanel(new GridLayout(0,2));
            dificuldadePanel.add(checkPanel, BorderLayout.CENTER);
            for (Dificuldade dificuldade : dao.ler()) {
                checkPanel.add(new JCheckBox(dificuldade.getDescricaoDificuldadeJogo()));
            }


            JPanel tipoCheckPanel = new JPanel(new GridLayout(0,2));
            tipoJogoPanel.add(tipoCheckPanel, BorderLayout.CENTER);
            for (TipoJogo tipoJogo : tipoDao.ler()) {
                tipoCheckPanel.add(new JCheckBox(tipoJogo.getDescricaoTipoJogo()));
            }

            JPanel modoCheckPanel = new JPanel(new GridLayout(0,2));
            modoJogoPanel.add(modoCheckPanel, BorderLayout.CENTER);
            for (ModoJogo modoJogo : modoDao.ler()) {
                modoCheckPanel.add(new JCheckBox(modoJogo.getDescricaoModoJogo()));
            }

//            dificuldadeJlist.setModel(model);
//            for (Dificuldade dificuldade : dao.ler()) {
//                JCheckBox dificuldadeCheckbox = new JCheckBox(dificuldade.getDescricaoDificuldadeJogo());
//                dificuldadeStates.put(dificuldade.getIdDificuldade(), false);
//                model.addElement(dificuldadeCheckbox);
//            }
//            dificuldadeJlist.setCellRenderer(new CheckboxListCellRenderer(dificuldadeStates));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        processarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Validação de campos obrigatórios:
                String nome = nomeTextField.getText().trim();
                String descricao = descricaoJogoTextField.getText().trim();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo 'Nome' é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (descricao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo 'Descrição' é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
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

                if (qtdMinJog > qtdMaxJog) {
                    JOptionPane.showMessageDialog(null, "Quantidade mínima de jogadores não pode ser maior que a quantidade máxima de jogadores", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (duracaoMin > duracaoMax) {
                    JOptionPane.showMessageDialog(null, "Duração mínima da partida não pode ser maior que a duração máxima da partida", "Erro", JOptionPane.ERROR_MESSAGE);
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
                    JogoBaseDAO dao = new JogoBaseDAO();
                    int idCriado = dao.criar(jogoBase);
                    DificuldadeDAO dificuldadeDao = new DificuldadeDAO();
                    TipoJogoDAO tipoJogoDao = new TipoJogoDAO();
                    ModoJogoDAO modoJogoDao = new ModoJogoDAO();
//                    Dificuldade d = (Dificuldade) dificuldadeComboBox.getSelectedItem();
//                    TipoJogo t = (TipoJogo) tipoJogoComboBox.getSelectedItem();
//                    ModoJogo m = (ModoJogo) modoJogoComboBox.getSelectedItem();
//                    dificuldadeDao.criarAssociacao(d.getIdDificuldade(), idCriado);
//                    tipoJogoDao.criarAssociacao(t.getIdTipoJogo(), idCriado);
//                    modoJogoDao.criarAssociacao(m.getIdModoJogo(), idCriado);
//                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);

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
                JFileChooser chooser = new JFileChooser();
                chooser.showDialog(rootPanel, "teste");
                try {
                    File file = chooser.getSelectedFile();
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image resizedBufferedImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(resizedBufferedImage);
                    imagemLabel.setIcon(imageIcon);
                    System.err.println(file.getAbsolutePath());

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //botão de voltar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(mainPanel);
            }
        });

//        //listener da seleção de checkbox de dificuldade
//        dificuldadeJlist.addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                int index = dificuldadeJlist.getSelectedIndex();
//                if (index != -1) {
//                    JCheckBox checkBox = model.getElementAt(index);
//                    boolean currentState = dificuldadeStates.get(index);
//                    dificuldadeStates.put(index, !currentState);
//                    checkBox.setSelected(!currentState);
//                    dificuldadeJlist.repaint();
//                }
//            }
//        });
    }
        public JPanel getRootPanel () {
            return rootPanel;
        }
}