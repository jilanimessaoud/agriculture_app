package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONException;
import org.json.JSONObject;

public class DAOUserJson {
    private static final String LOGIN_REQUEST_URL = "http://192.168.43.74/ProjectRecensementGenerale/CaracteristiqueGouvernorat.php";
    Context context, context2,context3 ;
    EditText pass , user;
    Bundle bundle;
    public DAOUserJson(Context context, Context context2, Context  context3 , EditText pass, EditText user ) {
        this.context = context;
        this.context2 = context2;
        this.context3=context3;
        this.pass=pass ;
        this.user=user ;
    }

    public void login() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    DAOSQlite DAOSQlite =new DAOSQlite(context) ;
                    DAOValeurDataRG valeurDataRG = new DAOValeurDataRG(context.getApplicationContext(), context2);
                    valeurDataRG.SetDataBase(DAOSQlite);
                    JSONObject jsonResponse = new JSONObject(response);
                    Boolean TestConnectionDB = jsonResponse.getBoolean("login");
                    if (TestConnectionDB==false) {
                        Toast toast = Toast.makeText(context,"Utilisateur ou mot de passe incorrecte" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else
                        {
                            String nom = jsonResponse.getString("nom");
                            bundle = new Bundle() ;
                            bundle.putString("nomAdmin",nom);
                            Intent    intent = new Intent(context3.getApplicationContext(),DirectionResponsable.class);
                            intent.putExtras(bundle);
                            context3.startActivity(intent);
                        }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteValeurLogin loginRequest = new RequesteValeurLogin("http://192.168.43.74/ProjectRecensementGenerale" +
                "/Login.php",user.getText().toString(),pass.getText().toString(),
                responseListener);
        RequestQueue queue = Volley.newRequestQueue(context2);
        queue.add(loginRequest);

    }
}

