package com.mobile.vivo.Controller.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

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

public class SearchFragment extends Fragment implements View.OnClickListener {
    private String TAG = "SearchFragment";
    private RecyclerView recyclerView;
    private List<TVShowDto> tvShowDtoList;
    private TVShowAdapter adapter;
    private ImageView ivClear;
    private EditText edSearch;

    private void initView(View v) {
        ivClear = (ImageView) v.findViewById(R.id.ivClear);
        ivClear.setOnClickListener(this);
        ivClear.setVisibility(View.GONE);

        edSearch = (EditText) v.findViewById(R.id.edSearch);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = charSequence.toString();
                if (s == null) return;

                if (s.trim().length() > 0) ivClear.setVisibility(View.VISIBLE);
                else ivClear.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // w: 300/3=100;
        // h:

        tvShowDtoList = new ArrayList<>();
        adapter = new TVShowAdapter(getActivity(), tvShowDtoList,
                Const.getWidthImageMovie(getActivity()), Const.getHeightImageMovie(getActivity()));
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        initDB();
    }

    private void initDB() {
        TVShowDto obj = new TVShowDto();
        obj.type = Statics.SEARCH_TITLE;
        obj.title = Const.getMsg(getActivity(), R.string.search_title);
        tvShowDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "CHUONG TRINH NOI BAT";
        obj.MENU_ID = Statics.MENU_HIGHTLIGHT;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        tvShowDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "VIVO EXCLUSIVE";
        obj.MENU_ID = Statics.MENU_VOVI_EXCUSIVE;
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        tvShowDtoList.add(obj);

        // WAIT_CONTENT
        tvShowDtoList.add(Const.waitContent());
        tvShowDtoList.add(Const.waitContent());
        tvShowDtoList.add(Const.waitContent());


        adapter.update(tvShowDtoList);
    }

    public SearchFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_search_fragment, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == ivClear) {
            edSearch.setText("");
            Const.hideKeyboardFrom(getContext(),edSearch);
        }
    }
}
