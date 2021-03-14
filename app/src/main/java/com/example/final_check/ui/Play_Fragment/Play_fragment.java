package com.example.final_check.ui.Play_Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_check.DatabaseHelper;
import com.example.final_check.DiceActivity;
import com.example.final_check.PowerPose;
import com.example.final_check.Questions;
import com.example.final_check.R;
import com.example.final_check.Youtube;
import com.example.final_check.patient_data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Play_fragment extends Fragment implements View.OnClickListener {

    View v;
    RecyclerView recyclerView;
    Spinner sName;
    DatabaseHelper db;
    Button play;
    EditText sCat;

    Button anxiety;
    Button anger;
    Button pts;
    Button depres;
    Button dissociation;
    Button concerns;
    Button mixed;

    String str1;

    int  getCat = 0;


    public Play_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_play,container,false);
        sName = v.findViewById(R.id.spinnerName);
        play = v.findViewById(R.id.Play);
        play.setOnClickListener(this);
        spinnerPop();
        sCat = v.findViewById(R.id.catSelected);
        sCat.setEnabled(false);
        anxiety = v.findViewById(R.id.anxiety);
        anger = v.findViewById(R.id.anger);
        pts = v.findViewById(R.id.post_traumatic_stress);
        dissociation = v.findViewById(R.id.dissociation);
        depres = v.findViewById(R.id.depres);
        concerns = v.findViewById(R.id.sexual_concerns);
        mixed = v.findViewById(R.id.wild_card);

        play.setOnClickListener(this);
        anxiety.setOnClickListener(this);
        anger.setOnClickListener(this);
        pts.setOnClickListener(this);
        depres.setOnClickListener(this);
        dissociation.setOnClickListener(this);
        concerns.setOnClickListener(this);
        mixed.setOnClickListener(this);
        play.setEnabled(false);
        return v;
    }


    public void spinnerPop(){
        String loggedUser = getActivity().getIntent().getStringExtra("loggedUser");

        db = new DatabaseHelper(this.getActivity());
        List<String> labels = db.patientLabels(loggedUser);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,labels);
        sName.setAdapter(dataAdapter);


        sName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.v("item", (String) adapterView.getItemAtPosition(position));
                str1 = (String) adapterView.getItemAtPosition(position);
//                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.parseColor("#009eba"));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "SELECT CLIENT", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        Intent i  = new Intent(this.getContext(), DiceActivity.class);




        if(view.getId() == R.id.anxiety) {
            getCat = 0;
            sCat.setText("Anxiety Selected");
            play.setEnabled(true);




        }

        if(view.getId() == R.id.anger) {

            play.setEnabled(true);
            sCat.setText("Anger Selected");
            getCat = 1;

        }

        if(view.getId() == R.id.post_traumatic_stress) {

            getCat = 2;

            sCat.setText("Post Traumatic Stress Selected");
            play.setEnabled(true);

        }
        if(view.getId() == R.id.depres) {

            play.setEnabled(true);
            sCat.setText("Depression Selected");
            getCat = 3;
        }
        if(view.getId() == R.id.dissociation) {
            getCat = 4;

            sCat.setText("Dissociation Selected");
            play.setEnabled(true);


        }

        if(view.getId() == R.id.sexual_concerns) {

            play.setEnabled(true);
            sCat.setText("Sexual Concerns Selected");
            getCat = 5;


        }



        if(view.getId() == R.id.wild_card) {
            getCat = 6;


            sCat.setText("Wild Card Selected");

            play.setEnabled(true);
        }

        if(view.getId() == R.id.Play){
            i.putExtra("state",getCat);

            startActivity(i);
        }
    }
}