package com.example.sourabh.bookmyticket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.*;

public  class FrontActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonreg;
    EditText ed1;
    EditText ed2;
    TextView text1;
    ProgressDialog pr1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        buttonreg = (Button) findViewById(R.id.button1);
        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        text1=(TextView)findViewById(R.id.textViewsignin);
        firebaseAuth = FirebaseAuth.getInstance();
        pr1 = new ProgressDialog(this);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),loginActivity.class));
            }
        });
        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getText().toString().trim();
                String password = ed2.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                pr1.setMessage("Registering user");
                pr1.show();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(FrontActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(FrontActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                                    pr1.cancel();
                                } else {
                                    Toast.makeText(FrontActivity.this, "Not Registered", Toast.LENGTH_SHORT).show();
                                    pr1.cancel();
                                }

                            }
                        });
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}