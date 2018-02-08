package com.mobile.vivo.Controller.Highlight.Country;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Model.CountryDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<CountryDto> countryDtoList;
    private String TAG = "CountryAdapter";

    public CountryAdapter(Context context, List<CountryDto> countryDtoList) {
        this.context = context;
        this.countryDtoList = countryDtoList;
    }

    public void update(List<CountryDto> countryDtoList) {
        if (countryDtoList == null) return;
        this.countryDtoList = countryDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == 1) {
            vh = null;
//            View v = LayoutInflater.from(parent.getContext()).inflate(
//                    R.layout.loading_layout, parent, false);
//            vh = new LoadingHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.highlight_country_name, parent, false);
            vh = new CountryNameVH(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryDto videoDto = countryDtoList.get(position);
        if (holder instanceof CountryNameVH) {
            ((CountryNameVH) holder).handler(videoDto, position);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return countryDtoList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return countryDtoList.size();
    }
}