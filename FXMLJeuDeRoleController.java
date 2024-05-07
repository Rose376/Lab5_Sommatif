package lab5_3_jeuderole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import personnage.*;
import exception.*;

public class FXMLJeuDeRoleController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtForce;
    @FXML
    private TextField txtArme;
    @FXML
    private TextField txtEnergie;
    @FXML
    private TextField txtMalefices;
    @FXML
    private ComboBox<String> cbType;
    @FXML
    private TextField txtIntelligence;
    @FXML
    private Label labelErreur;
    @FXML
    private TextArea txtDroite;
    @FXML
    private RadioButton btnAmi;
    @FXML
    private RadioButton btnEnnemi;
    @FXML
    private RadioButton btnBon;
    @FXML
    private RadioButton btnMechant;
    @FXML
    private ToggleGroup grStatut;
    @FXML
    private ToggleGroup grCaractere;

    //Type de personnage 
    String typePersonne;

    //Déclaration de l'objet Partie
    Partie maPartie;

    //Affichage
    boolean premierAjout = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Initialisation du combobox
        cbType.getItems().addAll("Troll", "Centaure", "Loup-garou", "Sorcier", "Druide", "Guerrier");
        //Créer l'objet de la classe partie
        maPartie = new Partie();

    }

    //Méthode lors du clic du bouton Ajouter
    @FXML
    private void Ajouter(ActionEvent event) {

        labelErreur.setText("");

        Personnage pers = null;
        String nom, statut, caractere, arme;
        int force, intelligence, energieMagique, nbMalefices;
        typePersonne = cbType.getValue();

        try {

            // ----------- Exceptions (Type, Nom, Force, Intelligene) -----------------
            //Type de personnage vide
            if (typePersonne == null) {
                throw new TypeException();
            }

            //Nom
            nom = txtNom.getText();

            //Force (NumberFormat)
            try {
                force = Integer.parseInt(txtForce.getText());
            } catch (NumberFormatException e) {
                throw new ForceException();
            }

            //Intelligence (NumberFormat)
            try {
                intelligence = Integer.parseInt(txtIntelligence.getText());
            } catch (NumberFormatException e) {
                throw new IntelligenceException();
            }

            switch (typePersonne) {

                //-------------- Troll ----------------------
                case "Troll":
                    if (grStatut.getSelectedToggle() == null) {
                        throw new StatutException();
                    }
                    statut = ((RadioButton) (grStatut.getSelectedToggle())).getText();
                    pers = new Troll(nom, force, intelligence, statut);
                    break;

                //-------------- Centaure ---------------------    
                case "Centaure":
                    if (grStatut.getSelectedToggle() == null) {
                        throw new StatutException();
                    }
                    statut = ((RadioButton) (grStatut.getSelectedToggle())).getText();
                    pers = new Centaure(nom, force, intelligence, statut);
                    break;

                //-------------- Loup-garou ---------------------    
                case "Loup-garou":
                    if (grStatut.getSelectedToggle() == null) {
                        throw new StatutException();
                    }
                    statut = ((RadioButton) (grStatut.getSelectedToggle())).getText();

                    if (grCaractere.getSelectedToggle() == null) {
                        throw new CaractereException();
                    }
                    caractere = ((RadioButton) (grCaractere.getSelectedToggle())).getText();

                    pers = new LoupGarou(nom, force, intelligence, caractere, statut);
                    break;

                //-------------- Sorcier ---------------------
                case "Sorcier":
                    try {
                    energieMagique = Integer.parseInt(txtEnergie.getText());
                } catch (NumberFormatException e) {
                    throw new EnergieMagiqueException();
                }

                if (grCaractere.getSelectedToggle() == null) {
                    throw new CaractereException();
                }
                caractere = ((RadioButton) (grCaractere.getSelectedToggle())).getText();

                try {
                    nbMalefices = Integer.parseInt(txtMalefices.getText());
                } catch (NumberFormatException e) {
                    throw new NbMaleficesException();
                }
                pers = new Sorcier(nom, force, intelligence, energieMagique, caractere, nbMalefices);
                break;

                //-------------- Druide ---------------------
                case "Druide":
                    try {
                    energieMagique = Integer.parseInt(txtEnergie.getText());
                } catch (NumberFormatException e) {
                    throw new EnergieMagiqueException();
                }

                if (grCaractere.getSelectedToggle() == null) {
                    throw new CaractereException();
                }
                caractere = ((RadioButton) (grCaractere.getSelectedToggle())).getText();

                pers = new Druide(nom, force, intelligence, energieMagique, caractere);
                break;

                //-------------- Guerrier ---------------------
                case "Guerrier":
                    arme = txtArme.getText();

                    pers = new Guerrier(nom, force, intelligence, arme);
                    break;
            }
        } catch (Exception e) {
            labelErreur.setText(e.getMessage());
        }

        //-------------- Affichage ---------------------
        if (pers != null && maPartie.ajouterAPartie(pers)) {
            txtDroite.setText("");
            txtDroite.appendText(maPartie.listerPersonnage());

            Reset();
            cbType.setValue("");
            txtNom.setText("");
            txtForce.setText("");
            txtIntelligence.setText("");
        }

    }

//Méthode lors de l'activation du combobox
    @FXML
    private void actionType(ActionEvent event) {

        String type = cbType.getValue();

        Reset();

        switch (type) {
            case "Troll":
                btnAmi.setDisable(false);
                btnEnnemi.setDisable(false);
                break;
            case "Centaure":
                btnAmi.setDisable(false);
                btnEnnemi.setDisable(false);
                break;
            case "Loup-garou":
                btnAmi.setDisable(false);
                btnEnnemi.setDisable(false);
                btnBon.setDisable(false);
                btnMechant.setDisable(false);
                break;
            case "Sorcier":
                txtEnergie.setDisable(false);
                txtMalefices.setDisable(false);
                btnBon.setDisable(false);
                btnMechant.setDisable(false);
                break;
            case "Druide":
                txtEnergie.setDisable(false);
                btnBon.setDisable(false);
                btnMechant.setDisable(false);
                break;
            case "Guerrier":
                txtArme.setDisable(false);
                break;
        }

    }

    //Méthode Reset
    public void Reset() {

        btnAmi.setSelected(false);
        btnAmi.setDisable(true);

        btnEnnemi.setSelected(false);
        btnEnnemi.setDisable(true);

        btnBon.setSelected(false);
        btnBon.setDisable(true);

        btnMechant.setSelected(false);
        btnMechant.setDisable(true);

        txtArme.setText("");
        txtArme.setDisable(true);

        txtEnergie.setText("");
        txtEnergie.setDisable(true);

        txtMalefices.setText("");
        txtMalefices.setDisable(true);
    }

}
