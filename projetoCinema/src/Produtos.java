public enum Produtos{
    REFRIGERANTE("Refrigerante", 40),
    PIPOCA("Pipoca", 30),
    CHOCOLATE("Chocolate", 20),
    MAXSTELL("Maxstell", 50),
    BARBIE("Barbie", 60);

    private String nome;
    private double valor;

    Produtos(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.valor;
    }

    /*
        Método para listar todos os valores dentro de um enum
        public void exibeProdutos() {
            int cont = 0;
            for (Produtos produto : values()) {
                System.out.println(cont+" "+produto.getNome() + " R$" + produto.getPreco());
                cont++;
            }
        }

     */
}