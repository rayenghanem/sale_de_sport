/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import entities.Exercice;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Strix
 */
public interface IServiceExercice {
    public void ajouterExercice1(Exercice E)throws SQLException ;
    public List<Exercice> getExercices()throws SQLException ;
   public void supprimerExercice(int id_ex) throws SQLException;
   public boolean modifierExercice(Exercice E ,int id) throws SQLException ;
    
}
