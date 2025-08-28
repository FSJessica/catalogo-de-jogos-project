package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;
import br.com.catalogodejogos.dao.ExpansaoDAO;
import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.Expansao;
import br.com.catalogodejogos.model.JogoBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.catalogodejogos.util.Constants.jogoBase;
import static br.com.catalogodejogos.util.Constants.expansao;


public class GerenciarExpansao extends JPanel{
    private JPanel panel1;
    private JTable table1;
    private JButton voltarButton;
    private JButton inserirExpansaoButton;
    private JButton verDetalhesDaExpansaoButton;
    private JButton deletarExpansaoButton;
    private List<Expansao> listExpansao;


    public JPanel getPanel1(){
        return panel1;
    }

    public GerenciarExpansao() {
        // Adiciona o panel1 (criado pelo GUI Designer) a este JPanel
        this.setLayout(new java.awt.BorderLayout());
        this.add(panel1, java.awt.BorderLayout.CENTER);


        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Descrição"}, 0);
        try {
            ExpansaoDAO dao = new ExpansaoDAO();
            listExpansao = dao.lerPorJogo(jogoBase.getIdJogo());

            for(Expansao expansao1 : listExpansao){
                model.addRow(new Object[]{
                        expansao1.getIdExpansao(),
                        expansao1.getNomeExps(),
                        expansao1.getDescricaoExps()
                });
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));


        inserirExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.updateFrameWithNewPanel(new CadastrarExpansao().getPanel1());

            }
        });
        verDetalhesDaExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Selecione uma expansão na tabela primeiro!");
                    return;
                }

                int idSelecionado = (int) table1.getModel().getValueAt(selectedRow, 0);

                try{
                    ExpansaoDAO dao = new ExpansaoDAO();
                    // setando variável global jogoBase pra ser o jogo que eu busquei pelo idSelecionado abaixo
                    expansao = dao.buscarExpansao(idSelecionado);

                    if (expansao != null) {
                        Main.updateFrameWithNewPanel(new DetalhesExpansao().getPanel1());
                    } else {
                        JOptionPane.showMessageDialog(null, "Expansão não encontrada no banco de dados.");
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao buscar expansão.");
                }
            }
        });
        deletarExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Selecione uma expansão para deletar.");
                    return;
                }
                //Telinha de confirmação
                int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa expansão?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if(confirmar == JOptionPane.YES_OPTION){
                    int idSelecionado = (int) table1.getModel().getValueAt(selectedRow, 0);

                    try{
                        ExpansaoDAO dao = new ExpansaoDAO();
                        dao.deletar(idSelecionado);

                        //Remove da tabela
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(null, "Expansão deletada!");
                    } catch (SQLException ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao tentar deletar: " + ex.getMessage());
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetalhesJogos detalhesJogos = new DetalhesJogos();
                Main.updateFrameWithNewPanel(detalhesJogos.getPanel1());
            }
        });
    }
}
