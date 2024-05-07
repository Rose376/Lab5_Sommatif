package personnage;

import exception.*;

public class Druide extends Magicien {

    //Constructeurs
    public Druide() {
        super();
    }

    public Druide(String nom, int force, int intelligence, int energieMagique, String caractere) 
    throws NomException, ForceException, IntelligenceException, EnergieMagiqueException, CaractereException{
        
        super(nom, force, intelligence, energieMagique, caractere);
    }

    //Redéfinition méthode toString
    @Override
    public String toString() {
        return "Je suis un druide" + " nommé " + getNom() + ", avec la force " + getForce() + " et l'intelligence " + getIntelligence()
                + ";\nNiveau d'énergie magique : " + getEnergieMagique() + ";\nJe suis " + getCaractere() + ".";
    }

}
