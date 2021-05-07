package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.final_check.ui.GameInstructions.fragment_InstructionActivity;

public class SafetyConcernsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safetyconcerns);
    }

    public void GameInstructionsPage(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
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
