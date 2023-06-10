public interface criticoInterface {

    void atribuirNota(double nota, Filme filme);
    void atribuirCritica(String critica, Filme filme);
    int comprar(Sala sala) throws IndisponivelException;
    void cancelarCompra();
    void alterar(Usuario usuario, Sessao sessao, int resp, int numTickets, int[] baseNumUnicoAnterior, Sala sala, int numSala) throws IndisponivelException;
    void dizBilhete();
}
