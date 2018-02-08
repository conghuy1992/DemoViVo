package com.mobile.vivo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.MainActivity;
import com.mobile.vivo.R;
import com.mobile.vivo.Model.MenuDto;

import java.util.List;

/**
 * Created by maidinh on 7/24/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MenuDto> menuDtoList;
    private MainActivity in;

    public MenuAdapter(Context context, List<MenuDto> menuDtoList, MainActivity in) {
        this.context = context;
        this.menuDtoList = menuDtoList;
        this.in = in;
    }

    public void update(List<MenuDto> menuDtoList) {
        if (menuDtoList == null) return;
        this.menuDtoList = menuDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.menu_adapter_layout, parent, false);
//
//        return new MyViewHolder(itemView);

        RecyclerView.ViewHolder vh;
        if (viewType == Statics.MENU_LOGIN) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.menu_login_layout, parent, false);
            vh = new LoginVH(v);
        } else if (viewType == Statics.MENU_LINE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.line_layout, parent, false);
            vh = new LineVH(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.menu_adapter_layout, parent, false);
            vh = new MenuVH(v, in,context);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuDto menuDto = menuDtoList.get(position);
        if (holder instanceof MenuVH) {
            ((MenuVH) holder).handler(menuDto, position);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return menuDtoList.get(position).id;
    }

    @Override
    public int getItemCount() {
        return menuDtoList.size();
    }
}