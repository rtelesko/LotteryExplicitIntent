package com.example.lotteryexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    // GUI controls
    private TextView tvNamePlayer;
    private TextView tvCostsTips;
    private Button btReturnToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get reference to the TextViews
        tvNamePlayer = (TextView) findViewById(R.id.tvNamePlayer);
        tvCostsTips = (TextView) findViewById(R.id.tvCostsTips);

        Intent intent = getIntent();

        // Get data
        String namePlayer = intent.getStringExtra("NAME");
        String numberTips = intent.getStringExtra("NUMBER_TIPS");

        // Calculation of tip costs
        int tips = Integer.parseInt(numberTips);
        double costTips = 2.5 * tips;

        // Set Data in TextViews
        tvNamePlayer.setText("Player name: " + namePlayer);
        tvCostsTips.setText("Costs in CHF: " + costTips);

        // Button for returning back to Main Activity
        btReturnToMain = findViewById(R.id.btReturnToMain);
        btReturnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                // Alternative
                // onBackPressed();
            }
        });

    }
}
