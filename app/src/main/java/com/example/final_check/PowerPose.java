package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PowerPose extends AppCompatActivity {
    /*Button timer = (Button) findViewById(R.id.start_timer);*/
    boolean running = false;
    int counter= 0;
    String playertag;
    TextView playertag_tv;
    Random random = new Random();
    Button back_button;
    private ImageView rView;
    FrameLayout powerposelay;
    private Integer [] images = {
        R.drawable.yoga1, R.drawable.yoga2,
            R.drawable.yoga3,  R.drawable.yoga4,
            R.drawable.yoga5,  R.drawable.yoga6,
            R.drawable.yoga7,  R.drawable.yoga8,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_pose);
        int rand = random.nextInt(8);
        rView = (ImageView)findViewById(R.id.rView);
        rView.setImageResource(images[rand]);
//        playertag_tv = findViewById(R.id.player_tag_pp);
//        playertag = getIntent().getExtras().getString("string_player");
//        playertag_tv.setText(playertag);
        back_button = (Button)findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running =false;
                PowerPose.super.onBackPressed();
            }
        });
//        Button start_powerpose = findViewById(R.id.powerposebut);
        runTimer();
    }

    private void runTimer() {
        final Button start_powerpose = (Button)findViewById(R.id.powerposebut);
        final Handler handler = new Handler();



        handler.post( new Runnable() {
            @Override
            public void run() {
                start_powerpose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        running = true;
                        Log.d("hi","check");
                        runTimer();
                    }
                });


                if(running) {
                    handler.postDelayed(this, 1000);
                    counter++;
                    start_powerpose.setText(String.valueOf(counter));
                    if(counter == 30){
                        running =false;
//                        finish();
                        PowerPose.super.onBackPressed();
                    }




                }
            }

        });


}


}
