package com.example.facebookclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.facebookclone.data.DataBase;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DataBase db;
    ViewPager viewPager;

    MyFragmentAdaptor myFragmentAdaptor;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.fragment_pager);

        myFragmentAdaptor = new MyFragmentAdaptor(getSupportFragmentManager(),1);

        viewPager.setAdapter(myFragmentAdaptor);

        tabLayout.setupWithViewPager(viewPager);
        db = new DataBase(this,DataBase.DB_NAME,null,DataBase.DB_VERSION);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
        tabLayout.getTabAt(2).setIcon(R.drawable.view);

    }



}
