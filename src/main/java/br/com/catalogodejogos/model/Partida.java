package br.com.catalogodejogos.model;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;

public class Partida {
    private int idPartida;
    private int jogo;
    private LocalDateTime data;
    private short duracao;
    private short qtdJogadorPrtd;
    private String participantesPrtd;
    private String vencedor;
    private String comentarioPrtd;

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getJogo() {
        return jogo;
    }

    public void setJogo(int jogo) {
        this.jogo = jogo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public short getDuracao() {
        return duracao;
    }

    public void setDuracao(short duracao) {
        this.duracao = duracao;
    }

    public short getQtdJogadorPrtd() {
        return qtdJogadorPrtd;
    }

    public void setQtdJogadorPrtd(short qtdJogadorPrtd) {
        this.qtdJogadorPrtd = qtdJogadorPrtd;
    }

    public String getParticipantesPrtd() {
        return participantesPrtd;
    }

    public void setParticipantesPrtd(String participantesPrtd) {
        this.participantesPrtd = participantesPrtd;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getComentarioPrtd() {
        return comentarioPrtd;
    }

    public void setComentarioPrtd(String comentarioPrtd) {
        this.comentarioPrtd = comentarioPrtd;
    }
}
