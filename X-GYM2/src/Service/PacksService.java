/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import entities.Packs;
import utils.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mezri
 */
public class PacksService {
    private Connection cnx;

    public PacksService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterPacks (Packs p){
        try {
            String req = "INSERT INTO Packs (pack_nom,pack_Montant,pack_description,pack_duration,pack_expiration_date) values ('"+p.getPack_nom()+"','"+p.getPack_Montant()+"','"+p.getPack_description()+"','"+p.getPack_duration()+"','"+p.getPack_expiration_date()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Pack added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterPacks1(Packs p){
        try {
            String req = "INSERT INTO Packs (pack_nom,pack_Montant,pack_description,pack_duration,pack_expiration_date) values (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, p.getPack_nom());
            pst.setString(2, p.getPack_Montant());
            pst.setString(3, p.getPack_description());
            pst.setString(4, p.getPack_duration());
            pst.setString(5, p.getPack_expiration_date());
            pst.executeUpdate();
            System.out.println("Packs added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 public List<Packs> getPacks(){
        List<Packs> packs = new ArrayList<>();
        try {
            String req = "Select * from packs";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Packs p = new Packs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                packs.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return packs;
    } 
   /* public void modifiernom_pack(String id,String nex)  {
//        System.out.println("entre Id de user a Modifier");
//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        System.out.println("entre le Nom a Modifier");
//        Scanner sc1 = new Scanner(System.in);
//        String b = sc1.nextLine();
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `pack` SET `Nom_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    public void modifierUser_Prenom(String id,String nex)  {
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Nom_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
        public void modifierUser_Email(String id,String nex)  {
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Email_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
            public void modifierUser_Adresse(String id,String nex)  {
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Adresse_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
     public void modifierUser_Pass(String id,String nex)  {
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Password_user` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    public void modifierUser_Cin(String id,String nex)  {
       
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Cin_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
      public void modifierUser_Num(String id,String nex)  {
       
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Num_User` ='"+nex+"' WHERE `user`.`Id_User` ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      public void supprimerUser()  {
        try {          System.out.println("entre l Id de User a supprimer");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
      
      String sql = "delete from user where Id_User="+f;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
      
      System.out.println("User a supprimer aves succeé");
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public List<User> afficherUser() throws SQLException 
{ 
    List<User> Users = new ArrayList<>();
        try {

String sql = "Select * from user ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    User u = new User ();
    u.setId_User(rs.getInt(1));
   u.setNom_User(rs.getString(2));
    u.setPrenom_User(rs.getString(3));
    u.setCin_User(rs.getInt(4));
   u.setNum_User(rs.getInt(5));
    u.setAdresse_User(rs.getString(6));
    u.setEmail_User(rs.getString(7));
    u.setRole_User(rs.getString(8));
     u.setDate_N_User(rs.getString(9));
    Users.add(u);
}}
catch (SQLException ex) {Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(Users);
        return Users;
}
public void CercheerUser() throws SQLException 
{ System.out.println("entre l Id de User a Chercher");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
    List<User> Users = new ArrayList<>();
        try {

String sql = "Select * from user WHERE `user`.`Id_User` ="+f;
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    User u = new User ();
    u.setId_User(rs.getInt(1));
   u.setNom_User(rs.getString(2));
    u.setPrenom_User(rs.getString(3));
    u.setCin_User(rs.getInt(4));
   u.setNum_User(rs.getInt(5));
    u.setAdresse_User(rs.getString(6));
     u.setDate_N_User(rs.getString(7));
    Users.add(u);
}}
catch (SQLException ex) {Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(Users);
}*/

}

