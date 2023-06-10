public interface compraInterface {

    void cancelarCompra();
    void alterar(Usuario usuario, Sessao sessao, int resp, int numTickets, int[] baseNumUnicoAnterior, Sala sala, int numSala) throws IndisponivelException;
    void dizBilhete();
    int comprar(Sala sala) throws IndisponivelException;
}

