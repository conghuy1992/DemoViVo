package com.mobile.vivo.Controller.News.LatestNews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.News.LatestNews.ViewHolder.LatestNewsCoverVH;
import com.mobile.vivo.Controller.News.LatestNews.ViewHolder.LatestNewsLineVH;
import com.mobile.vivo.Controller.News.LatestNews.ViewHolder.LatestNewsTitleVH;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class LatestNewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MovieDto> lastNewsDtoList;
    private String TAG = "LatestNewsAdapter";

    public LatestNewsAdapter(Context context, List<MovieDto> lastNewsDtoList) {
        this.context = context;
        this.lastNewsDtoList = lastNewsDtoList;
    }

    public void update(List<MovieDto> lastNewsDtoList) {
        if (lastNewsDtoList == null) return;
        this.lastNewsDtoList = lastNewsDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == Statics.LATEST_NEWS_COVER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_cover, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.LATEST_NEWS_COVER);
        }
        // VIDEOS_HOT
        else if (viewType == Statics.VIDEOS_HOT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_cover, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.VIDEOS_HOT);
        } else if (viewType == Statics.LATEST_NEWS_CONTENT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_content, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.LATEST_NEWS_CONTENT);
        } else if (viewType == Statics.LATEST_NEWS_LINE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_line, parent, false);
            vh = new LatestNewsLineVH(v);
        } else if (viewType == Statics.LATEST_NEWS_TREND) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_content, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.LATEST_NEWS_TREND);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_title, parent, false);
            vh = new LatestNewsTitleVH(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieDto tvShowDto = lastNewsDtoList.get(position);
        if (holder instanceof LatestNewsCoverVH) {
            ((LatestNewsCoverVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof LatestNewsTitleVH) {
            ((LatestNewsTitleVH) holder).handler(tvShowDto, position);
        }
//        else if (holder instanceof TVShowLoadMoreVH) {
//            ((TVShowLoadMoreVH) holder).handler(tvShowDto, position);
//        }


    }

    @Override
    public int getItemViewType(int position) {
        return lastNewsDtoList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return lastNewsDtoList.size();
    }
}