package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.graphics.Color;

import com.example.dellpc.project_pfe.Model.CaracteristiqueLieu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ControleurStatCercle {
    double x ;
    DecimalFormat df = new DecimalFormat("0.00");
    public PieChartView pieChartView;
    public Context context;

    public ControleurStatCercle(PieChartView pieChartView) {
        this.pieChartView = pieChartView;
        this.context = context;
    }

    public void setPieChartView(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNBbovins() + CaracteristiqueLieu.getNB_escargots() + CaracteristiqueLieu.getNB_avicultureModerne()
                + CaracteristiqueLieu.getNB_avicultureTraditionnelle() + CaracteristiqueLieu.getNB_cuniculture() + CaracteristiqueLieu.getNB_apiculture();


        pieData.add(new SliceValue(CaracteristiqueLieu.getNBbovins(), Color.BLUE).
                setLabel(

                        String.valueOf(Math.round((CaracteristiqueLieu.getNBbovins() / (Double.valueOf(totale)) * 100)*100.0)/100.0)   + "%: bovins")
        );

        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_escargots(), Color.GRAY).setLabel(
                String.valueOf((Math.round(CaracteristiqueLieu.getNB_escargots() / (Double.valueOf(totale)) * 100)*100.0)/100.0)   + "%: escargots")


        );
        x= (CaracteristiqueLieu.getNB_avicultureModerne() + CaracteristiqueLieu.getNB_avicultureTraditionnelle()) / Double.valueOf(totale) * 100 ;

        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_avicultureModerne() + CaracteristiqueLieu.getNB_avicultureTraditionnelle(), Color.RED).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)


                                + "%: aviculture")

        );
        x= (CaracteristiqueLieu.getNB_cuniculture() / Double.valueOf(totale))*100;

        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_cuniculture(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  +

                        "%: cuniculture"));

