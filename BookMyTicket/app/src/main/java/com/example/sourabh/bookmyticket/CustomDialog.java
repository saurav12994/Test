package com.example.sourabh.bookmyticket;

import android.app.Dialog;
import android.content.Context;
import android.widget.TabHost;

/**
 * Created by Sourabh on 27-02-2017.
 */
public class CustomDialog extends Dialog {
    public CustomDialog(final Context context) {
        super(context);

        setTitle("My First Custom Tabbed Dialog");
        setContentView(R.layout.custom_dialog_layout);
        TabHost tabHost = (TabHost)findViewById(R.id.TabHost01);
        tabHost.setup();

        // create tab 1
        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
        spec1.setIndicator("1", context.getResources().getDrawable(R.drawable.ew));
        spec1.setContent(R.id.TextView01);
        tabHost.addTab(spec1);
        //create tab2
        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setIndicator("2", context.getResources().getDrawable(R.drawable.ewallet));
        spec2.setContent(R.id.TextView02);
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
        spec3.setIndicator("3", context.getResources().getDrawable(R.drawable.ewallet));
        spec3.setContent(R.id.TextView03);
        tabHost.addTab(spec3);

        TabHost.TabSpec spec4 = tabHost.newTabSpec("tab4");
        spec4.setIndicator("4", context.getResources().getDrawable(R.drawable.ewallet));
        spec4.setContent(R.id.TextView04);
        tabHost.addTab(spec4);

        TabHost.TabSpec spec5 = tabHost.newTabSpec("tab5");
        spec5.setIndicator("5", context.getResources().getDrawable(R.drawable.ewallet));
        spec5.setContent(R.id.TextView05);
        tabHost.addTab(spec5);


    }
}
