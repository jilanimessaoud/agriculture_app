package com.example.dellpc.project_pfe.Controleur;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.ViewLogin;

public class SplashActivity extends AppCompatActivity {

    static int TIMEOUT_MILLIS = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, ViewLogin.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, TIMEOUT_MILLIS);
    }
}