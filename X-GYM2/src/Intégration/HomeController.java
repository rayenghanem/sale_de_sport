/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intégration;

import Service.PacksService;
import com.sun.javafx.scene.control.skin.Utils;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import entities.Packs;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import gui.MembershipController;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class HomeController implements Initializable {

    @FXML
    private Label Packs;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openPacks(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/membership.fxml"));
        try {
            Parent root = loader.load();
           gui.MembershipController mc = loader.getController();
           
           Packs.getScene().setRoot(root);
        } 
        catch (IOException ex) {
           System.err.println(ex.getMessage());

        }
    }

}
