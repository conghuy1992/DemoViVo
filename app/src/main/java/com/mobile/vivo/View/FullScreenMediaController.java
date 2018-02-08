package com.mobile.vivo.View;

/**
 * Created by android on 27/12/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import com.mobile.vivo.Common.interfaces.OnRotationVideoViewListener;
import com.mobile.vivo.R;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen;
    private String isFullScreen;
    private OnRotationVideoViewListener onRotationVideoViewListener;

    public FullScreenMediaController(Context context, OnRotationVideoViewListener onRotationVideoViewListener) {
        super(context);
        this.onRotationVideoViewListener = onRotationVideoViewListener;
    }

    public void setImageFullScreen(boolean b) {
        if (fullScreen == null) return;
        fullScreen.setImageResource(b ? R.drawable.ic_menu_camera : R.drawable.ic_menu_gallery);
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);

        //image button for full screen to be added to media controller
        fullScreen = new ImageButton(super.getContext());

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT | Gravity.CENTER;
//        params.rightMargin = 80;
        addView(fullScreen, params);

        //fullscreen indicator from intent
        isFullScreen = ((Activity) getContext()).getIntent().
                getStringExtra("fullScreenInd");

        if ("y".equals(isFullScreen)) {
            fullScreen.setImageResource(R.drawable.ic_menu_camera);
        } else {
            fullScreen.setImageResource(R.drawable.ic_menu_gallery);
        }

        //add listener to image button to handle full screen and exit full screen events
        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRotationVideoViewListener != null) onRotationVideoViewListener.onRotation();
//                Intent intent = new Intent(getContext(),MainActivity.class);
//
//                if("y".equals(isFullScreen)){
//                    intent.putExtra("fullScreenInd", "");
//                }else{
//                    intent.putExtra("fullScreenInd", "y");
//                }
//                ((Activity)getContext()).startActivity(intent);
            }
        });
    }
}