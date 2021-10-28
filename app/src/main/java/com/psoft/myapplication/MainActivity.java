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
    ViewPager carouselView;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView=findViewById(R.id.activity_main_view_pager);
        CarouselViewManager cv = new CarouselViewManager(MainActivity.this,carouselView);

        ArrayList<String> images = new ArrayList<>();
        getImages(images);
        cv.setup( this.getSupportFragmentManager(), images, false);
        //cv.animate(3000, 3000);

    }

    private void getImages(ArrayList<String> images) {

        images.add(("https://visme.co/blog/wp-content/uploads/2019/08/header-1200.gif"));

        images.add(("https://academics.design.ncsu.edu/yesand/wp-content/uploads/2017/11/Coca-Cola-1024x663.png"));

    }
}