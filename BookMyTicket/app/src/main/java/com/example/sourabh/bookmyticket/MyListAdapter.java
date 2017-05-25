package com.example.sourabh.bookmyticket;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sourabh.bookmyticket.R;

/**
 * Created by Sourabh on 07-02-2017.
 */
public class MyListAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] film;
    private final Integer[] progImages;
    public MyListAdapter(Activity context,String[] film,Integer[] progImages)
    { super(context, R.layout.activity_image_list,film);
        this.context=context;
        this.film=film;
        this.progImages=progImages;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.activity_imgete,null,true);
        TextView txtTitle=(TextView)rowview.findViewById(R.id.textView1);
        ImageView imageView=(ImageView)rowview.findViewById(R.id.imageView1);
        txtTitle.setText(film[position]);
        Button btn=(Button)rowview.findViewById(R.id.button3);
        imageView.setImageResource(progImages[position]);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context,Main5Activity.class);
                i.putExtra("U",film[position]);
                context.startActivity(i);
            }
        });
        return rowview;
    }
}
