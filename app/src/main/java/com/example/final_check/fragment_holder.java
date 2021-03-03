package com.example.final_check;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class fragment_holder extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        String loggedUser = getIntent().getStringExtra("loggedUser");

//        Log.d("LOGGED USER", loggedUser);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        String str1 = db.showUserName(loggedUser) ;
        Log.d("FRAGMENT USER", str1 );

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView navUsername = headerView.findViewById(R.id.userDisplay);
        navUsername.setText("Welcome "+str1);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_play, R.id.nav_add_patients, R.id.nav_existing_patients,
                R.id.nav_write_letter, R.id.nav_mindfulness)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if(patientCount > 0){
//
//
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void settingsPage(MenuItem item) {
        setContentView(R.layout.activity_settings);
    }

    public void findQuestions(View view) {
        Spinner category = (Spinner) findViewById(R.id.questionSelectList);
        String toGet = String.valueOf(category.getSelectedItem());
    ListView listView;
    String[] listValue={};
        listView = (ListView)findViewById(R.id.listView1);

        String questionList[] = {};
        if (toGet.equals("Anxiety")) {
            listValue = getResources().getStringArray(R.array.Anxiety);
        }else if (toGet.equals("Anger")) {
            listValue = getResources().getStringArray(R.array.Anger);
        } else if (toGet.equals("Post Traumatic Stress")) {
            listValue = getResources().getStringArray(R.array.PostTraumaticStress);
        }else if (toGet.equals("Depression")) {
            listValue = getResources().getStringArray(R.array.Depression);
        }else if (toGet.equals("Dissociation")) {
            listValue = getResources().getStringArray(R.array.Dissociation);
        }else if (toGet.equals("Sexual Concerns")) {
            listValue = getResources().getStringArray(R.array.SexualConcerns);
        }else if (toGet.equals("Wild Card")) {
            listValue = getResources().getStringArray(R.array.WildCard);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listValue);

        listView.setAdapter(adapter);
    }
}
