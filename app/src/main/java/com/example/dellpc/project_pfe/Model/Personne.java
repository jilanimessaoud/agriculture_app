package com.example.dellpc.project_pfe.Model;

public class Personne
{
    int  age ,nBFamileHomme,nBFamileFemme,codePostale;
    String cin  ,nom , prenom , gouvernorat ,sexe ,tlf,niveauInstruction,
            typeFormation,typeDiplome,activitePrincipale, assurance , entravesDeveloppement ,credit,cnss ,delegation,secteur;

    public Personne() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getnBFamileHomme() {
        return nBFamileHomme;
    }

    public void setnBFamileHomme(int nBFamileHomme) {
        this.nBFamileHomme = nBFamileHomme;
    }

    public int getnBFamileFemme() {
        return nBFamileFemme;
    }

    public void setnBFamileFemme(int nBFamileFemme) {
        this.nBFamileFemme = nBFamileFemme;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getNiveauInstruction() {
        return niveauInstruction;
    }

    public void setNiveauInstruction(String niveauInstruction) {
        this.niveauInstruction = niveauInstruction;
    }

    public String getTypeFormation() {
        return typeFormation;
    }

    public void setTypeFormation(String typeFormation) {
        this.typeFormation = typeFormation;
    }

    public String getTypeDiplome() {
        return typeDiplome;
    }

    public void setTypeDiplome(String typeDiplome) {
        this.typeDiplome = typeDiplome;
    }

    public String getActivitePrincipale() {
        return activitePrincipale;
    }

    public void setActivitePrincipale(String activitePrincipale) {
        this.activitePrincipale = activitePrincipale;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getEntravesDeveloppement() {
        return entravesDeveloppement;
    }

    public void setEntravesDeveloppement(String entravesDeveloppement) {
        this.entravesDeveloppement = entravesDeveloppement;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCnss() {
        return cnss;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    @Override
    public String toString() {
        return cin+","+nom+","+prenom+","+sexe+","+gouvernorat+","+age+","+tlf+","+cnss+","+niveauInstruction+","+
                typeFormation+","+typeDiplome+","+activitePrincipale+","
                +nBFamileHomme+","+nBFamileFemme+","+assurance+","+entravesDeveloppement
                +","+credit+","+delegation+","+codePostale+","+secteur;    }
}
