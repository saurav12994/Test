package com.example.sourabh.bookmyticket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.StaticLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
ViewPager viewPager;
  //  CustomSwipeAdapter adapter;
    Animation Fade_in,Fade_out;
    ViewFlipper viewFlipper;
    Context context;
    ArrayList progList;
    public static  Integer [] progImages ={ R.drawable.hqdefault,R.drawable.jagga,R.drawable.karan

    };
    String[] film={"Raess","Jagga Jassos","karan arjun"};
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* viewPager=(ViewPager)findViewById(R.id.viewpager);
        adapter=new CustomSwipeAdapter(getApplicationContext(),R.layout.swipe_layout);
        viewPager.setAdapter(adapter);*/
        viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
        Fade_in= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Fade_out= AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        viewFlipper.setInAnimation(Fade_in);
        viewFlipper.setOutAnimation(Fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
        Intent intent=getIntent();
        String u=intent.getStringExtra("U");
        MyListAdapter adapter= new MyListAdapter(this,film,progImages);
listView=(ListView)findViewById(R.id.listView);
        // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,film);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.textuser);
        nav_user.setText(u);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            profFragment fragment=new profFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();
        } else if (id == R.id.nav_gallery) {
            ShowFragment fragment=new ShowFragment();
            FragmentManager ft1=getSupportFragmentManager();
            ft1.beginTransaction().replace(R.id.relative1,fragment).commit();
        }  else if (id == R.id.nav_share) {
           ShareFragment fragment=new ShareFragment();
            FragmentManager ft2=getSupportFragmentManager();
            ft2.beginTransaction().replace(R.id.relative1,fragment).commit();
        } else if (id == R.id.nav_send) {
            Intent i=new Intent(MainActivity.this,loginActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
