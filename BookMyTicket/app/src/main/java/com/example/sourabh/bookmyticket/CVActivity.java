package com.example.sourabh.bookmyticket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CVActivity extends AppCompatActivity {
Toolbar toolbar;
    Button b1;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);
        toolbar=(Toolbar)findViewById(R.id.toolbar16);
        toolbar.setTitle("                  Credit Voucher ");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        et1=(EditText)findViewById(R.id.editText10);
        b1=(Button) findViewById(R.id.button12);
        final ArrayList<String> ar3=getIntent().getExtras().getStringArrayList("list");



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cv=et1.getText().toString().trim();
              if(cv.equals("123456789"))
               {Intent intent1=new Intent(CVActivity.this,BarcodeActivity.class);
                   intent1.putStringArrayListExtra("list",ar3);
                   startActivity(intent1);
                 //   Toast.makeText(CVActivity.this,cv,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
