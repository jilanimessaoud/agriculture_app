package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;

import com.example.dellpc.project_pfe.View.ChoixTypeProduit;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape1;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.ModificationIdentificationExploitation;
import com.example.dellpc.project_pfe.View.ModificationcaracteristiqueExploitationEtape1;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class ControleurModification implements View.OnClickListener
{

    Context contextModification ,contextActivity ;
    EditText codeExploitation , codesSecteur , coodeDelegation ;
    FragmentManager fragmentManager ;
    Bundle bundle ;

    public ControleurModification(Context contextActivity, Bundle bundle) {
        this.contextActivity = contextActivity;
        this.bundle = bundle;
    }

    @Override
    public void onClick(View v)
    {
        Intent intent ;
    switch (v.getId())
    {
        case R.id.buttomIdentificationExploitation :
            intent = new Intent(contextActivity.getApplicationContext(),ModificationIdentificationExploitation.class) ;
            bundle.putInt("modification",1 );
            bundle.putInt("etape",1);
            intent.putExtras(bundle) ;
            contextActivity.startActivity(intent);
        break;

            case R.id.buttonCaracterstiqueExploitant:
                intent = new Intent(contextActivity.getApplicationContext(),CaracteristiquePersonneEtape1.class) ;
                bundle.putInt("etape",1);
                bundle.putInt("modification",1 );
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);

                break;

            case  R.id.buttonExploitation:

            intent = new Intent(contextActivity.getApplicationContext(),ModificationcaracteristiqueExploitationEtape1.class) ;
            bundle.putInt("etape",1);
            intent.putExtras(bundle) ;
            contextActivity.startActivity(intent);
            break;

        case R.id.buttonOccupationSol :
            intent=new Intent(contextActivity.getApplicationContext(),ChoixTypeProduit.class) ;
            bundle.putInt("modification",1);
            intent.putExtras(bundle) ;
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
