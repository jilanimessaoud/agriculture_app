package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.dellpc.project_pfe.Controleur.ControleurSuprimer;
import com.example.dellpc.project_pfe.R;

public class ViewMenuSuprimer extends AppCompatActivity {
Button buttonExploitation , buttonExploitant  ,buttonRetour ;
ControleurSuprimer controleurSuprimer ;
Bundle bundle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_suprs);
    intial();
    setview();
    }
    private void setview ()
    {
        controleurSuprimer = new ControleurSuprimer(this,ViewMenuSuprimer.this,null,bundle,null) ;
    //    buttonProduit.setOnClickListener(controleurSuprimer);
        buttonRetour.setOnClickListener(controleurSuprimer);
        buttonExploitation.setOnClickListener(controleurSuprimer);
        buttonExploitant.setOnClickListener(controleurSuprimer);

    }

    private  void intial()
    {
        bundle =getIntent().getExtras();
        buttonExploitant = (Button)findViewById(R.id.exploitant) ;
        buttonExploitation = (Button)findViewById(R.id.exploitation) ;
        buttonRetour = (Button)findViewById(R.id.Retour) ;

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
