package com.mobile.vivo.Controller.About;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.R;

/**
 * Created by android on 28/12/2017.
 */

public class AgreeFragment extends Fragment {

    private void initView(View v) {
    }


    public AgreeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_agree_fragment, container, false);
        initView(v);
        return v;
    }
}
