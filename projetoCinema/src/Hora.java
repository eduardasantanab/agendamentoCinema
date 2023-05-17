import java.time.LocalTime;
public class Hora {
    public Hora() {

    }
    public int compare(String faixaDeHorario) {
        String faixaHorarioString = faixaDeHorario;
        String[] faixaHorarioParts = faixaHorarioString.split(" - ");
        String horarioInicioString = faixaHorarioParts[0];
        String horarioFimString = faixaHorarioParts[1];

        LocalTime horarioInicio = LocalTime.parse(horarioInicioString);
        LocalTime horarioFim = LocalTime.parse(horarioFimString);
        LocalTime horarioAtual = LocalTime.now();

        if (horarioAtual.isAfter(horarioInicio) && horarioAtual.isBefore(horarioFim)) {
            return 0;
        } else {
            return 1;
        }
    }
}