package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private int  numero;
    private double saldoDevedor;
    private List<Locacao> historicoLocacao;

    public Conta() {
        this.saldoDevedor = 0.0;
        this.historicoLocacao = new ArrayList<Locacao>() {
        };
    }

    public Conta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldoDevedor = 0.0;
        this.historicoLocacao = new ArrayList<Locacao>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public List<Locacao> getHistoricoLocacao() {
        return historicoLocacao;
    }

    public void locarFilmes(List<Filme> filmes){
        if(historicoLocacao.size() < 20) {
            Locacao locacao = new Locacao(new Date());
            for (int i = 0; i < filmes.size(); i++) {
                var addFilme = locacao.addFilme(filmes.get(i));
                if (!addFilme){
                    System.out.println("Número máximo de filmes atingidos por locação!");
                    return;
                }
            }
            historicoLocacao.add(locacao);
            saldoDevedor += locacao.getValorTotalAPagar();
            return;
        }
        System.out.println("Número máximo de locações atingidas por conta!");
    }

    public void extratoHistorico(){
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico de locações de " + cliente.getNome() + ": \n");
        for (Locacao locacao : historicoLocacao) {
            sb.append(locacao.toString());
        }

        System.out.println(sb.toString());
    }

    public void pagarDebito(double valor){
        saldoDevedor -= valor;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente +
                ", numero=" + numero +
                ", saldoDevedor=" + saldoDevedor +
                ", locacao=" + historicoLocacao.toString() +
                '}';
    }
}
