package com.example.dellpc.project_pfe.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.Json.DAOSuprimerJuson;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class DialogDelet extends AppCompatDialogFragment
{
    public DialogDelet() {
    }

    Context context ;
    Context contextDelet ;
    EditText editText ;
    int idButton  ;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        final ConnectionDetector connectionDetector = new ConnectionDetector(context) ;
        final DAOSQlite daosQlite = new DAOSQlite(context) ;
        builder.setView(view).setTitle("Voulez-vous enregistrer ?").setNegativeButton("annuler" , new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setView(view).setTitle("Voulez-vous enregistrer ?").setPositiveButton("ok" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if (connectionDetector.isConnected())

                {

                    DAOSuprimerJuson suprimerJuson = new DAOSuprimerJuson(contextDelet,contextDelet) ;
                   if (R.id.buttonValider ==idButton)
                    suprimerJuson.suprimerExploitation(editText);
                   else
                    suprimerJuson.suprimerExploitant(editText);

                }
                else
                {
                    boolean testDelet ;
                    if (R.id.buttonValider ==idButton)
                    testDelet=  daosQlite.suprimerExploitation(editText.getText().toString());
                    else testDelet = daosQlite.suprimerExploitant(editText.getText().toString()) ;

                    if (testDelet)
                    {
                        Toast.makeText(context.getApplicationContext(), "operation terminée Avec succès", Toast.LENGTH_LONG).show();
                        editText.setText(null);
                    }
                    else
                    {
                        editText.setError(" Vérifier "+editText.getHint().toString());
                    }
                }
            }
        });
        return builder.create();

    }
    public void setContext(Context context ,Context contextDelet)
    {
        this.context=context;
        this.contextDelet=contextDelet ;

    }

    public void setIdButton(int idButton) {
        this.idButton = idButton;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

}
