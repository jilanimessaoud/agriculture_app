package com.example.dellpc.project_pfe.Model;

import java.util.ArrayList;

public class TypeProduit
{
    int numeroTypeProduit ;
    int idType ;
    int idProduit ;
    String label ;

    public TypeProduit(int numeroTypeProduit, int idType, int idProduit, String label) {
        this.numeroTypeProduit = numeroTypeProduit;
        this.idType = idType;
        this.idProduit = idProduit;
        this.label = label;
    }

    public TypeProduit() {
    }

    public int getNumeroTypeProduit() {
        return numeroTypeProduit;
    }

    public void setNumeroTypeProduit(int numeroTypeProduit) {
        this.numeroTypeProduit = numeroTypeProduit;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<String> getLabels(ArrayList<TypeProduit> typeProduits )
    {
        ArrayList<String>  liste = new ArrayList<>();
        for (int i=0;i<typeProduits.size();i++)
        {
            liste.add(typeProduits.get(i).getLabel());

        }
        return liste ;
    }
}
