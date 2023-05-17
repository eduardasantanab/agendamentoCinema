public class Sessao {

    private String filme;
    private String[][] cadeirasDisponiveis = new String[2][3];
    private String ocupado = "[X]";
    private String disponivel = "[]";


    public Sessao() {
        for (int i = 0; i < cadeirasDisponiveis.length; i++) {
            for (int j = 0; j < cadeirasDisponiveis.length; j++) {
                this.cadeirasDisponiveis[i][j] = disponivel;
            }
        }
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

                cadeirasDisponiveis[linha][coluna] = disponivel;
            }
        }
    }

    public void sugereCadeiras() {
        for (int i = 0; i < getCadeirasDisponiveis().length; i++) {
            System.out.println();
            for (int j = 0; j < cadeirasDisponiveis[i].length - 1; j++) {
                if (cadeirasDisponiveis[i][j].equals("[]") && cadeirasDisponiveis[i][j + 1].equals("[]")) {
                    cadeirasDisponiveis[i][j] = "[$]";
                    cadeirasDisponiveis[i][j + 1] = "[$]";
                    System.out.print(cadeirasDisponiveis[i][j + 1]);
                } else if (cadeirasDisponiveis[i][j].equals("[$]") && cadeirasDisponiveis[i][j + 1].equals("[]")) {
                    cadeirasDisponiveis[i][j + 1] = "[$]";
                } else if (cadeirasDisponiveis[i][j].equals("[X]") && cadeirasDisponiveis[i][j + 1].equals("[]")) {
                    cadeirasDisponiveis[i][j + 1] = "[]";
                }
                System.out.print(cadeirasDisponiveis[i][j]);
            }
        }
    }

    public void selecionaCadeira(int[] posicao, int numBilhetes) {
        ocupado = "[X]";

        try {
            if (numBilhetes == 1) {
                for (int i = 0; i < cadeirasDisponiveis.length; i++) {
                    for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                        if (i == posicao[0] && j == posicao[1]) {
                            if (cadeirasDisponiveis[i][j].equals(ocupado)) {
                                throw new VendasException("Esta cadeira já está ocupada");
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
                        int tamanho = this.getCadeirasDisponiveis().length + 1; //numero de colunas

                        if (tamanho - j < numBilhetes) {
                            cont1 = posicao[aux * 2];
                            cont2 = posicao[(aux * 2) + 1];
                            if (i == posicao[cont1] && j == posicao[cont2]) {
                                for (int m = 0; m < numBilhetes; m++) {
                                    this.cadeirasDisponiveis[cont1][cont2] = ocupado;
                                    cont2--;
                                }
                            }
                        } else { //botei
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

                        if (cadeirasDisponiveis[i][j].equals(ocupado)) {
                            return;
                        }
                    }

                    if (aux * 2 >= posicao.length) {
                        return;
                    }
                }
            } else {
                throw new VendasException("Escolha uma quantidade possível!");
            }
        } catch (VendasException ex) {
            System.out.println("Erro de seleção: " + ex.getMessage());

        }
    }
}
