package com.psoft.myapplication.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;



public class CarouselBannerLayout extends LinearLayout {
    private float mScale = AppConstant.BIG_SCALE;

    public CarouselBannerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarouselBannerLayout(Context context) {
        super(context);
    }

    public void setScaleBoth(float scale) {
        this.mScale = scale;
        this.invalidate();    // If you want to see the mScale every time you set
        // mScale you need to have this line here,
        // invalidate() function will call onDraw(Canvas)
        // to redraw the view for you
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // The main mechanism to display mScale animation, you can customize it
        // as your needs
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(mScale, mScale, w / 2, h / 2);

        super.onDraw(canvas);
    }
}