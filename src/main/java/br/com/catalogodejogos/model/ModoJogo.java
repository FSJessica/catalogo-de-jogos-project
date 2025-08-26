package br.com.catalogodejogos.model;

public class ModoJogo {
    private int idModoJogo;
    private String descricaoModoJogo;

    public int getIdModoJogo() {
        return idModoJogo;
    }

    public void setIdModoJogo(int idModoJogo) {
        this.idModoJogo = idModoJogo;
    }

    public String getDescricaoModoJogo() {
        return descricaoModoJogo;
    }

    public void setDescricaoModoJogo(String descricaoModoJogo) {
        this.descricaoModoJogo = descricaoModoJogo;
    }

    @Override
    public String toString() {
        return getDescricaoModoJogo();
    }
}
