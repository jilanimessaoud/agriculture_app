package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.DirectionResponsable;

public class ControleurListeQuestionnaire implements View.OnClickListener {
    Bundle bundle ;
    Context context ;
    Intent intent ;

    public ControleurListeQuestionnaire(Bundle bundle, Context context) {
        this.bundle = bundle;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageButtonretourlisteAjout :
                intent = new Intent(context.getApplicationContext(),DirectionResponsable.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;
        }
    }
}
