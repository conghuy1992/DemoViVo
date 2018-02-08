package com.mobile.vivo.Controller.News.LatestNews.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

/**
 * Created by android on 25/12/2017.
 */

public class LatestNewsCoverVH extends RecyclerView.ViewHolder {
    private ImageView ivCover,ivLike,ivShare;
    private TextView tvTitle, tvName, tvMinute, tvCine, tvCineBig;
    private int type;
    private LinearLayout layoutCineBig,root;

    public LatestNewsCoverVH(View itemView, int type) {
        super(itemView);
        this.type = type;
        ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
        ivLike = (ImageView) itemView.findViewById(R.id.ivLike);
        ivShare = (ImageView) itemView.findViewById(R.id.ivShare);


        tvCine = (TextView) itemView.findViewById(R.id.tvCine);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvMinute = (TextView) itemView.findViewById(R.id.tvMinute);

        root = (LinearLayout) itemView.findViewById(R.id.root);
        layoutCineBig = (LinearLayout) itemView.findViewById(R.id.layoutCineBig);
        tvCineBig = (TextView) itemView.findViewById(R.id.tvCineBig);
    }

    public void handler(MovieDto dto, int position) {
        if (dto == null) return;

        tvCine.setVisibility(type==Statics.VIDEOS_HOT?View.GONE:View.VISIBLE);
        if (layoutCineBig != null) {
            if (type == Statics.WAIT_COVER) {
                layoutCineBig.setVisibility(View.VISIBLE);
                tvCine.setVisibility(View.GONE);
            } else {
                layoutCineBig.setVisibility(View.GONE);
                tvCine.setVisibility(View.VISIBLE);
            }
        }



        ivCover.setVisibility(type == Statics.LATEST_NEWS_TREND ? View.GONE : View.VISIBLE);

        tvCine.setText(dto.cine);

        tvTitle.setText(dto.movieTitle);

        tvName.setText(dto.userName);

        tvMinute.setText(dto.time);

        ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
