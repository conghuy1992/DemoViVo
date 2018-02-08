package com.mobile.vivo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Account.Profile.ProfileAdapter;
import com.mobile.vivo.Model.ProfileDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 26/12/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private String TAG = "ProfileActivity";
    private Context context;
    private RecyclerView recyclerView;
    private ProfileAdapter adapter;
    private List<ProfileDto> profileDtoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        context=this;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setTitle("Back");
        }
        initView();
    }

    private void initView() {
        profileDtoList = new ArrayList<>();
        adapter=new ProfileAdapter(context,profileDtoList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        initBD();
    }
    private void initBD(){
        ProfileDto obj = new ProfileDto();
        obj.type= Statics.PROFILE_COVER;
        obj.userName="John";
        profileDtoList.add(obj);


        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_INFOR,Const.getMsg(context,R.string.information)));
        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_HISTORY,Const.getMsg(context,R.string.history)));
        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_FAVORITE,Const.getMsg(context,R.string.favorite)));
        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_DOWNLOAD,Const.getMsg(context,R.string.download)));
        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_HOBBY,Const.getMsg(context,R.string.hobby)));
        profileDtoList.add(Const.profileMenu(Statics.PROFILE_MENU_HELP,Const.getMsg(context,R.string.help)));

        adapter.update(profileDtoList);
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
