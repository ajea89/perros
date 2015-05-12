package com.example.pyb.Adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.R;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Ajea on 21/04/2015.
 */
public class GalleryPagerAdapter extends PagerAdapter {

    private int[] images = {R.drawable.galeria, R.drawable.galeria1, R.drawable.galeria2, R.drawable.galeria3};

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
        photoView.setImageResource(images[position]);

        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
