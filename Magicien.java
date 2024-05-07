package personnage;

import exception.*;

public abstract class Magicien extends Personnage implements PersonnageHumain {

    //Déclaration des attributs
    private int energieMagique;
    private String caractere;

    //Constructeurs
    public Magicien() {
        super();
        energieMagique = 0;
        caractere = "";
    }

    public Magicien(String nom, int force, int intelligence, int energieMagique, String caractere)
            throws NomException, ForceException, IntelligenceException, EnergieMagiqueException, CaractereException {

        super(nom, force, intelligence);
        
        if (energieMagique < 0) {
        throw new EnergieMagiqueException();
    }
        if(caractere == null){
            throw new CaractereException();
        }
        
        this.energieMagique = energieMagique;
        this.caractere = caractere;
    }

    //Setters et getters 
    public int getEnergieMagique() {
        return energieMagique;
    }

    public void setEnergieMagique(int energieMagique) {
        this.energieMagique = energieMagique;
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
        return "Je suis un magicien " + super.toString() + ";\n Je suis " + getCaractere() + ".";
    }

}
