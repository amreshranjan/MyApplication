package com.example.amresh.mydresskode;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    //private SliderLayout mDemoSlider;
    ListView lvContainer;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    GridView gvFooter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlanetTitles = getResources().getStringArray(R.array.string_array_name);

        setSupportActionBar((Toolbar) findViewById(R.id.app_bar_main_id));
        System.out.println("Motu: In Main");
        lvContainer = (ListView) findViewById(R.id.ListViewContainer);
        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        ArrayAdapter<String> mAdaptor = new ArrayAdapter<String>(getApplicationContext(), R.layout.drawer_list_item, R.id.txtDrawer,mPlanetTitles);
        mDrawerList.setAdapter(mAdaptor);
        // Set the list's click listener
      // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        lvContainer.setAdapter(new ListAdapterClass(MainActivity.this));

        gvFooter =(GridView) findViewById(R.id.gridviewFooter);
    }




}