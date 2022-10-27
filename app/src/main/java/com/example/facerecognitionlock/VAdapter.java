package com.example.facerecognitionlock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext=new ArrayList<>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    public VAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items =new ArrayList<Fragment>();

        items.add(new Fragment_Lock());
        items.add(new Fragment_userManagement());
        items.add(new Fragment_visitors());


        itext.add("도어락 제어");
        itext.add("사용자 관리");
        itext.add("출입 기록");



    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
