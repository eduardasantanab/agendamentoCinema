import java.util.Objects;

public class IndisponivelException extends Exception {

    public IndisponivelException() {
        super("Esta cadeira está indisponível!");
    }

    public IndisponivelException(String[][] cadeirasDisponiveis) throws IndisponivelException {
        for (int i = 0; i < cadeirasDisponiveis.length; i++) {
            for (int j = 0; j < cadeirasDisponiveis[i].length; j++) {
                if (Objects.equals(cadeirasDisponiveis[i][j], "[X]")) {
                    IndisponivelException ex;
                    ex = new IndisponivelException();
                    throw ex;
                }
            }
        }
    }
}