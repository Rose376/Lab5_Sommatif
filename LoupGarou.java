package personnage;

import exception.*;

public class LoupGarou extends Personnage implements PersonnageHumain, PersonnageAnimal {

    //Attributs privates
    private String statut;
    private String caractere;

    //Constructeurs
    public LoupGarou() {
        super();
        statut = "";
        caractere = "";
    }

    public LoupGarou(String nom, int force, int intelligence, String caractere, String statut)
            throws NomException, ForceException, IntelligenceException, StatutException, CaractereException {
        
        super(nom, force, intelligence);
        
        if(statut == null){
            throw new StatutException();
        }
        
        if(caractere == null){
            throw new CaractereException();
        }
        
        this.statut = statut;
        this.caractere = caractere;
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

    @Override
    public String getCaractere() {
        return caractere;
    }

    @Override
    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    //Redéfinition méthode toString
    @Override
    public String toString() {
        return "Je suis un loup-garou" + super.toString() + ";\nJe suis " + getCaractere() + ";\nJe suis votre " + getStatut() + ".";
    }

}
