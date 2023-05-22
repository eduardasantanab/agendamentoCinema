import java.util.Scanner;

public enum SalasTipo {
    TIPOCOMUM("Tipo comum", 1.0),
    SALA3D("Tipo 3D", 1.2),
    SALAXD("Tipo XD", 1.3),
    SALAXD3D("Tipo XD/3D", 1.4);

    private String sala;
    private double valor;
    private Scanner s = new Scanner(System.in);
    SalasTipo(String sala, double valor) {
        this.sala = sala;
        this.valor = valor;
    }

    public String getSala() {
        return sala;
    }

    public double getValor() {
        return valor;
    }

    public double escolhaSuaSala() {
        System.out.println("\nQual tipo de sala deseja comprar?");
        int cont = 0;
        double result;

        for (SalasTipo sala : values()) {
            System.out.println(cont+": "+sala.sala);
            cont++;
        }

        result = s.nextInt();

        if(result == 0) {
            return TIPOCOMUM.valor;
        } else if (result == 1) {
            return SALA3D.valor;
        } else if (result == 2) {
            return SALAXD.valor;
        } else if (result == 3) {
            return SALAXD3D.valor;
        }

        return result;
    }
}