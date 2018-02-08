package com.mobile.vivo.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.ProfileActivity;
import com.mobile.vivo.R;


/**
 * Created by android on 26/12/2017.
 */

public class HeaderView extends LinearLayout implements View.OnClickListener {
    private ImageView ivAvatar;
    private Context context;

    public HeaderView(Context context, String title) {
        super(context);
        this.context = context;
        init(context, title);
    }

    private void init(Context context, String title) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.header_layout, this, true);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        ivAvatar = (ImageView) findViewById(R.id.ivAvatar);
        ivAvatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ivAvatar) {
            Intent intent = new Intent(context, ProfileActivity.class);
            context.startActivity(intent);
        }
    }
}
