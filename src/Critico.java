import java.util.Scanner;
public class Critico extends Usuario implements criticoInterface{
    private String origem;
    private Compra compra;

    Critico(String nome,String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao, String origem) {
        super(nome, cpf, senha, idade, sexo, email, nomeCartao, numeroCartao, codigoVerificadorCartao);
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }


    @Override
    public int comprar(Sala sala) throws IndisponivelException {
        int aux;
        Scanner s = new Scanner(System.in);
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
            this.compra.getBilhete().setValor(getBilhete().getValor() * 0);
            aux = (int) Math.round(this.compra.getBilhete().getValor());
            System.out.println("\nCritico");
            dizBilhete();
            return aux;
        }
        return -1;
    }

    public void atribuirNota(double nota, Filme filme){
        if(nota >= 0 && nota <= 10) {
            filme.setQuatidadeCriticos(filme.getQuatidadeCriticos() + 1);
            filme.setNota(filme.getNota() + nota);
        } else {
            System.out.println("A nota precisa estar entre 0 e 10");
        }
    }

    public void atribuirCritica(String critica, Filme filme){
        Critica critica2 = new Critica(super.getNome(), this.origem, critica);
        Critica[] vetCritica = new Critica[filme.getQuatidadeCriticos()];

        for (int i = 0; i < filme.getQuatidadeCriticos(); i++) {
            vetCritica[i] = critica2;
        }
        filme.setCritica(vetCritica);
    }
}
