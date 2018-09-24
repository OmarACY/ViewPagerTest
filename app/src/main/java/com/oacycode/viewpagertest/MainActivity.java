package com.oacycode.viewpagertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author      OmarACY <omaralejandrocy@gmail.com>
 * @version     1.0
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnFragmentStatePager).setOnClickListener(this);
        findViewById(R.id.btnFragmentPager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        if(v.getId() == R.id.btnFragmentPager){
            i = new Intent(this, FragmentPager.class);
        }else if (v.getId() == R.id.btnFragmentStatePager){
            i = new Intent(this, FragmentStatePager.class);
        }

        if(i != null) {
            startActivity(i);
        }

    }
}
