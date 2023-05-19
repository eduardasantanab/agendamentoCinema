public class ForaCartazException extends Exception {
    public ForaCartazException() {
        super("O Filme não está mais em cartaz!");
    }
    public int foraCartaz(boolean emCartaz){
        if(!emCartaz){
            return -2;
        }else {
            return 0;
        }
    }
}