public interface exceptionInterface {
    int comprarTicket(Usuario user, CupomPromocional cupom) throws IndisponivelException;
    void comprarItens(int numBilhetes, CupomPromocional cupom, Usuario usuario) throws IndisponivelException;
    void comprarItens(Sala sala, Usuario usuario, int numBilhetes) throws IndisponivelException;
    int comprarTicket(Usuario user) throws IndisponivelException;
}