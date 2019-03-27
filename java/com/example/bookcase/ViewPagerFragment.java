package com.example.bookcase;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class ViewPagerFragment extends Fragment {


    public ViewPagerFragment() {
        // Required empty public constructor
    }


    ViewPager vp;
    BookDetailsFragment bdFragment;


    PagerAdapter pagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_pager, container, false);
        vp = v.findViewById(R.id.viewPager);

        Resources res = this.getResources();
        final String[] booksArr = res.getStringArray(R.array.bookArr);

        bdFragment = new BookDetailsFragment();
        vp = v.findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getChildFragmentManager());

        for(int i = 0; i < booksArr.length; i++){
            bdFragment = BookDetailsFragment.newInstance(booksArr[i]);
            pagerAdapter.add(bdFragment);
        }

        vp.setAdapter(pagerAdapter);

        return v;
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        ArrayList<BookDetailsFragment> pagerFragments;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            pagerFragments = new ArrayList<>();
        }

        public void add(BookDetailsFragment fragment){
            pagerFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int i) {
            return pagerFragments.get(i);
        }

        @Override
        public int getCount() {
            return pagerFragments.size();
        }
    }

}
