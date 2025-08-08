package com.example.dellpc.project_pfe.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.dellpc.project_pfe.Controleur.ControlorLogin;
import com.example.dellpc.project_pfe.Json.DAOValeurDataRG;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class ViewLogin extends AppCompatActivity {

    Button button  ;
    EditText editPass , editUser ;
   long time ;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editUser = (EditText)findViewById(R.id.editLogin) ;
        editPass = (EditText)findViewById(R.id.editPass) ;
        button = (Button)findViewById(R.id.buttonLogin);


    final DAOSQlite DAOSQlite = new DAOSQlite(this) ;
    final DAOValeurDataRG valeurDataRG = new DAOValeurDataRG( this,ViewLogin.this) ;

        button.setOnClickListener(new ControlorLogin(this,ViewLogin.this,
                editPass,
                editUser, DAOSQlite));

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
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        time = System.currentTimeMillis();
    }
}
