package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import com.example.dellpc.project_pfe.Controleur.ControleuStatBar;
import com.example.dellpc.project_pfe.Controleur.ControleurStatCercle;
import com.example.dellpc.project_pfe.Model.CaracteristiqueLieu;
import com.example.dellpc.project_pfe.R;


import org.json.JSONException;
import org.json.JSONObject;

import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class DAOJsonValeurLieu {
    Context context, ContextResponce;
    PieChartView pieChartView ;
    String codeGouvernorat ,codeDelegation , codeSecteur ;
    public int valeurButtonMenu =-1;
    int IdGraphique = R.id.chart1 ;
    ColumnChartView chartView ;
    TextView label ;

    public DAOJsonValeurLieu(Context context, Context contextResponce, String codeGouvernorat,
                             String codeDelegation, String codeSecteur, int valeurButtonMenu, int idGraphique, ColumnChartView chartView, TextView label) {
        this.context = context;
        ContextResponce = contextResponce;
        this.codeGouvernorat = codeGouvernorat;
        this.codeDelegation = codeDelegation;
        this.codeSecteur = codeSecteur;
        this.valeurButtonMenu = valeurButtonMenu;
        IdGraphique = idGraphique;
        this.chartView = chartView;
        this.label=label ;
    }

    public DAOJsonValeurLieu(Context context, Context contextResponce, PieChartView pieChartView, String codeGouvernorat,
                             String codeDelegation, String codeSecteur, int valeurButtonMenu) {
        this.context = context;
        ContextResponce = contextResponce;
        this.pieChartView = pieChartView;
        this.codeGouvernorat = codeGouvernorat;
        this.codeDelegation = codeDelegation;
        this.codeSecteur = codeSecteur;
        this.valeurButtonMenu = valeurButtonMenu;
    }
    public DAOJsonValeurLieu(Context context, Context contextResponce, PieChartView pieChartView, String codeDelegation , String codeGouvernorat, String codeSecteur) {
        this.context = context;
        ContextResponce = contextResponce;
        this.pieChartView = pieChartView;
        this.codeGouvernorat = codeGouvernorat;
        this.codeDelegation = codeDelegation;
        this.codeSecteur = codeSecteur;
    }


     CaracteristiqueLieu getLieu(JSONObject jsonResponse) throws JSONException {
        CaracteristiqueLieu caracteristiqueLieu = new CaracteristiqueLieu() ;
        caracteristiqueLieu.setSptotale(Double.parseDouble(jsonResponse.getString("sptotale")));
         caracteristiqueLieu.setSplabourable(Double.parseDouble(jsonResponse.getString("splabourable")));
        caracteristiqueLieu.setSpIrrigable(Double.parseDouble(jsonResponse.getString("SpIrrigable")));
        caracteristiqueLieu.setNombrePuits(Integer.parseInt(jsonResponse.getString("NombrePuits")));
        caracteristiqueLieu.setNombresSondage(Integer.parseInt(jsonResponse.getString("NombresSondage")));
        caracteristiqueLieu.setSpCultive(Double.parseDouble(jsonResponse.getString("spCultive")));
        caracteristiqueLieu.setNBTypeIrriguéPrive(Integer.parseInt(jsonResponse.getString("NBTypeIrriguePrive")));
        caracteristiqueLieu.setNBTypeIrriguéPublic(Integer.parseInt(jsonResponse.getString("NBTypeIrriguePublic")));
        caracteristiqueLieu.setNbExplSanitaire(Integer.parseInt(jsonResponse.getString("nbExplSanitaire")));
        caracteristiqueLieu.setNbExplEngrais(Integer.parseInt(jsonResponse.getString("nbExplEngrais")));
        caracteristiqueLieu.setNbArbre(Integer.parseInt(jsonResponse.getString("NbArbre")));
        caracteristiqueLieu.setNbArbreHile(Integer.parseInt(jsonResponse.getString("nbArbreHile")));
        caracteristiqueLieu.setNbArbresFruitiers(Integer.parseInt(jsonResponse.getString("nbArbresFruitiers")));
        caracteristiqueLieu.setArbresSanFruits(Integer.parseInt(jsonResponse.getString("ArbresSanFruits")));
        caracteristiqueLieu.setNBEquidés(Integer.parseInt(jsonResponse.getString("NBEquides")));
        caracteristiqueLieu.setNBAnimalTotale(Integer.parseInt(jsonResponse.getString("NBAnimalTotale")));
        caracteristiqueLieu.setNBbovins(Integer.parseInt(jsonResponse.getString("NBbovins")));
        caracteristiqueLieu.setNb_ovins(Integer.parseInt(jsonResponse.getString("Nb_ovins")));
        caracteristiqueLieu.setNb_caprins(Integer.parseInt(jsonResponse.getString("Nb_caprins")));
        caracteristiqueLieu.setNB_camélidés(Integer.parseInt(jsonResponse.getString("NB_camelides")));
        caracteristiqueLieu.setNB_escargots(Integer.parseInt(jsonResponse.getString("NB_escargots")));
        caracteristiqueLieu.setNB_avicultureModerne(Integer.parseInt(jsonResponse.getString("NB_avicultureModerne")));
        caracteristiqueLieu.setNB_avicultureTraditionnelle(Integer.parseInt(jsonResponse.getString("NB_avicultureTraditionnelle")));
        caracteristiqueLieu.setNB_cuniculture(Integer.parseInt(jsonResponse.getString("NB_cuniculture")));
        caracteristiqueLieu.setNB_apiculture(Integer.parseInt(jsonResponse.getString("NB_apiculture")));


         caracteristiqueLieu.setNb_vaches(Integer.parseInt(jsonResponse.getString("nb_vaches")));




        caracteristiqueLieu.setNbExploiteur(Integer.parseInt(jsonResponse.getString("nbExploiteur")));
        //caracteristiqueLieu.setNBExploiteurPlusExploitation(Integer.parseInt(jsonResponse.getString("NBExploiteurPlusExploitation")));

        //caracteristiqueLieu.setNBExploiteurPlus20(Integer.parseInt(jsonResponse.getString("NBExploiteurPlus20")));
        caracteristiqueLieu.setNBExploiteurPlus40(Integer.parseInt(jsonResponse.getString("NBExploiteurPlus40")));
        caracteristiqueLieu.setNBExploiteurNvAlpahbete(Integer.parseInt(jsonResponse.getString("NBExploiteurNvAlpahbete")));
        caracteristiqueLieu.setNBExploiteurNvBase(Integer.parseInt(jsonResponse.getString("NBExploiteurNvBase")));
        caracteristiqueLieu.setNBExploiteurNvLire_Ecrire(Integer.parseInt(jsonResponse.getString("NBExploiteurNvLire_Ecrire")));

        caracteristiqueLieu.setNBExploiteurNvPrimaire(Integer.parseInt(jsonResponse.getString("NBExploiteurNvPrimaire")));
        caracteristiqueLieu.setNBExploiteurNvSecond(Integer.parseInt(jsonResponse.getString("NBExploiteurNvSecond")));
        caracteristiqueLieu.setNBExpltUniversitaire(Integer.parseInt(jsonResponse.getString("NBExpltUniversitaire")));
        caracteristiqueLieu.setNBExploiteurAvecDiplom(Integer.parseInt(jsonResponse.getString("NBExploiteurAvecDiplom")));
        //caracteristiqueLieu.setNBExploiteurAvecPret(Integer.parseInt(jsonResponse.getString("NBExploiteurAvecPret")));
        caracteristiqueLieu.setNBExploiteurPricipalAutre(Integer.parseInt(jsonResponse.getString("NBExploiteurPricipalAutre")));
        caracteristiqueLieu.setNBExploiteurPricipalPeche(Integer.parseInt(jsonResponse.getString("NBExploiteurPricipalPeche")));
        caracteristiqueLieu.setNBExploiteurPricipalAgriculture(Integer.parseInt(jsonResponse.getString("NBExploiteurPricipalAgriculture")));
       /*  caracteristiqueLieu.setObstacle1(Integer.parseInt(jsonResponse.getString("obstacle1")));
        caracteristiqueLieu.setObstacle2(Integer.parseInt(jsonResponse.getString("obstacle2")));
        caracteristiqueLieu.setNbExProductAil(Integer.parseInt(jsonResponse.getString("nbExProductAil")));
        caracteristiqueLieu.setNb_Exploitant15_25(Integer.parseInt(jsonResponse.getString("NBExploiteur15-25")));
        caracteristiqueLieu.setNb_Exploitant25_35(Integer.parseInt(jsonResponse.getString("NBExploiteur25-35")));
        caracteristiqueLieu.setNb_Exploitant35_45(Integer.parseInt(jsonResponse.getString("NBExploiteur35-45")));
        caracteristiqueLieu.setNb_Exploitant45_55(Integer.parseInt(jsonResponse.getString("NBExploiteur45-55")));
        caracteristiqueLieu.setNb_Exploitant55_65(Integer.parseInt(jsonResponse.getString("NBExploiteur55-65")));
*/
        return  caracteristiqueLieu ;
    }


void SetGraphique ( CaracteristiqueLieu caracteristiqueLieu)
{


    if (IdGraphique == R.id.chart1)
    {
        int totale = caracteristiqueLieu.getNBbovins() + caracteristiqueLieu.getNB_escargots() + caracteristiqueLieu.getNB_avicultureModerne()
                + caracteristiqueLieu.getNB_avicultureTraditionnelle() + caracteristiqueLieu.getNB_cuniculture() + caracteristiqueLieu.getNB_apiculture();

        if (totale!=0)
        {
            ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
            controleurStatCercle.setPieChartView(caracteristiqueLieu);

        }
        else
            {
                pieChartView.setPieChartData(null);
            }
   }
    else
        {
        ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
        double tabValeur[] = {caracteristiqueLieu.getNB_escargots(),caracteristiqueLieu.getNB_avicultureModerne()+caracteristiqueLieu.getNB_avicultureTraditionnelle()
                ,caracteristiqueLieu.getNB_cuniculture(),caracteristiqueLieu.getNB_apiculture(),caracteristiqueLieu.getNBbovins()
                };
        String tabLabel[] = {"escargots","aviculture","cuniculture","apicultue","bavins"};
        controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }

    if (valeurButtonMenu==R.id.bovins)
    {
        int totale = caracteristiqueLieu.getNb_ovins() + caracteristiqueLieu.getNBEquidés() + caracteristiqueLieu.getNb_caprins()
                + caracteristiqueLieu.getNB_camélidés();
        Toast.makeText(context.getApplicationContext(),String.valueOf(totale),Toast.LENGTH_LONG).show();
        if (IdGraphique == R.id.chart1)
        {
            if (totale!=0)


        {
            ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
            controleurStatCercle.setPieChartViewBouvins(caracteristiqueLieu);

        }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }
        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNb_caprins(),caracteristiqueLieu.getNBEquidés(),caracteristiqueLieu
            .getNB_camélidés(),caracteristiqueLieu.getNb_ovins()};
            String tabLabel[] = {"caprins","Equidés","Camélidés","les ovins"};

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);


        }


    }
    if (valeurButtonMenu==R.id.Aviculture)
    {
        int totale = caracteristiqueLieu.getNB_avicultureModerne() + caracteristiqueLieu.getNB_avicultureTraditionnelle();
        if (IdGraphique == R.id.chart1)
        {
          if (totale!=0)
          {
              ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
              controleurStatCercle.setPieChartViewAviculture(caracteristiqueLieu);

          }
          else
          {
              pieChartView.setPieChartData(null);
          }
        }
        else
        {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNB_avicultureModerne(),caracteristiqueLieu.getNB_avicultureTraditionnelle()};
            String tabLabel[] = {"Moderne","Traditionnelle"};
            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);


        }


    }

    if (valeurButtonMenu==R.id.arbre)
    {
        if (IdGraphique == R.id.chart1)
        {
            if ( caracteristiqueLieu.getNbArbre()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewArbre(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }
        else
        {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNbArbresFruitiers(),caracteristiqueLieu.getNbArbreHile()
            ,caracteristiqueLieu.getArbresSanFruits()};
            String tabLabel[] = {"Des fruits","Autres","D'iolive" };

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }


    }

    if (valeurButtonMenu==R.id.SuperficieLabourable)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getSptotale()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewSpLabourable(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }
        else
        {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getSplabourable(),caracteristiqueLieu.getSptotale()-caracteristiqueLieu.getSplabourable()
                    ,caracteristiqueLieu.getArbresSanFruits()};
            String tabLabel[] = {"labourable","Terre de bor "};

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }



    }
    if (valeurButtonMenu==R.id.SuperficieIrriguée)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getSptotale()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewSpIrrigable(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }
        else
        {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getSpIrrigable(),caracteristiqueLieu.getSptotale()-caracteristiqueLieu.getSpIrrigable()
                    ,caracteristiqueLieu.getArbresSanFruits()};
            String tabLabel[] = {"Irrigué","ne pas  Irrigué"};

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }



    }
    if (valeurButtonMenu==R.id.typeIrriguée)
    {
        if (IdGraphique == R.id.chart1)
        {
            int totale = caracteristiqueLieu.getNBTypeIrriguéPrive()+caracteristiqueLieu.getNBTypeIrriguéPublic();
         if (totale!=0)
         {
             ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
             controleurStatCercle.setPieChartViewTypeIrg(caracteristiqueLieu);

         }
         else
         {
             pieChartView.setPieChartData(null);
         }
        }

        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNBTypeIrriguéPrive()
            ,caracteristiqueLieu.getNBTypeIrriguéPublic()};
            String tabLabel[] = {"Privé","Public" };

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }

    }

    if (valeurButtonMenu==R.id.NV)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getNbExploiteur()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewNvInst(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }

        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNBExploiteurNvSecond(),caracteristiqueLieu.getNBExpltUniversitaire(),caracteristiqueLieu.getNBExploiteurNvPrimaire()
                    ,caracteristiqueLieu.getNBExploiteurNvAlpahbete(),caracteristiqueLieu.getNBExploiteurNvBase(),caracteristiqueLieu.getNBExploiteurNvLire_Ecrire()
                    };
            String tabLabel[] = {"Secondaire","Universitair","Primaire","Analphabéte" ,
                    " De base ", "lire/ecrire" };

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }

    }
    if (valeurButtonMenu==R.id.F_dip)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getNbExploiteur()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewDiplome(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }
        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNBExploiteurAvecDiplom(),caracteristiqueLieu.getNbExploiteur()-caracteristiqueLieu.getNBExploiteurAvecDiplom()};
            String tabLabel[] = {"diplômé","Pas un diplômé"};

            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }
    }

    if (valeurButtonMenu==R.id.typeIrriguée)
    {

        if (IdGraphique == R.id.chart1)
        { int totale = caracteristiqueLieu.getNBTypeIrriguéPrive()+caracteristiqueLieu.getNBTypeIrriguéPublic();
            if (totale!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewTypeIrg(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }


    }
    if (valeurButtonMenu==R.id.ActPrincpl)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getNbExploiteur()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewActivitrPrincipale(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }


        }

        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = { caracteristiqueLieu.getNBExploiteurPricipalPeche(),caracteristiqueLieu.getNBExploiteurPricipalAgriculture(),caracteristiqueLieu.getNBExploiteurPricipalAutre()};
            String tabLabel[] = {"peche","Agriculture","Autre" };
            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }

        }


    if (valeurButtonMenu==R.id.age_ex)
    {
        if (IdGraphique == R.id.chart1)
        {
            if (caracteristiqueLieu.getNbExploiteur()!=0)
            {
                ControleurStatCercle controleurStatCercle = new ControleurStatCercle(pieChartView);
                controleurStatCercle.setPieChartViewAgeExploiteur(caracteristiqueLieu);

            }
            else
            {
                pieChartView.setPieChartData(null);
            }

        }

        else {
            ControleuStatBar controleuStatBar = new ControleuStatBar(chartView);
            double tabValeur[] = {caracteristiqueLieu.getNBExploiteurPlus40(),caracteristiqueLieu.getNbExploiteur()-caracteristiqueLieu.getNBExploiteurPlus40()};
            String tabLabel[] = {"Age>40","40>Age>18" };
            controleuStatBar.getGraphiqueBarAnimal( label,tabValeur,tabLabel);
        }
    }

}
    public void GetValeur() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                   CaracteristiqueLieu caracteristiqueLieu = getLieu(jsonResponse);
                    SetGraphique (caracteristiqueLieu) ;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };


        RequesteValeurLieu loginRequest = new RequesteValeurLieu("http://192.168.43.74/ProjectRecensementGenerale" +
                "/CaracteristiqueLieu.php",codeGouvernorat,codeDelegation,codeSecteur  ,
                responseListener);
        RequestQueue queue = Volley.newRequestQueue(ContextResponce);
        queue.add(loginRequest);


    }
}


