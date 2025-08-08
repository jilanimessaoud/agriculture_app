package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DAOSuprimerJuson
{
    Context contextActivity ,contextSupr ;

    public DAOSuprimerJuson(Context contextActivity, Context contextSupr) {
        this.contextActivity = contextActivity;
        this.contextSupr = contextSupr;
    }
   public void suprimerExploitation(final EditText codeExploitation )
    {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                  //  Toast.makeText(contextActivity.getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
                    Boolean testSup = jsonResponse.getBoolean("test_sup") ;
                    if (testSup)
                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                        codeExploitation.setText(null);
                    }
                    else
                        {
                            codeExploitation.setError("Vérifier " + codeExploitation.getHint().toString());
                        }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteSuprimExploitation valeurAjout = new RequesteSuprimExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/Suprimer.php",codeExploitation.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextSupr);
        queue.add(valeurAjout);
    }
    public void suprimerExploitant(final EditText codeExploitation )
    {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    //  Toast.makeText(contextActivity.getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
                    Boolean testSup = jsonResponse.getBoolean("test_sup") ;
                    if (testSup)
                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                        codeExploitation.setText(null);
                    }
                    else
                    {
                        codeExploitation.setError("Vérifier " + codeExploitation.getHint().toString());
                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteSuprimExploitation valeurAjout = new RequesteSuprimExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/supprimeExp.php",codeExploitation.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextSupr);
        queue.add(valeurAjout);
    }

}
