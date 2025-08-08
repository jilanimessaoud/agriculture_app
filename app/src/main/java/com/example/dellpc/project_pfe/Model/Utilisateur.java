package com.example.dellpc.project_pfe.Model;

public class Utilisateur
{
    String user ,password , nom,prenom,type ;

    public Utilisateur() {
    }

    public Utilisateur(String user, String password, String nom, String prenom, String type) {
        this.user = user;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
