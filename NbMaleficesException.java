
package exception;


public class NbMaleficesException extends Exception{

    public NbMaleficesException() {
        super("Le nombre de maléfices doit être un nombre entier positif.");
    }

    public NbMaleficesException(String string) {
        super(string);
    }
    
    
}
