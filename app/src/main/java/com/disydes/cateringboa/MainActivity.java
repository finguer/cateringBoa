package com.disydes.cateringboa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
       // viewPager.setAdapter(new myAdapter(getSupportFragmentManager()));






    }



    /*public class myAdapter extends FragmentPagerAdapter{

        public myAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 0){
                return new NewsFragment();
            }else {
                return new NewsFragment();
            }
        }

        @Override
        public int getCount() {
            return 0;
        }*/


}
