/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author yassine
 */
public class coash  {
    private int id;
    private String nom;
    private String sexe;
    private int numtel;
    private String adressemail;
    private String adresse;
    private String username;
    private String specialite;

    public coash() {
    }

    public coash(int id, String nom, String sexe, int numtel, String adressemail, String adresse, String username, String specialite)
    {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numtel = numtel;
        this.adressemail = adressemail;
        this.adresse = adresse;
        this.username = username;
        this.specialite = specialite;
    }

    public coash(String nom, String sexe, int numtel, String adressemail, String adresse, String username, String specialite) {
        this.nom = nom;
        this.sexe = sexe;
        this.numtel = numtel;
        this.adressemail = adressemail;
        this.adresse = adresse;
        this.username = username;
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "coash{" + "id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", numtel=" + numtel + ", adressemail=" + adressemail + ", adresse=" + adresse + ", username=" + username + ", specialite=" + specialite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final coash other = (coash) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
     
}
