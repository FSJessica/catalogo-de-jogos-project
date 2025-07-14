package br.com.catalogodejogos.model;

public class Expansao {
    private int idExpansao;
    private int idjogo;
    private String nomeExps;
    private String descricaoExps;
    private byte[] imagemExps;
    private short qtdMinJogadorExps;
    private short qtdMaxJogadorExps;
    private String detalheQtdJogadorExps;
    private short idadeMinExps;
    private String detalheIdadeMinExps;
    private short duracaoMinPrtdExps;
    private short duracaoMaxPrtdExps;
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

    public short getQtdMinJogadorExps() {
        return qtdMinJogadorExps;
    }

    public void setQtdMinJogadorExps(short qtdMinJogadorExps) {
        this.qtdMinJogadorExps = qtdMinJogadorExps;
    }

    public short getQtdMaxJogadorExps() {
        return qtdMaxJogadorExps;
    }

    public void setQtdMaxJogadorExps(short qtdMaxJogadorExps) {
        this.qtdMaxJogadorExps = qtdMaxJogadorExps;
    }

    public String getDetalheQtdJogadorExps() {
        return detalheQtdJogadorExps;
    }

    public void setDetalheQtdJogadorExps(String detalheQtdJogadorExps) {
        this.detalheQtdJogadorExps = detalheQtdJogadorExps;
    }

    public short getIdadeMinExps() {
        return idadeMinExps;
    }

    public void setIdadeMinExps(short idadeMinExps) {
        this.idadeMinExps = idadeMinExps;
    }

    public String getDetalheIdadeMinExps() {
        return detalheIdadeMinExps;
    }

    public void setDetalheIdadeMinExps(String detalheIdadeMinExps) {
        this.detalheIdadeMinExps = detalheIdadeMinExps;
    }

    public short getDuracaoMinPrtdExps() {
        return duracaoMinPrtdExps;
    }

    public void setDuracaoMinPrtdExps(short duracaoMinPrtdExps) {
        this.duracaoMinPrtdExps = duracaoMinPrtdExps;
    }

    public short getDuracaoMaxPrtdExps() {
        return duracaoMaxPrtdExps;
    }

    public void setDuracaoMaxPrtdExps(short duracaoMaxPrtdExps) {
        this.duracaoMaxPrtdExps = duracaoMaxPrtdExps;
    }

    public String getDetalheDuracaoPrtdExps() {
        return detalheDuracaoPrtdExps;
    }

    public void setDetalheDuracaoPrtdExps(String detalheDuracaoPrtdExps) {
        this.detalheDuracaoPrtdExps = detalheDuracaoPrtdExps;
    }
}
