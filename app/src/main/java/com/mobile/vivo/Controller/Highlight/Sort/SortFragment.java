package com.mobile.vivo.Controller.Highlight.Sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.R;

/**
 * Created by android on 21/12/2017.
 */

public class SortFragment extends Fragment {
    public SortFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.highlight_sort_fragment, container, false);
        return v;
    }
}
