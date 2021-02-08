package com.example.final_check;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    Button login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Boolean res = db.checkUser(username,pass);

                if(res == true || TextUtils.isEmpty(username) || TextUtils.isEmpty(pass) || !isEmailValid(username)){
                    if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pass) || !isEmailValid(username))
                    {
                        if(!isEmailValid(username))
                            userName.setError("Please enter Correct Email");
                        if(TextUtils.isEmpty(pass))
                            password.setError("Please enter Password");
                        if(TextUtils.isEmpty(username))
                            userName.setError("Please enter Email");

                    }else{

                        Toast.makeText(LoginActivity.this,"Successfully Logged In ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, fragment_holder.class); // send string with user name so that it can be used in other activities
                        intent.putExtra("loggedUser", username);
                        startActivity(intent);
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this,"Please Check Username or Password", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
