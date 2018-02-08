package com.mobile.vivo.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.ProgramActivity;
import com.mobile.vivo.R;


/**
 * Created by android on 21/12/2017.
 */

public class ImageLayout extends LinearLayout implements View.OnClickListener {
    private Context context;
    private ImageView iv;
    private TextView tvName;
    private MovieDto dto;
    private int widthImage;
    private FrameLayout root;
    private int heightImage;
    private LinearLayout layoutTrans;

    public ImageLayout(Context context, MovieDto dto, int widthImage, int heightImage) {
        super(context);
        this.context = context;
        this.dto = dto;
        this.widthImage = widthImage;
        this.heightImage = heightImage;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.image_layout, this, true);
        tvName = (TextView) findViewById(R.id.tvName);
        iv = (ImageView) findViewById(R.id.iv);
        root = (FrameLayout) findViewById(R.id.root);

        layoutTrans = (LinearLayout) findViewById(R.id.layoutTrans);
        layoutTrans.setOnClickListener(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthImage, heightImage);
        int mg = Const.getDimenInPx(context, R.dimen.tv_show_margin_left);
        params.setMargins(0, 0, mg, 0);
        root.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        if (v == layoutTrans) {
            Intent intent=new Intent(context,ProgramActivity.class);
            context.startActivity(intent);
        }
    }
}
