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

public class BankingActiivty extends AppCompatActivity {
Toolbar toolbar;
    ListView listView;
    String[] Bank={"SBI Bank","CitiBank","UCO Bank","ICIC Bank","PNB Bank","Kotak"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_actiivty);
        toolbar=(Toolbar)findViewById(R.id.toolbar14);
        toolbar.setTitle("                    Net Banking");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        MyBankAdapter adapter = new MyBankAdapter(this,Bank);
        listView=(ListView)findViewById(R.id.list23);
        // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,film);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent1=new Intent(BankingActiivty.this,KotakActivity.class);
                    startActivity(intent1);
                }
                if(i==1)
                {
                    Intent intent1=new Intent(BankingActiivty.this,CitiActivity.class);
                    startActivity(intent1);
                }
                if(i==2)
                {
                    Intent intent1=new Intent(BankingActiivty.this,UCOActivity.class);
                    startActivity(intent1);
                }
                if(i==3)
                {
                    Intent intent1=new Intent(BankingActiivty.this,ICICActivity.class);
                    startActivity(intent1);
                }
                if(i==4)
                {
                    Intent intent1=new Intent(BankingActiivty.this,PnbActivity.class);
                    startActivity(intent1);
                }

                if(i==5)
                {
                    Intent intent1=new Intent(BankingActiivty.this,kotak1Activity.class);
                    startActivity(intent1);
                }
                else {
                Toast.makeText(BankingActiivty.this,Bank[i],Toast.LENGTH_LONG).show();
            }}
        });
    }
}
