package com.mobile.vivo.Controller.Live.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.Model.LiveNext;
import com.mobile.vivo.Model.LiveNow;
import com.mobile.vivo.R;

/**
 * Created by android on 28/12/2017.
 */

public class LiveCoverVH extends RecyclerView.ViewHolder {
    TextView tvNowFilm, tvNextFilm, tvNextTime,tvSchedule;

    public LiveCoverVH(View itemView) {
        super(itemView);
        tvNowFilm = (TextView) itemView.findViewById(R.id.tvNowFilm);
        tvNextFilm = (TextView) itemView.findViewById(R.id.tvNextFilm);
        tvNextTime = (TextView) itemView.findViewById(R.id.tvNextTime);
        tvSchedule = (TextView) itemView.findViewById(R.id.tvSchedule);
    }

    public void handler(LiveDto dto, int position) {
        if (dto == null) return;
        LiveNow liveNow = dto.liveNow;
        LiveNext liveNext = dto.liveNext;

        if (liveNow != null) {
            tvNowFilm.setText(liveNow.name);
        }

        if (liveNext != null) {
            tvNextFilm.setText(liveNext.name);
            tvNextTime.setText(liveNext.time);
        }

        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
