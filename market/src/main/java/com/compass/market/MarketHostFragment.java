package com.compass.market;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.compass.common.EmptyFragment;
import com.compass.common.base.BaseFragment;
import com.compass.market.hangqing.HangQingFragment;
import com.compass.market.view.CompassTabView;
import com.compass.market.view.EasyFragment;

import java.util.ArrayList;
import java.util.List;

public class MarketHostFragment extends BaseFragment {

    Button dayNight;
    Button search;
    CompassTabView tabView;
    ViewPager viewPager;
    FragmentAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.market_fragment_host;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dayNight = view.findViewById(R.id.theme_style);
        search = view.findViewById(R.id.add_stock);
        tabView = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);

        List<EasyFragment> list = new ArrayList<>();
        Fragment fragment1 = new HangQingFragment();
        Fragment fragment2 = new EmptyFragment();
        Fragment fragment3 = new EmptyFragment();
        Fragment fragment4 = new EmptyFragment();
        Fragment fragment5 = new EmptyFragment();
        list.add(new EasyFragment(fragment1,"行情"));
        list.add(new EasyFragment(fragment2,"自选股"));
        list.add(new EasyFragment(fragment3,"特色盯盘"));
        list.add(new EasyFragment(fragment4,"龙虎榜"));
        list.add(new EasyFragment(fragment5,"消息榜"));


        adapter = new FragmentAdapter(getChildFragmentManager(),list);
        viewPager.setOffscreenPageLimit(list.size());
        viewPager.setAdapter(adapter);
        tabView.setViewPager(viewPager);
        tabView.onViewCreate();
        viewPager.addOnPageChangeListener(new PageChangeListener());
    }


    private class FragmentAdapter extends FragmentPagerAdapter {

        private List<EasyFragment> mFragments;

        public FragmentAdapter(FragmentManager fm, List<EasyFragment> mFragments) {
            super(fm);
            this.mFragments = mFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position).getFragment();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getName();
        }
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
