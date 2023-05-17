import java.util.Scanner;
public class Funcionario extends Base implements GerenciaFilme {
    private Scanner s = new Scanner(System.in);
    private double salario;
    private Sala sala;

    public Funcionario(String nome, int idade, String email, Sala sala, double salario) {
        super(nome, idade, email);
        this.sala = sala;
        this.salario = salario;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    @Override
    public void adicionarUsuario() {

    }

    @Override
    public void alterarUsuario() {


    }

    @Override
    public void incluirFilme(String nomeDoFilme, String duracaoDoFilme, String sinopse, double valor) {
        Filme novoFilme = new Filme(nomeDoFilme, duracaoDoFilme, sinopse, valor);

        sala.setFilmesAdicionados(sala.getFilmesAdicionados() + 1);
        for (int i = 0; i < sala.getFilmesAdicionados(); i++) {
            if (sala.getFilmes()[i] == null) {
                sala.getFilmes()[i] = novoFilme;
                break;
            }
        }
    }

    @Override
    public void alterarFilme(String nomeFilme) {

        int indice = 0;
        boolean encontrado = false;
        for (int i = 0; i < sala.getFilmesAdicionados(); i++) {
            if (sala.getFilmes()[i] != null && sala.getFilmes()[i].getNomeDoFilme().equalsIgnoreCase(nomeFilme)) {
                System.out.println("Filme encontrado");
                indice = i;
                encontrado = true;
            }
        }

        if(encontrado == true) {
            int response;
            System.out.println("Quais informações você deseja alterar do filme?");
            do {

                System.out.println("0: Nome");
                System.out.println("1: duracao");
                System.out.println("2: sinpose");
                System.out.println("3: valor");
                response = s.nextInt();

            } while (response != 0 && response != 1 && response != 2 && response != 3);




            if( response == 0 ) {
                System.out.println("Escolha um novo nome para esse filme");
                s.nextLine();
                String novoNomeFilme = s.nextLine();
                sala.getFilmes()[indice].setNomeDoFilme(novoNomeFilme);

            } else if ( response == 1 ) {
                System.out.println("Escolha uma nova duração nesse esquema: 10:00 - 12:00");
                s.nextLine();
                String novaDuracaoFilme = s.nextLine();
                sala.getFilmes()[indice].setDuracaoFilme(novaDuracaoFilme);

            } else if ( response == 2 ) {
                System.out.println("Escolha uma nova sinopse para o filme");
                s.nextLine();
                String novaSinopseFilme = s.nextLine();
                sala.getFilmes()[indice].setSinopse(novaSinopseFilme);

            } else if ( response == 3 ) {
                System.out.println("Escolha um novo valor para o filme");
                double novoValorFilme = s.nextDouble();
                sala.getFilmes()[indice].setValor(novoValorFilme);

            }


        } else {
            System.out.println("O filme não foi encontrado no banco de dados!");
        }

        System.out.println("informação alterada com sucesso!");

    }

    @Override
    public void excluirFilme(String target) {
        for (int i = 0; i < sala.getFilmesAdicionados(); i++) {
            if (sala.getFilmes()[i] != null && sala.getFilmes()[i].getNomeDoFilme().equalsIgnoreCase(target)) {
                System.out.println("Filme encontrado");
                sala.getFilmes()[i] = null;
            }
        }

        sala.setFilmesAdicionados(sala.getFilmesAdicionados() - 1);

        int n = sala.getFilmesAdicionados();
        Filme[] novoArrayFilmes = sala.getFilmes();
        boolean trocado;

        for (int i = 0; i < n - 1; i++) {
            trocado = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (novoArrayFilmes[j] != null && novoArrayFilmes[j + 1] != null &&
                        novoArrayFilmes[j].getNomeDoFilme().compareToIgnoreCase(novoArrayFilmes[j + 1].getNomeDoFilme()) > 0) {
                    Filme temp = novoArrayFilmes[j];
                    novoArrayFilmes[j] = novoArrayFilmes[j + 1];
                    novoArrayFilmes[j + 1] = temp;
                    trocado = true;
                }
            }

            if (!trocado) {
                break;
            }
        }

        sala.setFilmes(novoArrayFilmes);

    }
}