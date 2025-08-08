package com.example.dellpc.project_pfe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Json.DAOJsonConsulter;
import com.example.dellpc.project_pfe.R;

public class ViewListeProduit extends AppCompatActivity {
ListView listView ;
TextView textView ;
Bundle bundle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produit);
        bundle =getIntent().getExtras();
        listView =(ListView) findViewById(R.id.liste) ;
        textView = (TextView) findViewById(R.id.t0);
        textView.setText(bundle.getString("code"));
        DAOJsonConsulter daoJsonConsulter = new DAOJsonConsulter(ViewListeProduit.this,ViewListeProduit.this) ;
        daoJsonConsulter.getAllProduit(getCodeExploitation(bundle.getString("code")),listView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusortie,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent ;
        if (id ==R.id.itmexit)

        {
        }


        return super.onOptionsItemSelected(item);
    }
    String getCodeExploitation(String itm )
    {
        String res = "";
        String intCh = " " ;
        for (int i = itm.length()-1 ; i>=0 ;i--  )
        {
                if (itm.charAt(i)==intCh.charAt(0))
                {
                    return res ;
                }
                else
                    {
                        res=itm.charAt(i)+res  ;
                    }
        }
        return  res ;
    }
}
