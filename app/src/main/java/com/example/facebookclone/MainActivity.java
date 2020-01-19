package com.example.facebookclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

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

    }


}
