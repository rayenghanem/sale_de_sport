/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
public class Packs {
   private int pack_id;
   private String pack_nom;
   private String pack_Montant;
   private String pack_description;
   private String pack_duration;
   private String pack_expiration_date;

    public Packs() {
    }

    public Packs(int pack_id, String pack_nom, String pack_Montant, String pack_description, String pack_duration, String pack_expiration_date) {
        this.pack_id = pack_id;
        this.pack_nom = pack_nom;
        this.pack_Montant = pack_Montant;
        this.pack_description = pack_description;
        this.pack_duration = pack_duration;
        this.pack_expiration_date = pack_expiration_date;
    }

    public Packs(String pack_nom, String pack_Montant, String pack_description, String pack_duration, String pack_expiration_date) {
        this.pack_nom = pack_nom;
        this.pack_Montant = pack_Montant;
        this.pack_description = pack_description;
        this.pack_duration = pack_duration;
        this.pack_expiration_date = pack_expiration_date;
    }

    public int getPack_id() {
        return pack_id;
    }

    public void setPack_id(int pack_id) {
        this.pack_id = pack_id;
    }

    public String getPack_nom() {
        return pack_nom;
    }

    public void setPack_nom(String pack_nom) {
        this.pack_nom = pack_nom;
    }

    public String getPack_Montant() {
        return pack_Montant;
    }

    public void setPack_Montant(String pack_Montant) {
        this.pack_Montant = pack_Montant;
    }

    public String getPack_description() {
        return pack_description;
    }

    public void setPack_description(String pack_description) {
        this.pack_description = pack_description;
    }

    public String getPack_duration() {
        return pack_duration;
    }

    public void setPack_duration(String pack_duration) {
        this.pack_duration = pack_duration;
    }

    public String getPack_expiration_date() {
        return pack_expiration_date;
    }

    public void setPack_expiration_date(String pack_expiration_date) {
        this.pack_expiration_date = pack_expiration_date;
    }

    @Override
    public String toString() {
        return "Packs{" + "pack_id=" + pack_id + ", pack_nom=" + pack_nom + ", pack_Montant=" + pack_Montant + ", pack_description=" + pack_description + ", pack_duration=" + pack_duration + ", pack_expiration_date=" + pack_expiration_date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.pack_id;
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
        final Packs other = (Packs) obj;
        if (this.pack_id != other.pack_id) {
            return false;
        }
        return true;
    }
    
}
