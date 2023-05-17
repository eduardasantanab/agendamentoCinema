import java.util.NoSuchElementException;
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

    public int comprarTicket(Usuario user, CupomPromocional cupom) {
        sala = new Sala();
        int returnAux = 0;

        if(cupom != null) {
            do {
                sala.exibeFilmes();
                System.out.println("Escolha um Filme");
                returnAux = s.nextInt();
            } while (returnAux > 5);
            double valor = 0, multiply = 0;

            try {
                String faixaHorario = sala.horarioFilme(returnAux);
                int response = hora.compare(faixaHorario);
                if (response == 0) {

                    if (returnAux == 0) {
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 0");
                        multiply = salasTipo[0].escolhaSuaSala();
                        sessao0.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao0.sugereCadeiras(); //
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

                            int tamanho = sessao0.getCadeirasDisponiveis().length + 1;

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
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 1");
                        multiply = salasTipo[1].escolhaSuaSala();
                        sessao1.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao1.sugereCadeiras(); //
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

                            int tamanho = sessao1.getCadeirasDisponiveis().length + 1;

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
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 2");
                        multiply = salasTipo[2].escolhaSuaSala();
                        sessao2.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao2.sugereCadeiras(); //
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

                            int tamanho = sessao2.getCadeirasDisponiveis().length + 1;

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
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 3");
                        multiply = salasTipo[3].escolhaSuaSala();
                        sessao3.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao3.sugereCadeiras(); //
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

                            int tamanho = sessao3.getCadeirasDisponiveis().length + 1;

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
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 4");
                        multiply = salasTipo[4].escolhaSuaSala();
                        sessao4.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao4.sugereCadeiras(); //
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

                            int tamanho = sessao4.getCadeirasDisponiveis().length + 1;

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
                        int cont = 0;
                        System.out.println("\nVocê está na sessão 5");
                        multiply = salasTipo[5].escolhaSuaSala();
                        sessao5.exibeCadeiras();
                        do{
                            System.out.println("\nQuantos tickets deseja comprar? ");
                            numerosTickets = s.nextInt();
                            assert numerosTickets != 0;
                        }while (numerosTickets <= 0);
                        sessao5.sugereCadeiras(); //
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

                            int tamanho = sessao5.getCadeirasDisponiveis().length + 1;

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
                } else {
                throw new VendasException("O Horario do filme já passou");
            }

        } catch (VendasException ex) {
            System.out.println("Erro de venda: " + ex.getMessage());
        }

            user.setNumeroTickets(numerosTickets);
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
    
    public int comprarTicket(Usuario user) { //conferir
        sala = new Sala();
        int aux;
        int returnAux;
        do {
            sala.exibeFilmes();
            System.out.println("Escolha um Filme");
            returnAux = s.nextInt();
        } while (returnAux > 5);

        double valor = 0, multiply;

        if (returnAux == 0) {
            int cont = 0;
            System.out.println("\nVocê está na sessão 0");
            multiply = salasTipo[0].escolhaSuaSala();
            sessao0.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao0.sugereCadeiras(); //
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

                int tamanho = sessao0.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
                    for (int i = 0;i < numerosTickets - 1; i++) {
                        numeroCadeira[cont * 2] = numeroCadeira[0];
                        numeroCadeira[(cont * 2) + 1] = numeroCadeira[1] - cont;
                        numeroUnicoCadeira[cont] = numeroCadeira[cont * 2] * 5 + numeroCadeira[(cont * 2) + 1];
                        cont++;
                    }
                }else {
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
            int cont = 0;
            System.out.println("\nVocê está na sessão 1");
            multiply = salasTipo[1].escolhaSuaSala();
            sessao1.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao1.sugereCadeiras(); //
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

                int tamanho = sessao1.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
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
            int cont = 0;
            System.out.println("\nVocê está na sessão 2");
            multiply = salasTipo[2].escolhaSuaSala();
            sessao2.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao2.sugereCadeiras(); //
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

                int tamanho = sessao2.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
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
            int cont = 0;
            System.out.println("\nVocê está na sessão 3");
            multiply = salasTipo[3].escolhaSuaSala();
            sessao3.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao3.sugereCadeiras(); //
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

                int tamanho = sessao3.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
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
            int cont = 0;
            System.out.println("\nVocê está na sessão 4");
            multiply = salasTipo[4].escolhaSuaSala();
            sessao4.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao4.sugereCadeiras(); //
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

                int tamanho = sessao4.getCadeirasDisponiveis().length + 1;
                if (tamanho - numeroCadeira[1] < numerosTickets) {
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
            int cont = 0;
            System.out.println("\nVocê está na sessão 5");
            multiply = salasTipo[5].escolhaSuaSala();
            sessao5.exibeCadeiras();
            do{
                System.out.println("\nQuantos tickets deseja comprar? ");
                numerosTickets = s.nextInt();
                assert numerosTickets != 0;
            }while (numerosTickets <= 0);
            sessao5.sugereCadeiras(); //
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

                int tamanho = sessao5.getCadeirasDisponiveis().length + 1;

                if (tamanho - numeroCadeira[1] < numerosTickets) {
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


