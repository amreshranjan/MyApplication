package com.example.amresh.mydresskode;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by Amresh on 2/8/2016.
 */
public class ListAdapterClass extends BaseAdapter implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    Context context;
    SliderLayout mDemoSlider;

 public  ListAdapterClass(Context context)
    {
        System.out.println("Motu: In constructr");
        this.context=context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("Motu: in GetView position"+ String.valueOf(position));
        View v =null;
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)context.getSystemService(inflater);
        switch (position)
        {
            case 0:
                v = li.inflate(R.layout.slider_item, null);
                System.out.println("Motu: In Slider View ?");
                fillSlider(context, v);
                break;
            case 1:
                v = li.inflate(R.layout.content_main, null);
                GridView gridview = (GridView)v.findViewById(R.id.gridview);
                gridview.setAdapter(new ImageAdapter(context));
                break;

        }

        return v;

    }

    public void fillSlider(Context context,View v)
    {
        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);
        System.out.println("MotuDiwa: In fillslider");

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Slider_1", "http://s10.postimg.org/9llrbkh6x/Slider_1.jpg");
        url_maps.put("Slider_2", "http://s10.postimg.org/u3bb0yio9/Slider_2.jpg");
        url_maps.put("Slider_3", "http://s22.postimg.org/a1fuihjap/Slider_3.jpg");
        url_maps.put("Slider_4", "http://s15.postimg.org/xs8r09357/slider_4.jpg");

        /*url_maps.put("Slider_1", R.drawable.slider_1);
        url_maps.put("Slider_2", R.drawable.slider_2);
        url_maps.put("Slider_3", R.drawable.slider_3);
        url_maps.put("Slider_4", R.drawable.slider_4);
*/


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(context);
            // initialize a SliderLayout
            textSliderView
                    /*.description(name)*/
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        //mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());


        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }



    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
