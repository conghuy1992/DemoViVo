package com.mobile.vivo.Controller.News.LatestNews;

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
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class LatestNewsFragment extends Fragment {
    private String TAG = "LatestNewsFragment";
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
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_COVER));

        // LATEST_NEWS_LINE
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_LINE));

        // LATEST_NEWS_CONTENT
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_CONTENT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_CONTENT));

        // trend
        lastNewsDtoList.add(Const.LATEST_NEWS_TITLE(Const.getMsg(getActivity(), R.string.trend)));

        // LATEST_NEWS_TREND
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_TREND));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_TREND));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_TREND));

        // do_not_miss
        lastNewsDtoList.add(Const.LATEST_NEWS_TITLE(Const.getMsg(getActivity(), R.string.do_not_miss)));

        // LATEST_NEWS_COVER
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_COVER));

        // LATEST_NEWS_LINE
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_LINE));

        // LATEST_NEWS_CONTENT
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_CONTENT));
        lastNewsDtoList.add(Const.LATEST_NEWS_COVER(Statics.LATEST_NEWS_CONTENT));

        adapter.update(lastNewsDtoList);
    }

    public LatestNewsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_fragment_latest_news_fragment, container, false);
        initView(v);
        return v;
    }
}
