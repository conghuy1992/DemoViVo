package com.mobile.vivo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Controller.Account.Profile.ExchangeHistory.ExChangHistoryAdapter;
import com.mobile.vivo.Model.ExChangeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 26/12/2017.
 */

public class ExChangeHistoryActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    private ExChangHistoryAdapter adapter;
    private List<ExChangeDto> exChangeDtoList;
    private RelativeLayout root;
    private TextView tvDate,tvMoney,tvBank;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_history_layout);
        context = this;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(Const.getMsg(context, R.string.payment));
        }
        initView();
    }

    private void initView() {
        root=(RelativeLayout)findViewById(R.id.root);
        root.setBackgroundColor(Const.getColor(context,R.color.colorPrimary));

        tvDate=(TextView)findViewById(R.id.tvDate);
        tvMoney=(TextView)findViewById(R.id.tvMoney);
        tvBank=(TextView)findViewById(R.id.tvBank);

        tvDate.setTextColor(Const.getColor(context,R.color.colorWhite));
        tvMoney.setTextColor(Const.getColor(context,R.color.colorWhite));
        tvBank.setTextColor(Const.getColor(context,R.color.colorWhite));

        exChangeDtoList = new ArrayList<>();
        adapter = new ExChangHistoryAdapter(context, exChangeDtoList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        initDB();
    }

    private void initDB() {
        ExChangeDto obj = new ExChangeDto();
        obj.date = "1/1/2018";
        obj.money = "22.000";
        obj.bank = "Vietcombank";
        exChangeDtoList.add(obj);

        obj = new ExChangeDto();
        obj.date = "1/1/2018";
        obj.money = "22.000";
        obj.bank = "Vietcombank";
        exChangeDtoList.add(obj);

        obj = new ExChangeDto();
        obj.date = "1/1/2018";
        obj.money = "22.000";
        obj.bank = "Vietcombank";
        exChangeDtoList.add(obj);

        adapter.update(exChangeDtoList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }
}
