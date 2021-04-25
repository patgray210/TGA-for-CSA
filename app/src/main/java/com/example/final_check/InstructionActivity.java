package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
    }

    public void onClick(View view) {

        if (view.getId() == R.id.SafetyConcerns) {
            Intent intent = new Intent(this, SafetyConcernsActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.Tostart) {
            Intent intent = new Intent(this, TostartActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.Clinicianpart) {
            Intent intent = new Intent(this, ClinicianPartActivity.class);
            startActivity(intent);
        }
    }

}
