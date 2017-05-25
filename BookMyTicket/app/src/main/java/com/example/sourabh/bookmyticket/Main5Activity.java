package com.example.sourabh.bookmyticket;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main5Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;


    //ListView listView;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent=getIntent();
        String u=intent.getStringExtra("U");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(u);
        toolbar.setSubtitle("2D  Hindi");
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
       mViewPager = (ViewPager) findViewById(R.id.container1);
        mViewPager.setAdapter(mSectionsPagerAdapter);
       // MyListAdapter adapter= new MyListAdapter(this,cinema);
        //listView=(ListView)findViewById(R.id.listView);

        //listView.setAdapter(adapter);





        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabTextColors(Color.BLACK,Color.BLACK);
        tabLayout.setSelectedTabIndicatorColor(Color.GREEN);

       tabLayout.setupWithViewPager(mViewPager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        Context c=getContext();
        ListView listView;
        String[] cinema={"Wave:Noida","Carnival:TGIP","DT Cinemas:Noida","Carnival:Greater Noida","Carnival:Vaishali"};
        private static final String ARG_SECTION_NUMBER = "section_number";
       // public Intent inten=c.getI;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main5, container, false);
//            String u=inten.getStringExtra("U");
      //      TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            MyLstAdapter adapter= new MyLstAdapter(getActivity(),cinema);
            listView=(ListView)rootView.findViewById(R.id.listView3);

            listView.setAdapter(adapter);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE dd");
                    Date d = new Date();
                    String day = sdf.format(d);
                    return day;
                case 1:
                    SimpleDateFormat dateFormat= new SimpleDateFormat("EEE dd");
                    Calendar currentCal = Calendar.getInstance();
                    String currentdate=dateFormat.format(currentCal.getTime());
                    currentCal.add(Calendar.DATE, 1);
                    String toDate=dateFormat.format(currentCal.getTime());
                    return toDate;

                case 2:
                    SimpleDateFormat dateFormat1= new SimpleDateFormat("EEE dd");
                    Calendar currentCal1 = Calendar.getInstance();
                    String currentdate1=dateFormat1.format(currentCal1.getTime());
                    currentCal1.add(Calendar.DATE, 2);
                    String toDate1=dateFormat1.format(currentCal1.getTime());
                    return toDate1;
                case 3:
                    SimpleDateFormat dateFormat2= new SimpleDateFormat("EEE dd");
                    Calendar currentCal2 = Calendar.getInstance();
                    String currentdate2=dateFormat2.format(currentCal2.getTime());
                    currentCal2.add(Calendar.DATE, 3);
                    String toDate2=dateFormat2.format(currentCal2.getTime());
                    return toDate2;
                case 4:
                    SimpleDateFormat dateFormat3= new SimpleDateFormat("EEE dd");
                    Calendar currentCal3 = Calendar.getInstance();
                    String currentdate3=dateFormat3.format(currentCal3.getTime());
                    currentCal3.add(Calendar.DATE, 4);
                    String toDate3=dateFormat3.format(currentCal3.getTime());
                    return toDate3;
                case 5:
                    SimpleDateFormat dateFormat4= new SimpleDateFormat("EEE dd");
                    Calendar currentCal4 = Calendar.getInstance();
                    String currentdate4=dateFormat4.format(currentCal4.getTime());
                    currentCal4.add(Calendar.DATE, 5);
                    String toDate4=dateFormat4.format(currentCal4.getTime());
                    return toDate4;

            }
            return null;
        }
    }
}
