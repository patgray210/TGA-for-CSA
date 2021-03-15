package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClinicianPartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicianparticipation);
    }

    public void GameinstructionsPage(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }

    public void TostartPage(View view) {
        Intent intent = new Intent(this, TostartActivity.class);
        startActivity(intent);
    }

    public void SafetyConcernsPage(View view) {
        Intent intent = new Intent(this, SafetyConcernsActivity.class);
        startActivity(intent);
    }
}
