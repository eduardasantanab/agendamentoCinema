import java.util.Scanner;
class Estudante extends Usuario implements compraInterface {
    private Compra compra;
    private int numeroTickets = 0;
    Scanner s;

    Estudante(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao) {
        super(nome, cpf, senha, idade, sexo, email, nomeCartao, numeroCartao, codigoVerificadorCartao);
        this.s = new Scanner(System.in);
    }

    @Override
    public int comprar(Sala sala) throws IndisponivelException {
        compra = new Compra(sala);
        int aux;
        System.out.println("\nMENU");
        System.out.println("0: Comprar Comida");
        System.out.println("1: Comprar Tickets");

        do {
            System.out.println("Escolha uma opção");
            aux = s.nextInt();
        } while (aux != 0 && aux != 1);

        if(aux == 0){
            this.compra.comprarItens(sala, this, this.getNumeroTickets());
        } else {
            aux = this.compra.comprarTicket(this);
            this.compra.getBilhete().setValor(getBilhete().getValor() * 0.5);
            aux = (int) Math.round(this.compra.getBilhete().getValor());
            System.out.println("\nESTUDANTE");
            dizBilhete();
            return aux;
        }
        return -1;
    }
}