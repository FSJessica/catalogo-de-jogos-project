package br.com.catalogodejogos.app;
import br.com.catalogodejogos.dao.*;
import br.com.catalogodejogos.model.*;
import br.com.catalogodejogos.infra.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestarCrud {
    public static void main(String[] args) {
        try (Connection conn = DataBaseConnection.getconnection()) {
//            testaJogo(conn);
//            testaDificuldade(conn);
//            testaExpansao(conn);
//            testaModoJogo(conn);
            testaTipoJogo(conn);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testaTipoJogo(Connection conn) throws SQLException {
        TipoJogoDAO dao = new TipoJogoDAO(conn);

        // Inserir
        TipoJogo novo = new TipoJogo();
        novo.setDescricaoTipoJogo("deeeeeeeeescricaotiiiiiiiiiiiipojoooooooogo");
        dao.criar(novo);
        System.out.println(" ok!");

        // Buscar primeiro dado inserido de cada tabela
        TipoJogo tipoJogo = dao.ler().getFirst();
        JogoBaseDAO jbDao = new JogoBaseDAO(conn);
        JogoBase jogoBase = jbDao.ler().getFirst();

        criarAssociacaoEntreJogoBaseTipoJogo(conn, jogoBase.getIdJogo(), tipoJogo.getIdTipoJogo());

    }

    public static void criarAssociacaoEntreJogoBaseTipoJogo (Connection connection, int idJogoBase, int idTipoJogo) throws SQLException{
        String sql = "INSERT INTO tb_associacao_tipo_jogo_base (id_jogo, id_tipo_jogo) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idJogoBase);
        statement.setInt(2, idTipoJogo);
        statement.executeUpdate();
        statement.close();
    }

//    public static void testaModoJogo(Connection conn) throws SQLException {
//        ModoJogoDAO dao = new ModoJogoDAO(conn);
//
//        // Inserir
//        ModoJogo novo = new ModoJogo();
//        novo.setDescricaoModoJogo("descricaomodojogodescricaomodojogo");
//        dao.criar(novo);
//        System.out.println(" ok!");
//
//        // Buscar primeiro dado inserido de cada tabela
//        ModoJogo modoJogo = dao.ler().getFirst();
//        JogoBaseDAO jbDao = new JogoBaseDAO(conn);
//        JogoBase jogoBase = jbDao.ler().getFirst();
//
//        criarAssociacaoEntreJogoBaseModoJogo(conn, jogoBase.getIdJogo(), modoJogo.getIdModoJogo());
//
//    }
//
//    public static void criarAssociacaoEntreJogoBaseModoJogo (Connection connection, int idJogoBase, int idModoJogo) throws SQLException{
//        String sql = "INSERT INTO tb_associacao_modo_jogo_base (id_jogo, id_modo_jogo) VALUES (?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, idJogoBase);
//        statement.setInt(2, idModoJogo);
//        statement.executeUpdate();
//        statement.close();
//    }

//    public static void testaDificuldade(Connection conn) throws SQLException {
//        DificuldadeDAO dao = new DificuldadeDAO(conn);
//
//        // Inserir
//        Dificuldade novo = new Dificuldade();
//        novo.setDescricaoDificuldadeJogo("hsdhdhjdhjdskhhjdhjhshkdskhsdhkdskkdskds");
//        dao.criar(novo);
//        System.out.println(" inserida!");
//
//        // Buscar primeiro dado inserido de cada tabela
//        Dificuldade dificuldade = dao.ler().getFirst();
//        JogoBaseDAO jbDao = new JogoBaseDAO(conn);
//        JogoBase jogoBase = jbDao.ler().getFirst();
//
//        criarAssociacaoEntreJogoBaseDificuldade(conn, jogoBase.getIdJogo(), dificuldade.getIdDificuldade());
//
//    }

//    public static void criarAssociacaoEntreJogoBaseDificuldade (Connection connection, int idJogoBase, int idDificuldade) throws SQLException{
//        String sql = "INSERT INTO tb_associacao_dificuldade_jogo (id_jogo, id_dificuldade) VALUES (?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, idJogoBase);
//        statement.setInt(2, idDificuldade);
//        statement.executeUpdate();
//        statement.close();
//    }

    public static void testaExpansao(Connection conn) throws SQLException {
        ExpansaoDAO dao = new ExpansaoDAO(conn);

        // Inserir
        Expansao novo = new Expansao();
        novo.setIdJogo(11);
        novo.setDescricaoExps("Um jogo dificil");
        novo.setNomeExps("efnkcgy");
        novo.setDetalheDuracaoPrtdExps("sdfgthjuk");
        novo.setDetalheIdadeMinExps(",lmkuhytf6r5d");
        novo.setDetalheQtdJogadorExps("çoiuytfgvbhuytrdxfchuytrdxchu");
        dao.criar(novo);
        System.out.println("Expansao inserida!");

        // Listar
        List<Expansao> listExpansao = dao.ler();
        System.out.println("Expansao do jogo");
        for (Expansao jb : listExpansao) {
            System.out.println(jb.getIdExpansao() + " - " + jb.getDescricaoExps() );
        }

        //Atualizar

        if (!listExpansao.isEmpty()) {
            Expansao expansaoAtualizar = listExpansao.get(0);
            expansaoAtualizar.setDescricaoExps("Descrição de Expansao atualizada");
            dao.atualizar(expansaoAtualizar);
            System.out.println("Expansao atualizada");
        }

        //Excluir
        if (!listExpansao.isEmpty()) {
            int idParaDeletar = listExpansao.get(listExpansao.size() - 1).getIdExpansao();
            dao.deletar(idParaDeletar);
            System.out.println("Expansao Deletada");
        }
    }

    public static void testaJogo(Connection conn) throws SQLException {
        JogoBaseDAO dao = new JogoBaseDAO(conn);

        // Inserir
        JogoBase novo = new JogoBase();
        novo.setNome("sjdkan");
        novo.setQtdMinJogador((short) 8);
        novo.setQtdMaxJogador((short) 8);
        novo.setDetalheIdadeMin("sdfds");
        novo.setIdadeMin((short) 8);
        novo.setDetalheIdadeMin("jsjkd");
        novo.setDuracaoMinPrtd((short) 1);
        novo.setDetalheDuracaoPrtd("jskd");
        novo.setDetalheQtdJogador("hhhhhhhhhhh");


        novo.setDescricaoJogo("Um jogo dificil");
        dao.criar(novo);
        System.out.println("JogoBase inseride!");

        // Listar
        List<JogoBase> listJogoBase = dao.ler();
        System.out.println(" jogo");
        for (JogoBase jb : listJogoBase) {
            System.out.println(jb.getIdJogo() + " - " + jb.getDescricaoJogo() );
        }

        //Atualizar
        if (!listJogoBase.isEmpty()) {
            JogoBase jogoBaseAtualizar = listJogoBase.get(0);
            jogoBaseAtualizar.setDescricaoJogo("Descrição de jogo atualizade");
            dao.atualizar(jogoBaseAtualizar);
            System.out.println("Jogo  atualizade");
        }

//        //Excluir
//        if (!listExpansao.isEmpty()) {
//            int idParaDeletar = listExpansao.get(listExpansao.size() - 1).getIdExpansao();
//            dao.deletar(idParaDeletar);
//            System.out.println("Expansao Deletada");
//        }
    }
}


