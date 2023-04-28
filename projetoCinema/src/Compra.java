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
    int[] numeroUnicoaaux;

    private String cupom;
    CupomPromocional[] cupomPromocional = CupomPromocional.values();
    SalasTipo[] salasTipo = SalasTipo.values();
    Sessao sessao0 = new Sessao();
    Sessao sessao1 = new Sessao();
    Sessao sessao2 = new Sessao();
    Sessao sessao3 = new Sessao();
    Sessao sessao4 = new Sessao();
    Sessao sessao5 = new Sessao();
    private Bilhete bilhete;

    public Compra() {
        itens = new String[3];
        itens[0] = "Refrigerante";
        itens[1] = "Pipoca";
        itens[2] = "Chocolate";
        this.s = new Scanner(System.in);
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
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

    public Produtos[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos[] produtos) {
        this.produtos = produtos;
    }

    public SalasTipo[] getSalasTipo() {
        return salasTipo;
    }

    public void setSalasTipo(SalasTipo[] salasTipo) {
        this.salasTipo = salasTipo;
    }

    public Sessao getSessao0() {
        return sessao0;
    }

    public void setSessao0(Sessao sessao0) {
        this.sessao0 = sessao0;
    }

    public Sessao getSessao1() {
        return sessao1;
    }

    public void setSessao1(Sessao sessao1) {
        this.sessao1 = sessao1;
    }

    public Sessao getSessao2() {
        return sessao2;
    }

    public void setSessao2(Sessao sessao2) {
        this.sessao2 = sessao2;
    }

    public Sessao getSessao3() {
        return sessao3;
    }

    public void setSessao3(Sessao sessao3) {
        this.sessao3 = sessao3;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }

    public Sessao getSessao4() {
        return sessao4;
    }

    public void setSessao4(Sessao sessao4) {
        this.sessao4 = sessao4;
    }

    public Sessao getSessao5() {
        return sessao5;
    }

    public void setSessao5(Sessao sessao5) {
        this.sessao5 = sessao5;
    }


    public int comprarTicket(Usuario user, CupomPromocional cupom) {
        sala = new Sala();
        int returnAux = 0;

        if(cupom != null) {
            do {
                sala.exibeFilmes();
                System.out.println("Escolha um Filme");
                returnAux = s.nextInt();
            } while (returnAux > 5);
            int[] numeroCadeiraaux;
            double valor = 0, multiply = 0;

            if (returnAux == 0) {
                System.out.println("\nVocê está na sessão 0");
                sessao0.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (sessao0.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao0.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao0.exibeCadeiras();

                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[2].getValor();
                } else {
                    System.out.println("Cupom errado!");
                    valor = 25.0 * numerosTickets * multiply;
                }


                bilhete = new Bilhete(user, 0, sessao0, sala.getOneFilme(0), valor, numeroUnicoCadeira);
                this.bilhete.setValor(valor);

                user.setSessao(sessao0);
                user.setBilhete(bilhete);

            } else if (returnAux == 1) {
                System.out.println("\nVocê está na sessão 1");
                sessao1.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (sessao0.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao1.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao1.exibeCadeiras();

                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[2].getValor();
                } else {
                    System.out.println("Cupom errado!");
                    valor = 25.0 * numerosTickets * multiply;
                }

                bilhete = new Bilhete(user, 1, sessao1, sala.getOneFilme(1), valor, numeroUnicoCadeira);
                this.bilhete.setValor(valor);

                user.setSessao(sessao1);
                user.setBilhete(bilhete);
            } else if (returnAux == 2) {

                System.out.println("\nVocê está na sessão 2");
                sessao2.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (sessao0.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao2.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao2.exibeCadeiras();

                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[2].getValor();
                } else {
                    System.out.println("Cupom errado!");
                    valor = 25.0 * numerosTickets * multiply;
                }

                bilhete = new Bilhete(user, 2, sessao2, sala.getOneFilme(2), valor, numeroUnicoCadeira);
                this.bilhete.setValor(valor);

                user.setSessao(sessao2);
                user.setBilhete(bilhete);
            } else if (returnAux == 3) {

                System.out.println("\nVocê está na sessão 3");
                sessao3.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (sessao0.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao3.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao3.exibeCadeiras();

                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[2].getValor();
                } else {
                    System.out.println("Cupom errado!");
                    valor = 25.0 * numerosTickets * multiply;
                }
                bilhete = new Bilhete(user, 3, sessao3, sala.getOneFilme(3), valor, numeroUnicoCadeira);
                this.bilhete.setValor(valor);

                user.setSessao(sessao3);
                user.setBilhete(bilhete);
            } else if (returnAux == 4) {

                System.out.println("\nVocê está na sessão 4");
                sessao4.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (user.getSessao().getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao4.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao4.exibeCadeiras();

                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[2].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[2].getValor();
                } else {
                    System.out.println("Cupom errado!");
                    valor = 25.0 * numerosTickets * multiply;
                }

                bilhete = new Bilhete(user, 4, sessao4, sala.getOneFilme(4), valor, numeroUnicoCadeira);
                this.bilhete.setValor(valor);
                user.setSessao(sessao4);
                user.setBilhete(bilhete);
            } else if (returnAux == 5) {

                System.out.println("\nVocê está na sessão 5");
                sessao5.exibeCadeiras();
                int cont = 0;
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                multiply = salasTipo[0].escolhaSuaSala();
                numeroCadeira = new int[numerosTickets * 2];
                numeroUnicoCadeira = new int[numerosTickets];


                if (numerosTickets > 1) {

                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[0] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                    cont++;

                    if (sessao5.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
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
                    numeroUnicoaaux = numeroUnicoCadeira;

                } else {
                    for (int i = 0; i < numerosTickets; i++) {
                        System.out.println("\nEscolha o número da linha");
                        numeroCadeira[cont * 2] = s.nextInt();
                        System.out.println("Escolha o número da coluna");
                        numeroCadeira[(cont * 2) + 1] = s.nextInt();
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                    numeroUnicoaaux = numeroUnicoCadeira;
                }

                sessao5.selecionaCadeira(numeroCadeira, numerosTickets);
                sessao5.exibeCadeiras();


                if (this.cupom.toLowerCase().compareTo(cupomPromocional[0].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[0].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[0].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[1].getCupom().toLowerCase()) == 0) {
                    System.out.println("O Cupom: " + cupomPromocional[1].getCupom() + ", Foi adicionado com sucesso!");
                    valor = 25.0 * numerosTickets * multiply;
                    valor = valor * cupomPromocional[1].getValor();
                } else if (this.cupom.toLowerCase().compareTo(cupomPromocional[2].getCupom().toLowerCase()) == 0) {
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
            bilhete = new Bilhete(user, 5, sessao5, sala.getOneFilme(5), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao5);
            user.setBilhete(bilhete);
        }else {
            comprarTicket(user);
        }
            return returnAux;
        }


    public void comprarItens(int numBilhetes, CupomPromocional cupom) {
    int aux, desconto;
    desconto = 1 - (Integer.parseInt(this.cupom)/100);
    double total = 0;
    System.out.println("\nAlimentos disponíveis");

    if(cupom != null){
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
        } while (aux != 1);


        System.out.println("\nTotal da compra: R$" + (total + (numBilhetes * 25.00)));
        bilhete.setValor((total + (numBilhetes * 25.00)));
    }else {
        comprarItens(numBilhetes);
    }

}

    public void comprarItens(int numBilhetes) {
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
        } while (aux != 1);


        System.out.println("\nTotal da compra: R$" + (total + bilhete.getValor()));
        bilhete.setValor((total + bilhete.getValor()));
    }
    
    public int comprarTicket(Usuario user) {
        sala = new Sala();
        int aux;
        int returnAux;
        do {
            sala.exibeFilmes();
            System.out.println("Escolha um Filme");
            returnAux = s.nextInt();
        } while (returnAux > 5);
        int[] numeroCadeiraaux;
        double valor = 0, multiply;

        if (returnAux == 0) {
            System.out.println("\nVocê está na sessão 0");
            sessao0.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            user.setNumeroTickets(numerosTickets);
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao0.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao0.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao0.exibeCadeiras();

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

            bilhete = new Bilhete(user, 0, sessao0, sala.getOneFilme(0), valor, numeroUnicoCadeira);

            this.bilhete.setValor(valor);
            user.setSessao(sessao0);
            user.setBilhete(bilhete);

        } else if (returnAux == 1) {
            System.out.println("\nVocê está na sessão 1");
            sessao1.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao1.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao1.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao1.exibeCadeiras();

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

            bilhete = new Bilhete(user, 1, sessao1, sala.getOneFilme(1), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao1);
            user.setBilhete(bilhete);
        } else if (returnAux == 2) {

            System.out.println("\nVocê está na sessão 2");
            sessao2.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao2.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao2.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao2.exibeCadeiras();

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

            bilhete = new Bilhete(user, 2, sessao2, sala.getOneFilme(2), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao2);
            user.setBilhete(bilhete);
        } else if (returnAux == 3) {

            System.out.println("\nVocê está na sessão 3");
            sessao3.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao3.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao3.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao3.exibeCadeiras();

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

            bilhete = new Bilhete(user, 3, sessao3, sala.getOneFilme(3), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao3);
            user.setBilhete(bilhete);

        } else if (returnAux == 4) {

            System.out.println("\nVocê está na sessão 4");
            sessao4.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao4.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao4.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao4.exibeCadeiras();

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

            bilhete = new Bilhete(user, 4, sessao4, sala.getOneFilme(4), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao4);
            user.setBilhete(bilhete);

        } else if (returnAux == 5) {

            System.out.println("\nVocê está na sessão 5");
            sessao5.exibeCadeiras();
            int cont = 0;
            System.out.println("\nQuantos tickets deseja comprar? ");
            numerosTickets = s.nextInt();
            multiply = salasTipo[0].escolhaSuaSala();
            numeroCadeira = new int[numerosTickets * 2];
            numeroUnicoCadeira = new int[numerosTickets];


            if (numerosTickets > 1) {

                System.out.println("\nEscolha o número da linha");
                numeroCadeira[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numeroCadeira[1] = s.nextInt();
                numeroUnicoCadeira[cont] = numeroCadeira[0] * 5 + numeroCadeira[1];
                cont++;

                if (sessao5.getCadeirasDisponiveis().length - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] + cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }
                numeroUnicoaaux = numeroUnicoCadeira;

            } else {
                for (int i = 0; i < numerosTickets; i++) {
                    System.out.println("\nEscolha o número da linha");
                    numeroCadeira[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    numeroCadeira[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                    cont++;
                }
                numeroUnicoaaux = numeroUnicoCadeira;
            }

            sessao5.selecionaCadeira(numeroCadeira, numerosTickets);
            sessao5.exibeCadeiras();

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

            bilhete = new Bilhete(user, 5, sessao5, sala.getOneFilme(5), valor, numeroUnicoCadeira);
            this.bilhete.setValor(valor);

            user.setSessao(sessao5);
            user.setBilhete(bilhete);
        }
        return returnAux;
    }
}


