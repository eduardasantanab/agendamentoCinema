import java.time.LocalTime;

public class ForaHorarioException extends Exception {

    public ForaHorarioException() {
        super("Fora do horario do filme");
    }
    public int foraHorario(String faixaDeHorario){
        String faixaHorarioString = faixaDeHorario;
        String[] faixaHorarioParts = faixaHorarioString.split(" - ");
        String horarioInicioString = faixaHorarioParts[0];
        String horarioFimString = faixaHorarioParts[1];

        LocalTime horarioInicio = LocalTime.parse(horarioInicioString);
        LocalTime horarioFim = LocalTime.parse(horarioFimString);
        LocalTime horarioAtual = LocalTime.now();

        if (horarioAtual.isBefore(horarioFim)) {
            return 0;
        } else {
            return 1;
        }
    }
}