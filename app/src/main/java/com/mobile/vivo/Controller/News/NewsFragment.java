package com.mobile.vivo.Controller.News;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Controller.News.LatestNews.LatestNewsFragment;
import com.mobile.vivo.Controller.News.Videos.VideosFragment;
import com.mobile.vivo.Controller.News.Wait.WaitFragment;
import com.mobile.vivo.R;
import com.mobile.vivo.adapters.ViewPagerAdapter;

/**
 * Created by android on 20/12/2017.
 */

public class NewsFragment extends Fragment {
    private String TAG = "NewsFragment";
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private void initView(View v) {
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new LatestNewsFragment(), Const.getMsg(getActivity(),R.string.latest_news));
        adapter.addFragment(new WaitFragment(), Const.getMsg(getActivity(),R.string.wait_news));
        adapter.addFragment(new VideosFragment(), Const.getMsg(getActivity(),R.string.videos_news));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

    }

    public NewsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_news_fragment, container, false);
        initView(v);
        return v;
    }
}
