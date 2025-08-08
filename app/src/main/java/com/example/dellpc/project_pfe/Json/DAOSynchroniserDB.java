package com.example.dellpc.project_pfe.Json;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAOSynchroniserDB
{
    boolean testAjout ;
    Context contextActivity ,contextAjout;
    DAOSQlite DAOSQlite;
    ArrayList<Personne>listPersonne =new ArrayList<>();
    ArrayList<Exploitation>listeExploitation = new ArrayList<>() ;
    public DAOSynchroniserDB(Context contextActivity, Context contextAjout)
    {
        this.contextActivity = contextActivity;
        this.contextAjout = contextAjout;
    }
    void getAllExploitant ()
    {
        listPersonne = DAOSQlite.getAllPersonne("") ;
    }

    void getAllExploitation ()
    {
       listeExploitation= DAOSQlite.RechercherExploitation("");
    }

   public  void AjoutListeExploitant()
    {
        DAOSQlite = new DAOSQlite(contextActivity) ;
        getAllExploitant();
        for (int i = 0 ; i<listPersonne.size();i++)
        {
            Personne personne = listPersonne.get(i);

            ajoutPersonne(personne);
        }

    }
    public  void AjoutListeExploitation()
    {
        DAOSQlite = new DAOSQlite(contextActivity) ;
        getAllExploitation();
        for (int i = 0 ; i<listeExploitation.size();i++)
        {
            Exploitation exploitation = listeExploitation.get(i) ;
            ajoutExploitation(exploitation);

        }

    }
    public void ajoutExploitation(final Exploitation exploitation)
    {
        DAOSQlite = new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    if     (!jsonResponse.getBoolean("test_ajout"))
                    {


                    }
                    else
                    {
                    DAOSQlite.suprimerExploitation(String.valueOf(exploitation.getCodExploitation()));
                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutExploitation valeurAjout = new RequesteAjoutExploitation("http://192.168.1.20/ProjectRecensementGenerale" +
                "/ajout.php",exploitation.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);


    }

    void ajoutPersonne(final Personne personne)
    {
DAOSQlite =new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    testAjout =    jsonResponse.getBoolean("test_ajout");
                    if (testAjout)

                    {
                        DAOSQlite.suprimerExploitant(personne.getCin());
                    }
                    else
                    {
                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteValeurAjout valeurAjout = new RequesteValeurAjout("http://192.168.1.20/ProjectRecensementGenerale" +
                "/ajout.php",personne.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextActivity);
        queue.add(valeurAjout);


    }

}
