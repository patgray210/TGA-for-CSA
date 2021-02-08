package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText fullName;
    EditText userName;
    EditText password;
    Button register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        fullName = findViewById(R.id.fullname);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = fullName.getText().toString().trim();
                String email = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();


                long val = db.addUser(name, email, pass);
                if(val > 0)
                {
                    if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) || !isEmailValid(email))
                    {
                        if(!isEmailValid(email))
                            userName.setError("Please enter Email");
                        if(TextUtils.isEmpty(name))
                            fullName.setError("Please enter Name");
                        if(TextUtils.isEmpty(pass))
                            password.setError("Please enter Password");


                    }else {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);

                    }

                }else {
                    Toast.makeText(RegisterActivity.this,"Registration ERROR", Toast.LENGTH_SHORT).show();

                }





            }
        });



    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
