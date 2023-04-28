public class Sala {
    private Filme filmes[] = new Filme[6];
    private Sessao poltronasPorSessao[] = new Sessao[6];


    public Sala() {
        filmes[0] = new Filme("Gato de botas 2", "08:00 - 10:00", "sinopse", 25.00);
        filmes[1] = new Filme("Avatar: O caminho da água", "10:30 - 12:00", "sinopse", 25.00);
        filmes[2] = new Filme("Homem-formiga e vespa", "12:30 - 15:00", "sinopse", 25.00);
        filmes[3] = new Filme("John Wick 4: Baba Yaga", "15:30 - 17:00", "sinopse", 25.00);
        filmes[4] = new Filme("Pânico VI", "17:00 - 18:45", "sinopse", 25.00);
        filmes[5] = new Filme("Creed III", "19:00 - 21:00", "sinopse", 25.00);
    }

    public Sessao[] getPoltronasPorSessao() {
        return poltronasPorSessao;
    }

    public void setPoltronasPorSessao(Sessao[] poltronasPorSessao) {
        this.poltronasPorSessao = poltronasPorSessao;
    }

    public Filme[] getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme[] filmes) {
        this.filmes = filmes;
    }

    public Filme getOneFilme(int i) {
        return filmes[i];
    }

    public void exibeFilmes() {
        for (int i = 0; i < filmes.length; i++) {
            System.out.println(i +": " + filmes[i].getNomeDoFilme() + " " + filmes[i].getDuracaoFilme());
        }

    }
}