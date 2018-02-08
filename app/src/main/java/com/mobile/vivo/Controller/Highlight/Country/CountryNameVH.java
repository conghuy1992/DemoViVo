package com.mobile.vivo.Controller.Highlight.Country;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.CountryDto;
import com.mobile.vivo.R;

/**
 * Created by android on 21/12/2017.
 */

public class CountryNameVH extends RecyclerView.ViewHolder {
    private TextView tvName;

    public CountryNameVH(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
    }

    public void handler(final CountryDto dto, final int position) {
        tvName.setText(dto.title);
    }
}
