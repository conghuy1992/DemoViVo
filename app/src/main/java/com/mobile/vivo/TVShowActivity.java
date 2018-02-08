package com.mobile.vivo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.TVShow.TVShowAdapter;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.View.HeaderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class TVShowActivity extends AppCompatActivity {
    private String TAG = "TVShowActivity";
    private Context context;
    private RecyclerView recyclerView;
    private TVShowAdapter adapter;
    private List<TVShowDto> movieDtoList;
    private LinearLayoutManager linearLayoutManager;
    private String title = "";

    private void initView() {
        movieDtoList = new ArrayList<>();
        adapter = new TVShowAdapter(context, movieDtoList,
                Const.getWidthImageMovie(this), Const.getHeightImageMovie(this));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        initDB();
    }

    private void initDB() {

        TVShowDto obj = new TVShowDto();
        obj.type = Statics.TV_SHOW_COVER_IMAGE;
        movieDtoList.add(obj);

        obj = new TVShowDto();
        obj.title = "NHIEU NGUOI XEM";
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);


        obj = new TVShowDto();
        obj.title = "TAT CA";
        obj.type = Statics.TV_SHOW_MANY_VIEW;
        obj.movieDtoList = Const.createMovieDtoList();
        movieDtoList.add(obj);

        adapter.update(movieDtoList);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_show_layout);
        this.context = this;

        Intent intent = getIntent();
        title = intent.getStringExtra(Statics.MENU_TITLE);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setTitle(title);

//            View v = Const.headerView(context, title);
            View v = new HeaderView(context, Const.getMsg(context, R.string.app_name));
            if (v != null) {
                getSupportActionBar().setCustomView(v);
                getSupportActionBar().setDisplayShowCustomEnabled(true);
            }
        }
        initView();
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
