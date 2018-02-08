package com.mobile.vivo.Controller.Account.Profile.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Model.ProfileDto;
import com.mobile.vivo.ProfileDetailsActivity;
import com.mobile.vivo.ProfileHistory;
import com.mobile.vivo.R;

/**
 * Created by android on 26/12/2017.
 */

public class ProfileMenuVH extends RecyclerView.ViewHolder {
    private TextView tvTitle;
    private ImageView iv;
    private LinearLayout root;
    private Context context;

    public ProfileMenuVH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        iv = (ImageView) itemView.findViewById(R.id.iv);
        root = (LinearLayout) itemView.findViewById(R.id.root);
    }

    public void handler(final ProfileDto dto, int position) {
        if (dto == null) return;
        tvTitle.setText(dto.titleMenu);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dto.id == Statics.PROFILE_MENU_INFOR) {
                    Intent intent = new Intent(context, ProfileDetailsActivity.class);
                    context.startActivity(intent);
                } else if (dto.id == Statics.PROFILE_MENU_HISTORY) {
                    Intent intent = new Intent(context, ProfileHistory.class);
                    intent.putExtra(Statics.MENU_TITLE, dto.titleMenu);
                    context.startActivity(intent);
                } else if (dto.id == Statics.PROFILE_MENU_FAVORITE) {
                    Intent intent = new Intent(context, ProfileHistory.class);
                    intent.putExtra(Statics.MENU_TITLE, dto.titleMenu);
                    context.startActivity(intent);
                } else if (dto.id == Statics.PROFILE_MENU_DOWNLOAD) {
                } else if (dto.id == Statics.PROFILE_MENU_HOBBY) {
                } else if (dto.id == Statics.PROFILE_MENU_HELP) {
                }
            }
        });
    }
}