x= (CaracteristiqueLieu.getNB_apiculture() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_apiculture(), Color.GREEN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) +

                        "%: apiculture"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;

    public void setPieChartViewBouvins(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNb_ovins() + CaracteristiqueLieu.getNBEquidés() + CaracteristiqueLieu.getNb_caprins()
                + CaracteristiqueLieu.getNB_camélidés();

        x= (CaracteristiqueLieu.getNb_ovins() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBbovins(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%: les ovins")

        );
        x=  (CaracteristiqueLieu.getNb_caprins() / Double.valueOf(totale))*100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNb_caprins(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: caprins")


        );
        x=  (CaracteristiqueLieu.getNBEquidés() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBEquidés(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: Equidés"));
        x=  (CaracteristiqueLieu.getNB_camélidés() / Double.valueOf(totale))*100 ;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_camélidés(), Color.RED).
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

    public void setPieChartViewAviculture(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNB_avicultureModerne() + CaracteristiqueLieu.getNB_avicultureTraditionnelle();
        x= (CaracteristiqueLieu.getNB_avicultureModerne()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_avicultureModerne(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)  + "%:moderne")

        );
        x= (CaracteristiqueLieu.getNB_avicultureTraditionnelle()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNB_avicultureTraditionnelle(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:traditionnelle")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }



    public void setPieChartViewArbre(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();

        int totale = CaracteristiqueLieu.getNbArbre();
        x= (CaracteristiqueLieu.getNbArbreHile()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNbArbreHile(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%: D'olive")
        );
        x= (CaracteristiqueLieu.getNbArbresFruitiers()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNbArbresFruitiers(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%: Des fruits")


        );
        x= (CaracteristiqueLieu.getArbresSanFruits()/ Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getArbresSanFruits(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  + "%: Autres"));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;


    public void setPieChartViewSpLabourable(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        x= (CaracteristiqueLieu.getSplabourable() / CaracteristiqueLieu.getSptotale()) * 100;
        pieData.add(new SliceValue((float) CaracteristiqueLieu.getSplabourable(), Color.BLUE).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)   + "%:labourable")

        );
        x= ((CaracteristiqueLieu.getSptotale()-CaracteristiqueLieu.getSplabourable()) / CaracteristiqueLieu.getSptotale()) * 100;
        pieData.add(new SliceValue((float) (CaracteristiqueLieu.getSptotale()-CaracteristiqueLieu.getSplabourable()), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Terre de Bor")


        );
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    public void setPieChartViewSpIrrigable(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        x= (CaracteristiqueLieu.getSpIrrigable() / CaracteristiqueLieu.getSptotale()) * 100;
        pieData.add(new SliceValue((float) CaracteristiqueLieu.getSpIrrigable(), Color.BLUE).
                setLabel(
                        String.valueOf(Math.round(x*100.0)/100.0)   + "%:irrigable")

        );
        x= ((CaracteristiqueLieu.getSptotale()-CaracteristiqueLieu.getSpIrrigable()) / CaracteristiqueLieu.getSptotale()) * 100;
        pieData.add(new SliceValue((float) (CaracteristiqueLieu.getSptotale()-CaracteristiqueLieu.getSpIrrigable()), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:non irrigable")


        );
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewTypeIrg(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNBTypeIrriguéPrive()+CaracteristiqueLieu.getNBTypeIrriguéPublic();
        x= (CaracteristiqueLieu.getNBTypeIrriguéPrive() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBTypeIrriguéPrive(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0)   + "%:Privé")

        );
        x= (CaracteristiqueLieu.getNBTypeIrriguéPublic() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBTypeIrriguéPublic(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Public")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewNvInst(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNbExploiteur();
        x= (CaracteristiqueLieu.getNBExploiteurNvAlpahbete() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurNvAlpahbete(), Color.BLUE).
                setLabel(

                        String.valueOf(Math.round(x*100.0)/100.0)  + "%:Analphabéte")

        );
        x= (CaracteristiqueLieu.getNBExploiteurNvBase() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurNvBase(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:De base")


        );
        x= (CaracteristiqueLieu.getNBExploiteurNvLire_Ecrire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurNvLire_Ecrire(), Color.CYAN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)  + "%:Lire/écrire")


        );
        x= (CaracteristiqueLieu.getNBExploiteurNvSecond() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurNvSecond(), Color.DKGRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)    + "%:Secondaire")


        );
        x= (CaracteristiqueLieu.getNBExpltUniversitaire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExpltUniversitaire(), Color.GREEN).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0)   + "%:Universitaire")


        );
        x= (CaracteristiqueLieu.getNBExploiteurNvPrimaire() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurNvPrimaire(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:Prrimaire")


        );

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }
    public void setPieChartViewActivitrPrincipale(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();

        int totale = CaracteristiqueLieu.getNbExploiteur();
        x= (CaracteristiqueLieu.getNBExploiteurPricipalAgriculture() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurPricipalAgriculture(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:Agriculture")
        );

        x= (CaracteristiqueLieu.getNBExploiteurPricipalPeche() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurPricipalPeche(), Color.GREEN).
                setLabel(

                        String.valueOf(Math.round(x*100.0)/100.0) + "%:pêche")
        );

        x= (CaracteristiqueLieu.getNBExploiteurPricipalAutre() / Double.valueOf(totale)) * 100;

        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurPricipalAutre(), Color.MAGENTA).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%: Autres")
        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        //pieChartData.setHasCenterCircle(true).setCenterText1("Production  : "+String.valueOf(totale)).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);

    }

    ;

    public void setPieChartViewAgeExploiteur(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNbExploiteur();
        x= ((totale-CaracteristiqueLieu.getNBExploiteurPlus40()) / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue((totale-CaracteristiqueLieu.getNBExploiteurPlus40()), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:40>age>18")

        );
        x= (CaracteristiqueLieu.getNBExploiteurPlus40() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurPlus40(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:age>40")


        );


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }

    public void setPieChartViewDiplome(CaracteristiqueLieu CaracteristiqueLieu) {


        List<SliceValue> pieData = new ArrayList<>();
        int totale = CaracteristiqueLieu.getNbExploiteur();
        x= (CaracteristiqueLieu.getNBExploiteurAvecDiplom() / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(CaracteristiqueLieu.getNBExploiteurAvecDiplom(), Color.BLUE).
                setLabel(String.valueOf(Math.round(x*100.0)/100.0) + "%:diplômé")

        );
        x= ((totale-CaracteristiqueLieu.getNBExploiteurAvecDiplom()) / Double.valueOf(totale)) * 100;
        pieData.add(new SliceValue(totale-CaracteristiqueLieu.getNBExploiteurAvecDiplom(), Color.GRAY).setLabel(
                String.valueOf(Math.round(x*100.0)/100.0) + "%:Pas un diplômé")

        );

        

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);


        pieChartView.setPieChartData(pieChartData);

    }

}