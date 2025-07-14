package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.model.Partida;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {
    private Connection connection;

    public PartidaDAO(Connection connection){
        this.connection = connection;

    }

    public void criar (Partida partida) throws SQLException{
        String sql = "INSERT INTO tb_partida (data_prtd, duracao_prtd, qtd_jogador_prtd, participantes_prtd, vencedor, comentario_prtd) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, Date.valueOf(partida.getData().toString()));
        statement.setShort(2, partida.getDuracao());
        statement.setShort(3, partida.getQtdJogadorPrtd());
        statement.setString(4, partida.getParticipantesPrtd());
        statement.setString(5, partida.getVencedor());
        statement.setString(6, partida.getComentarioPrtd());
        statement.executeUpdate();
        statement.close();
    }

    public List<Partida> ler() throws SQLException{
        List<Partida> listPartidas = new ArrayList<>();
        String sql = "SELECT * FROM tb_partida";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Partida ptd = new Partida();
            ptd.setIdPartida(resultSet.getInt("id_partida"));
            ptd.setData(LocalDateTime.ofInstant(resultSet.getDate("data_prtd").toInstant(), ZoneId.systemDefault()));
            ptd.setDuracao(resultSet.getShort("duracao_prtd"));
            ptd.setQtdJogadorPrtd(resultSet.getShort("qtd_jogador_prtd"));
            ptd.setParticipantesPrtd(resultSet.getString("participantes_prtd"));
            ptd.setVencedor(resultSet.getString("vencedor"));
            ptd.setComentarioPrtd(resultSet.getString("comentario_prtd"));
            listPartidas.add(ptd);
        }
        return listPartidas;
    }

    public void atualizar (Partida partida) throws SQLException{
        String sql = "UPDATE tb_partida SET data_prtd = ?, qtd_jogador_prtd = ? WHERE id_partida = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, Date.valueOf(partida.getData().toString()));
        statement.setInt(2, partida.getQtdJogadorPrtd());
        statement.setInt(3, partida.getIdPartida());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_partida WHERE id_partida =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
