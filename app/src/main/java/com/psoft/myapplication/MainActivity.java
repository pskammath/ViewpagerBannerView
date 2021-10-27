package com.psoft.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.psoft.myapplication.carousel.AppConstant;
import com.psoft.myapplication.carousel.CarouselBannerPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.psoft.myapplication.carousel.AppConstant.FIRST_PAGE;
import static com.psoft.myapplication.carousel.AppConstant.PAGES;


public class MainActivity extends AppCompatActivity {


    private CarouselBannerPager mAdapter;
    ViewPager mViewPager;
    private int currentPage=0;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.activity_main_view_pager);


        ArrayList<String> images=new ArrayList<>();

        images.add("https://visme.co/blog/wp-content/uploads/2019/08/header-1200.gif");
        images.add("https://academics.design.ncsu.edu/yesand/wp-content/uploads/2017/11/Coca-Cola-1024x663.png");

        images.add("https://www.marketing91.com/wp-content/uploads/2020/02/Creating-an-effective-Advertising-Campaign-Components-of-a-regular-Advertisement.jpg");

        images.add("https://i.ytimg.com/vi/5SyIMvBlol4/maxresdefault.jpg");
        images.add("https://i.gifer.com/8ufy.gif");
        images.add("https://64.media.tumblr.com/b47ebc475848678989974151ff64a7e5/tumblr_ms9tg6h3Zp1sf00k1o1_500.gifv");
        images.add("https://academics.design.ncsu.edu/yesand/wp-content/uploads/2017/11/Coca-Cola-1024x663.png");

        images.add("https://visme.co/blog/wp-content/uploads/2019/08/header-1200.gif");
        images.add("https://i.gifer.com/8ufy.gif");


        PAGES=images.size();

        mAdapter = new CarouselBannerPager(this, this.getSupportFragmentManager(),images);

        mViewPager.setAdapter(mAdapter);


        /*After setting the adapter use the timer */



        mViewPager.setPageTransformer(false, mAdapter);



        // Set current item to the middle page so we can fling to both
        // directions left and right

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == PAGES) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);



       // mViewPager.setCurrentItem(FIRST_PAGE);

        // Necessary or the mViewPager will only have one extra page to show
        // make this at least however many pages you can see
        //mViewPager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        //mViewPager.setPageMargin(-400);

    }
}