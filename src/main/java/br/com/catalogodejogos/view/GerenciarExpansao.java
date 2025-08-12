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

public class GerenciarExpansao extends JPanel{
    private JPanel panel1;
    private JTable table1;
    private JButton voltarButton;
    private JButton inserirExpansaoButton;
    private JButton verDetalhesDaExpansaoButton;
    private JButton deletarExpansaoButton;

    public GerenciarExpansao(JogoBase jogoBase) {
        // Adiciona o panel1 (criado pelo GUI Designer) a este JPanel
        this.setLayout(new java.awt.BorderLayout());
        this.add(panel1, java.awt.BorderLayout.CENTER);

        List<Expansao> listaExpansaos = new ArrayList<>();
        try{
            Connection conexao = DataBaseConnection.getconnection();
            ExpansaoDAO dao = new ExpansaoDAO(conexao);
            listaExpansaos = dao.ler();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar expansão no banco: " + ex.getMessage());
            ex.printStackTrace();
        }

//        // Configura modelo inicial da tabela
//        String[] colunas = {"ID", "Nome da Expansão", "Descrição"};
//        Object[][] dados = {
//                {1, "Expansão 1", "Expansão contém novas cartas"},
//                {2, "Expansão 2", "Expansão contém novos personagens e novas cartas"}
//        };
//        table1.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));

        List<Expansao> expansao;
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Descrição"}, 0);
        try {
            Connection conexao = DataBaseConnection.getconnection();
            ExpansaoDAO dao = new ExpansaoDAO(conexao);
            expansao = dao.lerPorJogo(jogoBase.getIdJogo());

            for(Expansao expansao1 : expansao){
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

            }
        });
        deletarExpansaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetalhesJogos detalhesJogos = new DetalhesJogos(jogoBase);
                Main.updateFrameWithNewPanel(detalhesJogos.getPanel1());
            }
        });
    }
}
