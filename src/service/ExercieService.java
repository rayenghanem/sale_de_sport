/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Iservice.IServiceExercice;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import connection.MyConnection;
import entities.Exercice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Strix
 */
public class ExercieService implements IServiceExercice {
    private Connection cnx;
    ObservableList<Exercice> ExercicesList = FXCollections.observableArrayList();

    public ExercieService() {
        cnx = (Connection) MyConnection.getMyCnx().getConnection();

      }
    
   
    public void ajouterExercice1(Exercice E){
        try {
            String req = "INSERT INTO planning(date_ex,type_ex,temps_ex,entraineur_ex)values(?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, E.getDate_ex());
            pst.setString(2, E.getType_ex());
            pst.setString(3, E.getTemps_ex());
            pst.setString(4, E.getEntraineur_ex());
            pst.executeUpdate();
            System.out.println("Exercice added !");
            JOptionPane.showMessageDialog(null, "Exercice Add ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
            
        }
     
    }
    
    public List<Exercice> getExercices()throws SQLException {
            
        
            String req = "Select * from planning";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ExercicesList.add(new Exercice(
                          rs.getInt("id_ex")  ,
                   rs.getString("date_ex")  ,
                    rs.getString("type_ex"),
                    rs.getString("temps_ex"),
                    rs.getString("entraineur_ex")));
               
            
        }
        return ExercicesList;
    }
  public void supprimerExercice(int id_ex) throws SQLException {

        String req = "DELETE FROM planning WHERE id_ex=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, id_ex);
            pst.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex);
        }

    }
  public Boolean chercher(int id) {
        String req = "select * from planning";
        List<Integer> list = new ArrayList<>();
        try {
            java.sql.Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                list.add(rs.getInt(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Exercice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.contains(id);
    }
     @Override
    public boolean modifierExercice(Exercice E,int id) throws SQLException {
         if (chercher(id)) {
            try {
                String req = "UPDATE `planning` SET `date_ex`=?,`type_ex`=?,`temps_ex`=?,`entraineur_ex`=? WHERE `planning`.`id_ex` = ?";
             java.sql.PreparedStatement pst = (java.sql.PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, E.getDate_ex());
            pst.setString(2, E.getType_ex());
            pst.setString(3, E.getTemps_ex());
            pst.setString(4, E.getEntraineur_ex());
           
            pst.setInt(5, id);
            pst.executeUpdate (); 

            } catch (SQLException ex) {
                Logger.getLogger(ExercieService.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("update valide");
            return true;
        }
        System.out.println("update invalid: formation nexiste pas");
        return false;
    }
    
    
    public static boolean ControleInt(String duree) {
        if ((duree).matches("[0-9]+")) {
            return true;
        }
        return false;
    }
    
    public static boolean ControleNom(String str) {
        str = str.toLowerCase();
        if (str.length() == 0) {
            return false;
        }
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
                return false;
            }
        }
        return true;
    }
}








