package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dellpc.project_pfe.View.ChoixTypeProduit;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape1;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape1;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class ControleurAjout implements View.OnClickListener
{
    Context contextResponce ;
    Context contextActivity ;
Bundle bundle ;
    public ControleurAjout(Context contextResponce, Context contextActivity, Bundle bundle) {
        this.contextResponce = contextResponce;
        this.contextActivity = contextActivity;
        this.bundle = bundle ;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.buttomIdentificationExploitation:


                intent = new Intent(contextActivity.getApplicationContext(), CaracteristiqueExploitationEtape1.class);
                intent.putExtras(bundle);
                contextActivity.startActivity(intent);
                break;
                case R.id.buttonCaracterstiqueExploitant:
                intent = new Intent(contextActivity.getApplicationContext(), CaracteristiquePersonneEtape1.class);
                    bundle.putInt("etape",1);
                    bundle.putInt("modification",0);
                    intent.putExtras(bundle);
                contextActivity.startActivity(intent);

                break;
                  case R.id.buttonExploitation:
                intent = new Intent(contextActivity.getApplicationContext(), CaracteristiqueExploitationEtape2.class);
                      bundle.putInt("modification",0);
                bundle.putInt("etape",1);
                intent.putExtras(bundle);
                contextActivity.startActivity(intent);

                break;
            case R.id.buttonOccupationSol:
                intent = new Intent(contextActivity.getApplicationContext(), ChoixTypeProduit.class);
                bundle.putInt("modification",0);
                intent.putExtras(bundle);
                contextActivity.startActivity(intent);

                break;


            case R.id.Retour :
                intent = new Intent(contextActivity.getApplicationContext(),DirectionResponsable.class) ;
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);
                break;
            case R.id.exit :
                intent = new Intent(contextActivity.getApplicationContext(),ViewLogin.class) ;
                contextActivity.startActivity(intent);
                break;


        }

    }
}
