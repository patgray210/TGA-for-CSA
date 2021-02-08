package com.example.final_check.ui.Existing_patient_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_check.DatabaseHelper;
import com.example.final_check.R;
import com.example.final_check.RecyclerViewAdapter;
import com.example.final_check.patient_data;

import java.util.ArrayList;
import java.util.List;

public class Existing_patient_fragment extends Fragment {


    View v;
    RecyclerView recyclerView;
    List<patient_data> list_patient_data;
    DatabaseHelper db;


    public Existing_patient_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.patient_recyclerview,container,false);

        recyclerView = v.findViewById(R.id.patient_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),list_patient_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String loggedUser = getActivity().getIntent().getStringExtra("loggedUser");

        list_patient_data = new ArrayList<>();
        db = new DatabaseHelper(this.getActivity());
        list_patient_data.addAll(db.allPatients(loggedUser));

    }
}