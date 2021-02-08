package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BreathingActivity extends AppCompatActivity {

    public static boolean running = true;

    public int counter =0;
    public int counter2 =0;
    public int display_counter =0;
    String playertag;
    TextView playertag_tv;
    Button done_mindfulness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
//        playertag_tv = findViewById(R.id.player_tag);
//        playertag = getIntent().getExtras().getString("string_player");
//        playertag_tv.setText(playertag);
        done_mindfulness = findViewById(R.id.done_mindfulness);
        done_mindfulness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreathingActivity.super.onBackPressed();
            }
        });
        runTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter = -1;
        counter2 = -1;
        display_counter= 0;

    }

    private void runTimer() {
        final TextView time = (TextView) findViewById(R.id.time_seconds);
        final TextView time2 = (TextView) findViewById(R.id.time_name);
        final TextView breathin = (TextView) findViewById(R.id.breath_in);
        final TextView hold1 = (TextView) findViewById(R.id.hold2);
        final TextView hold2 = (TextView) findViewById(R.id.hold1);
        final TextView breathout = (TextView) findViewById(R.id.breath_out);

        final Handler handler = new Handler();

        handler.post( new Runnable() {
            @Override
            public void run() {

                if(running) {

                    handler.postDelayed(this, 1000);

                    counter+=1;
                    counter2+=1;
                    counter =  counter%4;
                    display_counter = 4 -counter;
                    counter2 = counter2%16;
                    time.setText(String.valueOf(display_counter));
//                    time2.setText(String.valueOf(counter2));
                    if(counter2>= 12){
                        hold2.setTextColor(Color.WHITE);

                        breathout.setTextColor(Color.BLACK);
                        breathin.setTextColor(Color.BLACK);
                        hold1.setTextColor(Color.BLACK);
                    }
                    else if(counter2 >=8){
                        breathout.setTextColor(Color.WHITE);

                        hold2.setTextColor(Color.BLACK);
                        breathin.setTextColor(Color.BLACK);
                        hold1.setTextColor(Color.BLACK);
                    }
                    else if(counter2 >= 4){

                        hold1.setTextColor(Color.WHITE);

                        hold2.setTextColor(Color.BLACK);
                        breathin.setTextColor(Color.BLACK);
                        breathout.setTextColor(Color.BLACK);
                    }
                    else if(counter2 >= 0){

                        breathin.setTextColor(Color.WHITE);

                        hold2.setTextColor(Color.BLACK);
                        breathout.setTextColor(Color.BLACK);
                        hold1.setTextColor(Color.BLACK);
                    }

                }

            }
        });
    }
}
