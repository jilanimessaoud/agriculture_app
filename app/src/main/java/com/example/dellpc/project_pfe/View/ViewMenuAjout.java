package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.dellpc.project_pfe.Controleur.ControleurAjout;

import com.example.dellpc.project_pfe.R;

public class ViewMenuAjout extends AppCompatActivity {
Button b_identification_exploitation ,b_caractExploitant,b_occupationSol,retour,exit;
//ImageButton imageButton ;
    long time ;
Bundle bundle ;
    ControleurAjout controleurAjout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_questionnaire_ajout);
        bundle =getIntent().getExtras();
        initial();
        setView();


    }

    void initial ()
    {

        retour=(Button) findViewById(R.id.Retour);
        exit=(Button) findViewById(R.id.exit);
        b_identification_exploitation = (Button) findViewById(R.id.buttomIdentificationExploitation);
        b_caractExploitant = (Button)findViewById(R.id.buttonCaracterstiqueExploitant);
        b_occupationSol = (Button)findViewById(R.id.buttonOccupationSol);

    }
    void setView()
    {
        controleurAjout = new ControleurAjout(this,ViewMenuAjout.this,bundle);
        b_identification_exploitation.setOnClickListener(controleurAjout);
        //imageButton.setOnClickListener(controleurAjout);
        b_caractExploitant.setOnClickListener(controleurAjout);

        b_occupationSol.setOnClickListener(controleurAjout);

        exit.setOnClickListener(controleurAjout);
        retour.setOnClickListener(controleurAjout);
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

    @Override
    public void onBackPressed() {
        if (time+20000>System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(),DirectionResponsable.class);
            intent.putExtras(bundle) ;
            startActivity(intent);
        }
        time = System.currentTimeMillis();

    }
}
