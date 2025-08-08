package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Controleur.ControlorLogin;
import com.example.dellpc.project_pfe.Json.ListeDelegation;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class ViewListeDelegation extends AppCompatActivity  {

    ListView liste_delegation ;
   Button buttonExit ,buttonRetour;
    final String [] tab_delegation ={"chebba","mahdia","maloulech","ksour saf"} ;
  //  ImageButton  imageButtonREtourActivityRespons ;
    ArrayAdapter arrayAdapter ;
    Bundle bundle ;
    ControleurDirectionResponsable controleurDirectionResponsable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_lieu);
        DAOSQlite DAOSQlite = new DAOSQlite(this);
        ControlorLogin myTestClass=new ControlorLogin(this,ViewListeDelegation.this, DAOSQlite);
        bundle =getIntent().getExtras();
        controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle);

        buttonRetour = (Button)findViewById(R.id.Retour) ;
        buttonExit = (Button)findViewById(R.id.exit) ;
        buttonExit.setOnClickListener(controleurDirectionResponsable);
        buttonRetour.setOnClickListener(controleurDirectionResponsable);
        liste_delegation = (ListView) findViewById(R.id.listeDelegation);
        ListeDelegation listeDelegation = new ListeDelegation(getApplicationContext(),ViewListeDelegation.this,this,liste_delegation,bundle,null) ;
        listeDelegation.setListeViewDelegation();

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
