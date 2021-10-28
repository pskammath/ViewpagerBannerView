package com.psoft.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.psoft.myapplication.carousel.CarouselBannerPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CarouselViewManager {
    ViewPager pager;
    public int currentPage=0;
    Timer timer;
    int count=0;
    Activity activity;


    public CarouselViewManager(Activity activity, ViewPager pager) {
      this.pager=pager;
      this.activity=activity;
    }

    public void setup(FragmentManager fragmentManager, ArrayList<String> banners, boolean isReverse)
    {


        CarouselBannerPager mAdapter = new CarouselBannerPager(activity,fragmentManager ,banners);

        pager.setPageTransformer(isReverse, mAdapter);
        pager.setAdapter(mAdapter);
        count=banners.size();




    }


    public void animate(int delay, int period)
    {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == count) {
                    currentPage = 0;
                    Log.e("page", currentPage+"");
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, delay, period);
    }


}
