package com.example.sourabh.bookmyticket;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Sourabh on 07-02-2017.
 */
public class MyLtAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] film;

    public MyLtAdapter(Activity context, String[] film)
    { super(context, R.layout.activity_imagelist,film);
        this.context=context;
        this.film=film;


    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.sample,null,true);
        TextView txtTitle=(TextView)rowview.findViewById(R.id.textView6);

        txtTitle.setText(film[position]);

        return rowview;
    }
}
