package com.example.sourabh.bookmyticket;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Sourabh on 11-04-2017.
 */
public class MyBankAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] Bank;
    public MyBankAdapter(Activity context, String[] Bank)
    {
        super(context, R.layout.activity_imagelist,Bank);
        this.Bank=Bank;
        this.context=context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.sample1,null,true);
        TextView txtTitle=(TextView)rowview.findViewById(R.id.textq);

        txtTitle.setText(Bank[position]);

        return rowview;
    }
}
