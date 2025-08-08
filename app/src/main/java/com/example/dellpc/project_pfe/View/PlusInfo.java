package com.example.dellpc.project_pfe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dellpc.project_pfe.R;

import java.util.ArrayList;

public class PlusInfo extends AppCompatActivity {
TextView t1 ,t2,t3,t4,t5 ,t6,t7,t8,t9,t10,t11,t12,t13;
ImageButton buttonsuiv ;
    Bundle bundle ;
    int codeDelegation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_info);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        t9 = (TextView) findViewById(R.id.t9);
        t10 = (TextView) findViewById(R.id.t10);
        t11 = (TextView) findViewById(R.id.t11);
        t12 = (TextView) findViewById(R.id.t12);
       int tabId [] = {R.id.t1,R.id.t2,R.id.t3,R.id.t4,R.id.t5,R.id.t6,R.id.t7,R.id.t8,R.id.t9,R.id.t10,R.id.t11,R.id.t12};

        t1.getImeActionId();
        bundle =getIntent().getExtras();
        ArrayList<String> list = bundle.getStringArrayList("list");
        for (int i = 0 ; i<list.size();i++)
        {
            t1 = (TextView)findViewById(tabId[i]) ;
            t1.setText(list.get(i));
        }

    }
}
