package com.example.sourabh.bookmyticket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DebitActivity extends AppCompatActivity {
Toolbar toolbar;
    EditText et1,et2,et3,et4;
    Button b1;
    ProgressDialog pr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
        toolbar=(Toolbar)findViewById(R.id.toolbar13);
        toolbar.setTitle("               Enter Your Card Details");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        final ArrayList<String> ar3=getIntent().getExtras().getStringArrayList("list");
        et1=(EditText)findViewById(R.id.editText6);
        et2=(EditText)findViewById(R.id.editText7);
        et3=(EditText)findViewById(R.id.editText8);
        et4=(EditText)findViewById(R.id.editText9);
        pr1 = new ProgressDialog(this);
        b1=(Button)findViewById(R.id.button10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=et1.getText().toString().trim();
                String b=et2.getText().toString().trim();
                String c=et3.getText().toString().trim();
                String d=et4.getText().toString().trim();
                if (TextUtils.isEmpty(a)) {
                    Toast.makeText(DebitActivity.this, "Enter Card no", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(b)) {
                    Toast.makeText(DebitActivity.this, "Enter Expiry date.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(c)) {
                    Toast.makeText(DebitActivity.this, "Enter CVV", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(d)) {
                    Toast.makeText(DebitActivity.this, "Enter Cardholder  name ", Toast.LENGTH_SHORT).show();
                    return;
                }

                //pr1.setMessage("Paying");
                //pr1.show();
             //   Toast.makeText(DebitActivity.this,a.length(),Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(DebitActivity.this,BarcodeActivity.class);
                intent1.putStringArrayListExtra("list",ar3);
              //  pr1.dismiss();
                startActivity(intent1);

            }
        });

    }
}
