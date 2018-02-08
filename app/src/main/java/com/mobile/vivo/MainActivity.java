package com.mobile.vivo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.HttpRequest;
import com.mobile.vivo.Common.NukeSSLCerts;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Account.AccountFragment;
import com.mobile.vivo.Controller.Live.LiveFragment;
import com.mobile.vivo.Controller.News.NewsFragment;
import com.mobile.vivo.Controller.Search.SearchFragment;
import com.mobile.vivo.Controller.Video.VideoFragment;
import com.mobile.vivo.View.HeaderView;
import com.mobile.vivo.adapters.MenuAdapter;
import com.mobile.vivo.adapters.ViewPagerAdapter;
import com.mobile.vivo.Model.MenuDto;
import com.mobile.vivo.fragments.ChildFragment;
import com.mobile.vivo.fragments.FilmFragment;
import com.mobile.vivo.fragments.LoginFragment;
import com.mobile.vivo.fragments.MusicFragment;
import com.mobile.vivo.fragments.TiviFragment;
import com.mobile.vivo.fragments.TiviShowFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MenuAdapter menuAdapter;
    private Context context;
    private List<MenuDto> menuDtoList;
    private MainActivity in;
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        in = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        View v = Const.headerView(context, Const.getMsg(context, R.string.app_name));
        View v = new HeaderView(context, Const.getMsg(context, R.string.app_name));
        if (v != null && getSupportActionBar() != null) {
            getSupportActionBar().setCustomView(v);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        init();
        initDB();
    }

    void replace_fragment(Fragment fragment) {
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
////        transaction.addToBackStack("fragmentMain");
//        transaction.replace(R.id.root, fragment);
//        transaction.commit();
    }

    private int temp = -1;

    public void choose_menu(int position) {
        close_drawer();
        if (position == 0 && temp != position) {
            replace_fragment(new LoginFragment());
            temp = position;
        } else if (position == 1 && temp != position) {
            replace_fragment(new TiviFragment());
            temp = position;
        } else if (position == 2 && temp != position) {
            replace_fragment(new FilmFragment());
            temp = position;
        } else if (position == 3 && temp != position) {
            replace_fragment(new TiviShowFragment());
            temp = position;
        } else if (position == 4 && temp != position) {
            replace_fragment(new MusicFragment());
            temp = position;
        } else if (position == 5 && temp != position) {
            replace_fragment(new ChildFragment());
            temp = position;
        } else if (position == 6 && temp != position) {
//            replace_fragment(new NewsFragment());
//            temp = position;
        }
    }

    void init() {
        menuDtoList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        menuAdapter = new MenuAdapter(context, menuDtoList, in);
        recyclerView.setAdapter(menuAdapter);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        customTabLayout(tabLayout);
    }


    private void customTabLayout(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setCustomView(Const.createItem(context, R.string.video, R.drawable.ic_video));
        tabLayout.getTabAt(1).setCustomView(Const.createItem(context, R.string.live, R.drawable.ic_video));
        tabLayout.getTabAt(2).setCustomView(Const.createItem(context, R.string.news, R.drawable.ic_video));
        tabLayout.getTabAt(3).setCustomView(Const.createItem(context, R.string.search, R.drawable.ic_video));
        tabLayout.getTabAt(4).setCustomView(Const.createItem(context, R.string.account, R.drawable.ic_video));
        final ViewGroup test = (ViewGroup) (tabLayout.getChildAt(0));
        int tabLen = test.getChildCount();
        for (int i = 0; i < tabLen; i++) {
            View v = test.getChildAt(i);
            v.setPadding(0, 0, 0, 0);
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "position:" + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VideoFragment(), "");
        adapter.addFragment(new LiveFragment(), "");
        adapter.addFragment(new NewsFragment(), "");
        adapter.addFragment(new SearchFragment(), "");
        adapter.addFragment(new AccountFragment(), "");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

    }

    void initDB() {
//        TypedArray ic_list = getResources().obtainTypedArray(R.array.ic_menu);
//        String string_list[] = getResources().getStringArray(R.array.string_menu);
//        int n = ic_list.length();
//        for (int i = 0; i < n; i++) {
//            MenuDto menuDto = new MenuDto();
//            menuDto.title = string_list[i];
//            menuDto.icon = ic_list.getResourceId(i, -1);
//            menuDtoList.add(menuDto);
//        }

        // add login
        menuDtoList.add(Const.menuLogin(context));

        // add line
        menuDtoList.add(Const.menuLine(context));

        // add normal
        menuDtoList.add(Const.menuNormal(context, "TẤT CẢ CHƯƠNG TRÌNH", Statics.MENU_ALL));
        menuDtoList.add(Const.menuNormal(context, "CHƯƠNG TRÌNH NỔI BẬT", Statics.MENU_HIGHTLIGHT));
        menuDtoList.add(Const.menuNormal(context, "VOVI EXCUSIVE", Statics.MENU_VOVI_EXCUSIVE));
        menuDtoList.add(Const.menuNormal(context, "MỚI TRÊN VIVO", Statics.MENU_NEW_VIVO));
        menuDtoList.add(Const.menuNormal(context, "XU HƯỚNG", Statics.MENU_TREND));
        menuDtoList.add(Const.menuNormal(context, "PHIM TRUYỀN HÌNH", Statics.MENU_TV_SERIES));
        menuDtoList.add(Const.menuNormal(context, "PHIM ĐIỆN ẢNH", Statics.MENU_MOVIE));
        menuDtoList.add(Const.menuNormal(context, "TV SHOW", Statics.MENU_TV_SHOW));
        menuDtoList.add(Const.menuNormal(context, "VOVI KIDS", Statics.MENU_VIVO_KIDS));
        menuDtoList.add(Const.menuNormal(context, "TOP VIVO", Statics.MENU_TOP_VIVO));

        // add line
        menuDtoList.add(Const.menuLine(context));

        // add normal
        menuDtoList.add(Const.menuNormal(context, "GIỚI THIỆU", Statics.MENU_INTRO));
        menuDtoList.add(Const.menuNormal(context, "DỊCH VỤ", Statics.MENU_SERVICES));
        menuDtoList.add(Const.menuNormal(context, "THỎA THUẬN", Statics.MENU_AGREE));
        menuDtoList.add(Const.menuNormal(context, "CHÍNH SÁCH", Statics.MENU_POLICY));
        menuDtoList.add(Const.menuNormal(context, "QUẢNG CÁO", Statics.MENU_advertisement));
        menuDtoList.add(Const.menuNormal(context, "ĐỐI TÁC", Statics.MENU_PARTNER));

        menuAdapter.update(menuDtoList);



        Map<String, String> params = new HashMap<>();
        new HttpRequest().menuappvivo(context, params);
    }

    void close_drawer() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}
