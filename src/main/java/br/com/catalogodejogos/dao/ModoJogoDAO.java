package br.com.catalogodejogos.dao;

import br.com.catalogodejogos.model.ModoJogo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModoJogoDAO {
    private Connection connection;

    public ModoJogoDAO(Connection connection){
        this.connection = connection;
    }

    public void criar (ModoJogo modoJogo) throws SQLException{
        String sql = "INSERT INTO tb_modo_jogo (descricao_modo_jogo) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, modoJogo.getDescricaoModoJogo());
        statement.executeUpdate();
        statement.close();
    }

    public List<ModoJogo> ler() throws SQLException {
        List<ModoJogo> listModoJogo = new ArrayList<>();
        String sql = "SELECT * FROM tb_modo_jogo";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            ModoJogo md = new ModoJogo();
            md.setIdModoJogo(resultSet.getInt("id_modo_jogo"));
            md.setDescricaoModoJogo(resultSet.getString("descricao_modo_jogo"));
            listModoJogo.add(md);
        }
        return listModoJogo;
    }

    public void atualizar(ModoJogo modoJogo) throws SQLException{
        String sql = "UPDATE tb_modo_jogo SET descricao_modo_jogo = ? WHERE id_modo_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, modoJogo.getDescricaoModoJogo());
        statement.setInt(2, modoJogo.getIdModoJogo());
        statement.executeUpdate();
    }

    public void deletar (int id) throws SQLException{
        String sql = "DELETE FROM tb_modo_jogo WHERE id_modo_jogo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
