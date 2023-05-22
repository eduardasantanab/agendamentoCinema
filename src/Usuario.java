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
    private Compra compra;
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


    public int comprar(Sala sala) throws IndisponivelException {
        int aux;
        compra = new Compra(sala);
        System.out.println("\nMENU");
        System.out.println("0: Comprar Comida");
        System.out.println("1: Comprar Tickets");

        do {
            System.out.println("Escolha uma opção");
            aux = s.nextInt();
        } while (aux != 0 && aux != 1);

        if(aux == 0){
            this.compra.comprarItens(sala, this, numeroTickets);
        } else {
            aux = this.compra.comprarTicket(this);
            return aux;
        }

        return -1;
    }

    public void alterar(Usuario usuario, Sessao sessao, int resp, int numTickets, int[] baseNumUnicoAnterior, Sala sala, int numSala) throws IndisponivelException {
        int cont, adicional, remove, contador = 1;

        int[] numeroUnicoCadeira;

        if(resp == 0){
            cont = 0;
            System.out.println("\nQuantos tickets deseja adicionar? ");
            adicional = s.nextInt();
            int[] posCadeiras = new int[(numTickets + adicional)* 2];
            int[] ticketsFinal = new int[numTickets + adicional];
            numeroUnicoCadeira = new int[numTickets + adicional];

            if(adicional > 1){
                sessao.sugereCadeiras(adicional); //

                System.out.println("\nEscolha o número da linha");
                posCadeiras[0] = s.nextInt();
                System.out.println("Escolha o número da coluna");
                posCadeiras[1] = s.nextInt();
                numeroUnicoCadeira[cont] = posCadeiras[0] * 5 + posCadeiras[1];
                cont++;

                if (sessao.getCadeirasDisponiveis().length - posCadeiras[1] < numTickets) {
                    for (int i = 0;i < adicional - 1; i++) {
                        posCadeiras[cont * 2] = posCadeiras[0];
                        posCadeiras[(cont * 2) + 1] = posCadeiras[1] - cont;
                        numeroUnicoCadeira[cont] = posCadeiras[cont * 2] * 5 + posCadeiras[(cont * 2) + 1];
                        cont++;
                    }
                }
                else {
                    for (int i = 0; i < adicional - 1; i++) {
                        posCadeiras[cont * 2] = posCadeiras[0];
                        posCadeiras[(cont * 2) + 1] = posCadeiras[1] + cont;
                        numeroUnicoCadeira[cont] = posCadeiras[cont * 2] * 5 + posCadeiras[(cont * 2) + 1];
                        cont++;
                    }
                }
                setNumeroUnicoCadeira(numeroUnicoCadeira);//
            } else { //se for menor que 2 de adicionais
                for (int i = 0; i < adicional; i++) {
                    System.out.println("\nEscolha o número da linha");
                    posCadeiras[cont * 2] = s.nextInt();
                    System.out.println("Escolha o número da coluna");
                    posCadeiras[(cont * 2) + 1] = s.nextInt();
                    numeroUnicoCadeira[cont] = posCadeiras[cont * 2] * 5 + posCadeiras[(cont * 2) + 1];
                    cont++;
                }
            }

            sessao.selecionaCadeira(posCadeiras, adicional);

            for (int i = 0; i < baseNumUnicoAnterior.length; i++) {
                ticketsFinal[i] = baseNumUnicoAnterior[i]; //numAux é o numero unico da cadeira antes de alterar, para ser cumulativo
            }

            for (int i = baseNumUnicoAnterior.length; i < (numTickets+adicional); i++) {
                ticketsFinal[i] = numeroUnicoCadeira[adicional-contador];
                contador++;
            }

            bilhete = new Bilhete(usuario, numSala, sessao, sala.getOneFilme(numSala), (25.0 * (numTickets+adicional)), ticketsFinal);
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
            int[] remocao = new int[numTickets];
            int[] resultado = new int[numTickets - remove];


            if(remove == numTickets){
                cancelarCompra();
            }else {
                System.out.println("\n[Cadeiras do bilhete atual]");
                for (int i = 0; i < baseNumUnicoAnterior.length; i++) {
                    System.out.println("Número: " + baseNumUnicoAnterior[i]);
                }

                if (remove <= numTickets){
                    for(int i = 0; i < remove; i++){
                        System.out.println("\nEscolha o número da cadeira que deseja remover: ");
                        posicao[i] = s.nextInt();
                        cont = 0;
                        for(int j = 0; j < numTickets; j++){
                            if(posicao[i] != baseNumUnicoAnterior[j]){
                                baseNumUnicoAnterior[cont] = baseNumUnicoAnterior[j];
                                cont++;
                            }
                        }
                    }
                }

                for (int i = 0; i < resultado.length; i++) {
                    resultado[i] = baseNumUnicoAnterior[i];
                }

                usuario.setNumeroTickets(numTickets - remove);
                bilhete = new Bilhete(usuario, numSala, sessao, sala.getOneFilme(numSala), (25.0 * (numTickets - remove)), resultado);
                sessao.cancelarCadeira(posicao);
                sessao.exibeCadeiras();
                usuario.setBilhete(bilhete);
                usuario.dizBilhete();
            }
        }
    }
    public void cancelarCompra(){
        setBilhete(null);
        setNumeroTickets(0);
        System.out.println("O bilhete foi removido com sucesso!");
    }
}