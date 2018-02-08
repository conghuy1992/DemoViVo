package com.mobile.vivo.Controller.News.Videos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Controller.News.Videos.Fragments.VideoHotFragment;
import com.mobile.vivo.R;
import com.mobile.vivo.adapters.ViewPagerAdapter;

/**
 * Created by android on 25/12/2017.
 */

public class VideosFragment extends Fragment {
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
        adapter.addFragment(new VideoHotFragment(), Const.getMsg(getActivity(),R.string.videos_news));
        adapter.addFragment(new VideoHotFragment(), Const.getMsg(getActivity(),R.string.video_hot));
        adapter.addFragment(new VideoHotFragment(), Const.getMsg(getActivity(),R.string.video_all));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

    }
    public VideosFragment(){}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_fragment_videos_fragment, container, false);
        initView(v);
        return v;
    }
}
