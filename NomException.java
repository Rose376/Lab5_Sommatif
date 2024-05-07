package exception;

public class NomException extends Exception {

    public NomException() {
        super("Le champ 'Nom' est obligatoire");
    }

    public NomException(String msg) {
        super(msg);
    }

}
