package com.mobile.vivo.Controller.Account.Profile.ExchangeHistory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.ExChangeDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 26/12/2017.
 */

public class ExChangHistoryAdapter extends RecyclerView.Adapter<ExChangHistoryAdapter.MyViewHolder> {
    private String TAG = "ExChangHistoryAdapter";
    private List<ExChangeDto> exChangeDtoList;
    private Context context;


    public void update(List<ExChangeDto> exChangeDtoList) {
        if (exChangeDtoList == null) return;
        this.exChangeDtoList = exChangeDtoList;
        this.notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDate, tvMoney, tvBank;
        private RelativeLayout root;

        public MyViewHolder(View view) {
            super(view);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvMoney = (TextView) view.findViewById(R.id.tvMoney);
            tvBank = (TextView) view.findViewById(R.id.tvBank);

            root = (RelativeLayout) view.findViewById(R.id.root);
        }

        public void handler(final ExChangeDto dto, final int position) {

            if (dto == null) return;

            tvDate.setText(dto.date);
            tvMoney.setText(dto.money);
            tvBank.setText(dto.bank);

            int color = position % 2 == 0 ? Const.getColor(context, R.color.colorWhite) : Const.getColor(context, R.color.colorDevice);
            root.setBackgroundColor(color);

        }
    }


    public ExChangHistoryAdapter(Context context, List<ExChangeDto> exChangeDtoList) {
        this.context = context;
        this.exChangeDtoList = exChangeDtoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exchange_history_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ExChangeDto dto = exChangeDtoList.get(position);
        holder.handler(dto, position);
    }

    @Override
    public int getItemCount() {
        return exChangeDtoList.size();
    }
}