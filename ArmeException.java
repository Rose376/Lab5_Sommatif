package exception;

public class ArmeException extends Exception {

    public ArmeException() {
        super("Le nom de l'arme est invalide.");
    }

    public ArmeException(String msg) {
        super(msg);
    }

}
