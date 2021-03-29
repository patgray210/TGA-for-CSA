package com.example.final_check.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.final_check.BreathingActivity;
import com.example.final_check.PowerPose;
import com.example.final_check.R;
import com.example.final_check.Youtube;


public class Mindfulness extends Fragment implements View.OnClickListener {
    ImageButton play;
    ImageButton breath;
    ImageButton yoga;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mindfulness, container, false);
        Log.d("hi", "check");
        play = root.findViewById(R.id.play);
        breath = root.findViewById(R.id.breathing_button);
        yoga = root.findViewById(R.id.yoga);
        play.setOnClickListener(this);
        breath.setOnClickListener(this);
        yoga.setOnClickListener(this);
        return root;

    }

    @Override
    public void onClick(View view) {
        Log.d("hi", "check1");
        if(view.getId() == R.id.play){
            Log.d("hi", "check");
            Intent i  = new Intent(this.getContext() , Youtube.class);
            startActivity(i);
        }

        if(view.getId() == R.id.breathing_button){
            Intent i = new Intent(this.getContext(), BreathingActivity.class);
            startActivity(i);

        }

        if(view.getId() == R.id.yoga){
            Intent i = new Intent(this.getContext(), PowerPose.class);
            startActivity(i);
        }
    }
}