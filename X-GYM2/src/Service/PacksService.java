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
}

