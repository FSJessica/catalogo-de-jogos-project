package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.model.TipoJogo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoJogoDAO {
    private Connection connection;

    public TipoJogoDAO(Connection connection){
        this.connection = connection;
    }

    public void criar (TipoJogo tipoJogo) throws SQLException{
        String sql = "INSERT INTO tb_tipo_jogo (descricao_tipo_jogo) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipoJogo.getDescricaoTipoJogo());
        statement.executeUpdate();

        statement.close();


    }

    public List<TipoJogo> ler() throws SQLException{
        List<TipoJogo> listTipoJogo = new ArrayList<>();
        String sql = "SELECT * FROM tb_tipo_jogo";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            TipoJogo tp = new TipoJogo();
            tp.setIdTipoJogo(resultSet.getInt("id_tipo_jogo"));
            tp.setDescricaoTipoJogo(resultSet.getString("descricao_tipo_jogo"));
            listTipoJogo.add(tp);
        }
        return listTipoJogo;
    }

    public void atualizar(TipoJogo tipoJogo) throws SQLException{
        String sql = "UPDATE tb_tipo_jogo SET descricao_tipo_jogo = ? WHERE id_tipo_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipoJogo.getDescricaoTipoJogo());
        statement.setInt(2, tipoJogo.getIdTipoJogo());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_tipo_jogo WHERE id_tipo_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
