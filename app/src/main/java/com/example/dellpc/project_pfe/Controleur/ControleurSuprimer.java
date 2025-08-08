package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;

import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.DialogDelet;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.DoalogVerfieirNExploitation;
import com.example.dellpc.project_pfe.View.ViewSuprimerExploitant;
import com.example.dellpc.project_pfe.View.ViewSuprimerExploitation;

public class ControleurSuprimer implements View.OnClickListener
{
    Context contextActivity ,contextSuprimer  ;
    EditText editText ;
    Bundle bundle ;
    FragmentManager fragmentManager ;
    public ControleurSuprimer(Context contextActivity, Context contextSuprimer, EditText editText,Bundle bundle,FragmentManager fragmentManager) {
        this.contextActivity = contextActivity;
        this.contextSuprimer = contextSuprimer;
        this.editText = editText;
        this.bundle=bundle ;
    this.fragmentManager=fragmentManager ;
    }
Boolean testTextInteger()
{
    try {
        Integer.parseInt(editText.getText().toString()) ;
    return true ;
    } catch (NumberFormatException e) {
        e.printStackTrace();
    return false ;
    }
}

void alert()
{
    DoalogVerfieirNExploitation viewDialogInfoOcpSol = new DoalogVerfieirNExploitation() ;
    viewDialogInfoOcpSol.setContext(contextSuprimer,contextActivity);
    viewDialogInfoOcpSol.show(fragmentManager,"ok");
}
    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId())
        {
            //passe menusSprs>>ViewSuprimerExploitation
            // dans Activity MenuSprs

            case R.id.info :

                alert();
            break;
            case R.id.buttonValider :
                if (!testTextInteger()){editText.setError("Verifier  "+ editText.getHint().toString() );}
                else
                 {
                     DialogDelet dialogDelet = new DialogDelet();
                     dialogDelet.setContext(contextActivity,contextSuprimer);
                     dialogDelet.setEditText(editText);
                     dialogDelet.setIdButton(R.id.buttonValider);
                     dialogDelet.show(fragmentManager,"Suprimer");
                 }
                break;
            case R.id.buttonValiderExploitant :
                DialogDelet dialogDelet = new DialogDelet();
                dialogDelet.setContext(contextActivity,contextSuprimer);
                dialogDelet.setEditText(editText);
                dialogDelet.setIdButton(R.id.buttonValiderExploitant);
                dialogDelet.show(fragmentManager,"Suprimer");
                break;

            case R.id.exploitant :
                intent = new Intent(contextActivity.getApplicationContext(),ViewSuprimerExploitant.class) ;
                contextActivity.startActivity(intent);
                 break;
            case R.id.exploitation :
                intent = new Intent(contextActivity.getApplicationContext(),ViewSuprimerExploitation.class) ;
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);

                break;
            case R.id.Retour  :
                intent = new Intent(contextActivity.getApplicationContext(),DirectionResponsable.class) ;
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);
                break;
            case R.id.produit :
                break;
        }

    }
}
