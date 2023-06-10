import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IndisponivelException {
        Sala sala = new Sala();

        Administrador adm = new Administrador(sala);
        Funcionario func = new Funcionario(sala);

        adm.incluirFilme("Avatar: o caminho da água", "22:00 - 23:55", "descrição da sinopse", 0);
        adm.incluirFilme("Duna", "20:00 - 22:00", "Descrição da sinopse", 0);
        adm.incluirFilme("Pantera Negra", "18:00 - 19:55", "Descrição da sinopse", 0);
        func.incluirFilme("As linhas tortas de Deus", "07:00 - 07:30", "Descrição da sinopse", 0);
        adm.emCartaz("Duna");
        sala.exibeFilmes();

        adm.excluirFilme("Pantera Negra");
        sala.exibeFilmes();

        int aux, response;

        Scanner s = new Scanner(System.in);
        int P;

        System.out.println();
        Usuario user1 = new Usuario("Duda", "123123", "13213321", 23, "feminino", "nome@.com", "Duda", "123321321", "211");
        Usuario user2 = adm.adicionarUsuario("Alana", "985423", "31213321", 19, "feminino", "nome@.com", "Alana", "123321321", "210");
        Usuario user3 = adm.adicionarUsuario("Marcelo", "456789", "23213321", 19, "masculino", "nome@.com", "Marcelo", "123321321", "110");
        Usuario user4 = adm.adicionarUsuario("Vinicius", "987654", "33213321", 19, "masculino", "nome@.com", "Vinicius", "123321321", "220");
        Critico critico1 = adm.adicionarCritico("Alana", "654321", "22213321", 23, "feminino", "nome@.com", "Alana", "123321321", "210", "tal");
        Estudante estudante1 = adm.adicionarEstudante("Almir", "123456", "11213321", 18, "masculino", "nome@.com", "Almir", "123321321", "212");
        System.out.println();
        critico1.atribuirNota(9, sala.getOneFilme(0));
        critico1.atribuirCritica("O filme me surpreendeu, amei!", sala.getOneFilme(0));

        Critico critico2 = new Critico("Vinao", "123123312", "13213321", 19, "masculino", "dsadsadas", "Duda", "123321321", "210", "qual");
        critico2.atribuirNota(8, sala.getOneFilme(0));
        critico2.atribuirCritica("O filme é ótimo, mas dentro do esperado!", sala.getOneFilme(0));

        System.out.println(Arrays.stream(sala.getOneFilme(0).getCritica()).toList().get(0));
        sala.getOneFilme(0).exibirMedia();

        try {
            do {
                aux = user1.comprar(sala);

                if (aux == 0) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adicionar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }
                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == 1) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adiconar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }

                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == 2) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adiconar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }

                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == 3) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adiconar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }

                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == 4) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adiconar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }

                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == 5) {

                    System.out.println("\nDeseja alterar sua escolha?");
                    System.out.println("0: Adiconar Ticket");
                    System.out.println("1: Remover Ticket");
                    System.out.println("2: Não desejo alterar");
                    System.out.println("3: Adicionar lanche");
                    System.out.println("4: Cancelar compra");
                    response = s.nextInt();

                    if (response < 3 && response >= 0) {
                        int[] numCadAux = user1.getBilhete().getCadeira();
                        user1.alterar(user1, user1.getSessao(), response, user1.getNumeroTickets(), numCadAux, sala, aux);
                    }

                    if (response == 2) {
                        user1.dizBilhete();
                    }

                    if (response == 3) {
                        user1.getCompra().comprarItens(sala, user1, user1.getNumeroTickets());
                    }

                    if (response == 4) {
                        user1.cancelarCompra();
                        user1.getSessao().cancelarCadeira(user1.getNumeroUnicoCadeira());
                        System.out.println("Removemos a(as) cadeira(as) que você escolheu!");
                        user1.getSessao().exibeCadeiras();
                        break;
                    }
                } else if (aux == -2) {
                    P = 1;
                } else {
                    break;
                }
                System.out.println("\nDeseja finalizar a compra?\n0: SIM\n1: NÃO");
                P = s.nextInt();
            } while (P == 1);
        } catch (IndisponivelException ex) {
            ex = new IndisponivelException(user1.getSessao().getCadeirasDisponiveis());
            System.out.println("Erro de seleção: " + ex.getMessage());
        }
        System.out.println("\nCompra finalizada com sucesso!");
    }

}