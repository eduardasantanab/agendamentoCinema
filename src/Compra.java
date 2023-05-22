import java.util.Scanner;

public class Compra {
    private String[] itens;
    private Sala sala;
    private Filme filme;
    private Scanner s;
    private Produtos[] produtos = Produtos.values();
    private int numerosTickets;
    private int[] numeroCadeira;
    private int[] numeroUnicoCadeira;
    private String cupom;

    private Hora hora = new Hora();

    CupomPromocional[] cupomPromocional = CupomPromocional.values();
    SalasTipo[] salasTipo = SalasTipo.values();
    Sessao sessao = new Sessao();
    private Bilhete bilhete;

    public Compra(Sala sala) {
        this.sala = sala;
        this.s = new Scanner(System.in);
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public CupomPromocional[] getCupomPromocional() {
        return cupomPromocional;
    }

    public void setCupomPromocional(CupomPromocional[] cupomPromocional) {
        this.cupomPromocional = cupomPromocional;
    }

    public SalasTipo[] getSalasTipo() {
        return salasTipo;
    }

    public void setSalasTipo(SalasTipo[] salasTipo) {
        this.salasTipo = salasTipo;
    }

    public String[] getItens() {
        return itens;
    }

    public void setItens(String[] itens) {
        this.itens = itens;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public Produtos[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos[] produtos) {
        this.produtos = produtos;
    }

    public int getNumerosTickets() {
        return numerosTickets;
    }

    public void setNumerosTickets(int numerosTickets) {
        this.numerosTickets = numerosTickets;
    }

    public int[] getNumeroCadeira() {
        return numeroCadeira;
    }

    public void setNumeroCadeira(int[] numeroCadeira) {
        this.numeroCadeira = numeroCadeira;
    }

    public int[] getNumeroUnicoCadeira() {
        return numeroUnicoCadeira;
    }

    public void setNumeroUnicoCadeira(int[] numeroUnicoCadeira) {
        this.numeroUnicoCadeira = numeroUnicoCadeira;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public int comprarTicket(Usuario user, CupomPromocional cupom) throws IndisponivelException {
        int returnAux = 0;

        if (cupom != null) {
            do {
                sala.exibeFilmes();
                System.out.println("Escolha um Filme");
                returnAux = s.nextInt();
            } while (returnAux > sala.getFilmes().length);
            double valor = 0, multiply = 0;

            int cont = 0;
            System.out.println("\nVocê está na sessão do filme: " + sala.getOneFilme(returnAux).getNomeDoFilme());
            multiply = salasTipo[0].escolhaSuaSala();
            sessao.exibeCadeiras();
            do {
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            } while (numerosTickets <= 0);
            sessao.sugereCadeiras(numerosTickets); //
            user.setNumeroTickets(numerosTickets);
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];

            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                int tamanho = sessao.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5
                                + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                } else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5
                                + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                user.setNumeroUnicoCadeira(numeroUnicoCadeira);//

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                user.setNumeroUnicoCadeira(numeroUnicoCadeira);//
            }

            sessao.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao.exibeCadeiras();

            if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                System.out.println(
                        "O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                valor = 25.0 * numerosTickets * multiply;
                valor = valor * cupomPromocional[0].getValor();
            } else if (this.cupom.toLowerCase()
                    .compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                System.out.println(
                        "O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                valor = 25.0 * numerosTickets * multiply;
                valor = valor * cupomPromocional[1].getValor();
            } else if (this.cupom.toLowerCase()
                    .compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                System.out.println(
                        "O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                valor = 25.0 * numerosTickets * multiply;
                valor = valor * cupomPromocional[2].getValor();
            } else {
                System.out.println("Cupom errado!");
                valor = 25.0 * numerosTickets * multiply;
            }

            bilhete = new Bilhete(user, returnAux, sessao, sala.getOneFilme(returnAux), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao);
            user.setBilhete(bilhete);

        } else {
            comprarTicket(user);
        }
        return returnAux;
    }

    public void comprarItens(int numBilhetes, CupomPromocional cupom, Usuario usuario) throws IndisponivelException {
        int aux, desconto;
        desconto = 1 - (Integer.parseInt(this.cupom) / 100);
        double total = 0;
        System.out.println("\nAlimentos disponíveis");

        if (cupom != null) {
            do {
                for (int i = 0; i < produtos.length; i++) {
                    System.out.println(i + ": " + produtos[i].getNome() + " R$" + produtos[i].getPreco());
                }
                System.out.println("Escolha uma opção");
                aux = s.nextInt();
                if (aux == 0) {
                    total = (total + produtos[aux].getPreco()) * desconto;
                } else if (aux == 1) {
                    total = (total + produtos[aux].getPreco()) * desconto;
                } else if (aux == 2) {
                    total = (total + produtos[aux].getPreco()) * desconto;
                } else if (aux == 3) {
                    total = (total + produtos[aux].getPreco()) * desconto;
                } else if (aux == 4) {
                    total = (total + produtos[aux].getPreco()) * desconto;
                } else {
                    System.out.println("Digite um valor entre os listados");
                }
                System.out.println("Deseja comprar algo a mais?");
                System.out.println("0: SIM");
                System.out.println("1: NÃO");

                aux = s.nextInt();

                if (aux == 0) {
                    usuario.comprar(sala);
                    if(usuario.getBilhete() != null){
                        usuario.getBilhete().setValor((total + (usuario.getNumeroTickets() * 25.00)));
                        usuario.dizBilhete();
                    }
                    break;
                } else {
                    if(usuario.getBilhete() != null){
                        usuario.dizBilhete();
                    }
                    System.out.println("\nTotal da compra: R$" + (total + usuario.getNumeroTickets() * 25));
                    break;
                }
            } while (aux != 1);
        } else {
            comprarItens(sala, usuario, numBilhetes);
        }
    }

    public void comprarItens(Sala sala, Usuario usuario, int numBilhetes) throws IndisponivelException {
        int aux;
        double total = 0;
        System.out.println("\nAlimentos disponíveis");

        do {
            for (int i = 0; i < produtos.length; i++) {
                System.out.println(i + ": " + produtos[i].getNome() + " R$" + produtos[i].getPreco());
            }
            System.out.println("Escolha uma opção");
            aux = s.nextInt();
            if (aux == 0) {
                total = total + produtos[aux].getPreco();
            } else if (aux == 1) {
                total = total + produtos[aux].getPreco();
            } else if (aux == 2) {
                total = total + produtos[aux].getPreco();
            } else if (aux == 3) {
                total = total + produtos[aux].getPreco();
            } else if (aux == 4) {
                total = total + produtos[aux].getPreco();
            } else {
                System.out.println("Digite um valor entre os listados");
            }
            System.out.println("Deseja comprar algo a mais?");
            System.out.println("0: SIM");
            System.out.println("1: NÃO");

            aux = s.nextInt();

            if (aux == 0) {
                usuario.comprar(sala);
                if(usuario.getBilhete() != null){
                    usuario.getBilhete().setValor((total + (usuario.getNumeroTickets() * 25.00)));
                    usuario.dizBilhete();
                }
                break;
            } else {
                if(usuario.getBilhete() != null){
                    usuario.dizBilhete();
                }
                System.out.println("\nTotal da compra: R$" + (total + usuario.getNumeroTickets() * 25));
                break;
            }
        } while (aux != 1);
    }

    public int comprarTicket(Usuario user) throws IndisponivelException {
        int aux;
        int returnAux;

        do {
            sala.exibeFilmes();
            System.out.println("Escolha um Filme:");
            returnAux = s.nextInt();
        } while (returnAux > sala.getFilmes().length);

        try {
            String faixaHorario = sala.horarioFilme(returnAux);
            int response = hora.compare(faixaHorario);


            boolean emCartaz = sala.getFilmes()[returnAux].isEmCartaz();

            if (response == 0) {
                if (emCartaz) {
                    double valor, multiply;
                    int cont = 0;
                    System.out.println("\nVocê está na sessão do filme: " + sala.getOneFilme(returnAux).getNomeDoFilme());
                    multiply = salasTipo[0].escolhaSuaSala();
                    sessao.exibeCadeiras();

                    do {
                        System.out.println("\nQuantos tickets deseja comprar? ");
                        numerosTickets = s.nextInt();
                        assert numerosTickets != 0;
                    } while (numerosTickets <= 0);

                    sessao.sugereCadeiras(numerosTickets); //
                    user.setNumeroTickets(numerosTickets);
                    numeroCadeira = new int[numerosTickets * 2];
                    numeroUnicoCadeira = new int[numerosTickets];

                    if (numerosTickets > 1) {

                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[0] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                        cont++;

                        int tamanho = sessao.getCadeirasDisponiveis().length + 1;

                        if (tamanho - numeroCadeira[1] < numerosTickets) {
                            for (int i = 0; i < numerosTickets - 1; i++) {
                                numeroCadeira[cont * 2] = numeroCadeira[0];
                                numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                                numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                                cont++;
                            }
                        } else {
                            for (int i = 0; i < numerosTickets - 1; i++) {
                                numeroCadeira[cont * 2] = numeroCadeira[0];
                                numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                                numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                                cont++;
                            }
                        }
                        user.setNumeroUnicoCadeira(numeroUnicoCadeira);

                    } else {
                        for (int i = 0; i < numerosTickets; i++) {
                            System.out.println("\nEscolha o número da linha");
                            numeroCadeira[cont * 2] = s.nextInt();
                            System.out.println("Escolha o número da coluna");
                            numeroCadeira[(cont * 2) + 1] = s.nextInt();
                            numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                            cont++;
                        }
                        user.setNumeroUnicoCadeira(numeroUnicoCadeira);
                    }

                    sessao.selecionaCadeira(numeroCadeira, numerosTickets);
                    sessao.exibeCadeiras();

                    System.out.println("\nPossui um cupom promocional?");
                    System.out.println("0: SIM");
                    System.out.println("1: NÃO");
                    aux = s.nextInt();

                    if (aux == 0) {
                        System.out.println("Digite seu cupom promocional");
                        cupom = s.next();

                        if (cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                            System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                            valor = 25.0 * numerosTickets * multiply;
                            valor = valor * cupomPromocional[0].getValor();
                        } else if (cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                            System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                            valor = 25.0 * numerosTickets * multiply;
                            valor = valor * cupomPromocional[1].getValor();
                        } else if (cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                            System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                            valor = 25.0 * numerosTickets * multiply;
                            valor = valor * cupomPromocional[2].getValor();
                        } else {
                            System.out.println("Cupom errado!");
                            valor = 25.0 * numerosTickets * multiply;
                        }

                    } else {
                        valor = 25.0 * numerosTickets * multiply;
                    }

                    bilhete = new Bilhete(user, returnAux, sessao, sala.getOneFilme(returnAux), valor, numeroUnicoCadeira);

                    this.bilhete.setValor(valor);
                    user.setSessao(sessao);
                    user.setBilhete(bilhete);
                } else {
                    throw new ForaCartazException();
                }
            }
            else {
                returnAux = -2;
                throw new ForaHorarioException();
            }
        } catch (ForaHorarioException ex) {
            returnAux = -2;
            System.out.println("Erro de venda: " + ex.getMessage());
        } catch (ForaCartazException ex) {
            returnAux = -2;
            System.out.println("Erro de venda: " + ex.getMessage());
        }
        return returnAux;
    }
}