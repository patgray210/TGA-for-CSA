package com.example.final_check;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DearMeLetter extends Fragment implements View.OnClickListener {
    Button buttonSend;
    TextView textSubject;
    EditText textMessage;
    EditText textTo;
    View view;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dear_me_letter, container, false);

        buttonSend = (Button) view.findViewById(R.id.buttonSend);
        textTo = (EditText) view.findViewById(R.id.textTo);
        textSubject = (TextView) view.findViewById(R.id.textSubject);
        textMessage = (EditText) view.findViewById(R.id.textMessage);
        buttonSend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSend) {
            String to = textTo.getText().toString();
            String subject = textSubject.getText().toString();
            String message = textMessage.getText().toString();

            if(TextUtils.isEmpty(to)||TextUtils.isEmpty(message)){

                if(TextUtils.isEmpty(to))
                    textTo.setError("The item cannot be empty");
                if(TextUtils.isEmpty(message))
                    textMessage.setError("The item cannot be empty");

                Toast.makeText(getActivity(), "EMPTY FIELD DETECTED!!", Toast.LENGTH_SHORT).show();


            }else{
                Log.d("hi", "hi");
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(email, "Choose Email Client : "));
            }

        }
    }
}
