package com.mobile.vivo.Controller.News.LatestNews.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

/**
 * Created by android on 25/12/2017.
 */

public class LatestNewsTitleVH extends RecyclerView.ViewHolder {
    private TextView tvTitle;
    public LatestNewsTitleVH(View itemView) {
        super(itemView);
        tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
    }
    public void handler(MovieDto dto, int position){
        tvTitle.setText(dto.title);
    }
}
