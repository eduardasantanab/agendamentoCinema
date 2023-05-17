import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int aux, cont, numerosTickets, response;
        int[] numeroCadeira;
        int[] numeroCadeiraaux;
        int[] numeroUnicoaaux;
        int[] numeroUnicoCadeira;
        double multiply;
        CupomPromocional[] cupomPromocional = CupomPromocional.values();
        SalasTipo[] salasTipo = SalasTipo.values();
        String cupom;
        double valor;

        Bilhete bilhete;
        Sala sala = new Sala();
        Scanner s = new Scanner(System.in);
        int P;

        Usuario user1 = new Usuario("Duda", "123123312", "13213321", 23, "feminino", "dsadsadas", "Duda", "123321321", "210");

        Critico critico1 = new Critico("Duda", "123123312", "13213321", 23, "feminino", "dsadsadas", "Duda", "123321321", "210", "tal");
        critico1.atribuirNota(9, sala.getOneFilme(0));
        critico1.atribuirCritica("o filme me surpreendeu, amei!", sala.getOneFilme(0));

        Critico critico2 = new Critico("Vinao", "123123312", "13213321", 19, "masculino", "dsadsadas", "Duda", "123321321", "210", "qual");
        critico2.atribuirNota(8, sala.getOneFilme(0));
        critico2.atribuirCritica("o filme é ótimo, mas dentro do esperado!", sala.getOneFilme(0));

        sala.getOneFilme(0).getCritica();
        sala.getOneFilme(0).exibirMedia();


        do {
            aux = user1.comprar();
            if (aux == 0) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adicionar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    int[] numCadAux = user1.getBilhete().getCadeira();//peguei o valor da cad anterior pelo bilhete
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                }
                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else if (aux == 1) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adiconar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), user1.getNumeroCadeiraAux(), sala, aux);
                }

                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }
                user1.dizBilhete();

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else if (aux == 2) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adiconar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), user1.getNumeroCadeiraAux(), sala, aux);
                }

                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }
                user1.dizBilhete();

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else if (aux == 3) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adiconar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), user1.getNumeroCadeiraAux(), sala, aux);
                }

                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }
                user1.dizBilhete();

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else if (aux == 4) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adiconar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), user1.getNumeroCadeiraAux(), sala, aux);
                }

                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }
                user1.dizBilhete();

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else if (aux == 5) {

                System.out.println("\nDeseja alterar sua escolha?");
                System.out.println("0: Adiconar Ticket");
                System.out.println("1: Remover Ticket");
                System.out.println("2: Não desejo alterar");
                System.out.println("3: Adicionar lanche");
                System.out.println("4: Cancelar compra");
                response = s.nextInt();

                if (response < 3 && response >= 0) {
                    user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), user1.getNumeroCadeiraAux(), sala, aux);
                }

                if(response == 2){
                    user1.dizBilhete();
                }

                if (response == 3) {
                    user1.getCompra().comprarItens(user1.getNumeroTickets());
                }

                if (response == 4) {
                    user1.cancelarCompra();
                    user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                    System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                    user1.getSessao().exibeCadeiras();
                    break;
                }
                user1.dizBilhete();

                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } else {
                break;
            }
        } while (P == 1);
    }
}