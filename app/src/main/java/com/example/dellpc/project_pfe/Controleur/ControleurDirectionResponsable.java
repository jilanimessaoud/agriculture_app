package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.ViewStat;
import com.example.dellpc.project_pfe.View.DirectionStatistique;
import com.example.dellpc.project_pfe.View.ViewSatBar;
import com.example.dellpc.project_pfe.View.ListeExploitant;
import com.example.dellpc.project_pfe.View.ViewListeExploitation;
import com.example.dellpc.project_pfe.View.ViewMenuAjout;
import com.example.dellpc.project_pfe.View.ListeSecteur;
import com.example.dellpc.project_pfe.View.MenuModification;
import com.example.dellpc.project_pfe.View.ViewMenuSuprimer;
import com.example.dellpc.project_pfe.View.ViewListeDelegation;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class ControleurDirectionResponsable implements View.OnClickListener {
    Context context ;
    Bundle bundle ;
boolean connectionInternet ;
    ConnectionDetector connectionDetector ;
    public ControleurDirectionResponsable(Context context, Bundle bundle) {
        this.context = context;
        this.bundle = bundle;
    }
void message (String msq)
        {
            Toast.makeText(context.getApplicationContext(),msq,Toast.LENGTH_LONG).show();
        }
    @Override
    public void onClick(View v) {
        Intent intent ;
        connectionDetector = new ConnectionDetector(context) ;
        connectionInternet = connectionDetector.isConnected() ;
        switch (v.getId())
        {
            case   R.id.buttonStatistique :
                if (connectionInternet) {
                    intent = new Intent(context.getApplicationContext(), DirectionStatistique.class);
                    bundle.putInt("valeurMenu", 0);
                    bundle.putString("labelProduit","Selon les espèces animales");
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
                else
                    {
                        message("Il n'y a pas de connexion internet");
                    }
                break;
            case   R.id.buttonSupprimer :
                intent = new Intent(context.getApplicationContext() , ViewMenuSuprimer.class) ;
                intent.putExtras(bundle) ;
                context.startActivity(intent);
                break;
            case   R.id.buttonAjout :
                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case   R.id.buttonModification :
               intent = new Intent(context.getApplicationContext(),MenuModification.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case   R.id.imageButtonExit :

                intent = new Intent(context.getApplicationContext(),ViewLogin.class) ;
                context.startActivity(intent);
                break;
            case R.id.StatistiqueRetour:
                intent = new Intent(context.getApplicationContext(),DirectionResponsable.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case  R.id.StatistiqueGouvernorat :
                intent = new Intent(context.getApplicationContext(),ViewStat.ViewStatCercle.class) ;
                bundle.putString("direction","0");

                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.StatistiqueDelegation :
                intent = new Intent(context.getApplicationContext(),ViewListeDelegation.class) ;
                bundle.putString("direction","1");
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.imageButtonREtourActivityRespons :
                intent = new Intent(context.getApplicationContext(),DirectionResponsable.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
             case  R.id.graphiqueBar :
                  intent = new Intent(context.getApplicationContext(),ViewSatBar.class);
                  intent.putExtras(bundle);
                  context.startActivity(intent);

                 break;
                 case R.id.ParCercle :
                intent = new Intent(context.getApplicationContext(),ViewStat.ViewStatCercle.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.StatistiqueSecteur   :
                intent = new Intent(context.getApplicationContext(),ListeSecteur.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.buttonRetour   :
                intent = new Intent(context.getApplicationContext(),DirectionStatistique.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.Retour   :
                intent = new Intent(context.getApplicationContext(),DirectionStatistique.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case R.id.exit   :
                intent = new Intent(context.getApplicationContext(),ViewLogin.class) ;
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
            case   R.id.listeEploitant :
                intent = new Intent(context.getApplicationContext() , ListeExploitant.class) ;
                intent.putExtras(bundle) ;
                context.startActivity(intent);
                break;
            case   R.id.listeEploitations :
                intent = new Intent(context.getApplicationContext() , ViewListeExploitation.class) ;
                intent.putExtras(bundle) ;
                context.startActivity(intent);
                break;
        }

    }
}
