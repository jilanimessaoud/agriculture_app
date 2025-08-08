package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.dellpc.project_pfe.Json.DAOValeurDataRG;
import com.example.dellpc.project_pfe.Json.DAOUserJson;
import com.example.dellpc.project_pfe.Model.Utilisateur;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.DirectionResponsable;
import com.example.dellpc.project_pfe.View.ViewListeDelegation;
import com.example.dellpc.project_pfe.View.ViewLogin;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class ControlorLogin  extends ViewLogin implements View.OnClickListener

{
    Context context ,context1;
    boolean testLogin = true ;
    EditText pass ,user ;
    DAOSQlite DAOSQlite;
    ConnectionDetector  connectionDetector ;
    Bundle bundle ;
    public ControlorLogin(Context context , Context context1 , EditText pass, EditText user,DAOSQlite DAOSQlite)
    {
        super();
        this.context=context;
        this.context1=context1 ;
        this.pass = pass ;
        this.user=user ;
         this.DAOSQlite = DAOSQlite;
    }

    public ControlorLogin(Context context , Context context1 ,DAOSQlite DAOSQlite)
    {
        super();
        this.context=context;
        this.context1=context1 ;
         this.DAOSQlite = DAOSQlite;
    }

    boolean testText()
    {
        if (user.getText().toString().length()!=0 && pass.getText().toString().length()!=0)
        {return true ;}
        else
        {
            if (user.getText().toString().length()==0) user.setError("Vérifer");
            if (pass.getText().toString().length()==0) pass.setError("Vérifer");
            return false ;
        }
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
    public void onClick(View v) {
        Intent intent;
        connectionDetector = new ConnectionDetector(context) ;
        DAOSQlite =new DAOSQlite(context) ;
        switch (v.getId()) {
            case R.id.gouvernorat_delegation:
                intent = new Intent(context.getApplicationContext(), ViewListeDelegation.class);
                context.startActivity(intent);
                break;
            case R.id.buttonLogin:
                            if (testText())

                            {
                                if (connectionDetector.isConnected())
                                {
                                    DAOValeurDataRG valeurDataRG = new DAOValeurDataRG(context,context1) ;
                                    valeurDataRG.SetDataBase(DAOSQlite);
                                    DAOUserJson DAOUserJson = new DAOUserJson(context.getApplicationContext(), context1, context,
                                            pass, user
                                    );
                                    DAOUserJson.login();

                                }
                                else
                                {

                                    Utilisateur utilisateur =  DAOSQlite.getUtilisateur(user.getText().toString(),pass.getText().toString()) ;
                                    if (utilisateur !=null)
                                    {
                                        bundle = new Bundle() ;
                                        bundle.putString("nomAdmin",utilisateur.getNom()+" " + utilisateur.getPrenom());
                                        intent = new Intent(context.getApplicationContext(),DirectionResponsable.class);
                                        intent.putExtras(bundle);
                                        context.startActivity(intent);

                                    }
                                    else
                                    Toast.makeText(context.getApplicationContext(),"Utilisateur ou mot de passe incorrecte",Toast.LENGTH_LONG).show();
                             }
                        }
                break;


        }

    }
}
