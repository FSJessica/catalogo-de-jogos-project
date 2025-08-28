package br.com.catalogodejogos.model;

public class Dificuldade {
    private int idDificuldade;
    private String descricaoDificuldadeJogo;

    public int getIdDificuldade() {
        return idDificuldade;
    }

    public void setIdDificuldade(int idDificuldade) {
        this.idDificuldade = idDificuldade;
    }

    public String getDescricaoDificuldadeJogo() {
        return descricaoDificuldadeJogo;
    }

    public void setDescricaoDificuldadeJogo(String descricaoDificuldadeJogo) {
        this.descricaoDificuldadeJogo = descricaoDificuldadeJogo;
    }

    @Override
    public String toString() {
        return getDescricaoDificuldadeJogo();
    }
}
