public class Bilhete {

    private String nome;
    private String cpf;
    private int sala;
    private Sessao sessao;
    private Filme filme;
    private double valor;
    private int cadeira[];

    public Bilhete(Usuario user, int sala, Sessao sessao, Filme filme, double valor, int cadeira[]) {
        this.nome = user.getNome();
        this.cpf = user.getCpf();
        this.sala = sala;
        this.sessao = sessao;
        this.filme = filme;
        this.valor = valor;
        this.cadeira = cadeira;
    }

    public int[] getCadeira() {
        return cadeira;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSala() {
        return sala;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCadeira(int cadeira[]) {
        this.cadeira = cadeira;
    }

    public Filme getFilme() {
        return filme;
    }

    public double getValor() {
        return valor;
    }

    public void cadeiras() {
        for (int i = 0; i < cadeira.length; i++) {
            System.out.println("Número da cadeira: "+ cadeira[i]);
        }
    }

    @Override
    public String toString() {
        return "\n[Bilhete] \nNome: " + nome + "\nCPF: " + cpf + "\nSala: " + sala + "\nSessao: " + sessao + "\nFilme: " + filme
                + "\nValor: R$" + valor;
    }

}