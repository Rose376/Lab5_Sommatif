package exception;

public class EnergieMagiqueException extends Exception {

    public EnergieMagiqueException() {
        super("L'énergie magique doit être un nombre entier positif.");
    }

    public EnergieMagiqueException(String msg) {
        super(msg);
    }

}
