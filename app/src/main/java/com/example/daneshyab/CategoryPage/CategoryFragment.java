package com.example.daneshyab.CategoryPage;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daneshyab.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    private ViewPager view_pager;
    private SectionsPagerAdapter viewPagerAdapter;
    private TabLayout tab_layout;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initComponent(view);
        initToolbar(view);

        return view;
    }

    private void initToolbar(View view) {
        AppCompatActivity parent = (AppCompatActivity)getActivity();
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.category_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_round_more_vert_24px);
        parent.setSupportActionBar(toolbar);
        parent.getSupportActionBar().setTitle(R.string.app_name_second);
        parent.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        parent.getSupportActionBar().setElevation(4);
    }

    private  void initComponent(View view) {
        view_pager = view.findViewById(R.id.view_pager);
        tab_layout = view.findViewById(R.id.tab_layout);
        setupViewPager(view_pager);

        tab_layout.setupWithViewPager(view_pager);

        tab_layout.getTabAt(0).setIcon(R.drawable.ic_dashboard_black_24dp);
        tab_layout.getTabAt(1).setIcon(R.drawable.ic_notifications_black_24dp);
        tab_layout.getTabAt(2).setIcon(R.drawable.ic_round_search_24px);

        // set icon color pre-selected
        tab_layout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        AppCompatActivity parent = (AppCompatActivity)getActivity();
        viewPagerAdapter = new SectionsPagerAdapter(parent.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentFields(), getString(R.string.tab_name_fields));    // index 2
        viewPagerAdapter.addFragment(new FragmentSchools(), getString(R.string.tab_name_schools));   // index 1
        viewPagerAdapter.addFragment(new FragmentLessons(), getString(R.string.tab_name_lessons));    // index 0
        viewPager.setAdapter(viewPagerAdapter);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
