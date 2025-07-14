package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.model.Dificuldade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DificuldadeDAO {
    private Connection connection;

    public DificuldadeDAO(Connection connection){
        this.connection = connection;
    }

    public void criar (Dificuldade dificuldade) throws SQLException{
        String sql = "INSERT INTO tb_dificuldade (descricao_dificuldade_jogo) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dificuldade.getDescricaoDificuldadeJogo());
        statement.executeUpdate();
        statement.close();
    }

    public List<Dificuldade> ler() throws SQLException{
        List<Dificuldade> listDificuldade = new ArrayList<>();
        String sql = "SELECT * FROM tb_dificuldade";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Dificuldade df = new Dificuldade();
            df.setIdDificuldade(resultSet.getInt("id_dificuldade"));
            df.setDescricaoDificuldadeJogo(resultSet.getString("descricao_dificuldade_jogo"));
            listDificuldade.add(df);
        }
        return listDificuldade;
    }

    public void atualizar(Dificuldade dificuldade) throws SQLException{
        String sql = "UPDATE tb_dificuldade SET descricao_dificuldade_jogo = ? WHERE id_dificuldade = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dificuldade.getDescricaoDificuldadeJogo());
        statement.setInt(2, dificuldade.getIdDificuldade());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_dificuldade WHERE id_dificuldade = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
