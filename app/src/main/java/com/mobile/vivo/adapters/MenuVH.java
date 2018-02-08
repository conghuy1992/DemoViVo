package com.mobile.vivo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.vivo.AboutActivity;
import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.HighlightActivity;
import com.mobile.vivo.MainActivity;
import com.mobile.vivo.R;
import com.mobile.vivo.Model.MenuDto;
import com.mobile.vivo.TVShowActivity;

/**
 * Created by android on 21/12/2017.
 */

public class MenuVH extends RecyclerView.ViewHolder {
    private ImageView menu_ic;
    private TextView menu_title;
    private LinearLayout menu_root;
    private MainActivity in;
    private Context context;

    public MenuVH(View view, MainActivity in, Context context) {
        super(view);
        this.in = in;
        this.context = context;
        menu_ic = (ImageView) view.findViewById(R.id.menu_ic);
        menu_title = (TextView) view.findViewById(R.id.menu_title);
        menu_root = (LinearLayout) view.findViewById(R.id.menu_root);
    }

    public void handler(final MenuDto menuDto, final int position) {
        menu_title.setText(menuDto.title);
        menu_ic.setImageResource(menuDto.icon);
        menu_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                in.choose_menu(position);
                if (menuDto.type == Statics.MENU_VOVI_EXCUSIVE) {
                    Intent intent = new Intent(context, HighlightActivity.class);
                    intent.putExtra(Statics.MENU_TITLE, menuDto.title);
                    context.startActivity(intent);
                } else if (menuDto.type == Statics.MENU_TV_SHOW
                        || menuDto.type == Statics.MENU_TV_SERIES
                        || menuDto.type == Statics.MENU_MOVIE
                        || menuDto.type == Statics.MENU_VIVO_KIDS) {
                    Intent intent = new Intent(context, TVShowActivity.class);
                    intent.putExtra(Statics.MENU_TITLE, menuDto.title);
                    context.startActivity(intent);
                }
                else if (menuDto.type == Statics.MENU_INTRO
                        || menuDto.type == Statics.MENU_SERVICES
                        || menuDto.type == Statics.MENU_AGREE
                        || menuDto.type == Statics.MENU_POLICY
                        || menuDto.type == Statics.MENU_advertisement
                        || menuDto.type == Statics.MENU_PARTNER) {
//                    Const.showMsg(context,"type:"+menuDto.type);
                    Intent intent = new Intent(context, AboutActivity.class);
                    intent.putExtra(Statics.MENU_OBJECT, menuDto);
                    context.startActivity(intent);
                }
            }
        });
    }
}
