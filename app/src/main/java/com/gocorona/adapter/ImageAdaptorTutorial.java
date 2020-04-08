package com.gocorona.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.gocorona.R;

public class ImageAdaptorTutorial extends PagerAdapter {

private Context mContext;
private int[] mImageids = new int[] {R.mipmap.phonepic,R.mipmap.logosplash};

public ImageAdaptorTutorial(Context context){
    mContext = context;
}
    @Override
    public int getCount() {
        return mImageids.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageview = new ImageView(mContext);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(mImageids[position]);
        container.addView(imageview,0);
        return imageview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
