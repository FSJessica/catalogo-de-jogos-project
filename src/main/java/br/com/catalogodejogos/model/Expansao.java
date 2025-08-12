package br.com.catalogodejogos.model;

public class Expansao {
    private int idExpansao;
    private int idjogo;
    private String nomeExps;
    private String descricaoExps;
    private byte[] imagemExps;
    private int qtdMinJogadorExps;
    private int qtdMaxJogadorExps;
    private String detalheQtdJogadorExps;
    private int idadeMinExps;
    private String detalheIdadeMinExps;
    private int duracaoMinPrtdExps;
    private int duracaoMaxPrtdExps;
    private String detalheDuracaoPrtdExps;

    public int getIdExpansao() {
        return idExpansao;
    }

    public void setIdExpansao(int idExpansao) {
        this.idExpansao = idExpansao;
    }

    public int getIdJogo() {
        return idjogo;
    }

    public void setIdJogo(int jogo) {
        this.idjogo = jogo;
    }

    public String getNomeExps() {
        return nomeExps;
    }

    public void setNomeExps(String nomeExps) {
        this.nomeExps = nomeExps;
    }

    public String getDescricaoExps() {
        return descricaoExps;
    }

    public void setDescricaoExps(String descricaoExps) {
        this.descricaoExps = descricaoExps;
    }

    public byte[] getImagemExps() {
        return imagemExps;
    }

    public void setImagemExps(byte[] imagemExps) {
        this.imagemExps = imagemExps;
    }

    public int getQtdMinJogadorExps() {
        return qtdMinJogadorExps;
    }

    public void setQtdMinJogadorExps(int qtdMinJogadorExps) {
        this.qtdMinJogadorExps = qtdMinJogadorExps;
    }

    public int getQtdMaxJogadorExps() {
        return qtdMaxJogadorExps;
    }

    public void setQtdMaxJogadorExps(int qtdMaxJogadorExps) {
        this.qtdMaxJogadorExps = qtdMaxJogadorExps;
    }

    public String getDetalheQtdJogadorExps() {
        return detalheQtdJogadorExps;
    }

    public void setDetalheQtdJogadorExps(String detalheQtdJogadorExps) {
        this.detalheQtdJogadorExps = detalheQtdJogadorExps;
    }

    public int getIdadeMinExps() {
        return idadeMinExps;
    }

    public void setIdadeMinExps(int idadeMinExps) {
        this.idadeMinExps = idadeMinExps;
    }

    public String getDetalheIdadeMinExps() {
        return detalheIdadeMinExps;
    }

    public void setDetalheIdadeMinExps(String detalheIdadeMinExps) {
        this.detalheIdadeMinExps = detalheIdadeMinExps;
    }

    public int getDuracaoMinPrtdExps() {
        return duracaoMinPrtdExps;
    }

    public void setDuracaoMinPrtdExps(int duracaoMinPrtdExps) {
        this.duracaoMinPrtdExps = duracaoMinPrtdExps;
    }

    public int getDuracaoMaxPrtdExps() {
        return duracaoMaxPrtdExps;
    }

    public void setDuracaoMaxPrtdExps(int duracaoMaxPrtdExps) {
        this.duracaoMaxPrtdExps = duracaoMaxPrtdExps;
    }

    public String getDetalheDuracaoPrtdExps() {
        return detalheDuracaoPrtdExps;
    }

    public void setDetalheDuracaoPrtdExps(String detalheDuracaoPrtdExps) {
        this.detalheDuracaoPrtdExps = detalheDuracaoPrtdExps;
    }
}
