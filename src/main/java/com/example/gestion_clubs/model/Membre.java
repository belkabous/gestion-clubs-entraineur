package com.example.gestion_clubs.model;

public class Membre {
    private int id;
    private String nom_membre;
    private String sport_pratiquee;

    public Membre() {

    }

    public Membre(int id, String nom_membre, String sport_pratiquee) {
        this.id = id;
        this.nom_membre = nom_membre;
        this.sport_pratiquee = sport_pratiquee;
    }

    public Membre(String nomMembre, String sportPratiquee) {
        this.nom_membre = nomMembre;
        this.sport_pratiquee = sportPratiquee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_membre() {
        return nom_membre;
    }

    public void setNom_membre(String nom_membre) {
        this.nom_membre = nom_membre;
    }

    public String getSport_pratiquee() {
        return sport_pratiquee;
    }

    public void setSport_pratiquee(String sport_pratiquee) {
        this.sport_pratiquee = sport_pratiquee;
    }
}