package com.mobile.vivo.Controller.Highlight.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.ProgramActivity;
import com.mobile.vivo.R;

/**
 * Created by android on 21/12/2017.
 */

public class MovieVH extends RecyclerView.ViewHolder {
    private TextView tvName;
    private ImageView iv;
    private FrameLayout layoutTrans;
    private Context context;
    private int w, h;
    private RelativeLayout root;

    public MovieVH(View itemView, Context context, int w, int h) {
        super(itemView);
        this.context = context;
        this.w = w;
        this.h = h;
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        iv = (ImageView) itemView.findViewById(R.id.iv);
        layoutTrans = (FrameLayout) itemView.findViewById(R.id.layoutTrans);

        root= (RelativeLayout) itemView.findViewById(R.id.root);
    }

    public void handler(final MovieDto dto, final int position) {
        if (dto == null) return;

        tvName.setText(dto.movieTitle);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w, h);
        int mg = Const.getDimenInPx(context, R.dimen.tv_show_margin_left);
        params.setMargins(0, 0, mg, 0);
        root.setLayoutParams(params);

        layoutTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProgramActivity.class);
                context.startActivity(intent);
            }
        });

    }
}
