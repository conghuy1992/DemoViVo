package com.mobile.vivo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Highlight.MovieAdapter;
import com.mobile.vivo.Model.MovieDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 26/12/2017.
 */

public class ProfileHistory extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<MovieDto> movieDtoList;
    private String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_history);
        context = this;

        Intent intent = getIntent();
        try {
            title = intent.getStringExtra(Statics.MENU_TITLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setTitle(Const.getMsg(context, R.string.history));
            getSupportActionBar().setTitle(title);
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
        initDB();
    }

    private void initDB() {
//        private List<MovieDto> movieDtoList;

        for (int i = 0; i < 4; i++) {
            MovieDto obj = new MovieDto();
            obj.movieTitle = "ABC " + i;
            movieDtoList.add(obj);
        }
        MovieDto obj = new MovieDto();
        obj.type = Statics.MOVIE_LOAD_MORE;
        movieDtoList.add(obj);
        adapter.update(movieDtoList);
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
