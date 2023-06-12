public class Sala {
    private Filme filmes[] = new Filme[100];
    private Sessao poltronasPorSessao[] = new Sessao[100];
    private int filmesAdicionados = 0;


    public Sala() {}

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

    public int getFilmesAdicionados() {
        return this.filmesAdicionados;
    }

    public void setFilmesAdicionados(int i) {
        this.filmesAdicionados = i;
    }

    public void exibeFilmes() {
        for (int i = 0; i < filmesAdicionados; i++) {
            System.out.println(i + ": " +getFilmes()[i].getNomeDoFilme() + " " + getFilmes()[i].getDuracaoFilme());
        }
    }

    public String horarioFilme(int indice) {
        return this.filmes[indice].getDuracaoFilme();
    }

}