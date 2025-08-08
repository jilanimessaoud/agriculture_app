package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.Controleur.ControleurCaractExp;
import com.example.dellpc.project_pfe.Json.DAOModificationJuson;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class CaracteristiquePersonneEtape3 extends AppCompatActivity {
ImageButton imageButtonPred ,imageButtonSuiv ,exit;
Spinner spinnertypeAS ,spinerPrEn  ;
RadioButton trueCNSS ,falseCNSS , trueCredit ,fasleCredit ;
RadioGroup cnss , credit ;
ArrayAdapter<CharSequence> arrayAdapter ;
ConnectionDetector connectionDetector ;
boolean connectionInternet ;
DAOSQlite DAOSQlite;
Bundle bundle ;
Personne personne ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caracterstique_exploitant_etape3);
        intial();
        seView();
        if  (bundle.getInt("modification")!=0)
        {
            if (connectionInternet)
            {
                DAOModificationJuson modificationJuson = new DAOModificationJuson(CaracteristiquePersonneEtape3.this,this);
                modificationJuson.getExploitantEtape3(spinnertypeAS,spinerPrEn,trueCredit,fasleCredit,trueCNSS,falseCNSS,bundle.getString("cin"));
            }
            else {
                personne = DAOSQlite.getPersonne(bundle.getString("cin"));

                if (personne != null) {
                    spinnertypeAS.setSelection(Integer.parseInt(personne.getAssurance()));
                    spinerPrEn.setSelection(Integer.parseInt(personne.getEntravesDeveloppement()));
                    if (personne.getCredit().equals("Non"))
                    {
                        fasleCredit.setChecked(true);
                    }
                    else {
                        trueCredit.setChecked(true);
                    }
                    if (personne.getCnss().equals("Non"))
                    {
                        falseCNSS.setChecked(true);
                    }
                    else
                    {trueCNSS.setChecked(true);}

                }
            }
        }


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
    void seView ()
    {
        //modification view de Activity Caracteristique personne etape 3
        arrayAdapter  =ArrayAdapter.createFromResource(this,R.array.TypeAssurance,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertypeAS.setAdapter(arrayAdapter);
        arrayAdapter  =ArrayAdapter.createFromResource(this,R.array.AutravesDevelop,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerPrEn.setAdapter(arrayAdapter);

        ControleurCaractExp controleurCaractExp =
                new ControleurCaractExp
                        (this,credit,cnss,trueCredit,fasleCredit,trueCNSS,falseCNSS,spinnertypeAS,spinerPrEn,bundle,CaracteristiquePersonneEtape3.this,getSupportFragmentManager());
        exit.setOnClickListener(controleurCaractExp);
        imageButtonPred.setOnClickListener(controleurCaractExp);
        imageButtonSuiv.setOnClickListener(controleurCaractExp);

    }
    void intial()
    {
        /// recuperation eta intiale initiale de elements de acticity
        connectionDetector = new ConnectionDetector(this) ;
        connectionInternet = connectionDetector.isConnected() ;
        DAOSQlite =new DAOSQlite(this);
        bundle =getIntent().getExtras();
        imageButtonSuiv = findViewById(R.id.SavePerson);
        imageButtonPred = findViewById(R.id.predCarectristiqueExplEtap3);
        spinnertypeAS = findViewById(R.id.spineTypeAS);
        spinerPrEn =findViewById(R.id.spinerPrEn);
        cnss = (RadioGroup)findViewById(R.id.radioGroupeCNSS);
        credit = (RadioGroup)findViewById(R.id.radioGroupeCredi);
        trueCNSS = (RadioButton) findViewById(R.id.CNSsOui);
        falseCNSS= (RadioButton) findViewById(R.id.CNSSNon);
        fasleCredit= (RadioButton) findViewById(R.id.CrediNon);
        trueCredit= (RadioButton) findViewById(R.id.CrediOui);
        exit = (ImageButton) findViewById(R.id.exit) ;

    }
}
