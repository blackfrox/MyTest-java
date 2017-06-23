package com.example.mygame.activity;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mygame.R;
import com.example.mygame.adapter.MyFragmentPagerAdapter;
import com.example.mygame.zhihudaily.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private NewsFragment fragment=null;
    TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Fragment> fragmentList;
    MyFragmentPagerAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new NewsFragment());

        tabLayout= (TabLayout) findViewById(R.id.tab_layout);


        viewPager= (ViewPager) findViewById(R.id.viewpager);
        fragmentAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(ColorStateList.valueOf(R.color.black));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("知乎");
    }
}
