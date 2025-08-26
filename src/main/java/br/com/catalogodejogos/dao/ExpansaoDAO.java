package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.infra.DataBaseConnection;
import br.com.catalogodejogos.model.Expansao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    ExpansaoDAO {

    public void criar (Expansao expansao) throws SQLException{
        String sql = "INSERT INTO tb_expansao (nome_exps, descricao_exps, qtd_min_jogador_exps, qtd_max_jogador_exps, detalhe_qtd_jogador_exps, idade_min_exps, detalhe_idade_min_exps, duracao_min_prtd_exps, duracao_max_prtd_exps, detalhe_duracao_prtd_exps, id_jogo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
        statement.setString(1, expansao.getNomeExps());
        statement.setString(2, expansao.getDescricaoExps());
        statement.setInt(3, expansao.getQtdMinJogadorExps());
        statement.setInt(4, expansao.getQtdMaxJogadorExps());
        statement.setString(5, expansao.getDetalheQtdJogadorExps());
        statement.setInt(6, expansao.getIdadeMinExps());
        statement.setString(7, expansao.getDetalheIdadeMinExps());
        statement.setInt(8, expansao.getDuracaoMinPrtdExps());
        statement.setInt(9, expansao.getDuracaoMaxPrtdExps());
        statement.setString(10, expansao.getDetalheDuracaoPrtdExps());
        statement.setInt(11,expansao.getIdJogo());
        statement.executeUpdate();
        statement.close();
    }

    public List<Expansao> lerPorJogo(int idJogo) throws SQLException {
        List<Expansao> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_expansao WHERE id_jogo = ?";
        PreparedStatement stmt = DataBaseConnection.getconnection().prepareStatement(sql);
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

    public Expansao buscarExpansao (int idExpansao) throws SQLException{
        String sql = "SELECT * FROM tb_expansao WHERE id_expansao = ?";
        PreparedStatement stmt = DataBaseConnection.getconnection().prepareStatement(sql);
        stmt.setInt(1, idExpansao);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Expansao expansao = new Expansao();
            expansao.setIdExpansao(rs.getInt("id_expansao"));
            expansao.setNomeExps(rs.getString("nome_exps"));
            expansao.setDescricaoExps(rs.getString("descricao_exps"));
//            expansao.setImagemExps(rs.getString("descricao_exps"));
            expansao.setQtdMinJogadorExps(rs.getInt("qtd_min_jogador_exps"));
            expansao.setQtdMaxJogadorExps(rs.getInt("qtd_max_jogador_exps"));
            expansao.setDetalheQtdJogadorExps(rs.getString("detalhe_qtd_jogador_exps"));
            expansao.setIdadeMinExps(rs.getInt("idade_min_exps"));
            expansao.setDetalheIdadeMinExps(rs.getString("detalhe_idade_min_exps"));
            expansao.setDuracaoMinPrtdExps(rs.getInt("duracao_min_prtd_exps"));
            expansao.setDuracaoMaxPrtdExps(rs.getInt("duracao_max_prtd_exps"));
            expansao.setDetalheDuracaoPrtdExps(rs.getString("detalhe_duracao_prtd_exps"));


            return expansao;
        }
        return null;
    }

    public void atualizar (Expansao expansao) throws SQLException{
        String sql = "UPDATE tb_expansao SET nome_exps = ?,descricao_exps = ?, imagem_exps=?, qtd_min_jogador_exps =?, qtd_max_jogador_exps = ?, detalhe_qtd_jogador_exps = ?, idade_min_exps = ?, detalhe_idade_min_exps = ?, duracao_min_prtd_exps = ?, duracao_max_prtd_exps = ?, detalhe_duracao_prtd_exps = ? WHERE id_expansao = ?";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
        statement.setString(1, expansao.getNomeExps());
        statement.setString(2, expansao.getDescricaoExps());
        statement.setBytes(3, expansao.getImagemExps());
        statement.setInt(4, expansao.getQtdMinJogadorExps());
        statement.setInt(5, expansao.getQtdMaxJogadorExps());
        statement.setString(6, expansao.getDetalheQtdJogadorExps());
        statement.setInt(7, expansao.getIdadeMinExps());
        statement.setString(8, expansao.getDetalheIdadeMinExps());
        statement.setInt(9, expansao.getDuracaoMinPrtdExps());
        statement.setInt(10, expansao.getDuracaoMaxPrtdExps());
        statement.setString(11, expansao.getDetalheDuracaoPrtdExps());
        statement.setInt(12, expansao.getIdExpansao());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_expansao WHERE id_expansao = ?";
        PreparedStatement statement = DataBaseConnection.getconnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
