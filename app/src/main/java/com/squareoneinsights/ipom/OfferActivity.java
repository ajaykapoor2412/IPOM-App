package com.squareoneinsights.ipom;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class OfferActivity extends Activity {

    public static TextView offerTextView;
    public static EditText txtIPAddress;
    public static EditText txtUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer_layout);

        offerTextView = findViewById(R.id.txtViewOffer);
        offerTextView.setText("Click on options!");

        Button buttonAccept = findViewById(R.id.btnAccept);
        Button buttonReject = findViewById(R.id.btnReject);

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences offerPref = getApplicationContext().getSharedPreferences("Offer", 0);

                String offerDetail = offerPref.getString("offerDetail", "");
                String activityId = offerPref.getString("activityId", "");

                SharedPreferences appPref = getApplicationContext().getSharedPreferences("Application", 0);

                String userId = appPref.getString("UserId", "");


                ResponseAPI responseAPI = new ResponseAPI();
                String offerData = null;
                try {
                    offerData = responseAPI.execute(activityId, userId, offerDetail, "Yes").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goToHome();
            }
        });

        buttonReject.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences offerPref = getApplicationContext().getSharedPreferences("Offer", 0);

                String offerDetail = offerPref.getString("offerDetail", "");
                String activityId = offerPref.getString("activityId", "");

                SharedPreferences appPref = getApplicationContext().getSharedPreferences("Application", 0);

                String userId = appPref.getString("UserId", "");


                ResponseAPI responseAPI = new ResponseAPI();
                String offerData = null;
                try {
                    offerData = responseAPI.execute(activityId, userId, offerDetail, "No").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goToHome();
            }
        });
    }

    private void goToHome() {

        Intent mainIntent = new Intent(this, MenuActivity.class);
        startActivity(mainIntent);
    }
}
