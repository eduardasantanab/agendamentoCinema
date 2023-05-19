public interface gerenciaDeFilmes {

    void incluirFilme(String nomeDoFilme, String duracaoDoFilme, String sinopse, double valor);
    void excluirFilme(String target);
    void alterarFilme(String nomeFilme);

}