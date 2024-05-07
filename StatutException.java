package exception;

public class StatutException extends Exception {

    public StatutException() {
        super("Le statut doit être AMI ou ENNEMI.");
    }

    public StatutException(String msg) {
        super(msg);
    }

}
