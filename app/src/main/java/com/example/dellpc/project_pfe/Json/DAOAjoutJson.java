package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Caracteristique_exploitation;
import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.Model.Produit;
import com.example.dellpc.project_pfe.Model.Secteur;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape2;
import com.example.dellpc.project_pfe.View.ViewMenuAjout;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAOAjoutJson
{
   Context contextAjout ;
   Context contextActivity ;
   String stringValeur ;
Boolean testAjout  ;
Intent intent ;
ArrayList<String> liste ;
ArrayAdapter arrayAdapter ;
    public DAOAjoutJson(Context contextAjout, Context contextActivity)
    {
        this.contextAjout = contextAjout;
        this.contextActivity = contextActivity;
    }

    public void ajoutPersonne(final Personne personne, final Bundle bundle)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                 testAjout =    jsonResponse.getBoolean("test_ajout");
                if (testAjout)

                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();

                          intent = new Intent(contextActivity.getApplicationContext(),ViewMenuAjout.class);
                         intent.putExtras(bundle) ;
                         contextActivity.startActivity(intent);
                    }
                    else
                        {
                            Toast.makeText(contextActivity.getApplicationContext(),"Existe déjà",Toast.LENGTH_LONG).show();
                        }
                } catch (JSONException e)
                {

                    e.printStackTrace();

                }

            }

        };
        RequesteValeurAjout valeurAjout = new RequesteValeurAjout("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ajout.php",personne.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);


    }
    public void ajoutExploitation(final Exploitation exploitation, final Bundle bundle, final EditText cinGirant, final EditText cinExploitant )
    {
        String valeur = null;
        if (exploitation==null)valeur=cinGirant.getText().toString()+","+cinExploitant.getText().toString() ;
        else valeur=exploitation.toString() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
             if     (!jsonResponse.getBoolean("test_ajout"))
             {
                boolean testGerant =  jsonResponse.getBoolean("testcinG");
                boolean testExploitant =jsonResponse.getBoolean("testcinEx") ;
            if (!testGerant){cinGirant.setError(cinGirant.getHint().toString()+" N'existe pas");}
            if (!testExploitant){cinExploitant.setError(cinExploitant.getHint().toString()+" N'existe pas");}
            if (testExploitant&&testGerant)
            {
                Intent intent = new Intent(contextActivity.getApplicationContext(),CaracteristiqueExploitationEtape2.class) ;
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);
            }
             }
             else
                 {
                     Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(contextActivity.getApplicationContext(),ViewMenuAjout.class) ;
                    intent.putExtras(bundle) ;
                    contextActivity.startActivity(intent);

                 }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutExploitation valeurAjout = new RequesteAjoutExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ajout.php",valeur,responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);


    }
    public void ajoutOccupSol(final Caracteristique_exploitation caracteristique_exploitation, final Bundle bundle)
    {
       // Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    testAjout =    jsonResponse.getBoolean("test_ajout");
                    if (testAjout)
                    Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(contextActivity.getApplicationContext(),"Existe déjà",Toast.LENGTH_LONG).show();
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutOccupSol valeurAjout = new RequesteAjoutOccupSol("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ajout.php",caracteristique_exploitation.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);


    }
    public void getExploitation(final ListView listView, final EditText editText)
    {

        liste=new ArrayList<>();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    DAOSQlite daosQlite = new DAOSQlite(contextAjout) ;
                    ArrayList<Delegation> listeDelegation = daosQlite.getAllDelegation();

                    listView.setAdapter(null);
                    JSONObject jsonResponse = new JSONObject(response);
                    testAjout =    jsonResponse.getBoolean("test_ajout");
                    if (testAjout) {
                        JSONArray arrayExploitaion = jsonResponse.getJSONArray("tab_delegation");
                        for (int i = 0; i<arrayExploitaion.length();i++)
                        {
                            String secteur =arrayExploitaion.getJSONObject(i).getString("secteur") ;
                            String codeDelegation = daosQlite.getDelegation(secteur) ;
                            String labelD  = listeDelegation.get(Integer.parseInt(codeDelegation)-1).getLabel() ;
                            String labelS=daosQlite.getSecteur(secteur);
                            liste.add("numéro : " +arrayExploitaion.getJSONObject(i).getString(String.valueOf(i+1))+" localisation :  " + labelD+" / "+labelS );
                         }
                        arrayAdapter = new ArrayAdapter(contextActivity,R.layout.liste_des_lieux,R.id.leux,liste);
                        listView.setAdapter(arrayAdapter);
                    }
                    else
                        {
                            editText.setError("0 exploitation");
                        }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutGetExploitation valeurAjout = new RequesteAjoutGetExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ajout.php",editText.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);


    }
   public  void Ajout(final String codeProduit , final String stringValeur, final String codeExploitation )
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    testAjout =    jsonResponse.getBoolean("test_ajout");
                    if (testAjout) {
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                                    }
                                    else
                                        {
                                            Toast.makeText(contextActivity.getApplicationContext(),"Existe déjà",Toast.LENGTH_LONG).show();
                                        }
                    }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutProduit valeurAjout = new RequesteAjoutProduit("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ajout.php",stringValeur,codeExploitation,codeProduit,responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(valeurAjout);

    }
   public void getExploitant(final EditText cin, final Bundle bundle )
   {

       Response.Listener<String> responseListener = new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               try {
                   JSONObject jsonResponse = new JSONObject(response);
                   boolean testExiste = jsonResponse.getBoolean("exist_Exploitation");

                   if (!testExiste)
                   {
                       if  (bundle.getInt("modification")==0)
                       {
                           intent = new Intent(contextAjout.getApplicationContext(), CaracteristiquePersonneEtape2.class);
                           intent.putExtras(bundle);
                           contextAjout.startActivity(intent);
                       }
                       else cin.setError(cin.getHint().toString()+" ne pas existe");
                   }
                   else
                   {
                       if  (bundle.getInt("modification")==0)
                       {
                           cin.setError(cin.getHint().toString()+" déja existe");
                       }
                       else
                           {
                               intent = new Intent(contextAjout.getApplicationContext(), CaracteristiquePersonneEtape2.class);
                               intent.putExtras(bundle);
                               contextAjout.startActivity(intent);
                           }

                   }

               }
               catch (JSONException e)
               {

                   e.printStackTrace();
               }

           }

       };
       RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
               "/ConsultDonner.php",cin.getText().toString(),responseListener);

       RequestQueue queue = Volley.newRequestQueue(contextAjout);
       queue.add(modifOccupSol);

   }
}
