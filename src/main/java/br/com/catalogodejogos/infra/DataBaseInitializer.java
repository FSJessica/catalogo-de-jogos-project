package br.com.catalogodejogos.infra;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class DataBaseInitializer {
    public static void initialize(){
        try (Connection conn = DataBaseConnection.getconnection(); Statement stmt = conn.createStatement()){

            //Tabela de Jogo Base
            String createTbJogoBase = """
                    CREATE TABLE IF NOT EXISTS tb_jogo_base (
                    	id_jogo SERIAL PRIMARY KEY,
                    	nome VARCHAR(200) UNIQUE NOT NULL,
                    	imagem BYTEA,
                    	qtd_min_jogador SMALLINT NOT NULL,
                    	qtd_max_jogador SMALLINT NOT NULL,
                    	detalhe_qtd_jogador VARCHAR(1000) NOT NULL,
                    	idade_min SMALLINT NOT NULL,
                    	detalhe_idade_min VARCHAR(1000) NOT NULL,
                    	duracao_min_prtd SMALLINT NOT NULL,
                    	duracao_max_prtd SMALLINT,
                    	detalhe_duracao_prtd VARCHAR(200) NOT NULL,
                    	comentarios VARCHAR(1000)
                    );
                   """;

            //Tabela de dificuldade
            String createTbDificuldade = """
                    CREATE TABLE IF NOT EXISTS tb_dificuldade (
                    	id_dificuldade SERIAL PRIMARY KEY,
                    	descricao_jogo VARCHAR(1000)
                    );
                    """;

            //Tabela de associação entre dificuldade e jogo base
            String createTbAssociacaoDificuldadeJogoBase = """
                    CREATE TABLE IF NOT EXISTS tb_associacao_dificuldade_jogo (
                    	id_dificuldade INTEGER,
                    	id_jogo INTEGER,
                    
                    	PRIMARY KEY (id_dificuldade, id_jogo),
                    
                    	FOREIGN KEY (id_dificuldade) REFERENCES tb_dificuldade(id_dificuldade) ON DELETE CASCADE,
                    	FOREIGN KEY (id_jogo) REFERENCES tb_jogo_base(id_jogo) ON DELETE CASCADE
                    );
                    """;

            //Tabela de modo de jogo
            String createTbModoJogo = """
                    CREATE TABLE IF NOT EXISTS tb_modo_jogo(
                    	id_modo_jogo SERIAL PRIMARY KEY,
                    	descricao_modo_jogo VARCHAR(1000) NOT NULL
                    );
                    """;

            //Tabela de associação entre modo de jogo e o jogo base
            String createTbAssociacaoModoJogoBase = """
                    CREATE TABLE IF NOT EXISTS tb_associacao_modo_jogo_base(
                    	id_modo_jogo INTEGER,
                    	id_jogo INTEGER,
                    
                    	PRIMARY KEY (id_modo_jogo, id_jogo),
                    
                    	FOREIGN KEY (id_modo_jogo) REFERENCES tb_modo_jogo(id_modo_jogo) ON DELETE CASCADE,
                    	FOREIGN KEY (id_jogo) REFERENCES tb_jogo_base(id_jogo) ON DELETE CASCADE
                    );
                    """;

            //Tabela de tipo de jogo
            String createTbTipoJogo = """
                    CREATE TABLE IF NOT EXISTS tb_tipo_jogo(
                    	id_tipo_jogo SERIAL PRIMARY KEY,
                    	descricao_tipo_jogo VARCHAR(1000) NOT NULL
                    );
                    """;

            //Tabela de associacao entre tipo de jogo e o jogo base
            String createTbAssociacaoTipoJogoBase = """
                    CREATE TABLE IF NOT EXISTS tb_associacao_tipo_jogo_base(
                    	id_tipo_jogo INTEGER,
                    	id_jogo INTEGER,
                    
                    	PRIMARY KEY (id_tipo_jogo, id_jogo),
                    
                    	FOREIGN KEY (id_tipo_jogo) REFERENCES tb_tipo_jogo(id_tipo_jogo) ON DELETE CASCADE,
                    	FOREIGN KEY (id_jogo) REFERENCES tb_jogo_base (id_jogo) ON DELETE CASCADE
                    );
                    """;

            //Tabela de Expansão de jogo
            String createTbExpansao = """
                    CREATE TABLE IF NOT EXISTS tb_expansao(
                    	id_expansao SERIAL PRIMARY KEY,
                    	id_jogo INTEGER NOT NULL,
                    	nome_exps VARCHAR(200) UNIQUE NOT NULL,
                    	descricao_exps VARCHAR(1000) NOT NULL,
                    	imagem_exps BYTEA,
                    	qtd_min_jogador_exps SMALLINT,
                    	qtd_max_jogadpr_exps SMALLINT,
                    	detalhe_qtd_jogador_exps VARCHAR(1000) NOT NULL,
                    	idade_min_exps SMALLINT,
                    	detalhe_idade_min_exps VARCHAR(1000) NOT NULL,
                    	duracao_min_prtd_exps SMALLINT,
                    	duracao_max_prtd_exps SMALLINT,
                    	detalhe_duracao_prtd_exps VARCHAR(1000) NOT NULL,
                    
                    	FOREIGN KEY (id_jogo) REFERENCES tb_jogo_base(id_jogo) ON DELETE CASCADE
                    );
                    """;

            //Tabela de partida de jogo
            String createTbPartida = """
                    CREATE TABLE IF NOT EXISTS tb_partida(
                    	id_partida SERIAL PRIMARY KEY,
                    	id_jogo INTEGER NOT NULL,
                    	data_prtd timestamp NOT NULL,
                    	duracao_prtd SMALLINT,
                    	qtd_jogador_prtd SMALLINT,
                    	participantes_prtd VARCHAR(200),
                    	vencedor VARCHAR(100),
                    	comentario_prtd VARCHAR(1000),
                    
                    	FOREIGN KEY (id_jogo) REFERENCES tb_jogo_base(id_jogo) ON DELETE CASCADE
                    );
                    """;

            // Executando os comandos
            stmt.execute(createTbJogoBase);
            stmt.execute(createTbDificuldade);
            stmt.execute(createTbAssociacaoDificuldadeJogoBase);
            stmt.execute(createTbModoJogo);
            stmt.execute(createTbAssociacaoModoJogoBase);
            stmt.execute(createTbTipoJogo);
            stmt.execute(createTbAssociacaoTipoJogoBase);
            stmt.execute(createTbExpansao);
            stmt.execute(createTbPartida);

            System.out.println("Tabelas criadas/verificadas com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
