package com.mobile.vivo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.About.AdvertisementFragment;
import com.mobile.vivo.Controller.About.AgreeFragment;
import com.mobile.vivo.Controller.About.IntroFragment;
import com.mobile.vivo.Controller.About.PartnerFragment;
import com.mobile.vivo.Controller.About.PolicyFragment;
import com.mobile.vivo.Controller.About.ServicesFragment;
import com.mobile.vivo.Model.MenuDto;

/**
 * Created by android on 28/12/2017.
 */

public class AboutActivity extends AppCompatActivity {
    private String TAG = "AboutActivity";
    private Context context;
    private MenuDto menuDto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        context = this;

        Intent intent = getIntent();
        menuDto = (MenuDto) intent.getSerializableExtra(Statics.MENU_OBJECT);
        if (menuDto == null) return;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(menuDto.title);
        }

        if(menuDto.type == Statics.MENU_INTRO) addFragment(new IntroFragment());
        else if(menuDto.type == Statics.MENU_SERVICES) addFragment(new ServicesFragment());
        else if(menuDto.type == Statics.MENU_AGREE) addFragment(new AgreeFragment());
        else if(menuDto.type == Statics.MENU_POLICY) addFragment(new PolicyFragment());
        else if(menuDto.type == Statics.MENU_advertisement) addFragment(new AdvertisementFragment());
        else if(menuDto.type == Statics.MENU_PARTNER) addFragment(new PartnerFragment());

    }

    private void addFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack("fragmentMain");
        transaction.replace(R.id.root, fragment);
        transaction.commit();
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
