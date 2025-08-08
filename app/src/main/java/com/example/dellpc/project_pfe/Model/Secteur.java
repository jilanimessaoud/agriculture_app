package com.example.dellpc.project_pfe.Model;

import java.io.Serializable;

public class Secteur implements Serializable {
    private int code_secteur ;
    private String label ;
    private int codeDelegation  ;



    public int getCode_secteur() {
        return code_secteur;
    }

    public void setCode_secteur(int code_secteur) {
        this.code_secteur = code_secteur;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCodeDelegation() {
        return codeDelegation;
    }

    public void setCodeDelegation(int codeDelegation) {
        this.codeDelegation = codeDelegation;
    }
    public Secteur(int code_secteur, String label, int codeDelegation) {
        this.code_secteur = code_secteur;
        this.label = label;
        this.codeDelegation = codeDelegation;
    }
}
