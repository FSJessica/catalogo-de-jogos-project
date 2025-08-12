package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.model.Expansao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    ExpansaoDAO {
    private Connection connection;

    public ExpansaoDAO(Connection connection){
        this.connection = connection;

    }

    public void criar (Expansao expansao) throws SQLException{
        String sql = "INSERT INTO tb_expansao (nome_exps, descricao_exps, qtd_min_jogador_exps, qtd_max_jogadpr_exps, detalhe_qtd_jogador_exps, idade_min_exps, detalhe_idade_min_exps, duracao_min_prtd_exps, duracao_max_prtd_exps, detalhe_duracao_prtd_exps, id_jogo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, expansao.getNomeExps());
        statement.setString(2, expansao.getDescricaoExps());
        statement.setShort(3, expansao.getQtdMinJogadorExps());
        statement.setShort(4, expansao.getQtdMaxJogadorExps());
        statement.setString(5, expansao.getDetalheQtdJogadorExps());
        statement.setShort(6, expansao.getIdadeMinExps());
        statement.setString(7, expansao.getDetalheIdadeMinExps());
        statement.setShort(8, expansao.getDuracaoMinPrtdExps());
        statement.setShort(9, expansao.getDuracaoMaxPrtdExps());
        statement.setString(10, expansao.getDetalheDuracaoPrtdExps());
        statement.setInt(11,expansao.getIdJogo());
        statement.executeUpdate();
        statement.close();
    }

    public List<Expansao> ler() throws SQLException{
        List<Expansao> listExpansao = new ArrayList<>();
        String sql = "SELECT * FROM tb_expansao";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Expansao exp = new Expansao();
            exp.setIdExpansao(resultSet.getInt("id_expansao"));
            exp.setNomeExps(resultSet.getString("nome_exps"));
            exp.setDescricaoExps(resultSet.getString("descricao_exps"));
            exp.setQtdMinJogadorExps(resultSet.getShort("qtd_min_jogador_exps"));
            exp.setQtdMaxJogadorExps(resultSet.getShort("qtd_max_jogadpr_exps"));
            exp.setDetalheQtdJogadorExps(resultSet.getString("detalhe_qtd_jogador_exps"));
            exp.setIdadeMinExps(resultSet.getShort("idade_min_exps"));
            exp.setDetalheIdadeMinExps(resultSet.getString("detalhe_idade_min_exps"));
            exp.setDuracaoMinPrtdExps(resultSet.getShort("duracao_min_prtd_exps"));
            exp.setDuracaoMaxPrtdExps(resultSet.getShort("duracao_max_prtd_exps"));
            exp.setDetalheDuracaoPrtdExps(resultSet.getString("detalhe_duracao_prtd_exps"));
            listExpansao.add(exp);
        }
        return listExpansao;
    }

    public List<Expansao> lerPorJogo(int idJogo) throws SQLException {
        List<Expansao> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_expansao WHERE id_jogo = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idJogo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Expansao expansao = new Expansao();
            expansao.setIdExpansao(rs.getInt("id_expansao"));
            expansao.setNomeExps(rs.getString("nome_exps"));
            expansao.setDescricaoExps(rs.getString("descricao_exps"));
            lista.add(expansao);
        }
        return lista;
    }

    public void atualizar (Expansao expansao) throws SQLException{
        String sql = "UPDATE tb_expansao SET nome_exps = ?, detalhe_qtd_jogador_exps = ? WHERE id_expansao = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, expansao.getNomeExps());
        statement.setString(2, expansao.getDetalheQtdJogadorExps());
        statement.setInt(3, expansao.getIdExpansao());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_expansao WHERE id_expansao = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
