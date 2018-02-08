package com.mobile.vivo.Controller.TVShow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;
import com.mobile.vivo.View.AllLayout;
import com.mobile.vivo.View.ImageLayout;

import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class TVShowManyViewVH extends RecyclerView.ViewHolder {
    private LinearLayout root;
    private Context context;
    private int widthImage;
    private int heightImage;
    private TextView tvTitle;
    public TVShowManyViewVH(View itemView, Context context, int widthImage, int heightImage) {
        super(itemView);
        this.context = context;
        this.widthImage = widthImage;
        this.heightImage = heightImage;
        root = (LinearLayout) itemView.findViewById(R.id.root);
        tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
    }

    public void handler(TVShowDto dto, int position) {
        root.removeAllViews();
        if (dto == null || dto.movieDtoList == null) return;

        tvTitle.setText(dto.title);

        List<MovieDto> list = dto.movieDtoList;
        for (int i = 0; i < list.size(); i++) {
            if (i < Statics.MAX_FILM) {
                root.addView(new ImageLayout(context, list.get(i), widthImage, heightImage));
            } else {
                break;
            }
        }
        if (list.size() >= Statics.MAX_FILM) {
            root.addView(new AllLayout(context, widthImage, heightImage,dto));
        }
    }
}
