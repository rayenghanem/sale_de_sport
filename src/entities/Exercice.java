/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Strix
 */
public class Exercice {
    private int id_ex;
    private String date_ex;
    private String type_ex;
    private String temps_ex;
    private String entraineur_ex;

    public Exercice() {
    }

    public Exercice(int id_ex, String date_ex, String type_ex, String temps_ex, String entraineur_ex) {
        this.id_ex = id_ex;
        this.date_ex = date_ex;
        this.type_ex = type_ex;
        this.temps_ex = temps_ex;
        this.entraineur_ex = entraineur_ex;
    }

    public Exercice(String date_ex, String type_ex, String temps_ex, String entraineur_ex) {
        this.date_ex = date_ex;
        this.type_ex = type_ex;
        this.temps_ex = temps_ex;
        this.entraineur_ex = entraineur_ex;
    }

    public int getId_ex() {
        return id_ex;
    }

    public void setId_ex(int id_ex) {
        this.id_ex = id_ex;
    }

    public String getDate_ex() {
        return date_ex;
    }

    public void setDate_ex(String date_ex) {
        this.date_ex = date_ex;
    }

    public String getType_ex() {
        return type_ex;
    }

    public void setType_ex(String type_ex) {
        this.type_ex = type_ex;
    }

    public String getTemps_ex() {
        return temps_ex;
    }

    public void setTemps_ex(String temps_ex) {
        this.temps_ex = temps_ex;
    }

    public String getEntraineur_ex() {
        return entraineur_ex;
    }

    public void setEntraineur_ex(String entraineur_ex) {
        this.entraineur_ex = entraineur_ex;
    }

    @Override
    public String toString() {
        return "Exercice{" + "id_ex=" + id_ex + ", date_ex=" + date_ex + ", type_ex=" + type_ex + ", temps_ex=" + temps_ex + ", entraineur_ex=" + entraineur_ex + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_ex;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exercice other = (Exercice) obj;
        if (this.id_ex != other.id_ex) {
            return false;
        }
        return true;
    }
    
    
    
    
}
