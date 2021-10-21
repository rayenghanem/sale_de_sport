/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import com.mysql.jdbc.Connection;
import edu.esprit.entities.coash;
import edu.esprit.utils.Myconnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yassine
 */
public class coashservise {
   private Connection cnx; 

    public coashservise() {
        cnx = Myconnection.getmycnx().getConnection();
    }
    
   public void ajoutercoash (coash c) {
       try {
           String req = "INSERT INTO coash ( nom=, sexe, numtel, adressemai, adresse, username, specialite) value ('"+ c.getNom()+"','"+ c.getSexe()+"','"+c.getNumtel()+"','"+c.getAdressemail()+"','"+c.getAdresse()+"','"+c.getUsername()+"','"+c.getSpecialite()+"','";
           Statement st = cnx.createStatement();
           st.executeQuery(req);
           System.out.println("coash added");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
   public void ajouterentraineur (coash c) {
       try {
           String req = "INSERT INTO coash (?,?)"; 
           PreparedStatement pst =(PreparedStatement) cnx.prepareStatement(req);
           pst.setString(1,c.getNom());
           pst.setString(2,c.getUsername()); 
           pst.executeUpdate();
           System.out.println("coash added");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   } 
    
}
