package com.example.sourabh.bookmyticket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pay extends AppCompatActivity {
Toolbar toolbar;
   Double result;
    CheckBox checkBox;
    TextView t51,t52,t53;
    ListView listView;
    String[] film={"Debit/Credit Card","Net Banking","CashCard","GiftVoucher","Credit Voucher"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_scrolling);
        toolbar=(Toolbar)findViewById(R.id.toolbar12);
        Intent intent=getIntent();
        String u=intent.getStringExtra("SM");
        t51=(TextView)findViewById(R.id.textView52);
        t53=(TextView)findViewById(R.id.textView53);
            checkBox=(CheckBox)findViewById(R.id.checkBox1);
        t52=(TextView)findViewById(R.id.text124);
        t51.setText("Rs."+u);
        t52.setText("Rs."+u);
        result = Double.parseDouble(u);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result=result-50;
                String numberAsString = Double.toString(result);
                t52.setText("Rs."+numberAsString);

            }
        });
        setSupportActionBar(toolbar);
        final ArrayList<String> ar2=getIntent().getExtras().getStringArrayList("list");
        MyLtAdapter adapter= new MyLtAdapter(this,film);
        listView=(ListView)findViewById(R.id.listView10);
        // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,film);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i==0)
               {
                   Intent intent1=new Intent(Pay.this,DebitActivity.class);
                   intent1.putStringArrayListExtra("list",ar2);
                   startActivity(intent1);
               }
               if(i==1)
               {
                   Intent intent1=new Intent(Pay.this,BankingActiivty.class);
                   intent1.putStringArrayListExtra("list",ar2);
                   startActivity(intent1);
               }
                if(i==2)
                {
                    Intent intent1=new Intent(Pay.this,CascardActivity.class);
                    intent1.putStringArrayListExtra("list",ar2);
                    startActivity(intent1);
                }
                if(i==3)
                {
                    Intent intent1=new Intent(Pay.this,GVActivity.class);
                    intent1.putStringArrayListExtra("list",ar2);
                    startActivity(intent1);
                }
                if(i==4)
                {
                    Intent intent1=new Intent(Pay.this,CVActivity.class);
                    intent1.putStringArrayListExtra("list",ar2);
                    startActivity(intent1);
                }
                else {
                Toast.makeText(Pay.this,film[i],Toast.LENGTH_LONG).show();
            }}
        });
    }
}
