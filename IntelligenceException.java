package exception;

public class IntelligenceException extends Exception {

    public IntelligenceException() {
        super("L'intelligence doit être un nombre entre 1 et 20 inclusivement.");
    }

    public IntelligenceException(String msg) {
        super(msg);
    }

}
