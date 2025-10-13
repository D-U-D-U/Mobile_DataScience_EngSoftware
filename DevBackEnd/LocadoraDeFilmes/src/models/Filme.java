package models;

public class Filme {

    private String titulo;
    private int ano;
    private String genero;
    private double valorLocacao;

    public Filme() {
    }

    public Filme(String titulo, int ano, String genero, double valorLocacao) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.valorLocacao = valorLocacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    @Override
    public String toString() {
        return titulo + "(" + ano + ", " +
                genero + ") " + String.format("%.2f", valorLocacao) + System.lineSeparator();
    }

}
