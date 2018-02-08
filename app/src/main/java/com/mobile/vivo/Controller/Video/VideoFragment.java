package com.mobile.vivo.Controller.Video;

import android.content.Context;
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
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 20/12/2017.
 */

public class VideoFragment extends Fragment {
    private String TAG = "TVShowActivity";
    private RecyclerView recyclerView;
    private TVShowAdapter adapter;
    private List<TVShowDto> movieDtoList;
    private LinearLayoutManager linearLayoutManager;
    private String title = "";

    private void initView(View v) {
        movieDtoList = new ArrayList<>();
        adapter = new TVShowAdapter(getActivity(), movieDtoList,
                Const.getWidthImageMovie(getActivity()), Const.getHeightImageMovie(getActivity()));
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        initDB();
    }

    private void initDB() {

        TVShowDto obj = new TVShowDto();
        obj.type = Statics.TV_SHOW_COVER_IMAGE;
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "XEM TIEP";
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "CHUONG TRINH NOI BAT";
        obj.MENU_ID = Statics.MENU_HIGHTLIGHT;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "VIVO EXCLUSIVE";
        obj.MENU_ID = Statics.MENU_VOVI_EXCUSIVE;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "PHIM TRUYEN HINH";
        obj.MENU_ID = Statics.MENU_TV_SERIES;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "PHIM DIEN ANH";
        obj.MENU_ID = Statics.MENU_MOVIE;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "TV SHOW";
        obj.MENU_ID = Statics.MENU_TV_SHOW;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "VIVO KID";
        obj.MENU_ID = Statics.MENU_VIVO_KIDS;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        adapter.update(movieDtoList);
    }

    public VideoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_video_fragment, container, false);
        initView(v);
        return v;
    }
}
