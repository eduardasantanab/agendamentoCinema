public class Filme {

    private String nomeDoFilme;
    private String duracaoFilme;
    private String sinopse;
    private double valor;
    private double nota;
    private int quatidadeCriticos = 0;
    private Critica criticas[] = new Critica[100];

    public Filme(String nomeDoFilme, String duracaoFilme, String sinopse, double valor){
        this.nomeDoFilme = nomeDoFilme;
        this.duracaoFilme = duracaoFilme;
        this.sinopse = sinopse;
        this.valor = valor;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public String getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(String duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getNota() {
        return nota;
    }

    public int getQuatidadeCriticos() {
        return quatidadeCriticos;
    }

    public Critica[] getCritica() {
        return criticas;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setQuatidadeCriticos(int quatidadeCriticos) {
        this.quatidadeCriticos = quatidadeCriticos;
    }

    public void setCritica(Critica[] criticas) {
        this.criticas = criticas;
    }

    public void atibuirUmaCritica(Critica critica) {
        this.criticas[this.quatidadeCriticos] = critica;
    }

    public void exibirMedia() {
        double media = nota / quatidadeCriticos;
        System.out.println("A média do filme" + getNomeDoFilme() + " é: "+ media);
    }
}