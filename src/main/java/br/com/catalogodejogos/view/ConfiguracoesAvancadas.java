package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.DificuldadeDAO;
import br.com.catalogodejogos.dao.ModoJogoDAO;
import br.com.catalogodejogos.dao.TipoJogoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConfiguracoesAvancadas extends JPanel{

    private JPanel panel1;
    private JTextField novaDificuldadeTextField;
    private JTextField novoModoJogoTextField;
    private JTextField novoTipoJogoTextField;
    private JButton salvarButton;
    private JButton voltarButton;
    private JPanel rootPanel;

    public ConfiguracoesAvancadas() {
        this.setLayout(new java.awt.BorderLayout());
        this.add(panel1, java.awt.BorderLayout.CENTER);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean salvou = false;
                    //if novaDificuldadeTextField.getText() diferente vazio
                    if (!novaDificuldadeTextField.getText().isEmpty()){
                        DificuldadeDAO dificuldadeDAO = new DificuldadeDAO();
                        dificuldadeDAO.criar(novaDificuldadeTextField.getText());
                        salvou = true;
                    }

                    if(!novoModoJogoTextField.getText().isEmpty()){
                        ModoJogoDAO modoJogoDAO = new ModoJogoDAO();
                        modoJogoDAO.criar(novoModoJogoTextField.getText());
                        salvou = true;
                    }

                    if(!novoTipoJogoTextField.getText().isEmpty()){
                        TipoJogoDAO tipoJogoDAO = new TipoJogoDAO();
                        tipoJogoDAO.criar(novoTipoJogoTextField.getText());
                        salvou = true;
                    }


                   if (salvou) {
                       JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);
                   }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(mainPanel);
            }
        });
    }
}
