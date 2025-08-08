package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Json.DAOSynchroniserDB;
import com.example.dellpc.project_pfe.Model.Date;
import com.example.dellpc.project_pfe.R;

public class DirectionResponsable extends AppCompatActivity {
    Button buttonSupprition , buttonAjout,buttonModification,buttonStatistique , buttonListeExploitation,buttonLiteExploitant;
    ImageButton buttonSortie ;
    ControleurDirectionResponsable controleurDirectionResponsable;
    TextView textNom ,dateEntree ;
    Bundle bundle;
    long time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_responsable);
        iniale();
        setView();
    }
    void iniale()
    {
        bundle =getIntent().getExtras();
        buttonSortie  = (ImageButton)findViewById(R.id.imageButtonExit);
        buttonAjout = (Button)findViewById(R.id.buttonAjout);
        buttonModification = (Button)findViewById(R.id.buttonModification);
        buttonStatistique = (Button)findViewById(R.id.buttonStatistique);
        buttonSupprition =(Button)findViewById(R.id.buttonSupprimer);
        textNom = (TextView)findViewById(R.id.nomResponsable) ;
        dateEntree = (TextView)findViewById(R.id.dateEntree);
        buttonListeExploitation= (Button) findViewById(R.id.listeEploitations) ;
        buttonLiteExploitant =(Button)findViewById(R.id.listeEploitant) ;
        saveSqliteToMysqlLocalhost();

    }
    void  setView ()
    {
        textNom.setText(textNom.getText()+bundle.getString("nomAdmin"));
        dateEntree.setText(new Date().getDate());
        controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle);
        buttonStatistique.setOnClickListener(controleurDirectionResponsable);
        buttonAjout.setOnClickListener(controleurDirectionResponsable);
        buttonSortie.setOnClickListener(controleurDirectionResponsable);
        buttonSupprition.setOnClickListener(controleurDirectionResponsable);
        buttonModification.setOnClickListener(controleurDirectionResponsable);
        buttonLiteExploitant.setOnClickListener(controleurDirectionResponsable);
        buttonListeExploitation.setOnClickListener(controleurDirectionResponsable);

    }
    void saveSqliteToMysqlLocalhost()
    {
        DAOSynchroniserDB synchroniserDB = new DAOSynchroniserDB(this,DirectionResponsable.this) ;
        synchroniserDB.AjoutListeExploitant();
        synchroniserDB.AjoutListeExploitation();
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
            Intent intent = new Intent(getApplicationContext(),ViewLogin.class);

            startActivity(intent);
        }
        time = System.currentTimeMillis();

    }
}