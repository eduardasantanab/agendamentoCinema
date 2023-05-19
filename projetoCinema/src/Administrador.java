import java.util.Scanner;

public class Administrador extends Base implements gerenciaDeFilmes {
    private Scanner s = new Scanner(System.in);
    private double salario;
    private int id;
    private Sala sala;

    public Administrador(Sala sala) {
        this.sala = sala;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sala getSala() {
        return this.sala;
    }

    public boolean excluirUsuario(String cpf) {
        for (Usuario usuario : this.getUsers()) {
            if(usuario.getCpf().compareTo(cpf) == 0) {
                this.getUsers().remove(usuario);
                System.out.println("Usuario removido com sucesso!");
                return true;
            }
        }
        System.out.println("Usuario não encontrado!");
        return false;
    }

    @Override
    public Usuario adicionarUsuario(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao) {

        Usuario user = new Usuario(nome, cpf, senha, idade, sexo, email, nomeCartao, numeroCartao, codigoVerificadorCartao);

        if (this.getUsers().isEmpty()) {
            this.getUsers().add(user);
            System.out.println("Usuario adicionado com sucesso!");
            return user;
        }

        for (Usuario usuario : this.getUsers()) {
            if (usuario.getCpf().compareTo(user.getCpf()) == 0 ) {
                System.out.println("Usuario já foi cadastrado");
                return null;
            }
        }
        this.getUsers().add(user);
        System.out.println("Usuario cadastrado com sucesso!");
        return user;
    }

    @Override
    public Critico adicionarCritico(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao, String origem) {

        Critico critico = new Critico(nome, cpf, senha, idade, sexo, email, nomeCartao, numeroCartao, codigoVerificadorCartao, origem);

        if (this.getUsers().isEmpty()) {
            this.getUsers().add(critico);
            System.out.println("Critico adicionado com sucesso!");
            return critico;
        }

        for (Usuario usuario : this.getUsers()) {
            if (usuario.getCpf().compareTo(critico.getCpf()) == 0 ) {
                System.out.println("Usuario já foi cadastrado");
                return null;
            }
        }

        this.getUsers().add(critico);
        System.out.println("Critico cadastrado com sucesso!");
        return critico;
    }

    @Override
    public Estudante adicionarEstudante(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao) {


        Estudante estudante = new Estudante(nome, cpf, senha, idade, sexo, email, nomeCartao, numeroCartao, codigoVerificadorCartao);

        if (this.getUsers().isEmpty()) {
            this.getUsers().add(estudante);
            System.out.println("Estudante adicionado com sucesso!");
            return estudante;
        }

        for (Usuario usuario : this.getUsers()) {
            if (usuario.getCpf().compareTo(estudante.getCpf()) == 0 ) {
                System.out.println("Usuario já foi cadastrado");
                return null;
            }
        }
        this.getUsers().add(estudante);
        System.out.println("Estudante cadastrado com sucesso!");
        return estudante;
    }

    @Override
    public void alterarUsuario(String cpf) {

        Usuario changedUser = null;
        for (Usuario usuario : this.getUsers()) {
            if (usuario.getCpf().compareTo(cpf) == 0) {
                System.out.println("Usuario encontrado");
                changedUser = usuario;
            }
        }

        if (changedUser != null) {
            System.out.println("Qual informação você deseja alterar: ");
            System.out.println("0: Nome");
            System.out.println("1: Cpf");
            System.out.println("2: Senha");
            System.out.println("3: email");

            int response = s.nextInt();

            if (response == 0) {
                System.out.println("Digite o novo nome: ");
                s.nextLine();
                String newName = s.nextLine();
                changedUser.setNome(newName);
            } else if (response == 1) {
                System.out.println("Digite o novo CPF: ");
                s.nextLine();
                String newCPF = s.nextLine();

                for (Usuario usuario : this.getUsers()) {
                    if (usuario.getCpf().compareTo(newCPF) == 0) {
                        System.out.println("CPF já cadastrado!");
                        return;
                    }
                }

                changedUser.setCpf(newCPF);
            } else if (response == 2) {
                System.out.println("Digite a nova senha");
                s.nextLine();
                String newPassword = s.nextLine();
                changedUser.setSenha(newPassword);
            } else if (response == 3) {
                System.out.println("Digite o novo email");
                s.nextLine();
                String newEmail = s.nextLine();

                for (Usuario usuario : this.getUsers()) {
                    if (usuario.getCpf().compareTo(newEmail) == 0) {
                        System.out.println("Email já cadastrado!");
                        return;
                    }
                }
                changedUser.setEmail(newEmail);
            }

            for (Usuario usuario : this.getUsers()) {
                if(usuario.equals(changedUser)) {
                    this.getUsers().remove(usuario);
                    break;
                }
            }
            this.getUsers().add(changedUser);
            System.out.println("Informações alteradas com sucesso!");
        } else {
            System.out.println("Usuario não encontrado!");
        }
    }

    public void emCartaz(String nomeFilme) {
        for (int i = 0; i < sala.getFilmesAdicionados(); i++) {
            if (sala.getFilmes()[i] != null && sala.getFilmes()[i].getNomeDoFilme().equalsIgnoreCase(nomeFilme)) {
                Filme filme = sala.getOneFilme(i);
                filme.setEmCartaz(!filme.isEmCartaz());
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

        if (encontrado) {
            int response;
            System.out.println("Quais informações você deseja alterar do filme?");

            do {
                System.out.println("0: Nome");
                System.out.println("1: duracao");
                System.out.println("2: sinpose");
                System.out.println("3: valor");
                response = s.nextInt();

            } while (response != 0 && response != 1 && response != 2 && response != 3);

            if (response == 0) {
                System.out.println("Escolha um novo nome para esse filme");
                s.nextLine();
                String novoNomeFilme = s.nextLine();
                sala.getFilmes()[indice].setNomeDoFilme(novoNomeFilme);

            } else if (response == 1) {
                System.out.println("Escolha uma nova duração nesse esquema: 10:00 - 12:00");
                s.nextLine();
                String novaDuracaoFilme = s.nextLine();
                sala.getFilmes()[indice].setDuracaoFilme(novaDuracaoFilme);

            } else if (response == 2) {
                System.out.println("Escolha uma nova sinopse para o filme");
                s.nextLine();
                String novaSinopseFilme = s.nextLine();
                sala.getFilmes()[indice].setSinopse(novaSinopseFilme);

            } else if (response == 3) {
                System.out.println("Escolha um novo valor para o filme");
                double novoValorFilme = s.nextDouble();
                sala.getFilmes()[indice].setValor(novoValorFilme);
            }

            System.out.println("informação alterada com sucesso!");
        } else {
            System.out.println("O filme não foi encontrado no banco de dados!");
        }
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
                        novoArrayFilmes[j].getNomeDoFilme()
                                .compareToIgnoreCase(novoArrayFilmes[j + 1].getNomeDoFilme()) > 0) {
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
}