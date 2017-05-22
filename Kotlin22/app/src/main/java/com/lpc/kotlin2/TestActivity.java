package com.lpc.kotlin2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lpc.kotlin2.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eml19 on 2017/5/21.
 */

public class TestActivity extends AppCompatActivity {


    private FragmentPagerAdapter adapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        FragmentManager manager = getSupportFragmentManager() ;
        manager.beginTransaction();
//        manager.putFragment();

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return null;
            }

            @Override
            public int getCount() {
                return 0;
            }
        };


        List<Fragment> fragments = new ArrayList<>() ;
        fragments.add(new HomeFragment().getFragment("title"));


        View view = new View(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });
    }
}
