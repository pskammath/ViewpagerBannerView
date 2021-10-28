package com.psoft.myapplication.carousel;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.psoft.myapplication.Banners;
import com.psoft.myapplication.R;

import java.util.ArrayList;


public class BannerFragment extends Fragment {


    public static Fragment newInstance(Activity context, int position, float scale, ArrayList<String> imageUrl) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);

        ArrayList<String> urls=new ArrayList<>();



        bundle.putStringArrayList("urls",imageUrl);


        return Fragment.instantiate(context, BannerFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.banner_layout_item, container, false);

        assert this.getArguments() != null;
        int position = this.getArguments().getInt("position");
        TextView textView = (TextView) linearLayout.findViewById(R.id.item_text);
        textView.setText(String.valueOf(position));

        CarouselBannerLayout root = (CarouselBannerLayout) linearLayout.findViewById(R.id.item_root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        ImageView img= linearLayout.findViewById(R.id.urlImage);



        ArrayList<String> urls= this.getArguments().getStringArrayList("urls");

       try {
           Glide.with(requireContext())
                   .load(urls.get(position))
                   .centerCrop()
                   .into(img);
       }catch(Exception e)
       {
           Glide.with(requireContext())
                   .load(urls.get(0))
                   .centerCrop()
                   .into(img);
       }


        return linearLayout;
    }
}