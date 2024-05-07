package personnage;

import exception.*;

public abstract class Personnage {

    //Déclaration des attributs privates
    private String nom;
    private int force;
    private int intelligence;

    //Constructeurs
    public Personnage() {
        nom = "";
        force = 0;
        intelligence = 0;
    }

    public Personnage(String nom, int force, int intelligence)
            throws NomException, ForceException, IntelligenceException {

        if (nom.isEmpty()) {
            throw new NomException();
        }
        if (force < 0 || force > 20) {
            throw new ForceException();
        }
        if (intelligence < 0 || intelligence > 20) {
            throw new IntelligenceException();
        }

        this.nom = nom;
        this.force = force;
        this.intelligence = intelligence;
    }

    //Setters et getters
    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    //Redéfinition méthode equals
    @Override
    public boolean equals(Object unObjet) {
        if (unObjet == null) {
            return false;
        }
        if (this.getClass() != unObjet.getClass()) {
            return false;
        }
        if (unObjet == this) {
            return true;
        }
        //Conversion de l'objet de type Object en objet de type Personnage
        Personnage pers = (Personnage) unObjet;

        return (this.getNom().equalsIgnoreCase(pers.getNom())
                && this.getForce() == pers.getForce()
                && this.getIntelligence() == pers.getIntelligence());
    }

    //Redéfinition méthode toString
    @Override
    public String toString() {
        return " nommé " + nom + ", avec la force " + force + " et l'intelligence " + intelligence;
    }
}
