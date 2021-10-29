/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import Programme.Services.ProgrammeService;
import entities.Programme;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DetailsProgrammeController implements Initializable {

    @FXML
    private TableView<?> tftable;
    @FXML
    private TableColumn<?, ?> tfid_pro;
    @FXML
    private TableColumn<?, ?> tftype_sport;
    @FXML
    private TableColumn<?, ?> tfcoach_name;
    @FXML
    private TableColumn<?, ?> tfdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AllProgrammes();
               }
        private void AllProgrammes(){
          
        
                       
          List <Programme> Programmes =  new ArrayList();
          
          ProgrammeService  ps= new ProgrammeService();
          Programmes = ps.getProgrammes();
          
          tfid_pro.setCellValueFactory(new PropertyValueFactory<>("id_pro"));
          tfcoach_name.setCellValueFactory(new PropertyValueFactory<>("coach_name"));
          tfdate.setCellValueFactory(new PropertyValueFactory<>("date"));
          tftype_sport.setCellValueFactory(new PropertyValueFactory<>("type_sport"));
          
        
          tftable.setItems(Programme);
       
        }

    
}
