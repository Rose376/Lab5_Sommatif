package personnage;

public class Partie {

    //Définition des attribut
    private int maxPersonnage;
    private Personnage personnages[];
    private int nbPersonnages;

    //Constructeurs
    public Partie() {
        maxPersonnage = 20;
        personnages = new Personnage[maxPersonnage];
        nbPersonnages = 0;
    }

    public Partie(int nbJoueurs) {
        maxPersonnage = nbJoueurs;
        personnages = new Personnage[nbJoueurs];
        nbPersonnages = 0;
    }

    //Getter nbPersonnages
    public int getNbPersonnages() {
        return nbPersonnages;
    }

    //Méthode ajouterAPartie
    public boolean ajouterAPartie(Personnage personnageAjout) {

        //Vérifier si le personnage est déjà présent
        for (Personnage p : personnages) {
            if (p != null && p.equals(personnageAjout)) {
                //Le personnage est déjà dans le tableau
                return false;
            }
        }
        //Vérifier si il y a de l'espace dans le tableau
        for (int i = 0; i < personnages.length; i++) {
            if (personnages[i] == null) {
                //Emplacement vide trouvé
                personnages[i] = personnageAjout;
                nbPersonnages++;
                return true;
            }
        }
        //Aucun emplacement trouvé
        return false;
    }

    //Méthode supprimerDePartie
    public boolean supprimerDePartie(Personnage personnageSupp) {
        for (int i = 0; i < personnages.length; i++) {
            if (personnages[i] != null && personnages[i].equals(personnageSupp)) {
                //Personnage trouvé
                personnages[i] = null;
                nbPersonnages--;
                return true;
            }
        }
        //Personnage non trouvé
        return false;
    }

    //Méthode listerPersonnage
    public String listerPersonnage() {

        String sortie = "";
        sortie += "Ces personnages sont dans la partie : \n";

        for (Personnage p : personnages) {
            if (p != null) {
                sortie += p.toString() + "\n\n";
            }
        }
        sortie += "Il y a " + nbPersonnages + " personnage(s) dans le jeu.";

        return sortie;
    }

}
