package com.oacycode.viewpagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oacycode.viewpagertest.Fragments.ArrayListFragment;
import com.oacycode.viewpagertest.Fragments.QuestionFragment;
import com.oacycode.viewpagertest.Interfaces.FragmentChangeListener;

/**
 * @author      OmarACY <omaralejandrocy@gmail.com>
 * @version     1.0
 */

public class FragmentStatePager extends FragmentActivity implements FragmentChangeListener {

    static final int ITEMS = 10;
    MyAdapter mAdapter;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_pager);

        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        Button button = findViewById(R.id.first);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                replaceFragment(0);
            }
        });
        button = findViewById(R.id.last);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                replaceFragment(ITEMS - 1);
            }
        });
    }

    public static class MyAdapter extends FragmentStatePagerAdapter {
        MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return QuestionFragment.newInstance(position);
                case 1:
                    return QuestionFragment.newInstance(position);
                case 2:
                    return QuestionFragment.newInstance(position);
                default:
                    return ArrayListFragment.init(position);
            }
        }
    }

    public void replaceFragment(int id){
        mPager.setCurrentItem(id);
    }
}
