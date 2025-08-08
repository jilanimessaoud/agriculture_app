package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Json.DAOModificationJuson;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Produit;
import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import java.util.ArrayList;

public class ChoixTypeProduit extends AppCompatActivity implements View.OnClickListener ,DoalogVerfieirNExploitation.DialogListener {
    ArrayAdapter  arrayAdapter ;
    Spinner spinner ;
    Intent intent;
    int choix ;
    EditText numeroExploition,Superficie ;
    Button valide  ,retour,info;
    DAOSQlite DAOSQlite;
    ArrayList<String>listeLabel ;
    ArrayList<Integer>listValeur ;

    TextView titre ;
    Bundle bundle ;
    Produit p ;
    DAOModificationJuson modificationJuson ;
    ConnectionDetector connectionDetector ;
    boolean connectionInternet ;
    Exploitation exploitation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_produit);
        inial();
        setView();
    }
    void inial ()
    {
        modificationJuson = new DAOModificationJuson(ChoixTypeProduit.this, this);
        connectionDetector = new ConnectionDetector(this);
        connectionInternet=connectionDetector.isConnected();
        DAOSQlite =new DAOSQlite(this);
        spinner = findViewById(R.id.spinerAjout);
        numeroExploition = (EditText)findViewById(R.id.numeroExploition);
        valide = (Button)findViewById(R.id.valide);
        listeLabel = new ArrayList<>() ;
        info = (Button)findViewById(R.id.info) ;
        retour = (Button)findViewById(R.id.Retour) ;
    }
    void setView ()
    {
        boolean testExite  ;
        bundle =getIntent().getExtras();

        ///en cas d'ajout
        if (bundle.getInt("modification")==0)
        {
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(ChoixTypeProduit.this, android.R.layout.simple_spinner_item
                        , getListe());
                spinner.setAdapter(stringArrayAdapter);
        }


        valide.setOnClickListener(this);
        retour.setOnClickListener(this);
        info.setOnClickListener(this);
    }
    //recuperatipn liste de label  de tout produit
    ArrayList<String> getListe()
    {
        ArrayList<String > liste = new ArrayList<>();

        int tail = DAOSQlite.getAllProduit().size();
        for (int i = 0 ; i<tail;i++)
        {
          p=  (Produit) DAOSQlite.getAllProduit().get(i);
          liste.add(p.getLabel());
        }
        return liste ;
    }
    // recuperation liste de tout produit (d'un exploitation a partir code Exploitation)
    void getListeProduitSqlite()
    {
        listeLabel = new ArrayList<>();
        listValeur=new ArrayList<>();
        int codeProduit ;
        Produit produit ;

        int tail= DAOSQlite.getAllProducExploitation(numeroExploition.getText().toString()).size() ;
        com.example.dellpc.project_pfe.Model.ProduitExploitation produitExploitation ;
        for (int i = 0 ; i<tail ;  i++ )
        {
            produitExploitation = DAOSQlite.getAllProducExploitation(numeroExploition.getText().toString()).get(i);
            codeProduit = produitExploitation.getCodeProduit() ;
            produit = DAOSQlite.getProduit(String.valueOf(codeProduit)) ;
            listeLabel.add(produit.getLabel());
            listValeur.add(codeProduit) ;
        }
    }

