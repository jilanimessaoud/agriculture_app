package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.ViewListeDelegation;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class ControlorDialog extends ViewLogin implements View.OnClickListener

{
    Context context ;
    boolean testLogin = true ;


    public ControlorDialog(Context context )
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
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.gouvernorat_delegation:
                intent = new Intent(context.getApplicationContext(), ViewListeDelegation.class);
                context.startActivity(intent);
                break;



        }
    }

}

