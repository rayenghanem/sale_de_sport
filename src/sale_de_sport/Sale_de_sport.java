/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale_de_sport;

import Connection.MyConnection;
import reclamation.Reclamation;
import service.ReclamationService;

/**
 *
 * @author LENOVO
 */
public class Sale_de_sport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            MyConnection mc = MyConnection.getInstance();
            Reclamation p1 = new Reclamation( 1,"hamza", "i have problem ", "ajajgajzf,a;zdd");
            Reclamation p2 = new Reclamation( 2,"houssem12", "i have problem ", "aazertyujhgfd");
            Reclamation p3 = new Reclamation( 3,"ahmedAZE", "i have problem ", ":;,nbvcxdfgh");
            ReclamationService ps = new ReclamationService();
             
            ps.ajouterReclamation(p1);
            ps.ajouterReclamation(p2);
            ps.ajouterReclamation(p3);
            ps.deleteReclamation(3);
            p3.setId(4);
            p3.setDescription("no one knows ");
            p3.setObject("azerty");
            ps.updateReclamation(p3);
            System.out.println(ps.afficherReclamation());
            
           
    }
    
}
