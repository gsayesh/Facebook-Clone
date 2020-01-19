package com.example.facebookclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdaptor extends FragmentPagerAdapter {


    public MyFragmentAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return FragmentOne.newInstance();
            case 1: return FragmentTwo.newInstance();
            case 2: return FragmentThree.newInstance();
            case 3: return FragmentFour.newInstance();
            default: return FragmentOne.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position+1);
    }
}