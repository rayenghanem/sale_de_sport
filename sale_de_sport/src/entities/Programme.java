/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


/**
 *
 * @author LENOVO
 */
public class Programme {
    public Programme(){};

    private int id_pro;
    private String type_sport;
    private String coach_name;
    private String date;
  

    public Programme (int id_pro, String type_sport, String coach_name, String date) {
        this.id_pro= id_pro;
        this.type_sport = type_sport;
        this.coach_name = coach_name;
        this.date = date;
        
    }
    public Programme (String type_sport, String coach_name, String date) {
        
        this.type_sport = type_sport;
        this.coach_name = coach_name;
        this.date = date;
        
    }

    public int getId_pro() {
        return id_pro;
    }

    public String getType_sport() {
        return type_sport;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public String getDate() {
        return date;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Programme{" + "id_pro=" + id_pro + ", type_sport=" + type_sport + ", coach_name=" + coach_name + ", date=" + date + '}';
    }

}
