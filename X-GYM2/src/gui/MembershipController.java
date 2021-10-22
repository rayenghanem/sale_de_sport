/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.PacksService;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import entities.Packs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class MembershipController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfduration;
    @FXML
    private TextField tfmontant;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfnom2;
    @FXML
    private TextField tfdescription2;
    @FXML
    private TextField tfmontant2;
    @FXML
    private TextField tfduration2;
    @FXML
    private Button btnDelete2;
    @FXML
    private Button btnModify2;
    @FXML
    private TextField tfnom1;
    @FXML
    private TextField tfdescription1;
    @FXML
    private TextField tfmontant1;
    @FXML
    private TextField tfduration1;
    @FXML
    private Button btnDelete1;
    @FXML
    private Button btnmodify1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPack(ActionEvent event) {
        String pack_nom = tfnom.getText();
        String pack_description = tfdescription.getText();
        String pack_duration = tfduration.getText();
        String pack_Montant = tfmontant.getText();
        String pack_expiration_date = "";
                
        Packs p = new Packs (pack_nom, pack_Montant, pack_description, pack_duration, pack_expiration_date);
        
         
        PacksService ps = new PacksService(); 
        
        ps.ajouterPacks(p);
    }

    @FXML
    private void deletePack2(ActionEvent event) {
    }

    @FXML
    private void modifyPack2(ActionEvent event) {
    }

    @FXML
    private void deletePack1(ActionEvent event) {
    }

    @FXML
    private void modifyPack1(ActionEvent event) {
    }
    
}
