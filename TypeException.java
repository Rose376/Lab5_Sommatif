package exception;


public class TypeException extends Exception{

    public TypeException() {
        super("Veuillez entrer un type de personnage.");
    }

    public TypeException(String msg) {
        super(msg);
    }
    
    
}
