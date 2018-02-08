package com.mobile.vivo.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.R;

/**
 * Created by android on 25/12/2017.
 */

public class WaitCoverLayout extends LinearLayout implements View.OnClickListener {
    private Context context;
    private MovieDto dto;
    private FrameLayout root;
    private LinearLayout layoutTrans;
    private TextView tvCine, tvTitle, tvName, tvMinute;
    private ImageView ivLike, ivShare;

    public WaitCoverLayout(Context context, MovieDto dto) {
        super(context);
        this.context = context;
        this.dto = dto;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.wait_cover_layout, this, true);
        tvCine = (TextView) findViewById(R.id.tvCine);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvName = (TextView) findViewById(R.id.tvName);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        ivLike = (ImageView) findViewById(R.id.ivLike);
        ivLike.setOnClickListener(this);
        ivShare = (ImageView) findViewById(R.id.ivShare);
        ivShare.setOnClickListener(this);

        tvCine.setText(dto.cine);
        tvTitle.setText(dto.movieTitle);
        tvName.setText(dto.userName);
        tvMinute.setText(dto.time);

        root = (FrameLayout) findViewById(R.id.root);
        layoutTrans = (LinearLayout) findViewById(R.id.layoutTrans);
        layoutTrans.setOnClickListener(this);

        int width = Const.getDimenInPx(context, R.dimen.wait_cover_width);
        int height = Const.getDimenInPx(context, R.dimen.wait_cover_height);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        int mg = Const.getDimenInPx(context, R.dimen.wait_cover_margin_left);
        params.setMargins(0, 0, mg, 0);
        root.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        if (v == layoutTrans) {
        } else if (v == ivLike) {
        } else if (v == ivShare) {
        }
    }
}
