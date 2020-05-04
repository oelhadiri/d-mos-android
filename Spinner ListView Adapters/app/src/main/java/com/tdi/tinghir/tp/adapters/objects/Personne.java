package com.tdi.tinghir.tp.adapters.objects;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private boolean actif;

    public Personne() {
    }

    public Personne(int id, String nom, String prenom, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.actif = actif;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return getNom() + " " + getPrenom();
    }
}
