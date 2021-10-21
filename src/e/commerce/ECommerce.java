/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce;

import Entities.Product;
import Services.ProductsCrud;
import Util.MyConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bissa
 */
public class ECommerce extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        MyConnection.getMyCnx();
        ProductsCrud productService = new ProductsCrud();
//        List<Products> products = new ArrayList<>();
//        products = productService.GetProduits();
//        System.out.println(products);
        // add product
//        Product p = new Product("Proteine", "Whey", 10, 125f, 0);
//        productService.ajouterProduits(p);
        // edit product
//        Product p = productService.GetProduitsById(3);
//        p.setCategory("Mass");
//        if(p != null){
//            productService.editProducts(p);
//        }
        // product list
        List<Product> products = new ArrayList<>();
        products = productService.GetProduits();
        for (Product a : products){
            System.out.println(a);
        }
        // delete product
        productService.deleteProducts(7);
    }
    
}
