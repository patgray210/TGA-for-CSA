package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Sensing extends AppCompatActivity {
    List<String> list_of_cards_sensing;
    public static int index = 0;
    TextView questions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensing);
        questions = findViewById(R.id.sensing_question);


//        index =0;
        list_of_cards_sensing = new ArrayList<>();
        list_of_cards_sensing.add(("Look for 5 things you can see"));
        list_of_cards_sensing.add(("4 things you can touch"));
        list_of_cards_sensing.add(("3 things you can hear"));
        list_of_cards_sensing.add(("2 things you can smell"));
        list_of_cards_sensing.add(("1 thing you can taste"));

        questions.setText(list_of_cards_sensing.get(index));
        index++;
        index = index%5;
        Log.d("check", String.valueOf(index));



    }



    /*Create a timer counter*/
}
