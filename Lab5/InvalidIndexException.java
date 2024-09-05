public class InvalidIndexException extends RuntimeException {
    private int detail;
    public InvalidIndexException(int a){
        detail = a;
    }
    public String toString(){
        return "InvalidIndexException[ " + detail +" ]";
    }

}
