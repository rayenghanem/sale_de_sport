/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author yassine
 */
public class Myconnection {
    private String url="jdbc:mysql://localhost:3306/coash";
    private String user ="root";
    private String pwd = "";
    private Connection cnx ;
    
    private static Myconnection mycnx;
    
    private Myconnection() {
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("connected");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
 }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return cnx;
    }

   public static Myconnection getmycnx(){
       if (mycnx == null){
            mycnx = new Myconnection();
       }
       return mycnx;
   }
     
    
    
}
