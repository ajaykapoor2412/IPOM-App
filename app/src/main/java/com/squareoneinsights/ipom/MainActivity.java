package com.squareoneinsights.ipom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView textViewOffer;
    public static EditText txtIPAddress;
    public static EditText txtUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOffer = findViewById(R.id.txtViewOffer);
        txtIPAddress = findViewById(R.id.txtIPAddress);
        txtUserId = findViewById(R.id.txtUserId);

        Button buttonMovie = findViewById(R.id.btnMovie);
        Button buttonFlight = findViewById(R.id.btnFlight);
        Button buttonLoan = findViewById(R.id.btnLoan);
        buttonMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                offerAPI.execute(txtIPAddress.getText().toString(), txtUserId.getText().toString(), "Movie");
            }
        });

        buttonFlight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                offerAPI.execute(txtIPAddress.getText().toString(), txtUserId.getText().toString(), "Flight");
            }
        });

        buttonLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OfferAPI offerAPI = new OfferAPI();
                offerAPI.execute(txtIPAddress.getText().toString(), txtUserId.getText().toString(), "Loan");
            }
        });
    }
}
