package com.squareoneinsights.ipom;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MenuActivity extends Activity {

    public static int count = 0;
    public static final String IPAddress = "192.168.0.100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonMovie = findViewById(R.id.btnMovies);
        Button buttonFlight = findViewById(R.id.btnFlight);
        Button buttonShopping = findViewById(R.id.btnShopping);
        Button buttonLoan = findViewById(R.id.btnLoan);
        SharedPreferences appPref = getApplicationContext().getSharedPreferences("Application", 0);

        final String userId = appPref.getString("UserId", "");

        buttonFlight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                String offerData = null;
                try {
                    offerData = offerAPI.execute(userId, "Flight").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pushNotification(v, offerData);
            }
        });
        buttonMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                String offerData = null;
                try {
                    offerData = offerAPI.execute(userId, "Movie").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pushNotification(v, offerData);
            }
        });

        buttonShopping.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                String offerData = null;
                try {
                    offerData = offerAPI.execute(userId, "Shopping").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pushNotification(v, offerData);
            }
        });

        buttonLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                String offerData = null;
                try {
                    offerData = offerAPI.execute(userId, "Loan").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pushNotification(v, offerData);
            }
        });
    }


    public void pushNotification(View view, String offerData) {
        String offerDetails = "";
        String activityId = "";
        String offerCode = "";
        try {
            JSONObject jsonObject = new JSONObject(offerData);
            offerDetails = jsonObject.get("offerDetail").toString();
            activityId = jsonObject.get("activityId").toString();
            offerCode = jsonObject.get("offerCode").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (!offerCode.equals("")) {
            SharedPreferences sharedpreferences = getSharedPreferences("Offer", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("offerDetail", offerDetails);
            editor.putString("activityId", activityId);
            editor.putString("offerCode", offerCode);
            editor.commit();

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Intent targetIntent = new Intent(getApplicationContext(), OfferActivity.class);
            targetIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            Random randomNumber = new Random();
            count = randomNumber.nextInt();
            final PendingIntent resultPendingIntent =
                    PendingIntent.getActivity(
                            getApplicationContext(),
                            count,
                            targetIntent,
                            PendingIntent.FLAG_ONE_SHOT
                    );
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable
                            .ic_notification_icon))
                    .setSmallIcon(R.drawable.ic_notification_icon)
                    .setContentTitle("You got an offer!")
                    .setContentText(offerDetails)
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri);
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(count, notificationBuilder.build());
        }
    }
}
