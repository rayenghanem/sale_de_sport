/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.gym;
import entities.Packs;
import Service.PacksService;

/**
 *
 * @author ahmed
 */
public class XGYM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PacksService ps = new PacksService();
        Packs p = new Packs("Gold","60dt","All acces and personal trainer","1 month","2022-01-01");
        ps.ajouterPacks(p);
        //System.out.println(ps.getPacks());
    }
    
}
