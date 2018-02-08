package com.mobile.vivo.Controller.Account;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.vivo.LoginActivity;
import com.mobile.vivo.R;

/**
 * Created by android on 20/12/2017.
 */

public class AccountFragment extends Fragment implements View.OnClickListener{
    private TextView tvLogin,tvExperience;
    private void initView(View v){
        tvLogin=(TextView)v.findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);

        tvExperience=(TextView)v.findViewById(R.id.tvExperience);
        tvExperience.setOnClickListener(this);
    }

    public AccountFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_account_fragment, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v==tvLogin){
            Intent intent=new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
        else if(v==tvExperience){}
    }
}