boolean testInteger ()
{
    try {
        Integer.parseInt(numeroExploition.getText().toString());

        return  true ;
    } catch (NumberFormatException e) {
        e.printStackTrace();
        numeroExploition.setError("Vérifier");
        return false ;

        }
}
    void starActivity()
    {
            intent = new Intent(getApplicationContext(),ProduitExploitation.class);
            bundle.putString("titre",spinner.getItemAtPosition(choix).toString());
            //produit a supeerficie double = 0 , a cnt double!=0
            if (choix==0||choix==1) bundle.putInt("double", 0);
            else  bundle.putInt("double",1);
            /// get Produit
            p=  (Produit) DAOSQlite.getAllProduit().get(choix);
            bundle.putString("code",String.valueOf(p.getId()));
            bundle.putString("exploitation",numeroExploition.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
    }
    void starActivityModifSqlite()
    {
        intent = new Intent(getApplicationContext(),ProduitExploitation.class);
        bundle.putString("titre",spinner.getItemAtPosition(choix).toString());
        //produit a supeerficie double = 0 , a cnt double!=0



        if (listValeur.get(choix)==0||listValeur.get(choix)==1)
        bundle.putInt("double", 0);
        else  bundle.putInt("double",1);
        /// get Produit

        bundle.putString("code",String.valueOf(listValeur.get(choix)));
        bundle.putString("exploitation",numeroExploition.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }



//  verifier si que code Exploitation existe dans mon base
    boolean  checherCodeExploitation ()
    {
        DAOSQlite = new DAOSQlite(this);
        if (!testInteger())return false ;

        Exploitation exploitation =  DAOSQlite.getExploitation(numeroExploition.getText().toString());
        if (exploitation!=null) {
            return true ;
        }
        else
        {
            numeroExploition.setError("Ce code n'existe pas");
            return false ;
        }

    }
    boolean  checkProduitExploitation ()
    {
        if (!testInteger()) return false ;
      return DAOSQlite.getAllProducExploitation(numeroExploition.getText().toString()).size()>0;

    }
    boolean  checherProduitExploitation ()
    {
        p=  (Produit) DAOSQlite.getAllProduit().get(choix);

        if (!testInteger())return false ;

        com.example.dellpc.project_pfe.Model.ProduitExploitation produitExploitation =  DAOSQlite.getProducExploitation(numeroExploition.getText().toString(),String.valueOf(p.getId()));
        if (produitExploitation==null) {
            return true ;
        }
        else
        {
            numeroExploition.setError("Déjà ajouté");
            return false ;
        }

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        choix = -1  ;
       connectionDetector = new ConnectionDetector(this) ;
       connectionInternet=connectionDetector.isConnected() ;
        if (connectionInternet&&bundle.getInt("modification") == 0)
            choix= spinner.getSelectedItemPosition() ;

       else
       {
           if (bundle.getInt("modification")!=0)
           {

                   if (checherCodeExploitation())
                   {

                       if (checkProduitExploitation())
                       {
                           choix= spinner.getSelectedItemPosition() ;
                       }
                       else
                       {
                           numeroExploition.setError("aucun produit");
                       }


                   }
                   else
                       {
                           numeroExploition.setError("Vérifeir");
                       }
           }
       }

        if (v.getId()==R.id.info)
        {

                alert();

        }

      else  if (v.getId()==R.id.Retour)
        {
            {

                if (bundle.getInt("modification")==0) intent = new Intent(getApplicationContext(),ViewMenuAjout.class);
                else intent = new Intent(getApplicationContext(),MenuModification.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }
///button VAlider
        else

        {
            if (connectionInternet)
            {
                if (bundle.getInt("modification") == 0)
                {
                    starActivity();
                }

                else modificationJuson.modifProduit(spinner, numeroExploition, bundle, true);



            }
            else
                {

                                if (bundle.getInt("modification") == 0)
                                {

                                            if (checherCodeExploitation())
                                            {   choix= spinner.getSelectedItemPosition() ;
                                                starActivity();
                                            }
                                                else numeroExploition.setError("Vérifier");
                                }
                                    else
                                    {
                                     if (choix!=-1)
                                     {
                                         starActivityModifSqlite();
                                     }
                                    }

                }
        }
    }


void alert()
{
    DoalogVerfieirNExploitation viewDialogInfoOcpSol = new DoalogVerfieirNExploitation() ;
    viewDialogInfoOcpSol.setContext(ChoixTypeProduit.this,this);
    viewDialogInfoOcpSol.setToProduit(true);
    viewDialogInfoOcpSol.show(getSupportFragmentManager(),null);


}
    @Override
    public void ApplyCode(String code) {
        numeroExploition.setError(null);
        numeroExploition.setText(code);

        //cas existe un connection internet
        ///recuperation list de produit  à travers serveur
        if (connectionInternet)
    {
        if (bundle.getInt("modification") == 1)
        {
            numeroExploition.setError(null);
            modificationJuson.modifProduit(spinner,numeroExploition,bundle,false);

        }
    }
    /// aucun connection internet
    ///recuperation list de produit  à travers Base de données interne
    else
        {

            if (bundle.getInt("modification") == 1)
            {
                getListeProduitSqlite();
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(ChoixTypeProduit.this, android.R.layout.simple_spinner_item
                        , listeLabel);
                spinner.setAdapter(stringArrayAdapter);
            }

        }



    }
}
