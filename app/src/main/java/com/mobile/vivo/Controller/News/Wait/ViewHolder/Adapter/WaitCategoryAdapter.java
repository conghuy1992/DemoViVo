package com.mobile.vivo.Controller.News.Wait.ViewHolder.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobile.vivo.Model.WaitCategoryDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 25/12/2017.
 */

public class WaitCategoryAdapter extends RecyclerView.Adapter<WaitCategoryAdapter.MyViewHolder> {
    private String TAG = "WaitCategoryAdapter";
    private List<WaitCategoryDto> waitCategoryDtoList;
    private Context context;

    public List<WaitCategoryDto> getList() {
        return waitCategoryDtoList;
    }

    public WaitCategoryAdapter(Context context, List<WaitCategoryDto> waitCategoryDtoList) {
        this.context = context;
        this.waitCategoryDtoList = waitCategoryDtoList;
    }

    public void update(List<WaitCategoryDto> waitCategoryDtoList) {
        if (waitCategoryDtoList == null) return;
        this.waitCategoryDtoList = waitCategoryDtoList;
        this.notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private RelativeLayout root,layoutTrans;
        private ImageView iv;
//        private FrameLayout layoutBackground;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            layoutTrans = (RelativeLayout) view.findViewById(R.id.layoutTrans);
            root = (RelativeLayout) view.findViewById(R.id.root);
            iv = (ImageView) view.findViewById(R.id.iv);
//            ic_star = (ImageView) view.findViewById(R.id.ic_star);
//            layoutBackground = (FrameLayout) view.findViewById(R.id.layoutBackground);
        }

        public void handler(final WaitCategoryDto dto, final int position) {
            if (dto == null) return;

            tvTitle.setText(dto.title);

            layoutTrans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_fragment_wait_category_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final WaitCategoryDto dto = waitCategoryDtoList.get(position);
        holder.handler(dto, position);
    }

    @Override
    public int getItemCount() {
        return waitCategoryDtoList.size();
    }
}