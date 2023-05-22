public class QuickWithoutPartition {

    public static void sort(Filme[] vetFilmes, int qtdAdicionados) {
        sort(vetFilmes, 0, qtdAdicionados - 1);
    }
    private static void sort(Filme[] vetFilmes, int inicio, int qtdFilmes) {
        if (qtdFilmes <= inicio)
            return;

        int lt = inicio;
        int i = inicio + 1;
        int gt = qtdFilmes;

        if(vetFilmes[inicio] == null){
            inicio++;
            i = 0;
        }
        String nomeFilme = vetFilmes[inicio].getNomeDoFilme();

        while (i <= gt) {
            if(vetFilmes[i] == null || nomeFilme == null){
                exch(vetFilmes, i, (i+1));
                i++;
            }else {
                int cmp = vetFilmes[i].getNomeDoFilme().compareToIgnoreCase(nomeFilme);

                if (cmp < 0)
                    exch(vetFilmes, lt++, i++);
                else if (cmp > 0)
                    exch(vetFilmes, i, gt--);
                else
                    i++;
            }
        }
        sort(vetFilmes, inicio, lt - 1);
        sort(vetFilmes, gt + 1, qtdFilmes);
    }


    private static void exch(Filme[] vetFilmes, int i, int j) {
        Filme t = vetFilmes[i];
        vetFilmes[i] = vetFilmes[j];
        vetFilmes[j] = t;
    }
}