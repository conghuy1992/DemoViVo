package com.mobile.vivo.Controller.Live;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.Model.LiveNext;
import com.mobile.vivo.Model.LiveNow;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 20/12/2017.
 */

public class LiveFragment extends Fragment {
    private LiveAdapter adapter;
    private RecyclerView recyclerView;
    private List<LiveDto> liveDtoList;

    private void initView(View v) {
        liveDtoList = new ArrayList<>();
        adapter = new LiveAdapter(getActivity(), liveDtoList);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        initDB();
    }

    private void initDB() {

        liveDtoList.add(Const.liveCover());
        liveDtoList.add(Const.liveTitle("COMMENT"));
        liveDtoList.add(Const.liveCommentBox());
        liveDtoList.add(Const.liveUserComment());
        liveDtoList.add(Const.liveUserComment());
        liveDtoList.add(Const.liveUserComment());

        adapter.update(liveDtoList);

    }

    public LiveFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_live_fragment, container, false);
        initView(v);
        return v;
    }
}
