/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sale_de_sport;

import Programme.Services.ProgrammeService;
import entities.Programme;


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
            ProgrammeService ps = new ProgrammeService();
            Programme P = new Programme( "gymnastique", "razi", "01/02/2021");
            //ps.ajouterProgramme(P);   
            System.out.println(ps.getProgrammes());
    }
    
}
