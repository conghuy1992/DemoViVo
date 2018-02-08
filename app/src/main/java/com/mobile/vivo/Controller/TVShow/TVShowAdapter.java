package com.mobile.vivo.Controller.TVShow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.News.LatestNews.ViewHolder.LatestNewsCoverVH;
import com.mobile.vivo.Controller.News.Wait.ViewHolder.WaitCategoryVH;
import com.mobile.vivo.Controller.News.Wait.ViewHolder.WaitCoverVH;
import com.mobile.vivo.Controller.Search.ViewHolder.SearchTitleVH;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.Model.WaitDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class TVShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TVShowDto> movieDtoList;
    private String TAG = "TVShowAdapter";
    private int widthImage;
    private int heightImage;

    public TVShowAdapter(Context context, List<TVShowDto> movieDtoList, int widthImage, int heightImage) {
        this.context = context;
        this.movieDtoList = movieDtoList;
        this.widthImage = widthImage;
        this.heightImage = heightImage;
    }

    public void update(List<TVShowDto> movieDtoList) {
        if (movieDtoList == null) return;
        this.movieDtoList = movieDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        // TV SHOW
        if (viewType == Statics.TV_SHOW_MANY_VIEW) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.tv_show_many_view, parent, false);
            vh = new TVShowManyViewVH(v, context, widthImage, heightImage);
        } else if (viewType == Statics.TV_SHOW_LOAD_MORE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.tv_show_load_more, parent, false);
            vh = new TVShowLoadMoreVH(v);
        }

        // START WAIT LIST
        else if (viewType == Statics.WAIT_LIST_COVER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_wait_cover, parent, false);
            vh = new WaitCoverVH(v, context);
        } else if (viewType == Statics.WAIT_CATEGORY) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_wait_category, parent, false);
            vh = new WaitCategoryVH(v, context);
        } else if (viewType == Statics.WAIT_COVER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_cover, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.WAIT_COVER);
        } else if (viewType == Statics.WAIT_CONTENT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_content, parent, false);
            vh = new LatestNewsCoverVH(v, Statics.WAIT_CONTENT);
        }

        // SEARCH
        else if (viewType == Statics.SEARCH_TITLE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_fragment_latest_news_title, parent, false);
            vh = new SearchTitleVH(v, Statics.SEARCH_TITLE);
        } else if (viewType == Statics.SEARCH_RESULT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.search_holder, parent, false);
            vh = new SearchTitleVH(v, Statics.SEARCH_RESULT);
        }

        // TV SHOW COVER IMAGE
        else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.tv_show_cover_image, parent, false);
            vh = new CoverImageVH(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TVShowDto tvShowDto = movieDtoList.get(position);
        WaitDto waitDto = tvShowDto.waitDto;
        if (holder instanceof CoverImageVH) {
            ((CoverImageVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof TVShowManyViewVH) {
            ((TVShowManyViewVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof TVShowLoadMoreVH) {
            ((TVShowLoadMoreVH) holder).handler(tvShowDto, position);
        }

        // wait object
        else if (holder instanceof WaitCoverVH) {
            ((WaitCoverVH) holder).handler(waitDto, position);
        } else if (holder instanceof WaitCategoryVH) {
            ((WaitCategoryVH) holder).handler(waitDto, position);
        } else if (holder instanceof LatestNewsCoverVH) {
            ((LatestNewsCoverVH) holder).handler(waitDto.lastNewsDto, position);
        }

        // search

        else if (holder instanceof SearchTitleVH) {
            ((SearchTitleVH) holder).handler(tvShowDto, position);
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