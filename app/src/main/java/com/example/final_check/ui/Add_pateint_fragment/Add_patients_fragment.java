package com.example.final_check.ui.Add_pateint_fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.final_check.DatabaseHelper;
import com.example.final_check.LoginActivity;
import com.example.final_check.R;
import com.example.final_check.fragment_holder;

public class Add_patients_fragment extends Fragment implements View.OnClickListener {

    Button save;
    TextView patient_name;
    Spinner category;
    TextView age;
    TextView gender;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add_patient, container, false);
        save = root.findViewById(R.id.save);
        patient_name = root.findViewById(R.id.patient_name);
        category = root.findViewById(R.id.category);
        //age = root.findViewById(R.id.age);
        //gender = root.findViewById(R.id.gender);
        save.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        DatabaseHelper db = new DatabaseHelper(this.getActivity());
        String loggedUser = getActivity().getIntent().getStringExtra("loggedUser");
        Log.d("LOGGED IN USER", String.valueOf(loggedUser));

        Log.d("SAVE BUTTON PRESSED", "onClick: HERE AT THE SAVE ");

        String cat = category.getSelectedItem().toString();


        String name = patient_name.getText().toString().trim();
        /*String cat = category.getText().toString().trim();*/
        String patAge = age.getText().toString().trim();
        String gndr = gender.getText().toString().trim();
        boolean patientThere = db.checkPatient(loggedUser,name, cat ,patAge,gndr);
        if(patientThere == false){
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(patAge) || TextUtils.isEmpty(gndr))
            {
                if(TextUtils.isEmpty(name))
                    patient_name.setError("The item cannot be empty");
                /*if(TextUtils.isEmpty(cat))
                    category.setError("The item cannot be empty");*/
                if(TextUtils.isEmpty(patAge))
                    age.setError("The item cannot be empty");
                if(TextUtils.isEmpty(gndr))
                    gender.setError("The item cannot be empty");

                Toast.makeText(getActivity(), "EMPTY FIELD DETECTED!!", Toast.LENGTH_SHORT).show();
                Log.d("CHECK EMPTY ", "IT IS EMPTY IF STATEMENT");
            }
            else
            {
                db.addPatient(name, cat, gndr, patAge, loggedUser);
                patient_name.setText("");
                /*category.setText("");*/
                age.setText("");
                gender.setText("");
                Toast.makeText(getActivity(), "Patient Added", Toast.LENGTH_SHORT).show();

            }



        }
        else{
            Toast.makeText(getActivity(), "Patient Already Exists", Toast.LENGTH_SHORT).show();
        }

        Log.d("SAVE BUTTON PRESSED", "onClick: HERE AT THE SAVE2 ");

    }
}