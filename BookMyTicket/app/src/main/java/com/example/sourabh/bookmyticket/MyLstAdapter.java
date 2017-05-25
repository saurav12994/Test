package com.example.sourabh.bookmyticket;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sourabh on 25-02-2017.
 */
public class MyLstAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] cinema;

    public MyLstAdapter(Activity context, String[] cinema)
    { super(context, R.layout.activity_customl,cinema);
        this.context=context;
        this.cinema=cinema;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View rowview = inflater.inflate(R.layout.activity_customl,null,true);
        TextView txtTitle=(TextView)rowview.findViewById(R.id.textView);

        txtTitle.setText(cinema[position]);

        final Button bt1=(Button)rowview.findViewById(R.id.button);
        final Button bt2=(Button)rowview.findViewById(R.id.button1);
        final Button bt3=(Button)rowview.findViewById(R.id.button2);
        final Button bt4=(Button)rowview.findViewById(R.id.button3);
        final Button bt5=(Button)rowview.findViewById(R.id.button4);
        final Button bt6=(Button)rowview.findViewById(R.id.button5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttonp=(Button)dialog.findViewById(R.id.proceed);

                buttonp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt1.getText().toString();
                        //Toast.makeText(getContext(),b,Toast.LENGTH_LONG).show();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);

//Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();


                    }
                });
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttonq=(Button)dialog.findViewById(R.id.proceed);
                buttonq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt2.getText().toString();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);
                        //Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttonw=(Button)dialog.findViewById(R.id.proceed);
                buttonw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt3.getText().toString();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);
                       // Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttone=(Button)dialog.findViewById(R.id.proceed);
                buttone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt4.getText().toString();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);
                        //Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttont=(Button)dialog.findViewById(R.id.proceed);
                buttont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt5.getText().toString();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);
                      //  Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialog dialog=new CustomDialog(getContext());
                dialog.setTitle("How Many Seats ?");

                dialog.show();
                final TabHost tabHost = (TabHost)dialog.findViewById(R.id.TabHost01);
                Button buttoni=(Button)dialog.findViewById(R.id.proceed);
                buttoni.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String b=bt6.getText().toString();
                        String a =String.valueOf(tabHost.getCurrentTab());
                        Intent i =new Intent(getContext(),SeatActivity.class);
                        i.putExtra("U",a);
                        i.putExtra("T",b);
                        i.putExtra("TI",cinema[position]);
                        context.startActivity(i);
                     //   Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        return rowview;
    }
}
