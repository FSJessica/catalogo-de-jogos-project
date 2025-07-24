package br.com.catalogodejogos.view;

import br.com.catalogodejogos.app.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.com.catalogodejogos.view.MainPanel.updateFrameWithNewPanel;

public class VerListaJogos extends JPanel {
    private JTable table1;
    private JPanel panel1;
    private JButton maisDetalhesButton;
    private JButton voltarButton;

    public VerListaJogos(){
        //criando array de string para funcionar como o cabeçalho da tabela.
        String [] cabecalho = new String [] {"Jogo", "Categoria"};
                
        //Matriz pra comportar os dados da tabela.
        String [] [] dados = new String[][]{
                {"Jogo 1", "party game"},
                {"Jogo 2", "Estratégia"},
                {"Jogo 3", "Cooperativo"}
        };


        //Modelo da tabela(impede edição de células)
        DefaultTableModel model = new DefaultTableModel(dados, cabecalho){
            @Override
            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        table1.setModel(model);

        //ação do botão "mais detalhes"
        maisDetalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(null, "Selecione um jogo na tabela primeiro!");
                    return;
                }

                String nomeJogo = table1.getValueAt(table1.getSelectedRow(),0).toString();
                String descricaoJogo = table1.getValueAt(table1.getSelectedRow(),1).toString();

                //DEBUG verificar se está recebendo os dados certos:
                System.out.println("Selecionado: " + nomeJogo + " - " + descricaoJogo);
                System.out.println("Botão clicado");
                System.out.println("Selecionado: " + nomeJogo + ", " + descricaoJogo);

                //Cria o painel de detalhes com os dados
                //DetalhesJogos detalhes = new DetalhesJogos(nomeJogo, descricaoJogo);
                Main.updateFrameWithNewPanel(new DetalhesJogos(nomeJogo, descricaoJogo).getPanel1());

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
//                MainPanel mainPanel = new MainPanel();
                Main.updateFrameWithNewPanel(new MainPanel());
            }
        });
        // No TabelaPanel.form está a visualização gráfica de como o painel irá se comportar. Depois disso
        // chamo o método da classe main para atualizar o frame com o meu novo painel.
//        updateFrameWithNewPanel(VerListaJogos);
//        add(panel1);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(panel1);
    }

}
