package personnage;

import exception.*;

public class Sorcier extends Magicien {

    //Déclaration des attributs
    private int nbMalefices;

    //Constructeurs
    public Sorcier() {
        super();
        nbMalefices = 0;
    }

    public Sorcier(String nom, int force, int intelligence, int energieMagique, String caractere, int nbMalefices)
            throws NomException, ForceException, IntelligenceException, EnergieMagiqueException, CaractereException, NbMaleficesException {
        super(nom, force, intelligence, energieMagique, caractere);

        if (nbMalefices < 0) {
            throw new NbMaleficesException();
        }

        this.nbMalefices = nbMalefices;
    }

    //Setters et getters
    public int getNbMalefices() {
        return nbMalefices;
    }

    public void setNbMalefices(int nbMalefices) {
        this.nbMalefices = nbMalefices;
    }

    //Redéfinition méthode toString
    @Override
    public String toString() {
        return "Je suis un sorcier" + " nommé " + getNom() + ", avec la force " + getForce() + " et l'intelligence " + getIntelligence()
                + ";\nNiveau d'énergie magique : " + getEnergieMagique() + ";\nJe suis " + getCaractere() + ";\nJe peux jeter " + getNbMalefices() + " stupéfiants maléfices.";
    }

}
