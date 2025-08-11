package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.catalogodejogos.dao.JogoBaseDAO;
import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.JogoBase;

public class VerListaJogos extends JPanel {
    private JTable table1;
    private JPanel panel1;
    private JButton maisDetalhesButton;
    private JButton voltarButton;
    private JButton deletarButton;

    public VerListaJogos(){
        List<JogoBase> listaJogos = new ArrayList<>();
        try{
            Connection conexao = DataBaseConnection.getconnection();
            JogoBaseDAO dao = new JogoBaseDAO(conexao);
            listaJogos = dao.ler();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar jogos no banco: " + ex.getMessage());
            ex.printStackTrace();
        }

//        //Preencher dados com base na lista
//        String[][] dados = new String[listaJogos.size()][2];
//        for(int i = 0; i<listaJogos.size(); i++){
//            dados [i] [0] = listaJogos.get(i).getNome();
//            dados [i] [1] = listaJogos.get(i).getDescricaoJogo();
//        }

        List<JogoBase> jogos;
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Descrição"}, 0);
        try {
            Connection conexao = DataBaseConnection.getconnection();
            JogoBaseDAO dao = new JogoBaseDAO(conexao);
            jogos = dao.ler();

            for(JogoBase jogo : jogos){
                model.addRow(new Object[]{jogo.getIdJogo(), jogo.getNome(), jogo.getDescricaoJogo()});
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));


//        //Modelo da tabela(impede edição de células)
//        DefaultTableModel modelBd = new DefaultTableModel(dados, cabecalho){
//            @Override
//            public boolean isCellEditable(int column, int row) {
//                return false;
//            }
//        };
//        table1.setModel(modelBd);

        //ação do botão "mais detalhes"
        maisDetalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Selecione um jogo na tabela primeiro!");
                    return;
                }

                int idSelecionado = (int) table1.getModel().getValueAt(selectedRow, 0);

                try{
                    Connection conexao = DataBaseConnection.getconnection();
                    JogoBaseDAO dao = new JogoBaseDAO(conexao);
                    JogoBase jogo = dao.buscarPorId(idSelecionado);

                    if (jogo != null) {
                        Main.updateFrameWithNewPanel(new DetalhesJogos(jogo).getPanel1());
                    } else {
                        JOptionPane.showMessageDialog(null, "Jogo não encontrado no banco de dados.");
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao buscar jogo.");
                }
//
//                String nomeJogo = table1.getValueAt(table1.getSelectedRow(),0).toString();
//                String descricaoJogo = table1.getValueAt(table1.getSelectedRow(),1).toString();

//                //DEBUG verificar se está recebendo os dados certos:
//                System.out.println("Selecionado: " + nomeJogo + " - " + descricaoJogo);
//                System.out.println("Botão clicado");
//                System.out.println("Selecionado: " + nomeJogo + ", " + descricaoJogo);
//
//                //Cria o painel de detalhes com os dados
//                //DetalhesJogos detalhes = new DetalhesJogos(nomeJogo, descricaoJogo);
//                Main.updateFrameWithNewPanel(new DetalhesJogos(nomeJogo, descricaoJogo).getPanel1());

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Main.updateFrameWithNewPanel(new MainPanel());
            }
        });
        // No TabelaPanel.form está a visualização gráfica de como o painel irá se comportar. Depois disso
        // chamo o método da classe main para atualizar o frame com o meu novo painel.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(panel1);

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Selecione um jogo para deletar.");
                    return;
                }
                //Telinha de confirmação
                int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este jogo?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if(confirmar == JOptionPane.YES_OPTION){
                    int idSelecionado = (int) table1.getValueAt(selectedRow, 0);

                    try{
                        Connection connection = DataBaseConnection.getconnection();
                        JogoBaseDAO dao = new JogoBaseDAO(connection);
                        dao.deletar(idSelecionado);

                        //Remove da tabela
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(null, "Jogo deletado!");
                    } catch (SQLException ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro oao tentar deletar: " + ex.getMessage());
                    }
                }
            }
        });
    }

}
