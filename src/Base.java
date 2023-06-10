import java.util.LinkedList;
public abstract class Base {
    private String nome, email;
    private int idade;
    private LinkedList<Usuario> users = new LinkedList<Usuario>();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LinkedList<Usuario> getUsers() {
        return users;
    }
    public void setUsers(LinkedList<Usuario> users) {
        this.users = users;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public abstract Critico adicionarCritico(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao, String origem);
    public abstract Usuario adicionarUsuario(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao);
    public abstract Estudante adicionarEstudante(String nome, String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao);
    public abstract void alterarUsuario(String ID);
}