package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.Model.Secteur;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.ViewStat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListeDelegation implements  View.OnClickListener {
private Context contextMessage  , contextResponce ,contextStartActivity ; ;
private ArrayList <Delegation> listeDelegation  ;
private Delegation delegation ;
private ArrayList<String> listeLabel ;
ListView listViewDelegation ;
ArrayAdapter arrayAdapter ;
Bundle bundle ;
Button button;
Secteur secteurChoisir  = new Secteur(-1,"",0);
String codeDelegationChoisir ;
ArrayList<Secteur> listeSecteur ;
ArrayList<String> listeLabelSecteur  ;

    public ListeDelegation(Context contextMessage, Context contextResponce, Context contextStartActivity,
                           ListView listViewDelegation,
                           Bundle bundle,Button button) {
        this.contextMessage = contextMessage;
        this.contextResponce = contextResponce;
        this.contextStartActivity = contextStartActivity;
        this.listViewDelegation = listViewDelegation;
        this.bundle = bundle ;
        this.button = button ;
    }


    public void setListeViewDelegation() {
        listeDelegation = new ArrayList<>();
        listeLabel = new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    getAlldelegation(jsonResponse);
                    setListView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };

        connection(responseListener,"/ListeDelegation.php" , "1");
    }


    public void setSpinnerViewDelegation(final Spinner spinner, final Spinner spinnerSecteur, final Context contextSpiner ) {
        listeDelegation = new ArrayList<>();
        listeLabel = new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response ) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    getAlldelegation(jsonResponse);
                    setSpiner(spinner,spinnerSecteur,contextSpiner);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };

        connection(responseListener,"/ListeDelegation.php","1");
    }

    public void setSpinnerViewSecteur(final Spinner spinner, final Context contextSpiner, final String codeLieu) {
       listeSecteur = new ArrayList<Secteur>();
        listeLabelSecteur = new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response ) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    setListeSecteur(jsonResponse,spinner,contextSpiner,codeLieu);
             } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };

        connection(responseListener,"/ListeSecteur.php",codeLieu);
    }

void setListeSecteur (JSONObject jsonResponse , Spinner spinner , Context contextSpiner, final String codeLieu) throws JSONException {

    JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_delegation") ;
    listeLabelSecteur.add("secteur");
    for (int i = 0 ; i<arrayDelegation.length();i++)
    {
        JSONObject jsonObject = arrayDelegation.getJSONObject(i);
        Secteur secteur = new Secteur(codeSecteur(jsonObject.toString()),jsonObject.getString(String.valueOf(codeSecteur(jsonObject.toString()))),
                1);
        listeSecteur.add(secteur);
        listeLabelSecteur.add(jsonObject.getString(String.valueOf(codeSecteur(jsonObject.toString()))));
    }
    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(contextSpiner,android.R.layout.simple_spinner_item
            ,listeLabelSecteur);
    stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(stringArrayAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            if (position>0)
            {

             secteurChoisir = new Secteur(listeSecteur.get(position - 1).getCode_secteur(),listeSecteur.get(position - 1).getLabel(),Integer.parseInt(codeLieu));
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

}





    void connection ( Response.Listener<String> responseListener,String page ,String codeLieu)
    {
        RequesteListeDelegation loginRequest = new RequesteListeDelegation("http://192.168.43.74/ProjectRecensementGenerale" +
                page,
                codeLieu,responseListener);
        RequestQueue queue = Volley.newRequestQueue(contextResponce);
        queue.add(loginRequest);

    }
    void getAlldelegation ( JSONObject jsonResponse ) throws JSONException {


        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_delegation") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        {
            JSONObject jsonObject = arrayDelegation.getJSONObject(i);

            delegation = new Delegation(jsonObject.getString(String.valueOf(i+1)),i,i+1);
            listeDelegation.add(delegation) ;
            listeLabel.add(jsonObject.getString(String.valueOf(i+1)));

        }

    }

    void setListeSecteur ( JSONObject jsonResponse ) throws JSONException {


        JSONArray arrayDelegation =  jsonResponse.getJSONArray("tab_delegation") ;
        for (int i = 0 ; i<arrayDelegation.length();i++)
        {
            JSONObject jsonObject = arrayDelegation.getJSONObject(i);

            delegation = new Delegation(jsonObject.getString(String.valueOf(i+1)),i,i+1);
            listeDelegation.add(delegation) ;
            listeLabel.add(jsonObject.getString(String.valueOf(i+1)));

        }

    }

    void setListView ()
    {

        arrayAdapter = new ArrayAdapter(contextStartActivity,R.layout.liste_des_lieux,R.id.leux,listeLabel);
        listViewDelegation.setAdapter(arrayAdapter);
        listViewDelegation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(contextMessage,ViewStat.ViewStatCercle.class) ;
                delegation = listeDelegation.get(position);
                bundle.putString("codeDelegation" ,String.valueOf(delegation.getCodeDelegation()) ) ;
                intent.putExtras(bundle) ;
                //     Toast.makeText(contextMessage.getApplicationContext(),bundle.getString("codeDelegation"),Toast.LENGTH_LONG).show();
               contextStartActivity.startActivity(intent);
            }
        });

    }
    void setSpiner (final Spinner spinner , final Spinner spinnerSecteur, final Context contextSpiner)
    {
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(contextSpiner,android.R.layout.simple_spinner_item
                ,listeLabel);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                setSpinnerViewSecteur(spinnerSecteur,contextSpiner,String.valueOf(listeDelegation.get(position).getCodeDelegation()));
                delegation=listeDelegation.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private int codeSecteur(String valeur)
    {


        return Integer.parseInt( valeur.substring(2,valeur.indexOf(":")-1));
    }
void ViewButton ()
{
    button.setOnClickListener
            (
            new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(contextMessage, secteurChoisir.getLabel(), Toast.LENGTH_LONG).show();
                                    }
    });
}

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (secteurChoisir.getCodeDelegation()==0)
        {
            Toast.makeText(contextMessage,"Sv choisir un secteur",Toast.LENGTH_LONG).show();




        }
       else
        {
            Intent intent= new Intent(contextStartActivity.getApplicationContext(),ViewStat.ViewStatCercle.class);
          // Toast.makeText(contextMessage,String.valueOf(secteurChoisir.get()),Toast.LENGTH_LONG).show();

            bundle.putString("direction","2");
            bundle.putInt("valeurMenu",0);
            bundle.putString("codeDelegation","0");
            bundle.putString("codeSecteur",String.valueOf(secteurChoisir.getCode_secteur()));
            intent.putExtras(bundle);

            contextStartActivity.startActivity(intent);
        }


    }
}