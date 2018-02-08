package com.mobile.vivo.Controller.Highlight.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

/**
 * Created by android on 26/12/2017.
 */

public class MovieLoadMoreVH extends RecyclerView.ViewHolder {
    private TextView tvLoadMore;
    public MovieLoadMoreVH(View itemView) {
        super(itemView);
        tvLoadMore=(TextView)itemView.findViewById(R.id.tvLoadMore);
    }

    public void handler(final MovieDto dto, final int position) {
        tvLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
