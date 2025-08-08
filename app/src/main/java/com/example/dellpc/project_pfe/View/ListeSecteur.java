package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Json.ListeDelegation;
import com.example.dellpc.project_pfe.R;

public class ListeSecteur extends AppCompatActivity
{
    Spinner spinerDelegation , spinnerSecteur  ;
    TextView textViewDelegation , textViewSecteur ;
    Bundle bundle ;
    Button buttonValider  , buttonRetour ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_secteur);
        intView();
        setView();
    }
    void setView()
    {
        bundle =getIntent().getExtras();
        ControleurDirectionResponsable controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle) ;
        final ListeDelegation  listeDelegation = new ListeDelegation(getApplicationContext(),ListeSecteur.this,this,null
                ,bundle,buttonValider);
        listeDelegation.setSpinnerViewDelegation(spinerDelegation,spinnerSecteur,this);
        buttonValider.setOnClickListener(listeDelegation);
        buttonRetour.setOnClickListener(controleurDirectionResponsable);
    }
    void intView ()
    {
        spinnerSecteur = findViewById(R.id.spinerSecteur);
        spinerDelegation = findViewById(R.id.spinerDelegation);
        textViewDelegation = (TextView) findViewById(R.id.textDelegation);
        textViewSecteur = (TextView) findViewById(R.id.textSecteur);
        buttonRetour = (Button)findViewById(R.id.buttonRetour);
        buttonValider = (Button)findViewById(R.id.buttonValider);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusortie,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent ;
        if (id ==R.id.itmexit)

        {
        }


        return super.onOptionsItemSelected(item);
    }

}
