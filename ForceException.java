package exception;

public class ForceException extends Exception {

    public ForceException() {
        super("La force doit être un nombre entre 1 et 20 inclusivement.");
    }

    public ForceException(String msg) {
        super(msg);
    }

}
