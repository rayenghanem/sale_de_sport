package controller;

import entities.Reclamation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ResourceBundle;





public class MainController implements Initializable {

    @FXML
    private TextField idField;
    
    @FXML
    private TextField usernameField;

    @FXML
    private TextField objectField;

    @FXML
    private TextField descriptionField;

    

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Reclamation> TableView;
    
    @FXML
    private TableColumn<Reclamation, Integer> idColumn;
    
    @FXML
    private TableColumn<Reclamation, String> usernameColumn;

    @FXML
    private TableColumn<Reclamation, String> objectColumn;

    @FXML
    private TableColumn<Reclamation, String> descriptionColumn;

   

    @FXML
    private void insertButton() {
    	String query = "insert into reclamation values("+idField.getText()+",'"+usernameField.getText()+"','"+objectField.getText()+"','"+descriptionField.getText()+"')";
    	executeQuery(query);
    	showReclamations();
    }
    
    
    @FXML 
    private void updateButton() {
    String query = "UPDATE reclamation SET username='"+usernameField.getText()+"',object='"+objectField.getText()+"',description='"+descriptionField.getText()+"' WHERE ID="+idField.getText()+"";
    executeQuery(query);
	showReclamations();
    }
    
    @FXML
    private void deleteButton() {
    	String query = "DELETE FROM reclamation WHERE ID="+idField.getText()+"";
    	executeQuery(query);
    	showReclamations();
    }
    
    public void executeQuery(String query) {
    	Connection conn = getConnection();
    	Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showReclamations();
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/x-gym","root","");
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public ObservableList<Reclamation> getReclamationsList(){
    	ObservableList<Reclamation> reclamationList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM reclamation ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Reclamation reclamations;
			while(rs.next()) {
				reclamations = new Reclamation(rs.getInt("id"),rs.getString("username"),rs.getString("object"),rs.getString("description"));
				reclamationList.add(reclamations);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return reclamationList;
    }
    
    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showReclamations() {
    	ObservableList<Reclamation> list = getReclamationsList();
    	
    	idColumn.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("id"));
    	usernameColumn.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("username"));
    	objectColumn.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("object"));
    	descriptionColumn.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("description"));
    	
    	
    	TableView.setItems(list);
    }

}
