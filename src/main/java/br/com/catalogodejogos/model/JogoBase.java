package br.com.catalogodejogos.model;

public class JogoBase {
    private int idJogo;
    private String nome;
    private String descricaoJogo;
    private byte[] imagem;
    private int qtdMinJogador;
    private int qtdMaxJogador;
    private String detalheQtdJogador;
    private int idadeMin;
    private String detalheIdadeMin;
    private int duracaoMinPrtd;
    private int duracaoMaxPrtd;
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

    public int  getQtdMinJogador() {
        return qtdMinJogador;
    }

    public void setQtdMinJogador(int qtdMinJogador) {
        this.qtdMinJogador = qtdMinJogador;
    }

    public int getQtdMaxJogador() {
        return qtdMaxJogador;
    }

    public void setQtdMaxJogador(int qtdMaxJogador) {
        this.qtdMaxJogador = qtdMaxJogador;
    }

    public String getDetalheQtdJogador() { return detalheQtdJogador; }

    public void setDetalheQtdJogador(String detalheQtdJogador) { this.detalheQtdJogador = detalheQtdJogador; }

    public int getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }

    public String getDetalheIdadeMin() {
        return detalheIdadeMin;
    }

    public void setDetalheIdadeMin(String detalheIdadeMin) {
        this.detalheIdadeMin = detalheIdadeMin;
    }

    public int getDuracaoMinPrtd() {
        return duracaoMinPrtd;
    }

    public void setDuracaoMinPrtd(int duracaoMinPrtd) { this.duracaoMinPrtd = duracaoMinPrtd; }

    public int getDuracaoMaxPrtd() { return duracaoMaxPrtd;  }

    public void setDuracaoMaxPrtd(int duracaoMaxPrtd) { this.duracaoMaxPrtd = duracaoMaxPrtd; }

    public String getDetalheDuracaoPrtd() { return detalheDuracaoPrtd;  }

    public void setDetalheDuracaoPrtd(String detalheDuracaoPrtd) { this.detalheDuracaoPrtd = detalheDuracaoPrtd; }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
