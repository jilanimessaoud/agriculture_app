package com.example.dellpc.project_pfe.Controleur;

import android.graphics.Color;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.ColumnChartView;

public class ControleuStatBar {
    private ColumnChartView chart;
    private ColumnChartData data;
    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLabels = false;
    private boolean hasLabelForSelected = true;
    List<AxisValue> axisValues2 = new ArrayList<AxisValue>();
    List<Column> columns2 = new ArrayList<Column>();
    List<SubcolumnValue> values2;


    public ControleuStatBar(ColumnChartView chart) {
        this.chart = chart;
    }

    public  void getGraphiqueBarAnimal(TextView label,double tabValeur[],String tabLabel[])
    {
        generateDefaultData(label,tabValeur,tabLabel) ;
    }
    private void generateDefaultData( TextView label,double tabValeur[],String tabLabel[]) {

        String Alpha []= {"A"," B "," C "," D "," E "," F "," G "," H "," I "};
        String textLabel ="" ;
        //int somm = 0 ;
            for (int i=0;i<tabLabel.length;i++)
            {
                values2 = new ArrayList<SubcolumnValue>();
                values2.add(new SubcolumnValue(new SubcolumnValue((float) tabValeur[i], Color.BLUE)));
                //values2.add(new SubcolumnValue(7f, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));
               AxisValue axisValue =new AxisValue(i) ;
               axisValue.setLabel(Alpha[i]);
               axisValues2.add(axisValue);
               Column column = new Column(values2).setHasLabelsOnlyForSelected(true) ;
               columns2.add(column);
                textLabel = textLabel+" ( "+Alpha[i]+" : "+tabLabel[i]+ "  ) ";
               // somm = somm+tabValeur[i];
            }
        label.setText(textLabel);
        ColumnChartData  columnData = new ColumnChartData(columns2);
        columnData.setStacked(true);
        columnData.setFillRatio(0.50F);
        Axis axisX = new Axis(axisValues2).setHasLines(true) ;
        Axis axisY = new Axis().setHasLines(true).setTextColor(Color.BLACK);
        axisX.setTextColor(Color.BLACK);
        axisY.setTextColor(Color.BLACK);
        axisY.setName("Nombre");
        axisY.setMaxLabelChars(6);
        columnData.setAxisXBottom(axisX);

        columnData.setAxisYLeft(axisY);
        chart.setColumnChartData(columnData);

        Viewport v = new Viewport(-1, (float) (MaxValeur(tabValeur)+MaxValeur(tabValeur)/2+4), tabValeur.length, 0);

        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);



    }
double MaxValeur (double tab[])
        {
            double max=tab[0]  ;
            for (int i = 1;i<tab.length;i++)
            {
                if (tab[i]>max) max = tab[i] ;
            }
            return  max ;
        }
    }
