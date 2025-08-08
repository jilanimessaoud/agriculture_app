package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtpae3;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape1;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.ViewMenuAjout;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape3;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class ControlorQuestionnaire extends ViewLogin implements View.OnClickListener

{
    Context context ;
    boolean testLogin = true ;


    public ControlorQuestionnaire(Context context )
    {
        super();
        this.context=context;


    }

    public boolean verifierLogin()
    {

        return testLogin ;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
        Intent intent ;

        switch (v.getId())
        {
            case R.id.buttonAjout :

                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);
                context.startActivity(intent);

                break;


            case R.id.imageButtonretourlisteAjout :
                intent = new Intent(context.getApplicationContext(),DirectionResponsable.class);
                context.startActivity(intent);
                break;

            case R.id.imageButtonretourQuestionnaire :

                break;
            case R.id.buttonCaracterstiqueExploitant:
                intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape1.class);
                context.startActivity(intent);
                break;
            case R.id.imageButtonsuivant:
                intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape2.class);
                context.startActivity(intent);
                break;

            case R.id.imageButtonPred:
                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);

                context.startActivity(intent);
                break;
            case R.id.suivCarectristiqueExplEtap2:
                 intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape3.class);
                context.startActivity(intent); break;

               case R.id.imageButtonPredgerant:
                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);
                context.startActivity(intent); break;
            case R.id.buttonOccupationSol:
                intent = new Intent(context.getApplicationContext(),CaracteristiqueExploitationEtape2.class);
                context.startActivity(intent); break;
            case R.id.imageButtonPredOccup:
                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);
                context.startActivity(intent); break;
            case R.id.imageButtonSuivaOccup:
                intent = new Intent(context.getApplicationContext(),CaracteristiqueExploitationEtpae3.class);
                context.startActivity(intent); break;
            case R.id.imageButtonretourOcup2:
                intent = new Intent(context.getApplicationContext(),CaracteristiqueExploitationEtape2.class);
                context.startActivity(intent); break;

            case R.id.buttonExploitation:
              //  intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape1.class);
             //   context.startActivity(intent); break;

            case R.id.imageButtonRetourExploitation:
                intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape3.class);
                context.startActivity(intent); break;


            case R.id.predCarectristiqueExplEtap2 :
                intent=new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape1.class);
              context.startActivity(intent);
                break;


            case R.id.predCarectristiqueExplEtap3 :
                intent=new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape2.class);
                context.startActivity(intent);
                break;
        }

    }


}

