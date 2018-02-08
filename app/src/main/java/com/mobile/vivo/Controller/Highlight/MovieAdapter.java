package com.mobile.vivo.Controller.Highlight;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Highlight.ViewHolder.MovieLoadMoreVH;
import com.mobile.vivo.Controller.Highlight.ViewHolder.MovieVH;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MovieDto> movieDtoList;
    private String TAG = "MovieAdapter";
    private int w,h;
    public MovieAdapter(Context context, List<MovieDto> movieDtoList,int w,int h) {
        this.context = context;
        this.movieDtoList = movieDtoList;
        this.w=w;
        this.h=h;
    }

    public void update(List<MovieDto> movieDtoList) {
        if (movieDtoList == null) return;
        this.movieDtoList = movieDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == Statics.MOVIE_LOAD_MORE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.highlight_movie_load_more_layout, parent, false);
            vh = new MovieLoadMoreVH(v);
        } else { // MOVIE_ITEM
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.highlight_movie_layout, parent, false);
            vh = new MovieVH(v,context,w,h);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieDto videoDto = movieDtoList.get(position);
        if (holder instanceof MovieVH) {
            ((MovieVH) holder).handler(videoDto, position);
        } else if (holder instanceof MovieLoadMoreVH) {
            ((MovieLoadMoreVH) holder).handler(videoDto, position);
        }


    }

    @Override
    public int getItemViewType(int position) {
        return movieDtoList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return movieDtoList.size();
    }
}