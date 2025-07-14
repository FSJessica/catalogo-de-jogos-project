package br.com.catalogodejogos.model;

public class JogoBase {
    private int idJogo;
    private String nome;
    private String descricaoJogo;
    private byte[] imagem;
    private short qtdMinJogador;
    private short qtdMaxJogador;
    private String detalheQtdJogador;
    private short idadeMin;
    private String detalheIdadeMin;
    private short duracaoMinPrtd;
    private short duracaoMaxPrtd;
    private String detalheDuracaoPrtd;
    private String comentarios;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoJogo() {
        return descricaoJogo;
    }

    public void setDescricaoJogo(String descricaoJogo) {
        this.descricaoJogo = descricaoJogo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public short getQtdMinJogador() {
        return qtdMinJogador;
    }

    public void setQtdMinJogador(short qtdMinJogador) {
        this.qtdMinJogador = qtdMinJogador;
    }

    public short getQtdMaxJogador() {
        return qtdMaxJogador;
    }

    public void setQtdMaxJogador(short qtdMaxJogador) {
        this.qtdMaxJogador = qtdMaxJogador;
    }

    public String getDetalheQtdJogador() { return detalheQtdJogador; }

    public void setDetalheQtdJogador(String detalheQtdJogador) { this.detalheQtdJogador = detalheQtdJogador; }

    public short getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(short idadeMin) {
        this.idadeMin = idadeMin;
    }

    public String getDetalheIdadeMin() {
        return detalheIdadeMin;
    }

    public void setDetalheIdadeMin(String detalheIdadeMin) {
        this.detalheIdadeMin = detalheIdadeMin;
    }

    public short getDuracaoMinPrtd() {
        return duracaoMinPrtd;
    }

    public void setDuracaoMinPrtd(short duracaoMinPrtd) { this.duracaoMinPrtd = duracaoMinPrtd; }

    public short getDuracaoMaxPrtd() { return duracaoMaxPrtd;  }

    public void setDuracaoMaxPrtd(short duracaoMaxPrtd) { this.duracaoMaxPrtd = duracaoMaxPrtd; }

    public String getDetalheDuracaoPrtd() { return detalheDuracaoPrtd;  }

    public void setDetalheDuracaoPrtd(String detalheDuracaoPrtd) { this.detalheDuracaoPrtd = detalheDuracaoPrtd; }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
