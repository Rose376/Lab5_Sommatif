package exception;

public class CaractereException extends Exception {

    public CaractereException() {
        super("Le caractère doit être BON ou MÉCHANT.");
    }

    public CaractereException(String msg) {
        super(msg);
    }

    
}
