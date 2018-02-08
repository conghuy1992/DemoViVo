package com.mobile.vivo.Controller.News.Wait.ViewHolder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobile.vivo.Controller.News.Wait.ViewHolder.Adapter.WaitCategoryAdapter;
import com.mobile.vivo.Model.WaitCategoryDto;
import com.mobile.vivo.Model.WaitDto;
import com.mobile.vivo.R;

import java.util.ArrayList;

/**
 * Created by android on 25/12/2017.
 */

public class WaitCategoryVH extends RecyclerView.ViewHolder {
    private RecyclerView recyclerView;
    private WaitCategoryAdapter adapter;
    private Context context;

    public WaitCategoryVH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        adapter = new WaitCategoryAdapter(context, new ArrayList<WaitCategoryDto>());
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setAdapter(adapter);
    }

    public void handler(WaitDto dto, int position) {
        if (dto == null || dto.waitCategoryDtoList == null) return;

        adapter.update(dto.waitCategoryDtoList);
    }
}
