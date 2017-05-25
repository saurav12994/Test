package com.example.sourabh.bookmyticket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {
TextView t21,t22,t23,t24,t25,t26,t27;
    Toolbar toolbar;
    Button bpay,bcancel;
    public static  Integer [] progImages ={ R.drawable.hqdefault,R.drawable.jagga,R.drawable.karan

    };
    String[] film={"Raess","Jagga Jassos","karan arjun"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setTitle("                  Review Booking ");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        final ArrayList<String> ar1=getIntent().getExtras().getStringArrayList("list");
      //  t21=(TextView)findViewById(R.id.textView21);
        ///t21.setText(ar1.get(0));
        int retval = ar1.size();
        int price=retval*150;
        String pr=Integer.toString(price);
        String arrys = Integer.toString(retval);
        Intent intent=getIntent();
        String time=intent.getStringExtra("TW");
        String times=intent.getStringExtra("TIT");

       //Toast.makeText(getApplicationContext(),arrys,Toast.LENGTH_LONG).show();
        t21=(TextView)findViewById(R.id.textView26);
        t22=(TextView)findViewById(R.id.textView27);
        t23=(TextView)findViewById(R.id.textView31);
        t24=(TextView)findViewById(R.id.textView35);
        t25=(TextView)findViewById(R.id.textView33);
        t26=(TextView)findViewById(R.id.textView24);
        t27=(TextView)findViewById(R.id.textView25);
        Toast.makeText(PaymentActivity.this,time,Toast.LENGTH_LONG).show();
        t26.setText(time);
        t21.setText("    "+arrys);
        t22.setText(ar1.get(0));
        t27.setText(times);
        Double tax = 0.14 * price;
        double roundOff = Math.round(tax * 100.0) / 100.0;
        String txaa = Double.toString(roundOff);
        for (int i=1;i<retval;i++)
        {
            t22.append(","+ar1.get(i));
        }
        t24.setText("Rs."+retval);
        t23.setText("Rs."+pr);
        t25.setText("Rs."+txaa);
        Double sum=price+retval+roundOff;
        final String summ = Double.toString(sum);
        bpay=(Button)findViewById(R.id.button8);
        bpay.setText("Pay Rs."+summ);
        bcancel=(Button)findViewById(R.id.button9);
        bpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(PaymentActivity.this,Pay.class);
                intent1.putExtra("SM",summ);
                intent1.putStringArrayListExtra("list",ar1);
                startActivity(intent1);
              //  Toast.makeText(getApplicationContext(),"pay",Toast.LENGTH_SHORT).show();
            }
        });
        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(PaymentActivity.this,Main5Activity.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
