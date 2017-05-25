package com.example.sourabh.bookmyticket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity  {
    private EditText edit2;
    private EditText edit3;
    Button b1;
    private FirebaseAuth firebaseAuth;
    ProgressDialog pr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = (Button) findViewById(R.id.button2);
        edit2 = (EditText) findViewById(R.id.editText1);
        edit3 = (EditText) findViewById(R.id.editText2);
        firebaseAuth = FirebaseAuth.getInstance();

        pr1 = new ProgressDialog(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edit2.getText().toString().trim();
                final String password = edit3.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                pr1.setMessage("Logging user");
                pr1.show();
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
pr1.dismiss();
                                if (task.isSuccessful()) {
                                    finish();
                                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                    i.putExtra("U",email);
                                    startActivity(i);
                                //  startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                } else {
                                    Toast.makeText(loginActivity.this, "Not Registered", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });



    }
}
