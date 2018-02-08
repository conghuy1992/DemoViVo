package com.mobile.vivo.Controller.Live.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.R;
import com.mobile.vivo.View.CommentDialog;

/**
 * Created by android on 28/12/2017.
 */

public class LiveCommentBoxVH extends RecyclerView.ViewHolder {
    private TextView tvComment;
    private Context context;

    public LiveCommentBoxVH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        tvComment = (TextView) itemView.findViewById(R.id.tvComment);
    }

    public void handler(LiveDto dto, int position) {
        if (dto == null) return;

        tvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommentDialog(context).show();
            }
        });
    }
}
