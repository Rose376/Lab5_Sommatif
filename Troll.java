package personnage;

import exception.*;

public class Troll extends Personnage implements PersonnageAnimal {

    private String statut;

    //Constructeurs
    public Troll() {
        super();
        statut = "";
    }

    public Troll(String nom, int force, int intelligence, String statut)
            throws NomException, ForceException, IntelligenceException, StatutException {

        super(nom, force, intelligence);

        if (statut == null) {
            throw new StatutException();
        }

        this.statut = statut;
    }

    //Getters et setters
    @Override
    public String getStatut() {
        return statut;
    }

    @Override
    public void setStatut(String statut) {
        this.statut = statut;
    }

    //Redéfinition méthode toString
    @Override
    public String toString() {
        return "Je suis un troll" + super.toString() + ";\nJe suis votre " + getStatut() + ".";
    }

}
