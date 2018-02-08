package com.mobile.vivo.Controller.TVShow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;

/**
 * Created by android on 21/12/2017.
 */

public class CoverImageVH extends RecyclerView.ViewHolder {
    private ImageView ivCover;
    private FrameLayout layoutTrans;

    public CoverImageVH(View itemView) {
        super(itemView);
        ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
        layoutTrans = (FrameLayout) itemView.findViewById(R.id.layoutTrans);
    }

    public void handler(TVShowDto dto, int position) {
        layoutTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
