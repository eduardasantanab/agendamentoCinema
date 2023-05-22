public class QuickWithoutPartition {

    public static <T extends Comparable<T>> void sort(Filme[] a, int qtdAdicionados) {
        sort(a, 0, qtdAdicionados - 1);
    }
    private static <T extends Comparable<T>> void sort(Filme[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        if(a[lo] == null){
            lo++;
            i = 0;
        }
        String v = a[lo].getNomeDoFilme();

        while (i <= gt) {
            if(a[i] == null || v == null){
                exch(a, i, (i+1));
                i++;
            }else {
                int cmp = a[i].getNomeDoFilme().compareToIgnoreCase(v);

                if (cmp < 0)
                    exch(a, lt++, i++);
                else if (cmp > 0)
                    exch(a, i, gt--);
                else
                    i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    private static <T extends Comparable<T>> void exch(Filme[] a, int i, int j) {
        Filme t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}