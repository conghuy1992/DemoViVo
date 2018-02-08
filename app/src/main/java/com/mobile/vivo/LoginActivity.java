package com.mobile.vivo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;

/**
 * Created by android on 22/12/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private TextView tvFacebook,tvGoogle,tvLogin,tvFogetPw,tvRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        context=this;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(Const.getMsg(context,R.string.login));
        }

        initView();
    }
    private void initView(){
        tvFacebook=(TextView)findViewById(R.id.tvFacebook);
        tvFacebook.setOnClickListener(this);

        tvGoogle=(TextView)findViewById(R.id.tvGoogle);
        tvGoogle.setOnClickListener(this);

        tvLogin=(TextView)findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);

        tvFogetPw=(TextView)findViewById(R.id.tvFogetPw);
        tvFogetPw.setOnClickListener(this);

        tvRegister=(TextView)findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(this);
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
        if(v==tvFacebook){}
        else if(v==tvGoogle){}
        else if(v==tvLogin){}
        else if(v==tvFogetPw){}
        else if(v==tvRegister){}
    }
}
