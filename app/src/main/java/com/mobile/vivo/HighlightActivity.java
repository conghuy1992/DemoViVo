package com.mobile.vivo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Highlight.Country.CountryFragment;
import com.mobile.vivo.Controller.Highlight.Kind.KindFragment;
import com.mobile.vivo.Controller.Highlight.MovieAdapter;
import com.mobile.vivo.Controller.Highlight.Sort.SortFragment;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.View.HeaderView;
import com.mobile.vivo.View.WrapContentHeightViewPager;
import com.mobile.vivo.adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class HighlightActivity extends AppCompatActivity {
    private String TAG = "HighlightActivity";
    private Context context;
    private WrapContentHeightViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<MovieDto> movieDtoList;
    private String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highlight_layout);
        context = this;

        Intent intent=getIntent();
        title=intent.getStringExtra(Statics.MENU_TITLE);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setTitle("Back");
//            View v = Const.headerView(context, title);
            View v = new HeaderView(context, Const.getMsg(context, R.string.app_name));
            if (v != null) {
                getSupportActionBar().setCustomView(v);
                getSupportActionBar().setDisplayShowCustomEnabled(true);
            }
        }
        initView();
    }

    private void initView() {
        movieDtoList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int w = Const.getWidthScreen(this)/2;
        int h = (int) (w*Statics.RATIO_HEIGHT_IMAGE);
        adapter = new MovieAdapter(context, movieDtoList,w,h);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(adapter);


        viewPager = (WrapContentHeightViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        customTabLayout(tabLayout);

        initDB();
    }

    private void initDB() {
//        private List<MovieDto> movieDtoList;

        for (int i = 0; i < 5; i++) {
            MovieDto obj = new MovieDto();
            obj.movieTitle = "ABC " + i;
            movieDtoList.add(obj);
        }

        adapter.update(movieDtoList);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new KindFragment(), "");
        adapter.addFragment(new CountryFragment(), "");
        adapter.addFragment(new SortFragment(), "");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

    }

    private void customTabLayout(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setCustomView(Const.createItemHighlight(context, R.string.kind, R.drawable.ic_hightlight_kind));
        tabLayout.getTabAt(1).setCustomView(Const.createItemHighlight(context, R.string.country, R.drawable.ic_hightlight_kind));
        tabLayout.getTabAt(2).setCustomView(Const.createItemHighlight(context, R.string.sort, R.drawable.ic_hightlight_kind));
        final ViewGroup test = (ViewGroup) (tabLayout.getChildAt(0));
        int tabLen = test.getChildCount();
        for (int i = 0; i < tabLen; i++) {
            View v = test.getChildAt(i);
            v.setPadding(0, 0, 0, 0);
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "position:" + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }
}
