package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Locacao {
    private Date data;
    private double valorTotalAPagar;
    private List<Filme> listaFilmes;

    public Locacao() {
        this.valorTotalAPagar = 0.0;
        this.listaFilmes = new ArrayList<Filme>();
    }

    public Locacao(Date data) {
        this.data = data;
        this.valorTotalAPagar = 0.00;
        this.listaFilmes = new  ArrayList<Filme>();
    }

    public Date getData() {
        return data;
    }

    public double getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public boolean addFilme(Filme filme) {
        if (listaFilmes.size() >= 10) {
            return false;
        }
        valorTotalAPagar += filme.getValorLocacao();
        listaFilmes.add(filme);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Filme filme : listaFilmes) {
            sb.append(data + " ");
            sb.append(filme.toString());
        }

        return sb.toString();
    }
}
