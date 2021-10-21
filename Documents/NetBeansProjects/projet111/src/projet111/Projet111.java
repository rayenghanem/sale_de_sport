/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet111;

import edu.esprit.entities.coash;
import edu.esprit.services.coashservise;


/**
 *
 * @author yassine
 */
public class Projet111 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      coashservise cs = new coashservise();
      coash c = new coash ("coash1","homme",20123456,"asd@gmail.com","ariana","coash11","special");
      cs.ajouterentraineur(c);
    }
    
}
