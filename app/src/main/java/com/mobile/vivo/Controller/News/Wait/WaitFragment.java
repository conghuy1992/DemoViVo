package com.mobile.vivo.Controller.News.Wait;

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
import com.mobile.vivo.Controller.TVShow.TVShowAdapter;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.Model.WaitDto;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class WaitFragment extends Fragment {
    private String TAG = "WaitFragment";
    private RecyclerView recyclerView;
    private List<TVShowDto> waitDtoList;
    private TVShowAdapter adapter;

    private void initView(View v) {
        waitDtoList = new ArrayList<>();
        adapter = new TVShowAdapter(getActivity(), waitDtoList,
                Const.getWidthImageMovie(getActivity()), Const.getHeightImageMovie(getActivity()));
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        initDB();
    }

    private void initDB() {
        List<MovieDto> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Const.LATEST_NEWS_COVER(Statics.WAIT_LIST_COVER));
        }
        WaitDto obj = new WaitDto();
        obj.lastNewsDtoList = list;
        TVShowDto tvShowDto = new TVShowDto();
        tvShowDto.type = Statics.WAIT_LIST_COVER;
        tvShowDto.waitDto = obj;
        waitDtoList.add(tvShowDto);

        // categoryList
        tvShowDto = new TVShowDto();
        tvShowDto.type = Statics.WAIT_CONTENT;
        tvShowDto.waitDto = Const.categoryList();
        tvShowDto.type = Statics.WAIT_CATEGORY;
        waitDtoList.add(tvShowDto);

        // WAIT_COVER
        obj = new WaitDto();
        obj.lastNewsDto = Const.LATEST_NEWS_COVER(Statics.WAIT_COVER);
        tvShowDto = new TVShowDto();
        tvShowDto.type = Statics.WAIT_COVER;
        tvShowDto.waitDto = obj;
        waitDtoList.add(tvShowDto);

        // WAIT_CONTENT
        waitDtoList.add(Const.waitContent());
        waitDtoList.add(Const.waitContent());
        waitDtoList.add(Const.waitContent());

        adapter.update(waitDtoList);
    }

    public WaitFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_fragment_wait_fragment, container, false);
        initView(v);
        return v;
    }
}
