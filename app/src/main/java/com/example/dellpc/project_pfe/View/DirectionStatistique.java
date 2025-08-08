package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Model.Date;
import com.example.dellpc.project_pfe.R;

public class DirectionStatistique extends AppCompatActivity {
Button buttonGouvernorat , buttonReour ,buttonDelegation , buttonSecteur ;
ImageButton buttonSortie;
ControleurDirectionResponsable controleurDirectionResponsable;
Bundle bundle ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.direction_statistique);
        initView();
        setView();

    }
void setView ()
{
    bundle =getIntent().getExtras();
    controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle);
    buttonSortie.setOnClickListener(controleurDirectionResponsable);
    buttonDelegation.setOnClickListener(controleurDirectionResponsable);
    buttonGouvernorat.setOnClickListener(controleurDirectionResponsable);
    buttonReour.setOnClickListener(controleurDirectionResponsable);
    buttonSecteur.setOnClickListener(controleurDirectionResponsable);
}
void initView()
{
        buttonSortie  = (ImageButton)findViewById(R.id.imageButtonExit);
        buttonReour = (Button)findViewById(R.id.StatistiqueRetour);
        buttonGouvernorat = (Button)findViewById(R.id.StatistiqueGouvernorat);
        buttonDelegation = (Button)findViewById(R.id.StatistiqueDelegation);
        buttonSecteur =(Button)findViewById(R.id.StatistiqueSecteur);
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
