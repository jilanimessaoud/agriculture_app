package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Controleur.ConroleurMenu;
import com.example.dellpc.project_pfe.Controleur.ControleurDirectionResponsable;
import com.example.dellpc.project_pfe.Json.DAOJsonValeurLieu;
import com.example.dellpc.project_pfe.R;

import lecho.lib.hellocharts.view.ColumnChartView;

public class ViewSatBar extends AppCompatActivity {
 private long time ;
    ControleurDirectionResponsable controleurDirectionResponsable ;
    private ColumnChartView chart;
    Bundle bundle;

    TextView label ,titre;
    DAOJsonValeurLieu DAOJsonValeurLieu;
    Button buttonCercle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphique_bar);

        initView();
        setBundel() ;
        seView() ;
        }

    private void seView()
    {
        bundle =getIntent().getExtras();
        String title = getIntent().getStringExtra("title");
        titre.setText(bundle.getString("labelProduit"));
        DAOJsonValeurLieu = new DAOJsonValeurLieu(getApplicationContext(),
                ViewSatBar.this, bundle.getString("direction"), bundle.getString("codeDelegation"),
                bundle.getString("codeSecteur"), bundle.getInt("valeurMenu"), R.id.graphiqueBar, chart,label);
        DAOJsonValeurLieu.GetValeur();
        controleurDirectionResponsable = new ControleurDirectionResponsable(this,bundle);

        buttonCercle.setOnClickListener(controleurDirectionResponsable);

    }

    private void setBundel() {
    }

    private void initView() {
        chart = (ColumnChartView) findViewById(R.id.graphiqueBar);
        label = (TextView)findViewById(R.id.label) ;
        titre = (TextView)findViewById(R.id.titre) ;

        buttonCercle = (Button)findViewById(R.id.ParCercle) ;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delegation,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent ;
        if (id ==R.id.Retour)

        {
            intent = new Intent(getApplicationContext(),PlusInfo.class);
            Bundle bundle = new Bundle() ;
            bundle.putInt("Plusinfo",0);
            intent.putExtras(bundle);
            startActivity(intent);
        }
           else
        {

            ConroleurMenu conroleurMenu = new ConroleurMenu(this,ViewSatBar.this) ;
            conroleurMenu.setMenuStaiqueBar(id,label,chart,bundle,bundle.getString("codeDelegation"),titre);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (time+2000>System.currentTimeMillis())
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
