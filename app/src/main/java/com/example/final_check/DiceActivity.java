package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DiceActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button player1;
    private Button player2;
    private ImageView imageView1, rec1, rec2, rec3 , rec4,rec5,rec6,rec7,rec8,rec9,rec10,rec11,rec12,rec13,rec14,rec15,rec16;
    private static  int location = 1, location2 = 1;
    int value1, value2, counter1=1, counter2=1, choicee;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

//        int str1 = getIntent().getExtras().getInt("state");
//        Log.d("CLICKED BUTTON=====",String.valueOf(str1));
        location = 1;
        location2 = 1;
        player1 = (Button) findViewById(R.id.player1);
        player2 = (Button) findViewById(R.id.player2);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        rec1 = (ImageView) findViewById(R.id.rec1);
        rec2 = (ImageView) findViewById(R.id.rec2);
        rec3 = (ImageView) findViewById(R.id.rec3);
        rec4 = (ImageView) findViewById(R.id.rec4);
        rec5 = (ImageView) findViewById(R.id.rec5);
        rec6 = (ImageView) findViewById(R.id.rec6);
        rec7 = (ImageView) findViewById(R.id.rec7);
        rec8 = (ImageView) findViewById(R.id.rec8);
        rec9 = (ImageView) findViewById(R.id.rec9);
        rec10 = (ImageView) findViewById(R.id.rec10);
        rec11 = (ImageView) findViewById(R.id.rec11);
        rec12 = (ImageView) findViewById(R.id.rec12);
        rec13 = (ImageView) findViewById(R.id.rec13);
        rec14 = (ImageView) findViewById(R.id.rec14);
        rec15 = (ImageView) findViewById(R.id.rec15);
        rec16 = (ImageView) findViewById(R.id.rec16);
        rec2.setImageResource(0);
        rec3.setImageResource(0);
        rec4.setImageResource(0);
        rec5.setImageResource(0);
        rec6.setImageResource(0);
        rec7.setImageResource(0);
        rec8.setImageResource(0);
        rec9.setImageResource(0);
        rec10.setImageResource(0);
        rec11.setImageResource(0);
        rec12.setImageResource(0);
        rec13.setImageResource(0);
        rec14.setImageResource(0);
        rec15.setImageResource(0);
        rec16.setImageResource(0);

        choicee = getIntent().getExtras().getInt("state");

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1.setEnabled(false);
                player2.setEnabled(true);

                value1 = randomDiceValue();

                location += value1;
                counter1 += value1;
                location = location %17 ;
                if(location == 0)
                    location =1;

                final Animation anim1 = AnimationUtils.loadAnimation(DiceActivity.this, R.anim.shake);

                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.final_check");
                        Log.d("DICE ", String.valueOf(res1));
                        imageView1.setImageResource(res1);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };



                anim1.setAnimationListener(animationListener);
                imageView1.startAnimation(anim1);



                if(location == 1){
                    rec1.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 2){
                    rec2.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec1.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }
                if(location == 3){
                    rec3.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec2.setImageResource(0);
                    rec1.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }
                if(location == 4){
                    rec4.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec1.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 5){
                    rec5.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }

                if(location == 6){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 7){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }

                if(location == 8){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);
                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    startActivity(intent);
                }

                if(location == 9){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);
                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
                    startActivity(intent);
                }

                if(location == 10){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }

                if(location == 11){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 12){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }

                if(location == 13){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 1");
                    startActivity(intent);
                }
                if(location == 14){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 15){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(R.drawable.ic_location_on_black_24dp);
                    rec16.setImageResource(0);
                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }
                if(location == 16){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(R.drawable.ic_location_on_black_24dp);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 1)
                    rec1.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 2)
                    rec2.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 3)
                    rec3.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 4)
                    rec4.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 5)
                    rec5.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 6)
                    rec6.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 7)
                    rec7.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 8)
                    rec8.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 9)
                    rec9.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 10)
                    rec10.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 11)
                    rec11.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 12)
                    rec12.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 13)
                    rec13.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 14)
                    rec14.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 15)
                    rec15.setImageResource(R.drawable.ic_location_player2);
                if(location2 == 16)
                    rec16.setImageResource(R.drawable.ic_location_player2);
