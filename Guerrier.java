package personnage;

import exception.*;

public class Guerrier extends Personnage {

    //Déclaration des attributs 
    private String armeType;

    //Constructeurs
    public Guerrier() {
        super();
        armeType = "Aucune arme";
    }

    public Guerrier(String nom, int force, int intelligence, String armeType)
            throws NomException, ForceException, IntelligenceException, ArmeException {
        super(nom, force, intelligence);

        if(armeType.equalsIgnoreCase("")){
            throw new ArmeException();
        }
        
        this.armeType = armeType;
    }

    //Setters et getters
    public String getArmeType() {
        return armeType;
    }

    public void setArmeType(String armeType) {
        this.armeType = armeType;
    }

    //Redéfinition méthode toString 
    @Override
    public String toString() {
        return "Je suis un guerrier" + super.toString() + ";\nTous mes ennemis se méfient de mon/ma puissant(e) " + armeType + ".";
    }

}
