package personnage;

import exception.ForceException;
import exception.IntelligenceException;
import exception.NomException;
import exception.StatutException;

public class Centaure extends Personnage implements PersonnageAnimal {

    //Attributs privates
    private String statut;

    //Constructeurs 
    public Centaure() {
        super();
        statut = "";
    }

    public Centaure(String nom, int force, int intelligence, String statut)
            throws NomException, ForceException, IntelligenceException, StatutException {

        super(nom, force, intelligence);
        
        if(statut == null){
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

    //Redéfintion méthode toString
    @Override
    public String toString() {
        return "Je suis un centaure" + super.toString() + ";\nJe suis votre " + getStatut() + ".";
    }

}
