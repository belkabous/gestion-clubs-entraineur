package com.example.gestion_clubs.model;

import java.sql.Timestamp;

public class Seance {
    private CompositId id;
    private Timestamp date_heure;

    public Seance() {
    }

    public Seance(CompositId id, Timestamp date_heure) {
        this.id = id;
        this.date_heure = date_heure;
    }

    public CompositId getId() {
        return id;
    }

    public void setId(CompositId id) {
        this.id = id;
    }

    public Timestamp getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(Timestamp date_heure) {
        this.date_heure = date_heure;
    }
}
