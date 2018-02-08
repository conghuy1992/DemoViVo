package com.mobile.vivo.View;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.R;

/**
 * Created by android on 28/12/2017.
 */

public class CommentDialog extends BottomSheetDialog implements View.OnClickListener {
    private String TAG = "CommentDialog";
    private EditText edComment;
    private ImageView ivSend;
    private Context context;

    public CommentDialog(@NonNull final Context context) {
        super(context);
        this.context = context;

        setCanceledOnTouchOutside(false);

        setContentView(R.layout.comment_layout);

        edComment = (EditText) findViewById(R.id.edComment);
        ivSend = (ImageView) findViewById(R.id.ivSend);
        ivSend.setOnClickListener(this);

        edComment.setText("");
        edComment.requestFocus();
        Const.showKeyBoard(context);

//        setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                Const.showMsg(context,"onDismiss");
//                Const.hideKeyboardFrom(context, edComment);
//                dialog.dismiss();
////                String s = ed_comment.getText().toString().trim();
////                if (s.length() > 0) {
////                    dialogConfirm(dialogComment);
////                } else {
////                    Const.hideKeyboardFrom(context, ed_comment);
////                    dialog.dismiss();
////                }
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE)
                && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            Log.d(TAG, "view != null");
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom()) {

                Log.d(TAG, "dispatchTouchEvent");
                if (edComment != null && isShowing()) {
                    Log.d(TAG, "ed_comment != null");
                    String s = edComment.getText().toString().trim();
                    if (s.length() > 0) {
                        confirm();
                    } else {
                        Const.hideKeyboardFrom(context, edComment);
//                                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
                        dismiss();
                    }
                }

            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private void confirm() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set dialog message
        alertDialogBuilder
                .setMessage(Const.getMsg(context, R.string.remove_cmt))
                .setCancelable(false)
                .setPositiveButton(Const.getMsg(context, R.string.remove), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Const.hideKeyboardFrom(context, edComment);
                        dismiss();
                        dialog.cancel();
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                isShow = true;
//                            }
//                        }, 500);
                    }
                })
                .setNegativeButton(Const.getMsg(context, R.string.continue_cmt), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
//                        isShow = true;
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == ivSend) {
        }
    }
}
