package com.example.admin.movie.Tab;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.admin.movie.R;
import com.example.admin.movie.fragment.homefragment;
import com.example.admin.movie.fragment.moviefragment;
import com.example.admin.movie.fragment.timefragment;

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"A", "B", "C", "D"};
    int[] icon = new int[]{R.drawable.homeicon,R.drawable.movieicon,R.drawable.timeicon};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new homefragment();
        } else if (position == 1) {
            frag = new moviefragment();
        } else if (position == 2) {
            frag = new timefragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0, 0, heightIcon, heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
}