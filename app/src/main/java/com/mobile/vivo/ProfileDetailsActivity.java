package com.mobile.vivo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by android on 26/12/2017.
 */

public class ProfileDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private FrameLayout frExchangeHistory, frRenewal;
    private TextView tvLogout,tvChange;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_details_layout);
        context = this;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setTitle("Back");
        }
        initView();
    }

    private void initView() {
        frExchangeHistory = (FrameLayout) findViewById(R.id.frExchangeHistory);
        frExchangeHistory.setOnClickListener(this);

        frRenewal = (FrameLayout) findViewById(R.id.frRenewal);
        frRenewal.setOnClickListener(this);

        tvLogout = (TextView) findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(this);

        tvChange = (TextView) findViewById(R.id.tvChange);
        tvChange.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == frExchangeHistory) {
            Intent intent=new Intent(context,ExChangeHistoryActivity.class);
            startActivity(intent);
        } else if (v == frRenewal) {
            Intent intent=new Intent(context,RenewalActivity.class);
            startActivity(intent);
        }
        else if(v==tvLogout){}
        else if(v==tvChange){}

    }
}
