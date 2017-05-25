package com.example.sourabh.bookmyticket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CascardActivity extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    String[] Bank={"Smart Paisa","ZipCash","itzCash","YPAYCASH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cascard);
        toolbar=(Toolbar)findViewById(R.id.toolbar17);
        toolbar.setTitle("                    Cash Cards");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        MyBankAdapter adapter = new MyBankAdapter(this,Bank);
        listView=(ListView)findViewById(R.id.list26);
        // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,film);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent1=new Intent(CascardActivity.this,SmartActivity.class);
                    startActivity(intent1);
                }
                if(i==1)
                {
                    Intent intent1=new Intent(CascardActivity.this,ZipActivity.class);
                    startActivity(intent1);
                }
                if(i==2)
                {
                    Intent intent1=new Intent(CascardActivity.this,ItzActivity.class);
                    startActivity(intent1);
                }
                if(i==3)
                {
                    Intent intent1=new Intent(CascardActivity.this,YpayActivity.class);
                    startActivity(intent1);
                }
                else
                {
                Toast.makeText(CascardActivity.this,Bank[i],Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
