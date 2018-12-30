package com.squareoneinsights.ipom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static int count = 0;

    public static NotificationCompat.Builder notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();


        Button buttonUser1 = findViewById(R.id.btnUser01);
        Button buttonUser2 = findViewById(R.id.btnUser02);
        Button buttonUser3 = findViewById(R.id.btnUser03);
        Button buttonUser4 = findViewById(R.id.btnUser04);
        Button buttonUser5 = findViewById(R.id.btnUser05);
        Button buttonUser6 = findViewById(R.id.btnUser06);
        Button buttonUser7 = findViewById(R.id.btnUser07);
        Button buttonUser8 = findViewById(R.id.btnUser08);
        Button buttonUser9 = findViewById(R.id.btnUser09);
        Button buttonUser10 = findViewById(R.id.btnUser10);


        buttonUser1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C1");
                editor.commit();
                goToActivity();
            }
        });

        buttonUser2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C7");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C8");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C11");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C22");
                editor.commit();
                goToActivity();
            }
        });

        buttonUser6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C24");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C26");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C29");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C30");
                editor.commit();
                goToActivity();
            }
        });
        buttonUser10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences sharedpreferences = getSharedPreferences("Application", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserId", "C15");
                editor.commit();
                goToActivity();
            }
        });

    }

    private void goToActivity() {
        Intent mainIntent = new Intent(this, MenuActivity.class);
        startActivity(mainIntent);
    }


}
