package com.example.final_check.ui.GameInstructions;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.final_check.R;


import com.example.final_check.ClinicianPartActivity;
import com.example.final_check.SafetyConcernsActivity;
import com.example.final_check.TostartActivity;

public class fragment_InstructionActivity extends Fragment implements View.OnClickListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragement_activity_instructions, container, false);

        Button title_safetyConcerns = root.findViewById(R.id.SafetyConcerns);
        Button title_toStart = root.findViewById(R.id.Tostart);
        Button title_clinicalPart = root.findViewById(R.id.Clinicianpart);
/*
        root.findViewById(R.id.body_Gameinstructions);
        root.findViewById(R.id.ObjectofGame);
 */
        title_safetyConcerns.setOnClickListener(this);
        title_toStart.setOnClickListener(this);
        title_clinicalPart.setOnClickListener(this);

        return root;


    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.SafetyConcerns){
            Intent i = new Intent(this.getContext(), SafetyConcernsActivity.class);
            startActivity(i);
        }

        if(view.getId() == R.id.Tostart) {
            Intent i = new Intent(this.getContext(), TostartActivity.class);
            startActivity(i);
        }

        if(view.getId() == R.id.Clinicianpart) {
            Intent i = new Intent(this.getContext(), ClinicianPartActivity.class);
            startActivity(i);
        }
    }
}
