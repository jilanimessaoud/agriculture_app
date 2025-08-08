package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dellpc.project_pfe.Controleur.ControleurModification;
import com.example.dellpc.project_pfe.R;

public class MenuModification extends AppCompatActivity {
    Button b_identification_exploitation ,b_caractExploitant,b_occupationSol,retour,exit;
    ImageButton imageButton ;
    Bundle bundle ;
    long time;
    ControleurModification controleurModification  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mofification);
        initial();
        setView();


    }

    void initial ()
    {
        retour=(Button) findViewById(R.id.Retour);
        exit=(Button) findViewById(R.id.exit);
        bundle =getIntent().getExtras();
        b_identification_exploitation = (Button) findViewById(R.id.buttomIdentificationExploitation);
        imageButton = (ImageButton)findViewById(R.id.imageButtonretourlisteAjout);
        b_caractExploitant = (Button)findViewById(R.id.buttonCaracterstiqueExploitant);

        b_occupationSol = (Button)findViewById(R.id.buttonOccupationSol);

    }
    void setView(){

                controleurModification = new ControleurModification(this,bundle) ;
                b_identification_exploitation.setOnClickListener(controleurModification);
                b_occupationSol.setOnClickListener(controleurModification);
                b_caractExploitant.setOnClickListener(controleurModification);

                exit.setOnClickListener(controleurModification);
                retour.setOnClickListener(controleurModification);
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
