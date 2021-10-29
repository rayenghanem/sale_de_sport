/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import Programme.Services.ProgrammeService;
import entities.Programme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button btajout;
    @FXML
    private Button btmod;
    @FXML
    private Button btsup;
    @FXML
    private TextField ftid_pro;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfcoach_name;
    @FXML
    private Button btaff;
    @FXML
    private Button btvalider;
    @FXML
    private TextField tftype_sport;

    /**
     * Initializes the controller class.
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveprogramme(ActionEvent event) {
        
            int id_pro= Integer.parseInt(ftid_pro.getText());
            String type_sport = tftype_sport.getText();
            String date = tfdate.getText();
            String coach_name = tfcoach_name.getText();
            
            
            Programme P = new Programme(id_pro, type_sport, coach_name, date);
            
           
            ProgrammeService ps = new ProgrammeService() ;
            ps.ajouterProgramme(P);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsProgramme.fxml"));
            
            
        try {  
            
            Parent root = loader.load();
           DetailsProgrammeController dpc= loader.getController();
           tfdate.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
            
          
            
    }
    
}
    
   

    
