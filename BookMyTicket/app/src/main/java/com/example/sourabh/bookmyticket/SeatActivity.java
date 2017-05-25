package com.example.sourabh.bookmyticket;

import java.util.ArrayList;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.Toast;

/**
 *
 * @author Sourabh Gupta
 *
 */

public class SeatActivity extends Activity implements OnItemClickListener
{int j=0;
public ArrayList<String> scre=new ArrayList<String>();
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;
    public Bitmap seatIcon;
    public Bitmap seatSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        seatIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.seat_layout_screen_nor_avl);
        seatSelect = BitmapFactory.decodeResource(this.getResources(), R.drawable.seat_layout_screen_nor_std);
        totalSeat(80);
        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.seatrow_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(this);
        Button done=(Button)findViewById(R.id.doneButton);
        Button cancel=(Button)findViewById(R.id.cancelButton);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String u=intent.getStringExtra("U");
                String uw=intent.getStringExtra("T");
                String tit=intent.getStringExtra("TI");
             //   Toast.makeText(SeatActivity.this,uw,Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(SeatActivity.this,PaymentActivity.class);
                intent1.putStringArrayListExtra("list",scre);
                intent1.putExtra("TU",u);
                intent1.putExtra("TW",uw);
                intent1.putExtra("TIT",tit);
                startActivity(intent1);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1=new Intent(SeatActivity.this,Main5Activity.class);
                startActivity(intent1);
            }
        });
    }

    public void totalSeat(int n)
    {
        for (int i = 1; i <= n; ++i)
        {
            gridArray.add(new Item(seatIcon, ""+i));

        }
    }

    public void seatSelected(int pos)
    {
        gridArray.remove(pos);
        int i = pos + 1;
        String numberAsString = String.valueOf(i);
        scre.add(numberAsString);

        gridArray.add(pos, new Item(seatSelect, "" +i));
        customGridAdapter.notifyDataSetChanged();
    }

    public void seatDeselcted(int pos)
    {

        gridArray.remove(pos);
        int i = pos + 1;
        scre.remove(i);
        gridArray.add(pos, new Item(seatIcon, "" + i));
        customGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent intent=getIntent();
        String u=intent.getStringExtra("U");
        String uw=intent.getStringExtra("T");
        int result = Integer.parseInt(u);
        Item item = gridArray.get(position);
        Bitmap seatcompare = item.getImage();
        result=result+1;
        if(j<result) {
            if (seatcompare == seatIcon) {
                seatSelected(position);
              //  Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
                j++;

            } else {
                seatDeselcted(position);
                j--;
            }
        }
    }

}

