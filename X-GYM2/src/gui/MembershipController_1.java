/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.PacksService;
import com.sun.javafx.scene.control.skin.Utils;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import entities.Packs;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class MembershipController_1 implements Initializable {

    @FXML
    private TextField tfnom5;
    @FXML
    private TextField tfdescription5;
    @FXML
    private TextField tfmontant5;
    @FXML
    private TextField tfduration5;
    @FXML
    private Button btnDelete5;
    @FXML
    private Button btnModify2;
    @FXML
    private TextField tfnom3;
    @FXML
    private TextField tfdescription3;
    @FXML
    private TextField tfmontant3;
    @FXML
    private TextField tfduration3;
    @FXML
    private Button btnDelete3;
    @FXML
    private Button btnmodify3;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfmontant;
    @FXML
    private TextField tfduration;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnModify;
    @FXML
    private ImageView btnBack;
    @FXML
    private ImageView btnForward2;


   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deletePack5(ActionEvent event) {
    }

    @FXML
    private void modifyPack5(ActionEvent event) {
    }

    @FXML
    private void deletePack3(ActionEvent event) {
    }

    @FXML
    private void modifyPack3(ActionEvent event) {
    }

    @FXML
    private void deletePack4(ActionEvent event) {
    }

    @FXML
    private void modifyPack4(ActionEvent event) {
    }
    public void setTextpack_nom(String msg){
       this.tfnom.setText(msg);
   }
    public void setTextpack_description(String msg){
       this.tfdescription.setText(msg);
   }
        public void setTextpack_Montant(String msg){
       this.tfmontant.setText(msg);
   }
        public void setTextpack_duration(String msg){
       this.tfduration.setText(msg);
   }

    @FXML
    private void Back(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("membership.fxml"));
        try {
            Parent root = loader.load();
           MembershipController mc = loader.getController();
           
           btnBack.getScene().setRoot(root);
        } 
        catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
               
    }

    @FXML
    private void Forward2(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("membership2.fxml"));
        try {
            Parent root = loader.load();
           MembershipController2 mc2 = loader.getController();
           
           btnForward2.getScene().setRoot(root);
        } 
        catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
    }
   
}