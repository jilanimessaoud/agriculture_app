package com.example.dellpc.project_pfe.Model;

import java.util.ArrayList;

public class Produit
{
    int id ;
    String label ;
ArrayList<String>listLabelProduit = new ArrayList<>();

    public ArrayList<String> getListLabelProduit(ArrayList<Produit> produits)
    {
        for (int i = 0 ; i<produits.size();i++)
        {
            listLabelProduit.add(produits.get(i).getLabel()) ;
        }
        return listLabelProduit;
    }

    public Produit() {
    }

    public Produit(int id, String label) {
        this.id = id;
        this.label = label;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
