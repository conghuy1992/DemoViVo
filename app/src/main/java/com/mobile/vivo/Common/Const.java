package com.mobile.vivo.Common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Model.CommentDto;
import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.Model.LiveNext;
import com.mobile.vivo.Model.LiveNow;
import com.mobile.vivo.Model.MovieDto;
import com.mobile.vivo.Model.ProfileDto;
import com.mobile.vivo.Model.TVShowDto;
import com.mobile.vivo.Model.WaitCategoryDto;
import com.mobile.vivo.Model.WaitDto;
import com.mobile.vivo.R;
import com.mobile.vivo.Model.MenuDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maidinh on 7/24/2017.
 */

public class Const {
    public static void setPictureFromURL(Context context, String url, final ImageView iv) {
//        Log.d(TAG,"url:"+url);
        if (url != null && url.trim().length() > 0) {
            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .listener(new RequestListener<String, Bitmap>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                            // call callback when loading error

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            // call callback when loading success

                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                            int srcWidth = resource.getWidth();
//                            int srcHeight = resource.getHeight();
//                            int dstWidth = (int) (srcWidth * ratio);
//                            int dstHeight = (int) (srcHeight * ratio);
//
//                            Bitmap putImage = createScaledBitmap(resource, dstWidth, dstHeight, true);
                            iv.setImageBitmap(resource);

                        }
                    });
        } else {
            iv.setImageResource(R.drawable.picture_temp);
        }
    }

    public static void showMsg(Context context) {
        Toast.makeText(context, context.getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
    }

    public static void showMsg(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showMsg(Context context, int id) {
        Toast.makeText(context, getMsg(context, id), Toast.LENGTH_SHORT).show();
    }
    public static int getColor(Context context,int color){
        return context.getResources().getColor(color);
    }
    public static String getMsg(Context context, int id) {
        return context.getResources().getString(id);
    }

    public static MenuDto menuLogin(Context context) {
        MenuDto menuDto = new MenuDto();
        menuDto.id = Statics.MENU_LOGIN;
        menuDto.title = Const.getMsg(context, R.string.login);
        return menuDto;
    }

    public static MenuDto menuLine(Context context) {
        MenuDto menuDto = new MenuDto();
        menuDto.id = Statics.MENU_LINE;
        return menuDto;
    }

    public static MenuDto menuNormal(Context context, String msg, int type) {
        MenuDto menuDto = new MenuDto();
        menuDto.icon = R.drawable.ic_menu_camera;
        menuDto.type = type;
        menuDto.id = Statics.MENU_NORMAL;
        menuDto.title = msg;
        return menuDto;
    }

    public static View createItemHighlight(Context context, int title, int icon) {
        View tabOne = LayoutInflater.from(context).inflate(R.layout.custom_tablayout_hightlight, null);
        TextView tvTitle = (TextView) tabOne.findViewById(R.id.tvTitle);
        tvTitle.setText(context.getResources().getString(title));
        ImageView imgIcon = (ImageView) tabOne.findViewById(R.id.imgIcon);
        imgIcon.setImageResource(icon);
//        RelativeLayout lnContainer=(RelativeLayout)tabOne.findViewById(R.id.lnContainer);
//        lnContainer.setBackgroundColor(R.color.background_highlight);

        tabOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return tabOne;
    }

    public static View createItem(Context context, int title, int icon) {
        View tabOne = LayoutInflater.from(context).inflate(R.layout.custom_tablayout_layout, null);
        TextView tvTitle = (TextView) tabOne.findViewById(R.id.tvTitle);
        tvTitle.setText(context.getResources().getString(title));
        ImageView imgIcon = (ImageView) tabOne.findViewById(R.id.imgIcon);
        imgIcon.setImageResource(icon);
        tabOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return tabOne;
    }

    public static List<MovieDto> createMovieDtoList() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MovieDto obj = new MovieDto();
            obj.movieTitle = "Movie " + i;
            obj.type = Statics.TV_SHOW_MANY_VIEW;
            movieDtoList.add(obj);
        }
        return movieDtoList;
    }

    public static int getWidthScreen(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
    public static int getWidthImageMovie(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels/3;
    }
    public static int getHeightImageMovie(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((displayMetrics.widthPixels/3)*Statics.RATIO_HEIGHT_IMAGE);
    }

    public static int getHeightScreen(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getDimenInPx(Context context, int id) {
        return (int) context.getResources().getDimension(id);
    }

//    public static View headerView(Context context, String title) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        View header = inflater.inflate(R.layout.header_layout, null);
//        if (header != null) {
//            TextView tvTitle = (TextView) header.findViewById(R.id.tvTitle);
//            tvTitle.setText(title);
//            ImageView ivAvatar = (ImageView) header.findViewById(R.id.ivAvatar);
//        }
//        return header;
//    }

    public static MovieDto LATEST_NEWS_COVER(int type) {
        MovieDto obj = new MovieDto();
        obj.type = type;
        obj.movieTitle = "Computer use and programmers...";
        obj.time = "3 min ago";
        obj.cine = "cine";
        obj.userName = "John";
        return obj;
    }

    public static MovieDto LATEST_NEWS_TITLE(String msg) {
        MovieDto obj = new MovieDto();
        obj.type = Statics.LATEST_NEWS_TITLE;
        obj.title = msg;
        return obj;
    }

    public static WaitDto categoryList() {
        WaitDto obj = new WaitDto();
        obj.type = Statics.WAIT_CATEGORY;
        List<WaitCategoryDto> waitCategoryDtoList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            WaitCategoryDto dto = new WaitCategoryDto();
            dto.title = "menu: " + i;
            waitCategoryDtoList.add(dto);
        }
        obj.waitCategoryDtoList = waitCategoryDtoList;
        return obj;
    }

    public static TVShowDto waitContent() {
        WaitDto obj = new WaitDto();
        obj.lastNewsDto = Const.LATEST_NEWS_COVER(Statics.WAIT_CONTENT);

        TVShowDto tvShowDto = new TVShowDto();
        tvShowDto.type = Statics.WAIT_CONTENT;
        tvShowDto.waitDto = obj;
        return tvShowDto;
    }

    public static ProfileDto profileMenu(int id, String msg) {
        ProfileDto obj = new ProfileDto();
        obj.type = Statics.PROFILE_MENU;
        obj.titleMenu = msg;
        obj.id = id;
        return obj;
    }

    public static LiveDto liveCover() {
        // add cover
        LiveDto obj = new LiveDto();
        obj.type = Statics.LIVE_COVER;
        LiveNow liveNow = new LiveNow();
        liveNow.name = "LIVE NOW FILM";
        LiveNext liveNext = new LiveNext();
        liveNext.name = "LIVE NEXT FILM";
        liveNext.time = "12:00";

        obj.liveNow = liveNow;
        obj.liveNext = liveNext;
        return obj;
    }

    public static LiveDto liveTitle(String msg) {
        // add cover
        LiveDto obj = new LiveDto();
        obj.type = Statics.LIVE_TITLE;
        obj.title = msg;
        return obj;
    }

    public static LiveDto liveCommentBox() {
        // add cover
        LiveDto obj = new LiveDto();
        obj.type = Statics.LIVE_COMMENT_BOX;
        return obj;
    }

    public static LiveDto liveUserComment() {
        // add cover
        LiveDto obj = new LiveDto();
        obj.type = Statics.LIVE_USER_COMMENT;
        CommentDto commentDto = new CommentDto();
        commentDto.name = "John";
        commentDto.comment = "Great film";
        obj.commentDto=commentDto;
        return obj;
    }
    public static void showKeyBoard(Context context) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void hideKeyboardFrom(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getHeader(){
        Map<String, String> params = new HashMap<>();
        String credentials = "admin"+":"+"admin";
        String auth = "Basic "
                + Base64.encodeToString(credentials.getBytes(),
                Base64.NO_WRAP);
        params.put("Authorization", auth);
        return params;
    }
}
