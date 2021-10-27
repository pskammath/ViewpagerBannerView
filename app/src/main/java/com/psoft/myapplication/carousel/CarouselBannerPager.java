package com.psoft.myapplication.carousel;

import android.app.Activity;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.psoft.myapplication.R;

import java.util.ArrayList;


public class CarouselBannerPager extends FragmentPagerAdapter implements ViewPager.PageTransformer {
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    private Activity mContext;
    private FragmentManager mFragmentManager;
    private float mScale;
    ArrayList<String> imageUrl;

    public CarouselBannerPager(Activity context, FragmentManager fragmentManager, ArrayList<String> images) {
        super(fragmentManager);
        this.mFragmentManager = fragmentManager;
        this.mContext = context;
        this.imageUrl=images;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first mViewPager bigger than others
        if (position == AppConstant.FIRST_PAGE)
            mScale = BIG_SCALE;
        else
            mScale = SMALL_SCALE;

        return BannerFragment.newInstance(mContext, position, mScale, imageUrl);
    }



    @Override
    public int getCount() {
        return AppConstant.PAGES;
    }

    @Override
    public void transformPage(View page, float position) {
        CarouselBannerLayout myLinearLayout = (CarouselBannerLayout) page.findViewById(R.id.item_root);
        float scale = BIG_SCALE;
        if (position > 0) {
            scale = scale - position * DIFF_SCALE;
        } else {
            scale = scale + position * DIFF_SCALE;
        }
        if (scale < 0) scale = 0;
        myLinearLayout.setScaleBoth(scale);


        //cube
//        if (position < -1) {
//            page.setAlpha(0);
//        } else if (position <= 0) {
//            page.setAlpha(1);
//            page.setPivotX(page.getWidth());
//            page.setRotation(-90 * Math.abs(position));
//        } else if (position <= 1) {
//            page.setAlpha(1);
//            page.setPivotX(0);
//            page.setRotationY(90 * Math.abs(position));
//        } else {
//            page.setAlpha(0);
//        }
        //gate

        page.setTranslationX(-position*page.getWidth());



        if (position<-1){    // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        }
        else if (position<=0){    // [-1,0]
            page.setAlpha(1);
            page.setPivotX(0);
            page.setRotationY(90*Math.abs(position));

        }
        else if (position <=1){    // (0,1]
            page.setAlpha(1);
            page.setPivotX(page.getWidth());
            page.setRotationY(-90*Math.abs(position));

        }else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);

        }

    }
}
