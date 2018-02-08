package com.mobile.vivo.Controller.News.Wait.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.Model.WaitDto;
import com.mobile.vivo.R;
import com.mobile.vivo.View.WaitCoverLayout;

import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class WaitCoverVH extends RecyclerView.ViewHolder {
    private LinearLayout layoutCover;
    private Context context;

    public WaitCoverVH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        layoutCover = (LinearLayout) itemView.findViewById(R.id.layoutCover);
    }

    public void handler(WaitDto dto, int position) {
        layoutCover.removeAllViews();
        if (dto == null || dto.lastNewsDtoList == null) return;

        List<MovieDto> list = dto.lastNewsDtoList;
        for (MovieDto obj : list) {
            layoutCover.addView(new WaitCoverLayout(context, obj));
        }

    }
}
