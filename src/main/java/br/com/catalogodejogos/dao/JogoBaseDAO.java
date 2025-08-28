package br.com.catalogodejogos.dao;


import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.JogoBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogoBaseDAO {


    public int criar (JogoBase jogobase) throws SQLException{
        //String sql = "INSERT INTO tb_jogo_base (nome, qtd_min_jogador, qtd_max_jogador, detalhe_qtd_jogador, idade_min, detalhe_idade_min, duracao_min_prtd, duracao_max_prtd, detalhe_duracao_prtd, comentarios) VALUES (teste, 2, 2, teste, 2, teste, 2, 2, teste, teste)";
        String sql = "INSERT INTO tb_jogo_base (nome, qtd_min_jogador, qtd_max_jogador, detalhe_qtd_jogador, idade_min, detalhe_idade_min, duracao_min_prtd, duracao_max_prtd, detalhe_duracao_prtd, comentarios, descricao_jogo_base) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
        ResultSet generatedKeys = statement.getGeneratedKeys();

        int i = 0;
        if (generatedKeys.next()){
            i = generatedKeys.getInt(1);
        }
        statement.close();
        return i;
    }

    public List<JogoBase> ler() throws SQLException{
        List<JogoBase> listjogobase = new ArrayList<>();
        String sql = "SELECT * FROM tb_jogo_base";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
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
        try(PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql)){
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
        String sql = "UPDATE tb_jogo_base SET nome = ?, descricao_jogo_base =?, imagem = ?, qtd_min_jogador = ?, qtd_max_jogador = ?, detalhe_qtd_jogador = ? , idade_min = ?, detalhe_idade_min = ?, duracao_min_prtd = ?, duracao_max_prtd = ?, detalhe_duracao_prtd = ?,  comentarios = ? WHERE id_jogo = ?";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
        statement.setString(1, jogobase.getNome());
        statement.setString(2, jogobase.getDescricaoJogo());
        statement.setBytes(3, jogobase.getImagem());
        statement.setInt(4, jogobase.getQtdMinJogador());
        statement.setInt(5, jogobase.getQtdMaxJogador());
        statement.setString(6, jogobase.getDetalheQtdJogador());
        statement.setInt(7, jogobase.getIdadeMin());
        statement.setString(8, jogobase.getDetalheIdadeMin());
        statement.setInt(9, jogobase.getDuracaoMinPrtd());
        statement.setInt(10, jogobase.getDuracaoMaxPrtd());
        statement.setString(11, jogobase.getDetalheDuracaoPrtd());
        statement.setString(12, jogobase.getComentarios());
        statement.setInt(13, jogobase.getIdJogo());

        statement.executeUpdate();

    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_jogo_base WHERE id_jogo = ?";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }



}
