package com.example.gestion_clubs.model;

public class Entraineur {
    private int id;
    private String nom;
    private String specialite;

    public Entraineur() {
    }

    public Entraineur(String specialite, String nom, int id) {
        this.specialite = specialite;
        this.nom = nom;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
