package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.Controleur.ControleurCaractExp;
import com.example.dellpc.project_pfe.Json.DAOModificationJuson;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class CaracteristiquePersonneEtape2 extends AppCompatActivity {
Bundle bundle ;
    Spinner spinerNV , spinnerTypeFormation  , spinnerDiplome,spinnerActivite;
    ImageButton buttonRetour,buttonSuiv ,exit ;
    EditText editTextNbHomme ,editTextNbFemme;
    RadioButton  radioButtonGernt ,radioButtonExploitant ;
    RadioGroup radioGroup ;
    ArrayAdapter<CharSequence> arrayAdapter ;
    ConnectionDetector connectionDetector ;
    boolean connectionInternet ;
    Personne personne ;
    DAOSQlite DAOSQlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caracteristique_eploitant_etape2);
        intial();

        setView();
        if  (bundle.getInt("modification")!=0)
        {
            if (connectionInternet)
            {
                DAOModificationJuson modificationJuson = new DAOModificationJuson(CaracteristiquePersonneEtape2.this,this);
                modificationJuson.getExploitantEtape2(spinerNV,spinnerDiplome,spinnerTypeFormation,
                spinnerActivite,editTextNbHomme,editTextNbFemme,bundle.getString("cin"));
            }
            else
                {
                    personne= DAOSQlite.getPersonne(bundle.getString("cin")) ;
                    if(personne!=null)
                    {
                        editTextNbFemme.setText(String.valueOf(personne.getnBFamileFemme()));
                        editTextNbHomme.setText(String.valueOf(personne.getnBFamileHomme()));
                       spinerNV.setSelection(Integer.parseInt(personne.getNiveauInstruction()));
                        spinnerDiplome.setSelection(Integer.parseInt(personne.getTypeDiplome()));
                        spinnerTypeFormation.setSelection(Integer.parseInt(personne.getTypeFormation()));
                        spinnerActivite.setSelection(Integer.parseInt(personne.getActivitePrincipale()));

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
private  void setView ()
    {
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.NV_inst,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerNV.setAdapter(arrayAdapter);


        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.typeFormation,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeFormation.setAdapter(arrayAdapter);


        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.diplome,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiplome.setAdapter( arrayAdapter);


        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.activite,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivite.setAdapter( arrayAdapter);

        if (bundle.getInt("etape")!=1)
        {
            editTextNbHomme.setText(bundle.getString("homme"));
            editTextNbFemme.setText(bundle.getString("femme"));
            Toast.makeText(getApplication(),bundle.getString("homme"),Toast.LENGTH_LONG).show();
        }


        ControleurCaractExp controleurCaractExp =new ControleurCaractExp(
                this,editTextNbHomme,editTextNbFemme,radioGroup,radioButtonExploitant,radioButtonGernt,spinerNV,
                spinnerTypeFormation,spinnerDiplome,spinnerActivite ,bundle);
        buttonSuiv.setOnClickListener(controleurCaractExp);
        exit.setOnClickListener(controleurCaractExp);
        buttonRetour.setOnClickListener(controleurCaractExp);
            }
private  void intial ()
            {
                DAOSQlite =new DAOSQlite(this) ;
                connectionDetector =new ConnectionDetector(this);
                connectionInternet = connectionDetector.isConnected();
                bundle =getIntent().getExtras();
                editTextNbFemme = (EditText)findViewById(R.id.nbFemme) ;
                editTextNbHomme = (EditText)findViewById(R.id.nBhomme) ;
                radioGroup = (RadioGroup)findViewById(R.id.radioGroupe);
                buttonSuiv= (ImageButton) findViewById(R.id.suivCarectristiqueExplEtap2) ;
                spinerNV = findViewById(R.id.spinerNV);
                spinnerTypeFormation = findViewById(R.id.typeFormation);
                spinnerDiplome = findViewById(R.id.diplome);
                spinnerActivite = findViewById(R.id.activite);
                buttonRetour = (ImageButton) findViewById(R.id.predCarectristiqueExplEtap2) ;
                exit = (ImageButton) findViewById(R.id.exit) ;
            }
}