//
                if(counter1 > 32){
                    Intent i = new Intent(DiceActivity.this, result.class);
                    i.putExtra("result", 1);
                    Questions.index=0;
                    startActivity(i);
                }
                anim1.setAnimationListener(animationListener);
                imageView1.startAnimation(anim1);
                Log.d("DICEEEE", "onClick: DICEEEE");
            }


        });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                value2 = randomDiceValue();
                player2.setEnabled(false);
                player1.setEnabled(true);

                location2 += value2;
                counter2 += value2;
                location2 = location2 %17 ;
                if(location2 == 0)
                    location2 =1;

                final Animation anim1 = AnimationUtils.loadAnimation(DiceActivity.this, R.anim.shake);

                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        int res1 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.final_check");
                        Log.d("DICE ", String.valueOf(res1));
                        imageView1.setImageResource(res1);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };


                anim1.setAnimationListener(animationListener);
                imageView1.startAnimation(anim1);



                if(location2 == 1){
                    rec1.setImageResource(R.drawable.ic_location_player2);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 2){
                    rec2.setImageResource(R.drawable.ic_location_player2);
                    rec1.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }
                if(location2 == 3){
                    rec3.setImageResource(R.drawable.ic_location_player2);
                    rec2.setImageResource(0);
                    rec1.setImageResource(0);
                    rec4.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }
                if(location2 == 4){
                    rec4.setImageResource(R.drawable.ic_location_player2);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec1.setImageResource(0);
                    rec5.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 5){
                    rec5.setImageResource(R.drawable.ic_location_player2);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }

                if(location2 == 6){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(R.drawable.ic_location_player2);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 7){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(R.drawable.ic_location_player2);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }

                if(location2 == 8){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(R.drawable.ic_location_player2);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }

                if(location2 == 9){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(R.drawable.ic_location_player2);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }

                if(location2 == 10){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(R.drawable.ic_location_player2);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }

                if(location2 == 11){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(R.drawable.ic_location_player2);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 12){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(R.drawable.ic_location_player2);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, BreathingActivity.class);
//                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }

                if(location2 == 13){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(R.drawable.ic_location_player2);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, PowerPose.class);
                    intent.putExtra("string_player" , "Player 2");
                    startActivity(intent);
                }
                if(location2 == 14){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(R.drawable.ic_location_player2);
                    rec15.setImageResource(0);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location2 == 15){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(R.drawable.ic_location_player2);
                    rec16.setImageResource(0);

                    intent = new Intent(DiceActivity.this, Sensing.class);
                    startActivity(intent);
                }
                if(location2 == 16){
                    rec5.setImageResource(0);
                    rec2.setImageResource(0);
                    rec3.setImageResource(0);
                    rec4.setImageResource(0);
                    rec1.setImageResource(0);
                    rec6.setImageResource(0);
                    rec7.setImageResource(0);
                    rec8.setImageResource(0);
                    rec9.setImageResource(0);
                    rec10.setImageResource(0);
                    rec11.setImageResource(0);
                    rec12.setImageResource(0);
                    rec13.setImageResource(0);
                    rec14.setImageResource(0);
                    rec15.setImageResource(0);
                    rec16.setImageResource(R.drawable.ic_location_player2);

                    intent = new Intent(DiceActivity.this, Questions.class);
                    intent.putExtra("stat", choicee);
                    startActivity(intent);
                }

                if(location == 1)
                    rec1.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 2)
                    rec2.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 3)
                    rec3.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 4)
                    rec4.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 5)
                    rec5.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 6)
                    rec6.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 7)
                    rec7.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 8)
                    rec8.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 9)
                    rec9.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 10)
                    rec10.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 11)
                    rec11.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 12)
                    rec12.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 13)
                    rec13.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 14)
                    rec14.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 15)
                    rec15.setImageResource(R.drawable.ic_location_on_black_24dp);
                if(location == 16)
                    rec16.setImageResource(R.drawable.ic_location_on_black_24dp);

                if(counter2 > 32){
                    Intent i = new Intent(DiceActivity.this, result.class);
                    i.putExtra("result", 2);
                    Questions.index=0;
                    startActivity(i);
                }

                anim1.setAnimationListener(animationListener);
                imageView1.startAnimation(anim1);
                Log.d("DICEEEE", "onClick: DICEEEE111111111111");

            }

        });
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(4) + 1;
    }


//    public void rotate(View view){
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 180f,0f);
//        rotate.setDuration(500);
//        rotate.start();
//    }

}
