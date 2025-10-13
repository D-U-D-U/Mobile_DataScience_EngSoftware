import models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Lista de filmes diferentes
        Filme f1 = new Filme("Interestelar", 2014, "Ficção Científica/Drama", 15.00);
        Filme f2 = new Filme("Gladiador", 2000, "Ação/Histórico", 11.80);
        Filme f3 = new Filme("O Rei Leão", 1994, "Animação/Aventura", 9.50);
        Filme f4 = new Filme("Homem-Aranha 2", 2004, "Ação/Super-Herói", 10.20);
        Filme f5 = new Filme("De Volta para o Futuro", 1985, "Ficção Científica/Aventura", 12.30);
        Filme f6 = new Filme("O Lobo de Wall Street", 2013, "Comédia/Drama", 13.00);
        Filme f7 = new Filme("A Viagem de Chihiro", 2001, "Animação/Fantasia", 10.90);
        Filme f8 = new Filme("Os Infiltrados", 2006, "Crime/Suspense", 12.70);
        Filme f9 = new Filme("Whiplash", 2014, "Drama/Música", 11.40);
        Filme f10 = new Filme("O Grande Gatsby", 2013, "Drama/Romance", 10.60);

        //Cliente 1
        Endereco e1 = new Endereco("Rua do Carvalho", 112, "Bloco B", "Centro", "Campina Grande", "PB", "58000001");
        Cliente c1 = new Cliente("Marcos Vieira", "20111111111", e1, "81990001111");
        Conta conta1 = new Conta(c1, 1);
        conta1.locarFilmes(Arrays.asList(f1, f2));
        conta1.locarFilmes(Arrays.asList(f3));
        conta1.locarFilmes(Arrays.asList(f4, f5, f6));
        conta1.locarFilmes(Arrays.asList(f7, f8, f9, f10));
        conta1.extratoHistorico();

        //Cliente 2
        Endereco e2 = new Endereco("Av. das Palmeiras", 999, null, "Boa Viagem", "Recife", "PE", "51000020");
        Cliente c2 = new Cliente("Larissa Rocha", "20222222222", e2, "81991234567");
        Conta conta2 = new Conta(c2, 2);
        conta2.locarFilmes(Arrays.asList(f10));
        conta2.locarFilmes(Arrays.asList(f1, f3, f5));
        conta2.locarFilmes(Arrays.asList(f2, f4));
        conta2.locarFilmes(Arrays.asList(f6, f7, f8));
        conta2.locarFilmes(Arrays.asList(f9));
        conta2.extratoHistorico();

        //Cliente 3
        Endereco e3 = new Endereco("Rua Bela Vista", 77, "Casa", "Rosarinho", "Olinda", "PE", "53000005");
        Cliente c3 = new Cliente("Eduarda Barros", "20333333333", e3, "81995554433");
        Conta conta3 = new Conta(c3, 3);
        conta3.locarFilmes(Arrays.asList(f2, f3));
        conta3.locarFilmes(Arrays.asList(f4));
        conta3.locarFilmes(Arrays.asList(f5, f6, f7));
        conta3.locarFilmes(Arrays.asList(f8, f9, f10));
        conta3.locarFilmes(Arrays.asList(f1));
        conta3.extratoHistorico();

        //Cliente 4
        Endereco e4 = new Endereco("Travessa Juazeiro", 45, "Casa", "Casa Amarela", "Recife", "PE", "52070555");
        Cliente c4 = new Cliente("Carlos Mendes", "20444444444", e4, "81993332222");
        Conta conta4 = new Conta(c4, 4);
        conta4.locarFilmes(Arrays.asList(f3, f4, f5));
        conta4.locarFilmes(Arrays.asList(f6));
        conta4.locarFilmes(Arrays.asList(f7, f8));
        conta4.locarFilmes(Arrays.asList(f9, f10));
        conta4.locarFilmes(Arrays.asList(f1, f2));
        conta4.locarFilmes(Arrays.asList(f3));
        conta4.extratoHistorico();
    }
}
