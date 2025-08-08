package com.example.dellpc.project_pfe.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Controleur.ConroleurMenu;
import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Json.DAOJsonValeurLieu;
import com.example.dellpc.project_pfe.Model.Gouvernorats;
import com.example.dellpc.project_pfe.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ViewStat {
    double x ;
    DecimalFormat df = new DecimalFormat("0.00");
    public PieChartView pieChartView;
    public Context context;

    public ViewStat(PieChartView pieChartView) {
        this.pieChartView = pieChartView;
        this.context = context;
    }

    public void setPieChartView(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNBbovins() + gouvernorats.getNB_escargots() + gouvernorats.getNB_avicultureModerne()
                + gouvernorats.getNB_avicultureTraditionnelle() + gouvernorats.getNB_cuniculture() + gouvernorats.getNB_apiculture();


        pieData.add(new SliceValue(gouvernorats.getNBbovins(), Color.BLUE).
                setLabel(

                        String.valueOf(Math.round((gouvernorats.getNBbovins() / (Double.valueOf(totale)) * 100)*100.0)/100.0)   + "%: bovins")
        );

        pieData.add(new SliceValue(gouvernorats.getNB_escargots(), Color.GRAY).setLabel(
                String.valueOf((Math.round(gouvernorats.getNB_escargots() / (Double.valueOf(totale)) * 100)*100.0)/100.0)   + "%: escargots")


        );
        x= (gouvernorats.getNB_avicultureModerne() + gouvernorats.getNB_avicultureTraditionnelle()) / Double.valueOf(totale) * 100 ;

        pieData.add(new SliceValue(gouvernorats.getNB_avicultureModerne() + gouvernorats.getNB_avicultureTraditionnelle(), Color.RED).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)


                                + "%: aviculture")

        );
        x= (gouvernorats.getNB_cuniculture() / Double.valueOf(totale))*100;

        pieData.add(new SliceValue(gouvernorats.getNB_cuniculture(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  +

                        "%: cuniculture"));

x= (gouvernorats.getNB_apiculture() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(gouvernorats.getNB_apiculture(), Color.GREEN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) +

                        "%: apiculture"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;

    public void setPieChartViewBouvins(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNb_ovins() + gouvernorats.getNBEquidés() + gouvernorats.getNb_caprins()
                + gouvernorats.getNB_camélidés();

        x= (gouvernorats.getNb_ovins() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(gouvernorats.getNBbovins(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%: les ovins")

        );
        x=  (gouvernorats.getNb_caprins() / Double.valueOf(totale))*100;
        pieData.add(new SliceValue(gouvernorats.getNb_caprins(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: caprins")


        );
        x=  (gouvernorats.getNBEquidés() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(gouvernorats.getNBEquidés(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: Equidés"));
        x=  (gouvernorats.getNB_camélidés() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(gouvernorats.getNB_camélidés(), Color.RED).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0) + "%: camélidés")

        );
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        // pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;

    public void setPieChartViewAviculture(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNB_avicultureModerne() + gouvernorats.getNB_avicultureTraditionnelle();
        x= (gouvernorats.getNB_avicultureModerne()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNB_avicultureModerne(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)  + "%:moderne")

        );
        x= (gouvernorats.getNB_avicultureTraditionnelle()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNB_avicultureTraditionnelle(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:traditionnelle")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }



    public void setPieChartViewArbre(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();

        int totale = gouvernorats.getNbArbre();
        x= (gouvernorats.getNbArbreHile()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNbArbreHile(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%: D'olive")
        );
        x= (gouvernorats.getNbArbresFruitiers()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNbArbresFruitiers(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: Des fruits")


        );
        x= (gouvernorats.getArbresSanFruits()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getArbresSanFruits(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  + "%: Autres"));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;


    public void setPieChartViewSpLabourable(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        x= (gouvernorats.getSplabourable() / gouvernorats.getSptotale()) * 100;
        pieData.add(new SliceValue((float) gouvernorats.getSplabourable(), Color.BLUE).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)   + "%:labourable")

        );
        x= ((gouvernorats.getSptotale()-gouvernorats.getSplabourable()) / gouvernorats.getSptotale()) * 100;
        pieData.add(new SliceValue((float) (gouvernorats.getSptotale()-gouvernorats.getSplabourable()), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Terre de Bor")


        );
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    public void setPieChartViewSpIrrigable(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        x= (gouvernorats.getSpIrrigable() / gouvernorats.getSptotale()) * 100;
        pieData.add(new SliceValue((float) gouvernorats.getSpIrrigable(), Color.BLUE).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)   + "%:irrigable")

        );
        x= ((gouvernorats.getSptotale()-gouvernorats.getSpIrrigable()) / gouvernorats.getSptotale()) * 100;
        pieData.add(new SliceValue((float) (gouvernorats.getSptotale()-gouvernorats.getSpIrrigable()), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:non irrigable")


        );
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewTypeIrg(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNBTypeIrriguéPrive()+gouvernorats.getNBTypeIrriguéPublic();
        x= (gouvernorats.getNBTypeIrriguéPrive() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBTypeIrriguéPrive(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%:Privé")

        );
        x= (gouvernorats.getNBTypeIrriguéPublic() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBTypeIrriguéPublic(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Public")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewNvInst(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNbExploiteur();
        x= (gouvernorats.getNBExploiteurNvAlpahbete() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurNvAlpahbete(), Color.BLUE).
                setLabel(

                        String.valueOf(Math.round(x*100.0)/100.0)  + "%:Analphabéte")

        );
        x= (gouvernorats.getNBExploiteurNvBase() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurNvBase(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:De base")


        );
        x= (gouvernorats.getNBExploiteurNvLire_Ecrire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurNvLire_Ecrire(), Color.CYAN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  + "%:Lire/écrire")


        );
        x= (gouvernorats.getNBExploiteurNvSecond() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurNvSecond(), Color.DKGRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)    + "%:Secondaire")


        );
        x= (gouvernorats.getNBExpltUniversitaire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExpltUniversitaire(), Color.GREEN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Universitaire")


        );
        x= (gouvernorats.getNBExploiteurNvPrimaire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurNvPrimaire(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:Prrimaire")


        );

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewActivitrPrincipale(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();

        int totale = gouvernorats.getNbExploiteur();
        x= (gouvernorats.getNBExploiteurPricipalAgriculture() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurPricipalAgriculture(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:Agriculture")
        );

        x= (gouvernorats.getNBExploiteurPricipalPeche() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurPricipalPeche(), Color.GREEN).
                setLabel(

                        String.valueOf(Math.round(x*100.0)/100.0) + "%:pêche")
        );

        x= (gouvernorats.getNBExploiteurPricipalAutre() / Double.valueOf(totale)) * 100;

        pieData.add(new SliceValue(gouvernorats.getNBExploiteurPricipalAutre(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%: Autres")
        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;

    public void setPieChartViewAgeExploiteur(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNbExploiteur();
        x= (gouvernorats.getNBExploiteurPlus20() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurPlus20(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:40>age>18")

        );
        x= (gouvernorats.getNBExploiteurPlus40() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurPlus40(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:age>40")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }

    public void setPieChartViewDiplome(Gouvernorats gouvernorats) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = gouvernorats.getNbExploiteur();
        x= (gouvernorats.getNBExploiteurAvecDiplom() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(gouvernorats.getNBExploiteurAvecDiplom(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:diplômé")

        );
        x= ((totale-gouvernorats.getNBExploiteurAvecDiplom()) / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(totale-gouvernorats.getNBExploiteurAvecDiplom(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:Pas un diplômé")

        );

        

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }

    public static class ViewStatCercle extends AppCompatActivity implements PieChartOnValueSelectListener {
        Button button_Gouvernorat_A_Liste_delegation,graphiqueBar,Total_gouvarnorat;
        PieChartView pieChartView ;
        com.example.dellpc.project_pfe.Json.DAOJsonValeurLieu DAOJsonValeurLieu;
        TextView textLabel ;
        Bundle bundle ;
        String codeDelegation ="0";
        ImageButton imageButtonREtourActivityRespons ;
        String codeSecteur = "0";
        long time ;
        ControleurDirectionResponsable controleurDirectionResponsable;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.statique_lieu);
            initView();
            setBundel() ;
            testDirection ();
            seView() ;

        }


        private void initView()
        {
            button_Gouvernorat_A_Liste_delegation=(Button)findViewById(R.id.gouvernorat_delegation);
            imageButtonREtourActivityRespons = (ImageButton)findViewById(R.id.imageButtonREtourActivityRespons) ;
            graphiqueBar = (Button)findViewById(R.id.graphiqueBar) ;
            textLabel = (TextView)findViewById(R.id.type);
            pieChartView = findViewById(R.id.chart1);

        }

        @Override
        public void onValueSelected(int arcIndex, SliceValue value) {
            List<SliceValue> pieData = pieChartView.getPieChartData().getValues();
            ArrayList<String> list = new ArrayList<>();
            if (pieData!=null)
            {
                for(int i=0 ; i<pieData.size();i++)
                {  if (pieData.get(i).getLabel()!=null  )
                    list.add
                    (
                  String.valueOf(pieData.get(i).getLabel())+" : Quantité :  "+ String.valueOf(pieData.get(i).getValue())
                    );
                }
                if (list.size()>0)
                {
                    bundle.putStringArrayList("list",list);
                    Intent intent = new Intent(getApplicationContext(),PlusInfo.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else
                {
               Toast.makeText(getApplicationContext(),"L'information est égale à 0",Toast.LENGTH_LONG).show();
                }

            }

        }

        private void setBundel()
        {
            bundle =getIntent().getExtras();

        }
        private void seView()
        {
            textLabel.setText(bundle.getString("labelProduit"));
            if (pieChartView!=null )
            {
                pieChartView.setClickable(true);
                pieChartView.setOnValueTouchListener(this);

            }


           DAOJsonValeurLieu = new DAOJsonValeurLieu(getApplicationContext(),
            ViewStatCercle.this,pieChartView,bundle.getString("direction"),codeDelegation,
            codeSecteur,bundle.getInt("valeurMenu"));
            DAOJsonValeurLieu.GetValeur();
            controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle);
            imageButtonREtourActivityRespons.setOnClickListener(controleurDirectionResponsable);
            graphiqueBar.setOnClickListener(controleurDirectionResponsable);

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_delegation,menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            ConroleurMenu conroleurMenu = new ConroleurMenu(this,ViewStatCercle.this) ;
            conroleurMenu.setMenuStaiqueCercle(id,textLabel,pieChartView,bundle,codeDelegation);
            return super.onOptionsItemSelected(item);
        }
        @Override
        public void onValueDeselected() {

        }
        private void testDirection ()
        {
            if (bundle.getString("direction").equals("1"))
            {
                codeDelegation = bundle.getString("codeDelegation") ;
                bundle.putString("codeSecteur",codeSecteur);
            }
            else if (bundle.getString("direction").equals("2"))
            {

                bundle.putString("codeDelegation",codeDelegation);
                codeSecteur=bundle.getString("codeSecteur");


            }
            else
            {
                bundle.putString("codeDelegation","0");
                bundle.putString("codeSecteur",codeSecteur);
            }

        }

        @Override
        public void onBackPressed() {
            if (time+20000>System.currentTimeMillis())
            {
                super.onBackPressed();
                return;
            }
            else
            {
                Intent intent = new Intent(getApplicationContext(),DirectionResponsable.class);
                intent.putExtras(bundle) ;
                startActivity(intent);
            }
            time = System.currentTimeMillis();
        }
    }
}