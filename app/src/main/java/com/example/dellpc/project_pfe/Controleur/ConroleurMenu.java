package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.example.dellpc.project_pfe.Json.DAOJsonValeurLieu;
import com.example.dellpc.project_pfe.R;

import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class ConroleurMenu
{
    Context context ;
    Context ContextResponce ;

    public ConroleurMenu(Context context, Context contextResponce) {
        this.context = context;
        ContextResponce = contextResponce;
    }

   public void setMenuStaiqueCercle (int id , TextView textLabel , PieChartView  pieChartView , Bundle bundle , String codeDelegation )
    {
        Intent intent ;
        DAOJsonValeurLieu DAOJsonValeurLieu;
        switch (id)
        {
            case R.id.bovins :
                bundle.putInt("valeurMenu",R.id.bovins);
                textLabel.setText("Par type de bétail");
                bundle.putString("labelProduit","Par type de bétail");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(), ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.bovins);
                DAOJsonValeurLieu.GetValeur();
                break;
            case R.id.Aviculture :
                bundle.putInt("valeurMenu",R.id.Aviculture);
                textLabel.setText("Par type de volaille");
                bundle.putString("labelProduit","Par type de volaille");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.Aviculture);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.tout :
                bundle.putInt("valeurMenu",R.id.tout)  ;
                textLabel.setText("Selon les espèces animales");
                bundle.putString("labelProduit","Selon les espèces animales");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.tout);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.arbre :
                bundle.putInt("valeurMenu",R.id.arbre);
                textLabel.setText("En fonction du type d'arbres plantés");
                bundle.putString("labelProduit","En fonction du type d'arbres plantés");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.arbre);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.SuperficieLabourable :
                bundle.putInt("valeurMenu",R.id.SuperficieLabourable);
                textLabel.setText("En fonction du superficie labourable");
                bundle.putString("labelProduit","En fonction du superficie labourable");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.SuperficieLabourable);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.SuperficieIrriguée :
                bundle.putInt("valeurMenu",R.id.SuperficieIrriguée);
                textLabel.setText("En fonction du superficie irriguée");
                bundle.putString("labelProduit","En fonction du superficie irriguée");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.SuperficieIrriguée);
                DAOJsonValeurLieu.GetValeur();

                break;
            case R.id.NV  :
                bundle.putInt("valeurMenu",R.id.NV);
                textLabel.setText("En fonction du niveau d'instruction");
                bundle.putString("labelProduit","En fonction du niveau d'instruction");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.NV);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.typeIrriguée :
                bundle.putInt("valeurMenu",R.id.typeIrriguée);
                textLabel.setText("En fonction de type du périmètre irrigué");
                bundle.putString("labelProduit","En fonction de type du périmètre irrigué");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView, bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.typeIrriguée);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.F_dip :
                bundle.putInt("valeurMenu",R.id.F_dip);
                textLabel.setText("En fonction de la composition des agriculteurs");
                bundle.putString("labelProduit","En fonction de la composition des agriculteurs");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.F_dip);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.ActPrincpl :
                bundle.putInt("valeurMenu",R.id.ActPrincpl);
                textLabel.setText("En fonction de l'activité des agriculteurs");
                bundle.putString("labelProduit","En fonction de l'activité des agriculteurs");

                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.ActPrincpl);
                DAOJsonValeurLieu.GetValeur();

                break;

            case R.id.age_ex :
                bundle.putInt("valeurMenu",R.id.age_ex);
                textLabel.setText("En fonction de l'âge des agriculteurs");
                bundle.putString("labelProduit","En fonction de l'âge des agriculteurs");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),ContextResponce,pieChartView,bundle.getString("direction"),codeDelegation,bundle.getString("codeSecteur"),R.id.age_ex);
                DAOJsonValeurLieu.GetValeur();

                break;
        }
    }
    public void setMenuStaiqueBar (int id , TextView textLabel , ColumnChartView chart , Bundle bundle , String codeDelegation ,TextView titre)
    { DAOJsonValeurLieu DAOJsonValeurLieu;
        switch (id)
        {

            case R.id.bovins :
                bundle.putString("labelProduit","Par type de bétail");
                bundle.putInt("valeurMenu",R.id.bovins);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                bundle.getString("codeSecteur"), R.id.bovins, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;
            case R.id.Aviculture :
                bundle.putString("labelProduit","Par type de volaille");
                bundle.putInt("valeurMenu",R.id.Aviculture);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.Aviculture , R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.tout :
                bundle.putString("labelProduit","Selon les espèces animales");
                bundle.putInt("valeurMenu",R.id.tout);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.tout, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.arbre :
                bundle.putString("labelProduit","En fonction du type d'arbres plantés");
                bundle.putInt("valeurMenu",R.id.arbre);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.arbre, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.SuperficieLabourable :
                bundle.putString("labelProduit","En fonction du superficie labourable");
                bundle.putInt("valeurMenu",R.id.SuperficieLabourable);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.SuperficieLabourable, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.SuperficieIrriguée :
                bundle.putString("labelProduit","En fonction du superficie irriguée");
                bundle.putInt("valeurMenu",R.id.SuperficieIrriguée);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.SuperficieIrriguée, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;
            case R.id.NV :

                bundle.putInt("valeurMenu",R.id.NV);
                bundle.putString("labelProduit","En fonction du niveau d'instruction");
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),

                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.NV , R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.typeIrriguée :
                bundle.putString("labelProduit","En fonction de type du périmètre irrigué");
                bundle.putInt("valeurMenu",R.id.typeIrriguée);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.typeIrriguée, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.F_dip:
                bundle.putString("labelProduit","En fonction de la composition des agriculteurs");
                bundle.putInt("valeurMenu",R.id.F_dip);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.F_dip , R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.ActPrincpl  :
                bundle.putString("labelProduit","En fonction de l'activité des agriculteurs");
                bundle.putInt("valeurMenu",R.id.ActPrincpl);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.ActPrincpl, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;

            case R.id.age_ex :
                bundle.putString("labelProduit","En fonction de l'âge des agriculteurs");
                bundle.putInt("valeurMenu",R.id.age_ex);
                DAOJsonValeurLieu = new DAOJsonValeurLieu(context.getApplicationContext(),
                        ContextResponce, bundle.getString("direction"), bundle.getString("codeDelegation"),
                        bundle.getString("codeSecteur"), R.id.age_ex, R.id.graphiqueBar, chart,textLabel);
                DAOJsonValeurLieu.GetValeur();
                titre.setText(bundle.getString("labelProduit"));
                break;
        }

    }

}
