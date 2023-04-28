import java.util.Scanner;
public class Usuario {

    private String nome;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private String nomeCartao;
    private String numeroCartao;
    private String codigoVerificadorCartao;
    private Scanner s;
    private Bilhete bilhete;
    private Compra compra = new Compra();
    private int numeroTickets = 0;
    private int[] numeroCadeiraaux;
    private int[] numeroUnicoCadeira;
    private Sessao sessao;


    public Usuario(String nome,String cpf, String senha, int idade, String sexo, String email, String nomeCartao, String numeroCartao, String codigoVerificadorCartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.codigoVerificadorCartao = codigoVerificadorCartao;
        this.s = new Scanner(System.in);

    }

    public Compra getCompra() {
        return compra;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Sessao getSessao() {
        return this.sessao;
    }
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }



    public void setIdade(int idade) {
        this.idade = idade;
    }



    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }



    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }



    public void setCodigoVerificadorCartao(String codigoVerificadorCartao) {
        this.codigoVerificadorCartao = codigoVerificadorCartao;
    }

    public int[] getNumeroCadeiraaux() {
        return numeroCadeiraaux;
    }

    public void setNumeroCadeiraaux(int[] numeroCadeiraaux) {
        this.numeroCadeiraaux = numeroCadeiraaux;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getSenha() {
        return this.senha;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNomeCartao() {
        return this.nomeCartao;
    }

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public String getCodigoVerificadorCartao() {
        return this.codigoVerificadorCartao;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public void setNumeroTickets(int num) {
        this.numeroTickets = num;
    }

    public int getNumeroTickets() {
        return this.numeroTickets;
    }

    public void setNumeroCadeiraAux(int []cadeiraAux) {
        this.numeroCadeiraaux = cadeiraAux;
    }

    public int[] getNumeroCadeiraAux() {
        return this.numeroCadeiraaux;
    }

    public void setNumeroUnicoCadeira(int []cadeiraUnico) {
        this.numeroUnicoCadeira = cadeiraUnico;
    }

    public int[] getNumeroUnicoCadeira() {
        return this.numeroUnicoCadeira;
    }

    public void dizBilhete(){
        String toString = this.bilhete.toString();
        System.out.println(toString);
        this.bilhete.cadeiras();
    }


    public int comprar(){
        int aux;
        System.out.println("\nMENU");
        System.out.println("0: Comprar Comida");
        System.out.println("1: Comprar Tickets");

        do {
            System.out.println("Escolha uma opção");
            aux = s.nextInt();
        } while (aux != 0 && aux != 1);

        if(aux == 0){
            this.compra.comprarItens(this.numeroTickets);
        } else {
            aux = this.compra.comprarTicket(this);
            return aux;
        }

        return -1;
    }

    public void alterar(Usuario usuario, Sessao sessao, int resp, int numTickets, int[] numAux, Sala sala, int numSala){
        int cont, adicional, remove, contador = 1;

        int[] numeroUnicoCadeira;

        if(resp == 0){
            cont = 0;
            System.out.println("\nQuantos tickets deseja adicionar? ");
            adicional = s.nextInt();
            int[] numCadeira = new int[(numTickets + adicional)* 2];
            int[] adicionadas = new int[numTickets + adicional];
            numeroUnicoCadeira = new int[numTickets + adicional];

            if(adicional > 1){
                sessao.sugereCadeiras();
            }

            for (int i = 0; i < adicional; i++) {
                System.out.println("\nEscolha o número da linha");
                numCadeira[cont * 2] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                numCadeira[(cont * 2) + 1] = s.nextInt();
                numeroUnicoCadeira[cont] = numCadeira[cont * 2] * 5 + numCadeira[(cont * 2) + 1];
                cont++;
            }

            sessao.selecionaCadeira(numCadeira, (numTickets+adicional));

            for (int i = 0; i < numAux.length; i++) {
                adicionadas[i] = numAux[i];
            }

            for (int i = numAux.length; i < (numTickets+adicional); i++) {
                adicionadas[i] = numeroUnicoCadeira[adicional-contador];
                contador++;
            }

            bilhete = new Bilhete(usuario, numSala, sessao, sala.getOneFilme(numSala), (25.0 * (numTickets+adicional)), adicionadas);
            usuario.setNumeroTickets(numTickets + adicional);
            sessao.exibeCadeiras();
            usuario.setBilhete(bilhete);
            usuario.dizBilhete();
        }
        else if(resp == 1) {
            cont = 0;
            System.out.println("\nQuantos tickets deseja remover? ");
            remove = s.nextInt();
            int[] posicao = new int[remove];
            int[] removidas = new int[numTickets - remove];

            if (remove <= numTickets){
                for(int i = 0; i < remove; i++){
                    System.out.println("\nEscolha o numero da " + (i+1) + "ª cadeira que deseja remover: ");
                    posicao[i] = s.nextInt();
                    for(int j = 0; j < numTickets; j++){
                        if(posicao[i] != numAux[j]){
                            removidas[cont] = numAux[j];
                            cont++;
                        }
                    }
                }
            }

            usuario.setNumeroTickets(numTickets - remove);
            bilhete = new Bilhete(usuario, numSala, sessao, sala.getOneFilme(numSala), (25.0 * (numTickets - remove)), removidas);
            sessao.cancelarCadeira(removidas);
            sessao.exibeCadeiras();
            usuario.setBilhete(bilhete);
            usuario.dizBilhete();
        }
    }
    public void cancelarCompra(){
        setBilhete(null);
        setNumeroTickets(0);
    }
}