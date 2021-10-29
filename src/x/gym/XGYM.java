/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.gym;

import entities.Exercice;
import service.ExercieService;





/**
 *
 * @author Strix
 */
public class XGYM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // MyConnection.getMyCnx();
      ExercieService es = new ExercieService();
      Exercice E = new Exercice("15-15-15", "qsdfg", "13", "jassser");
      es.ajouterExercice1(E);
      //  System.out.println(es.getExercices());
     
    }
    
}
