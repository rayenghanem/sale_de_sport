/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Exercice;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import service.ExercieService;

/**
 * FXML Controller class
 *
 * @author Strix
 */
public class AjouterexerciceController implements Initializable {

    @FXML
    private Button btnadd;
    @FXML
    private DatePicker tfdate;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tftemps;
    @FXML
    private TextField tfentraineur;
    @FXML
    private Button btnremove;
    @FXML
    private TableView<Exercice> tvexercice;
    @FXML
    private TableColumn<Exercice, String> colid;
    @FXML
    private TableColumn<Exercice, String> coldate;
    @FXML
    private TableColumn<Exercice, String> coltype;
    @FXML
    private TableColumn<Exercice, String> colduree;
    @FXML
    private TableColumn<Exercice, String> colentraineur; 
    @FXML
    private Button btnedit;
    
    
    Exercice ff = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
                try {
                    
            AfficherExercice();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterexerciceController.class.getName()).log(Level.SEVERE, null, ex);

        }
        tvexercice.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ff = (Exercice) tvexercice.getSelectionModel().getSelectedItem();
                System.out.println(ff);
                
                int pid = ff.getId_ex();
                String Spid = String.valueOf(pid);
               // tfdate.setText(ff.getDate_ex());
               //tfdate.setConverter(value);
               // String date = String.valueOf(tfdate.); 
                tftype.setText(ff.getType_ex());
                tftemps.setText(ff.getTemps_ex());
                tfentraineur.setText(ff.getEntraineur_ex());
               
               
                
            }
        });
    }    
       
      

    @FXML
    private void addexercice(ActionEvent event) {
          ExercieService pc = new ExercieService();
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText("Ajout de l'Exercice");
            String date = String.valueOf(tfdate.getValue());
            String type = tftype.getText();
            String temps = tftemps.getText();
            String entraineur = tfentraineur.getText();
             boolean verif = true;
             System.out.println("Initialize Done !");
          
        
      if (!pc.ControleNom(date)) {
        }

        if (!pc.ControleNom(type)) {
            verif = false;
            alert.setContentText("Verifiez le type !");
            alert.showAndWait();
        }
         if (!pc.ControleInt(temps)) {
          
        }
        if (!pc.ControleNom(entraineur)) {
            verif = false;
            alert.setContentText("Verifiez l'entraineur !");
            alert.showAndWait();
        }

        if (verif) {
          Exercice exercice = new Exercice(date, type, temps, entraineur);
                 System.out.println(exercice);
            System.out.println("Exercice Initialized !");
            pc.ajouterExercice1(exercice);
            System.out.println("Exercice Added Done !");
           
            //Api CONTROLSfx
            Notifications notificationBuilder = Notifications.create().title("Exercice ajouté").graphic(null)
            	.hideAfter(javafx.util.Duration.seconds(10)).position(Pos.TOP_LEFT);
            notificationBuilder.show();
        }
            
             try {
            AfficherExercice();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterexerciceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         tftype.clear();
         tftemps.clear();
         tfentraineur.clear();         
    }

    
     private void AfficherExercice() throws SQLException {
         ExercieService es= new ExercieService();
        List exercice = (List) es.getExercices();
        ObservableList et = FXCollections.observableArrayList(exercice);
        colid.setCellValueFactory(new PropertyValueFactory<Exercice, String>("id_ex"));
        coldate.setCellValueFactory(new PropertyValueFactory<Exercice, String>("date_ex"));
        coltype.setCellValueFactory(new PropertyValueFactory<Exercice, String>("type_ex"));
        colduree.setCellValueFactory(new PropertyValueFactory<Exercice, String>("temps_ex"));
        colentraineur.setCellValueFactory(new PropertyValueFactory<Exercice, String>("entraineur_ex"));
        
        tvexercice.setItems(et);}

    @FXML
    private void SupprimerExercice(ActionEvent event) throws SQLException {
        ExercieService es = new ExercieService();
                Exercice E = (Exercice) tvexercice.getSelectionModel().getSelectedItem();
        System.out.println(E);
        if (ff == null) {
            JOptionPane.showMessageDialog(null, "choisir l'Exercice !!");
            

        } else {
            
            es.supprimerExercice(ff.getId_ex());

            try { //afficher au fur et a mesure avec l'ajout
                AfficherExercice();
            } catch (SQLException ex) {
                Logger.getLogger(AjouterexerciceController.class.getName()).log(Level.SEVERE, null, ex);
            }

         Notifications notificationBuilder = Notifications.create().title("Exercice Supprimer").graphic(null)
            	.hideAfter(javafx.util.Duration.seconds(10)).position(Pos.TOP_LEFT);
            notificationBuilder.show();
            tftype.clear();
            tftemps.clear();
            tfentraineur.clear();
            

            ff = null;
        }
    }

    @FXML
    private void ModifierExercice(ActionEvent event) throws SQLException {
          ExercieService es = new ExercieService();
         System.out.println(ff);
        if (ff == null) {
            JOptionPane.showMessageDialog(null, "choisir l'Exercice!!");

        } else {
            String date = String.valueOf(tfdate.getValue());
            String type = tftype.getText();
            String temps = tftemps.getText();
            String entraineur = tfentraineur.getText();
            es.modifierExercice(new Exercice(date, type, temps, entraineur), ff.getId_ex());
         
            Notifications notificationBuilder = Notifications.create().title("Exercice Modifier").graphic(null)
            	.hideAfter(javafx.util.Duration.seconds(10)).position(Pos.TOP_LEFT);
            notificationBuilder.show();
            tftype.clear();
            tftemps.clear();
            tfentraineur.clear();
  
    
            ff = null;
            try {
                AfficherExercice();
              
            } catch (SQLException ex) {
                Logger.getLogger(AjouterexerciceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
