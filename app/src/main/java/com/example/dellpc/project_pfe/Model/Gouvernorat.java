package com.example.dellpc.project_pfe.Model;

import java.util.ArrayList;

public class Gouvernorat {
    private int code_gouvernorat ;
    private String label ;
    ArrayList <Delegation> listDelegation ;
    ArrayList<String> listeLabel ;
    ArrayList<Integer> listeCode ;

    public ArrayList<Integer> getListeCode() {
        return listeCode;
    }

    public void setListeCode(ArrayList<Integer> listeCode) {
        this.listeCode = listeCode;
    }

    public ArrayList<String> getListeLabel() {
        return listeLabel;
    }

    public void setListeLabel(ArrayList<String> listeLabel) {
        this.listeLabel = listeLabel;
    }

    public Gouvernorat(int code_gouvernorat, String label) {
        code_gouvernorat = code_gouvernorat;
        this.label = label;
    }

    public Gouvernorat() {
        listDelegation =new ArrayList<>() ;
        listeLabel = new ArrayList<>() ;
        listeCode = new ArrayList<>() ;
                         }

    public ArrayList<Delegation> getListDelegation() {
        return listDelegation;
    }

    public void setListDelegation(ArrayList<Delegation> listDelegation) {
        this.listDelegation = listDelegation;
    }

    public int getCode_gouvernorat() {
        return code_gouvernorat;
    }

    public void setCode_gouvernorat(int code_niveauAnInt) {
        code_gouvernorat = code_gouvernorat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;

    }
}
