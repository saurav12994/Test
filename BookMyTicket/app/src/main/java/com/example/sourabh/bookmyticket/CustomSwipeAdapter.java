package com.example.sourabh.bookmyticket;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

/**
 * Created by Sourabh on 24-01-2017.
 */
public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources={R.drawable.jagga,R.drawable.hqdefault,R.drawable.karan};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public  CustomSwipeAdapter(Context ctx, int swipe_layout)
    {

        this.ctx=ctx;
    }
    @Override
    public int getCount() {

        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o ){

        return (view==(ImageView)o);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

      /*  layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        //ImageView imageView = new ImageView(ctx);
       // ImageView imageView=(ImageView)item_view.findViewById(R.id.imageView3);
        //TextView textView=(TextView)item_view.findViewById(R.id.textView18);
        //imageView.setImageResource(image_resources[position]);
        //textView.setText("image:" +position);
        container.addView(item_view);
        return item_view;*/
       ImageView mImageView = new ImageView(ctx);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(image_resources[position]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
