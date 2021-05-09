package com.example.final_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ground extends AppCompatActivity {
    List<String> list_of_cards_sensing;
    Button str_next;
    Random random = new Random();

    public static int index = 0;
    TextView questions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground);
        questions = findViewById(R.id.ground_question);


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

        str_next = (Button)findViewById(R.id.next);
        str_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int rand = random.nextInt(5);
                    index = rand;
                    if(index >= 0 && index < list_of_cards_sensing.size()){
                        questions.setText(String.valueOf(list_of_cards_sensing.get(index)));
                    }
                    else{
                        index = 1;
                    }
            }
        });
    }



    /*Create a timer counter*/
}
