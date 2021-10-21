/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Util.MyConnection;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bissa
 */
public class ProductsCrud {
    private Connection cnx;
    
    public ProductsCrud (){
        cnx = MyConnection.getMyCnx().getCnx();
    }
    
    public void ajouterProduits (Product p){
        try {
            
            String req = "INSERT INTO produits (category,product,stock,price,rating) values (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1,p.getCategory());
            pst.setString(2,p.getProduct());
            pst.setInt(3,p.getStock());
            pst.setFloat(4,p.getPrice());
            pst.setInt(5,p.getRating());
            pst.executeUpdate();
            System.out.println(" product added !");
            }
            catch (SQLException ex) {
            System.err.println(ex.getMessage());        
                    }
    }
     public List<Product> GetProduits(){
         List<Product> products = new ArrayList<>();
         try {
            String req = "Select * from produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6));
                products.add(p);
            }
            return products;
        }
         catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }  
         return products;
     }
     
     public void editProducts(Product p) throws SQLException{
    String sql = "UPDATE produits SET category=?,product=?,stock=?,price=?,rating=? WHERE id="+p.getId();
 
    PreparedStatement statement = cnx.prepareStatement(sql);

    statement.setString(1, p.getCategory());
    statement.setInt(3, p.getStock());
    statement.setString(2, p.getProduct());
    statement.setFloat(4, p.getPrice());
    statement.setInt(5, p.getRating());
    
    int rowsUpdated = statement.executeUpdate();
    
    
    if (rowsUpdated > 0) {
       System.out.println("The product was updated successfully!");
}
    
}
     public void deleteProducts(int id) throws SQLException{
    String sql = "DELETE FROM produits where id="+id;
 
    PreparedStatement statement = cnx.prepareStatement(sql);
    
    int rowsDeleted = statement.executeUpdate();
    if (rowsDeleted > 0) {
    System.out.println("The product was deleted successfully!");
    }   
}
     public Product GetProduitsById(int id){
         List<Product> products = new ArrayList<>();
         try {
            String req = "Select * from produits WHERE id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6));
                products.add(p);
            }
            return products.get(0);
        }
         catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }  
         return null;
     }
}
    
