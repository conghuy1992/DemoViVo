package com.mobile.vivo.Controller.Live;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Live.ViewHolder.LiveCommentBoxVH;
import com.mobile.vivo.Controller.Live.ViewHolder.LiveCoverVH;
import com.mobile.vivo.Controller.Live.ViewHolder.LiveUserCommentVH;
import com.mobile.vivo.Controller.Search.ViewHolder.SearchTitleVH;
import com.mobile.vivo.Model.CommentDto;
import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 28/12/2017.
 */

public class LiveAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<LiveDto> liveDtoList;
    private String TAG = "LiveAdapter";

    public LiveAdapter(Context context, List<LiveDto> liveDtoList) {
        this.context = context;
        this.liveDtoList = liveDtoList;
    }

    public void update(List<LiveDto> liveDtoList) {
        if (liveDtoList == null) return;
        this.liveDtoList = liveDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == Statics.LIVE_TITLE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.search_holder, parent, false);
            vh = new SearchTitleVH(v, Statics.LIVE_TITLE);
        } else if (viewType == Statics.LIVE_COMMENT_BOX) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.live_comment_box, parent, false);
            vh = new LiveCommentBoxVH(v,context);
        } else if (viewType == Statics.LIVE_USER_COMMENT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.live_user_comment, parent, false);
            vh = new LiveUserCommentVH(v, context);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.live_cover, parent, false);
            vh = new LiveCoverVH(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LiveDto tvShowDto = liveDtoList.get(position);
        if (holder instanceof LiveCoverVH) {
            ((LiveCoverVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof SearchTitleVH) {
            TVShowDto obj = new TVShowDto();
            obj.title = tvShowDto.title;
            ((SearchTitleVH) holder).handler(obj, position);
        } else if (holder instanceof LiveCommentBoxVH) {
            ((LiveCommentBoxVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof LiveUserCommentVH) {
            CommentDto commentDto = tvShowDto.commentDto;
            ((LiveUserCommentVH) holder).handler(commentDto, position);
        }


    }

    @Override
    public int getItemViewType(int position) {
        return liveDtoList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return liveDtoList.size();
    }
}