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
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.R;
import com.mobile.vivo.TVShowActivity;

/**
 * Created by android on 21/12/2017.
 */

public class AllLayout extends LinearLayout implements View.OnClickListener {
    private String TAG = "AllLayout";
    private LinearLayout layoutTrans;
    private FrameLayout root;
    private int widthImage;
    private int heightImage;
    private Context context;
    private TVShowDto dto;

    public AllLayout(Context context, int widthImage, int heightImage, TVShowDto dto) {
        super(context);
        this.context = context;
        this.widthImage = widthImage;
        this.heightImage = heightImage;
        this.dto=dto;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.all_movie_layout, this, true);
        layoutTrans = (LinearLayout) findViewById(R.id.layoutTrans);
        layoutTrans.setOnClickListener(this);
        root = (FrameLayout) findViewById(R.id.root);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthImage, heightImage);
        int mg = Const.getDimenInPx(context,R.dimen.tv_show_margin_left);
        params.setMargins(mg,0,mg,0);
        root.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        if (v == layoutTrans) {
            if(dto.MENU_ID!=0)
            {
                Intent intent = new Intent(context, TVShowActivity.class);
                intent.putExtra(Statics.MENU_TITLE, dto.title);
                context.startActivity(intent);
            }
        }
    }
}
