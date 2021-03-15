package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
    }

    public void SafetyConcernsPage(View view) {
        Intent intent = new Intent(this, SafetyConcernsActivity.class);
        startActivity(intent);
    }

    public void TostartPage(View view) {
        Intent intent = new Intent(this, TostartActivity.class);
        startActivity(intent);
    }

    public void ClinicianpartPage(View view) {
        Intent intent = new Intent(this, ClinicianPartActivity.class);
        startActivity(intent);
    }
}
