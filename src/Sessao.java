import java.util.Objects;

public class Sessao {

    private String filme;
    private String[][] cadeirasDisponiveis = new String[10][15];
    private String ocupado = "[X]";
    private String disponivel = "[]";


    public Sessao() {
        for (int i = 0; i < cadeirasDisponiveis.length; i++) {
            for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                this.cadeirasDisponiveis[i][j] = disponivel;
            }
        }

//      cadeiras pré selecionadas
        cadeirasDisponiveis[6][8] = ocupado;
        cadeirasDisponiveis[6][10] = ocupado;

        for (int i = 3; i < 4; i++) {
            for (int j = 4; j < 8; j++) {
                this.cadeirasDisponiveis[i][j] = ocupado;
            }
        }
        for (int i = 5; i < 6; i++) {
            for (int j = 2; j < 4; j++) {
                this.cadeirasDisponiveis[i][j] = ocupado;
            }
        }
        for (int i = 8; i < 9; i++) {
            for (int j = 8; j < 11; j++) {
                this.cadeirasDisponiveis[i][j] = ocupado;
            }
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 8; j < 10; j++) {
                this.cadeirasDisponiveis[i][j] = ocupado;
            }
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                this.cadeirasDisponiveis[i][j] = ocupado;
            }
        }
//
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String[][] getCadeirasDisponiveis() {
        return cadeirasDisponiveis;
    }

    public void setCadeirasDisponiveis(String[][] cadeirasDisponiveis) {
        this.cadeirasDisponiveis = cadeirasDisponiveis;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getOcupado() {
        return ocupado;
    }

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }

    public void exibeCadeiras() {
        System.out.println("\nCadeiras disponíveis [ ] | Cadeiras ocupadas [X] | Posições sugeridas [$]: ");

        for (int i = 0; i < this.cadeirasDisponiveis.length; i++) {
            for (int j = 0; j < this.cadeirasDisponiveis[0].length; j++) {
                if (this.cadeirasDisponiveis[i][j] == null) {
                    this.cadeirasDisponiveis[i][j] = "[]";
                }
                System.out.print(this.cadeirasDisponiveis[i][j]);
            }
            System.out.println("");
        }
    }

    public void cancelarCadeira(int[] numeroUnicoCadeira) {

        for (int i = 0; i < cadeirasDisponiveis.length; i++) {
            for (int j = 0; j < numeroUnicoCadeira.length; j++) {
                //linha = índice / número_de_colunas
                //coluna = índice % número_de_colunas
                int linha = numeroUnicoCadeira[j] / 5;
                int coluna = numeroUnicoCadeira[j] % 5;

                cadeirasDisponiveis[linha][coluna] = "[$]";
            }
        }
    }

    public void sugereCadeiras(int numTickets) {
        int cont;

        for (int i = 0; i < getCadeirasDisponiveis().length; i++) {
            cont = 0;
            for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                if((j + numTickets) >= (cadeirasDisponiveis[i].length)){
                    cadeirasDisponiveis[i][j] = "[.]";
                }
                for (int k = 0; k < numTickets; k++) {
                    if(Objects.equals(cadeirasDisponiveis[i][j], disponivel)){
                        cadeirasDisponiveis[i][j] = "[$]";
                        cont++;
                        if(cont == numTickets){
                            if(j < cadeirasDisponiveis[i].length - 1){
                                cadeirasDisponiveis[i][j + 1] = "[.]";
                                cont = 0;
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < cadeirasDisponiveis.length; i++) {
            System.out.println();
            for (int j = 0; j < cadeirasDisponiveis[i].length - 1; j++) {
                System.out.print(cadeirasDisponiveis[i][j]);
            }
        }
    }

    public void selecionaCadeira(int[] posicao, int numBilhetes) throws IndisponivelException{
        ocupado = "[X]";

        if (numBilhetes == 1) {
            for (int i = 0; i < cadeirasDisponiveis.length; i++) {
                for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                    if (i == posicao[0] && j == posicao[1]) {
                        if (cadeirasDisponiveis[i][j].equals(ocupado)) {
                            IndisponivelException ex;
                            ex = new IndisponivelException();
                            throw ex;
                        }
                        this.cadeirasDisponiveis[i][j] = ocupado;
                    }
                }
            }
        } else if (numBilhetes > 1) {
            int aux = 0;
            int cont1, cont2;
            for (int i = 0; i < cadeirasDisponiveis.length; i++) {
                for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                    if (aux * 2 >= posicao.length) {
                        return;
                    }
                    int tamanho = cadeirasDisponiveis[i].length;

                    if (tamanho - j < numBilhetes) {
                        cont1 = posicao[aux * 2];
                        cont2 = posicao[(aux * 2) + 1];
                        if (i == posicao[cont1] && j == posicao[cont2]) {
                            for (int m = 0; m < numBilhetes; m++) {
                                this.cadeirasDisponiveis[cont1][cont2] = ocupado;
                                cont2--;
                            }
                        }
                    } else {
                        if (i == posicao[aux * 2] && j == posicao[(aux * 2) + 1]) {
                            cont1 = posicao[aux * 2];
                            cont2 = posicao[(aux * 2) + 1];
                            for (int k = 0; k < numBilhetes; k++) {
                                this.cadeirasDisponiveis[cont1][cont2] = ocupado;
                                cont2++;
                            }
                            aux++;
                        }
                    }
                    if (cadeirasDisponiveis[(posicao[aux * 2])][posicao[((aux * 2) + 1)]].equals("[$]")) {

                        int  cont;
                        for (int m = 0; m < getCadeirasDisponiveis().length; m++) {
                            cont = 0;
                            for (int n = 0; n < cadeirasDisponiveis[m].length; n++) {
                                for (int k = 0; k < numBilhetes; k++) {
                                    if (Objects.equals(cadeirasDisponiveis[i][j], "[$]")) {
                                        cadeirasDisponiveis[i][j] = ocupado;
                                        cont++;
                                        if (cont == numBilhetes) {
                                        }
                                    }
                                }
                            }
                        }
                        cadeirasDisponiveis[(posicao[aux * 2])][posicao[((aux * 2) + 1)]] = ocupado;
                        aux++;
                        return;
                    }
                    if (cadeirasDisponiveis[posicao[aux * 2]][posicao[(aux * 2) + 1]].equals(ocupado)) {
                        return;
                    }
                }

                if (aux * 2 >= posicao.length) {
                    return;
                }
            }
        } else {
            throw new IndisponivelException();
        }
    }
}