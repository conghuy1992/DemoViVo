package com.mobile.vivo.Controller.TVShow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;

/**
 * Created by android on 25/12/2017.
 */

public class TVShowLoadMoreVH extends RecyclerView.ViewHolder {
    private TextView tvLoadMore;

    public TVShowLoadMoreVH(View itemView) {
        super(itemView);
        tvLoadMore = (TextView) itemView.findViewById(R.id.tvLoadMore);
    }

    public void handler(TVShowDto dto, int position) {
        tvLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}