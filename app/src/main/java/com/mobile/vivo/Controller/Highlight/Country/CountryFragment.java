package com.mobile.vivo.Controller.Highlight.Country;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Model.CountryDto;
import com.mobile.vivo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 21/12/2017.
 */

public class CountryFragment extends Fragment {
    private String TAG = "CountryFragment";
    private RecyclerView recyclerView;
    private List<CountryDto> countryDtoList;
    private CountryAdapter adapter;

    private void initView(View v) {
        countryDtoList = new ArrayList<>();
        adapter = new CountryAdapter(getActivity(), countryDtoList);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        initDB();
    }

    private void initDB() {
        CountryDto obj = new CountryDto();
        obj.title = "Viet Nam";
        countryDtoList.add(obj);

        obj = new CountryDto();
        obj.title = "Han Quoc";
        countryDtoList.add(obj);

        obj = new CountryDto();
        obj.title = "Nhat ban";
        countryDtoList.add(obj);

        obj = new CountryDto();
        obj.title = "Trung Quoc";
        countryDtoList.add(obj);

        obj = new CountryDto();
        obj.title = "Thai Lan";
        countryDtoList.add(obj);

        adapter.update(countryDtoList);

    }

    public CountryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.highlight_country_fragment, container, false);
        initView(v);
        return v;
    }
}
