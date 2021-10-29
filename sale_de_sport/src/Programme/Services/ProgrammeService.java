/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programme.Services;

import Connection.util.MyConnection;
import entities.Programme;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lenovo
 */
public class ProgrammeService {
    public Connection cnx;
public PreparedStatement ste;
    public ProgrammeService() {
        cnx = MyConnection.getInstance().getConnection();
     }   
    
    
     public void ajouterProgramme(Programme P){
    try {
        String sql = "INSERT INTO Programme(type_sport , coach_name , date)"+"values(?,?,?)";
        ste=cnx.prepareStatement(sql);
        ste.setString(1, P.getType_sport());
        ste.setString(2, P.getCoach_name());
        ste.setString(3, P.getDate());
        ste.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
     public List <Programme> getProgrammes() {
          List <Programme> Programmes = new  ArrayList<>();
          
        try {
           
            String req =" Select* from Programme";
            Statement st =  cnx.createStatement();
            
           
            ResultSet rs = st.executeQuery(req);
           
            while (rs.next())
            {
              Programme P = new Programme(rs.getInt(1), rs.getString(4),rs.getString(2),rs.getString(3));
              
              
              Programmes.add(P);
            }
            }     
        catch (SQLException ex) {
          System.out.println(ex.getMessage()); 
        }
           return Programmes ;
     }

     
  public  void suppProgramme (int  id ){
  
        try {
           
         
            String rec = "DELETE FROM Programme WHERE id= '"+id+"'" ;
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(rec);
           
            pst.executeUpdate();
      
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        
        }
   }
     
   
   
   
   
   public void ModifierProgramme ( int id_pro ,String type_sport , String coach_name ,String date ) {
		try {
                  
                  
	 String rec="UPDATE Programme  SET type_sport='"+ type_sport + "',coach_name='" + coach_name +"',date='" + date+"' WHERE id_pro="+id_pro+"";

                  PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(rec);
	 
	    	
	     pst.executeUpdate();
             
                }
  	  catch (SQLException ex)
	  {
		 System.err.println(ex.getMessage());
	}
   }

}
