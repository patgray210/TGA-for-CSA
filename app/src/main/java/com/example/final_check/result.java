package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView result_tv;
    boolean running = true;
    int counter = 0;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result_tv = findViewById(R.id.result);
        result = getIntent().getExtras().getInt("result");
        if (result == 1)
            result_tv.setText("Player 1 Wins!!");
        if (result == 2)
            result_tv.setText("Player 2 Wins!!");
        runTimer();

    }

    private void runTimer() {
        final Button start_powerpose = (Button) findViewById(R.id.powerposebut);
        final Handler handler = new Handler();


        handler.post(new Runnable() {
            @Override
            public void run() {


                if (running) {
                    handler.postDelayed(this, 1000);
                    counter++;
                    if (counter == 3) {
                        running = false;
//                        finish();
                        Intent i = new Intent(result.this, fragment_holder.class);
                        startActivity(i);
                    }


                }
            }

        });

    }
}



