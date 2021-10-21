/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bissa
 */
public class MyConnection {

		private String url ="jdbc:mysql://localhost:3306/pi-java";
		private String user ="root";
		private String pw ="";
                private Connection cnx;
                
	private static MyConnection myCnx;
	
	private MyConnection(){
		try {
		cnx = (Connection) DriverManager.getConnection(url, user, pw);
		 System.out.println("Connection reussie");
                }catch(SQLException ex){
		//( delete import) 
                System.out.println(ex.getMessage()); }
		//(faire une instance de myConnection main new myConnection )

        }
    public static  MyConnection getMyCnx(){
			if(myCnx == null )
			myCnx  = new MyConnection ();
			return myCnx ; 
                        
}
    public Connection getCnx(){
        return cnx;
}
}

