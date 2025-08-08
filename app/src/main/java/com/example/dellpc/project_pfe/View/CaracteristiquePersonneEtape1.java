package com.example.dellpc.project_pfe.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.Controleur.ControleurCaractExp;
import com.example.dellpc.project_pfe.Json.DAOModificationJuson;
import com.example.dellpc.project_pfe.Json.DAOValeurDataRG;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class CaracteristiquePersonneEtape1 extends AppCompatActivity {
Bundle bundle ;
ImageButton imageButtonSuivant , imageButtonPred;
EditText textCin ,textNom,textPrenom ,textAge ,texttlf,textCodePostale ,textGouvernorat,textDelegation ,textSecteur;
TextView textViewTitre ;
RadioButton radioButton,radioButton1 ;
RadioGroup radioGroup ;
Context context ;
ConnectionDetector connectionDetector ;
boolean connectionInternet ;
DAOSQlite DAOSQlite;
Personne personne ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caracteristique_exploitant_etape1);
    intial();
    seView();

        if  (bundle.getInt("modification")!=0)
        {
            this.context=this ;
            textCin.addTextChangedListener(textWatcher);

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
            //intent = new Intent(getApplicationContext(),ViewQuestionnaire.class);
            //startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    private  void  seView()
    {

        textViewTitre.setText("Caractéristique de l'exploitant");

        if (bundle.getInt("etape")!=1)
        {
            textCin.setText(bundle.getString("cin"));
            textAge.setText(bundle.getString("age"));
            textCodePostale.setText(bundle.getString("postale"));
            textNom.setText(bundle.getString("nom"));
            textPrenom.setText(bundle.getString("penom"));
            texttlf.setText(bundle.getString("tlf"));
            textGouvernorat.setText(bundle.getString("gouvernorat"));
            textSecteur.setText(bundle.getString("secteur"));
            textDelegation.setText(bundle.getString("delegation"));
        }

        ControleurCaractExp controlorQuestionnaire = new
                ControleurCaractExp(this,textCin,textDelegation,textSecteur,textGouvernorat,textCodePostale,textNom,textPrenom,texttlf,textAge,radioGroup,textViewTitre,radioButton,radioButton1,bundle);

        imageButtonSuivant.setOnClickListener(controlorQuestionnaire);
        imageButtonPred.setOnClickListener(controlorQuestionnaire);



            }
private  void intial ()

{
    DAOSQlite =new DAOSQlite(this);
    connectionDetector = new ConnectionDetector(this) ;
    connectionInternet = connectionDetector.isConnected() ;
    DAOValeurDataRG valeurDataRG = new DAOValeurDataRG(getApplicationContext(),CaracteristiquePersonneEtape1.this);
    valeurDataRG.SetDataBase(new DAOSQlite(this));
    bundle =getIntent().getExtras();
    radioButton = (RadioButton) findViewById(R.id.radioButton);
    radioButton1 = (RadioButton) findViewById(R.id.radioButton2);

    radioGroup = (RadioGroup)findViewById(R.id.radioGroupe) ;
    imageButtonSuivant = (ImageButton)findViewById(R.id.imageButtonsuivant);
    imageButtonPred = (ImageButton)findViewById(R.id.imageButtonPred);
    textAge = (EditText) findViewById(R.id.textAge);
    textCin=(EditText) findViewById(R.id.textCin) ;
    textCodePostale = (EditText) findViewById(R.id.textCodePostale) ;
    textNom= (EditText) findViewById(R.id.textNom) ;
    textPrenom = (EditText) findViewById(R.id.textPreom) ;
    texttlf = (EditText) findViewById(R.id.textMobile) ;
    textGouvernorat = (EditText) findViewById(R.id.textgouvernorat) ;
    textSecteur  = (EditText) findViewById(R.id.textSecteur) ;
    textDelegation= (EditText) findViewById(R.id.textdelegation) ;
    textViewTitre = (TextView)findViewById(R.id.titre);
}
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                if (connectionInternet)
                {
                    DAOModificationJuson modificationJuson = new DAOModificationJuson(CaracteristiquePersonneEtape1.this,context);
                    modificationJuson.getExploitant(textCin,textNom,textPrenom,texttlf,textAge,textCodePostale,textDelegation,textGouvernorat,textSecteur,radioButton,radioButton1);
                }
                else
                    {

                        personne= DAOSQlite.getPersonne(textCin.getText().toString()) ;
                        if(personne!=null)
                        {
                            textNom.setText(personne.getNom());
                            textPrenom.setText(personne.getPrenom());
                            texttlf.setText(personne.getTlf());
                            textAge.setText(String.valueOf(personne.getAge()));
                            textCodePostale.setText(String.valueOf(personne.getCodePostale()));
                            textDelegation.setText(personne.getDelegation());
                            textGouvernorat.setText(personne.getGouvernorat());
                            textSecteur.setText(personne.getSecteur());
                            String sexe = personne.getSexe() ;
                            if (sexe.equals("Femme")){radioButton.setChecked(true);  }
                            else{radioButton1.setChecked(true);}
                        }
                     //   Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
                    }
                }
    };
}
