package com.mobile.vivo.Controller.Search.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;

/**
 * Created by android on 25/12/2017.
 */

public class SearchTitleVH extends RecyclerView.ViewHolder {
    private int type;
    private TextView tvTitle;

    public SearchTitleVH(View itemView, int type) {
        super(itemView);
        this.type = type;
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
    }

    public void handler(TVShowDto dto, int position) {
        if (dto == null) return;
        tvTitle.setText(dto.title);
    }
}
