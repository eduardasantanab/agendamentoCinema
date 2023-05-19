public enum Produtos{
    REFRIGERANTE("Refrigerante", 10),
    PIPOCA("Pipoca", 40),
    CHOCOLATE("Chocolate", 12),
    CHIPS("Chips", 18),
    SORVETE("Sorvete", 23);

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