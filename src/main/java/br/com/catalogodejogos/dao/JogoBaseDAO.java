package br.com.catalogodejogos.dao;


import br.com.catalogodejogos.model.JogoBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogoBaseDAO {
    private Connection connection;

    public JogoBaseDAO(Connection connection){
        this.connection = connection;

    }

    public void criar (JogoBase jogobase) throws SQLException{
        //String sql = "INSERT INTO tb_jogo_base (nome, qtd_min_jogador, qtd_max_jogador, detalhe_qtd_jogador, idade_min, detalhe_idade_min, duracao_min_prtd, duracao_max_prtd, detalhe_duracao_prtd, comentarios) VALUES (teste, 2, 2, teste, 2, teste, 2, 2, teste, teste)";
        String sql = "INSERT INTO tb_jogo_base (nome, qtd_min_jogador, qtd_max_jogador, detalhe_qtd_jogador, idade_min, detalhe_idade_min, duracao_min_prtd, duracao_max_prtd, detalhe_duracao_prtd, comentarios, descricao_jogo_base) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, jogobase.getNome());
        statement.setInt(2,jogobase.getQtdMinJogador());
        statement.setInt(3, jogobase.getQtdMaxJogador());
        statement.setString(4, jogobase.getDetalheQtdJogador());
        statement.setInt(5, jogobase.getIdadeMin());
        statement.setString(6, jogobase.getDetalheIdadeMin());
        statement.setInt(7, jogobase.getDuracaoMinPrtd());
        statement.setInt(8, jogobase.getDuracaoMaxPrtd());
        statement.setString(9, jogobase.getDetalheDuracaoPrtd());
        statement.setString(10, jogobase.getComentarios());
        statement.setString(11, jogobase.getDescricaoJogo());
        statement.executeUpdate();
        statement.close();
    }

    public List<JogoBase> ler() throws SQLException{
        List<JogoBase> listjogobase = new ArrayList<>();
        String sql = "SELECT * FROM tb_jogo_base";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            JogoBase jb = new JogoBase();
            jb.setIdJogo(resultSet.getInt("id_jogo")); //fazer isso em todos
            jb.setNome(resultSet.getString("nome"));
            jb.setQtdMinJogador(resultSet.getInt("qtd_min_jogador"));
            jb.setQtdMaxJogador(resultSet.getInt("qtd_max_jogador"));
            jb.setDetalheQtdJogador(resultSet.getString("detalhe_qtd_jogador"));
            jb.setIdadeMin(resultSet.getInt("idade_min"));
            jb.setDetalheIdadeMin(resultSet.getString("detalhe_idade_min"));
            jb.setDuracaoMinPrtd(resultSet.getInt("duracao_min_prtd"));
            jb.setDuracaoMaxPrtd(resultSet.getInt("duracao_max_prtd"));
            jb.setDetalheDuracaoPrtd(resultSet.getString("detalhe_duracao_prtd"));
            jb.setComentarios(resultSet.getString("comentarios"));
            jb.setDescricaoJogo(resultSet.getString("descricao_jogo_base"));
            listjogobase.add(jb);
        }
        return listjogobase;
    }

    public JogoBase buscarPorId(int id) throws SQLException{
        String sql = "SELECT * FROM tb_jogo_base WHERE id_jogo = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            try (ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    JogoBase jogoBase = new JogoBase();
                    jogoBase.setIdJogo(rs.getInt("id_jogo"));
                    jogoBase.setNome(rs.getString("nome"));
                    jogoBase.setQtdMinJogador(rs.getInt("qtd_min_jogador"));
                    jogoBase.setQtdMaxJogador(rs.getInt("qtd_max_jogador"));
                    jogoBase.setDetalheQtdJogador(rs.getString("detalhe_qtd_jogador"));
                    jogoBase.setIdadeMin(rs.getInt("idade_min"));
                    jogoBase.setDetalheIdadeMin(rs.getString("detalhe_idade_min"));
                    jogoBase.setDuracaoMinPrtd(rs.getInt("duracao_min_prtd"));
                    jogoBase.setDuracaoMaxPrtd(rs.getInt("duracao_max_prtd"));
                    jogoBase.setDetalheDuracaoPrtd(rs.getString("detalhe_duracao_prtd"));
                    jogoBase.setComentarios(rs.getString("comentarios"));
                    jogoBase.setDescricaoJogo(rs.getString("descricao_jogo_base"));
                    return jogoBase;

                }
            }
        }
        return null;
    }

    public void atualizar(JogoBase jogobase) throws  SQLException{
        String sql = "UPDATE tb_jogo_base SET nome = ?, detalhe_qtd_jogador = ? WHERE id_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, jogobase.getNome());
        statement.setString(2, jogobase.getDetalheQtdJogador());
        statement.setInt(3, jogobase.getIdJogo());
        statement.executeUpdate();

    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_jogo_base WHERE id_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }




}
