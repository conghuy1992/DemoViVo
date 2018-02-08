package com.mobile.vivo.Controller.News.Videos.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.News.LatestNews.LatestNewsAdapter;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class VideoHotFragment extends Fragment {
    private RecyclerView recyclerView;
    private LatestNewsAdapter adapter;
    private List<MovieDto> lastNewsDtoList;
    private void initView(View v) {
        lastNewsDtoList = new ArrayList<>();
        adapter = new LatestNewsAdapter(getActivity(), lastNewsDtoList);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        initDB();
    }
    private void initDB() {
        // LATEST_NEWS_COVER
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.VIDEOS_HOT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.VIDEOS_HOT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.VIDEOS_HOT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.VIDEOS_HOT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.VIDEOS_HOT));


        adapter.update(lastNewsDtoList);
    }
    public VideoHotFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_fragment_videos_hot, container, false);
        initView(v);
        return v;
    }
}
