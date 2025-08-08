package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.Model.Produit;
import com.example.dellpc.project_pfe.Model.Secteur;
import com.example.dellpc.project_pfe.Model.TypeProduit;
import com.example.dellpc.project_pfe.Model.Utilisateur;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAOValeurDataRG {
    private static final String LOGIN_REQUEST_URL = "http://192.168.1.43/ProjectRecensementGenerale/CaracteristiqueGouvernorat.php";
    Context context, context2,context3 ;
    EditText pass , user;
    ArrayList<Delegation> listeDelegation   ;
    ArrayList<Secteur> listeSecteur ;
    ArrayList<Produit> listeProduit ;
    ArrayList<TypeProduit> listeTypeProduit ;
    Delegation delegation ;
    Secteur secteur  ;
    Produit produit  ;
    TypeProduit typeProduit ;
    ArrayList<Utilisateur> listUser = new ArrayList<>( ) ;
Bundle bundle;
    public DAOValeurDataRG(Context context, Context context2 ) {
        this.context = context;
        this.context2 = context2;

    }
    public void SetDataBase(final DAOSQlite DAOSQlite) {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);

                        getListeUser(jsonResponse);
                        getListeDelegation(jsonResponse);
                        getListeSecteur(jsonResponse);
                        getListeProduit(jsonResponse);
                        getlisteTypeProduit(jsonResponse);
                        insertData(DAOSQlite);
                      //    Toast.makeText(context.getApplicationContext(),String.valueOf(listUser.get(0).getUser()),Toast.LENGTH_LONG).show();
                         } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };
        RequesteValeurBaseRG requesteValeurBaseRG = new RequesteValeurBaseRG("http://192.168.43.74/ProjectRecensementGenerale/ValeuDataSqlite.php",responseListener);
        RequestQueue queue = Volley.newRequestQueue(context2);
        queue.add(requesteValeurBaseRG);

    }
    void getListeSecteur  ( JSONObject jsonResponse ) throws JSONException {

        listeSecteur = new ArrayList<>() ;
        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_seteur") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        {
            JSONObject jsonObject = arrayDelegation.getJSONObject(i);

            secteur = new Secteur(getValeur(jsonObject.toString()),jsonObject.getString(String.valueOf(getValeur(jsonObject.toString()))),
                    Integer.parseInt(jsonObject.getString("codedelegation")));
           listeSecteur.add(secteur);


        }

    }
    void getListeUser  ( JSONObject jsonResponse ) throws JSONException {
    String user , pass , nom , prenom ,type;
    Utilisateur utilisateur  ;
    listUser = new ArrayList<>() ;
    JSONArray arrayUser =  jsonResponse.getJSONArray("tab_user") ;
        for (int i = 0 ; i<arrayUser.length();i++)
        {
        JSONObject jsonObject = arrayUser.getJSONObject(i);
        utilisateur = new Utilisateur() ;
        user = arrayUser.getJSONObject(i).getString("user") ;
        pass=arrayUser.getJSONObject(i).getString("pass");
        nom=arrayUser.getJSONObject(i).getString("nom");
        prenom=arrayUser.getJSONObject(i).getString("prenom");
        type = arrayUser.getJSONObject(i).getString("type");
        utilisateur.setNom(nom);
        utilisateur.setPassword(pass);
        utilisateur.setType(type);
        utilisateur.setPrenom(prenom);
        utilisateur.setUser(user);
        listUser.add(utilisateur) ;
        }

    }

    void getListeDelegation  ( JSONObject jsonResponse ) throws JSONException {

        listeDelegation = new ArrayList<>() ;
        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_delegation") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        {
            JSONObject jsonObject = arrayDelegation.getJSONObject(i);

            delegation = new Delegation(jsonObject.getString(String.valueOf(getValeur(jsonObject.toString()))),1,getValeur(jsonObject.toString()));
            listeDelegation.add(delegation);


        }

    }

    void getListeProduit  ( JSONObject jsonResponse ) throws JSONException {

        listeProduit = new ArrayList<>() ;
        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_produit") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        { JSONObject jsonObject = arrayDelegation.getJSONObject(i);
          produit = new Produit(Integer.parseInt(jsonObject.getString("codeProduit")),jsonObject.getString("label"));
          listeProduit.add(produit);
           // delegation = new Delegation(jsonObject.getString(String.valueOf(getValeur(jsonObject.toString()))),1,getValeur(jsonObject.toString()));
            //listeDelegation.add(delegation);


        }

    }

    void getlisteTypeProduit  ( JSONObject jsonResponse ) throws JSONException {

        listeTypeProduit = new ArrayList<>() ;
        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_Typeproduit") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        {
            JSONObject jsonObject = arrayDelegation.getJSONObject(i);

            typeProduit = new TypeProduit(Integer.parseInt(jsonObject.getString("numero"))
                    ,Integer.parseInt(jsonObject.getString("codeType")),
                    Integer.parseInt(jsonObject.getString("codeProduit"))
                    ,jsonObject.getString("label"));
            listeTypeProduit.add(typeProduit);
            // delegation = new Delegation(jsonObject.getString(String.valueOf(getValeur(jsonObject.toString()))),1,getValeur(jsonObject.toString()));
            //listeDelegation.add(delegation);


        }

    }
            private void insertData (DAOSQlite DAOSQlite)
            {
                    for (int i = 0 ; i<listeProduit.size();i++)
                    {
                        Produit produit = listeProduit.get(i);
                        Boolean b= DAOSQlite.insertDataProduit(produit.getId(),produit.getLabel());
                       // Toast.makeText(context, String.valueOf(b), Toast.LENGTH_LONG).show();

                        }
                for (int i = 0 ; i<listeTypeProduit.size();i++)
                {
                    typeProduit = listeTypeProduit.get(i);
                    Boolean b= DAOSQlite.insertDataTypeProduit(typeProduit.getNumeroTypeProduit(),typeProduit.getIdProduit(),
                            typeProduit.getIdType(),typeProduit.getLabel());
                    //Toast.makeText(context, String.valueOf(b), Toast.LENGTH_LONG).show();

                }


                for (int i = 0 ; i<listeSecteur.size();i++)
                {
                    secteur = listeSecteur.get(i);
                    Boolean b= DAOSQlite.insertDataSecteur(secteur.getCode_secteur(),secteur.getCodeDelegation(),secteur.getLabel());
                  //  Toast.makeText(context, String.valueOf(b), Toast.LENGTH_LONG).show();

                }
                for (int i = 0 ; i<listeDelegation.size();i++)
                {
                    delegation = listeDelegation.get(i);
                    Boolean b= DAOSQlite.insertDataDelegation(delegation.getCodeDelegation(),delegation.getLabel());

                }
                for (int i = 0 ; i<listUser.size();i++)
                {
                    Utilisateur utilisateur = listUser.get(i) ;
                    Boolean b= DAOSQlite.insertUser(utilisateur);
                }
            }
    private int getValeur(String valeur)
    {


        return Integer.parseInt( valeur.substring(2,valeur.indexOf(":")-1));
    }


}

