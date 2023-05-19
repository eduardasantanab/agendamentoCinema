public enum CupomPromocional {
    PRIMEIRACOMPRA("primeiracompra", 0.5),
    CINE("cine", 0.3),
    FERIAS("ferias", 0.4);

    private String cupom;
    private double valor;

    CupomPromocional(String cupom, double valor) {
        this.cupom = cupom;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getCupom() {
        return cupom;
    }

}