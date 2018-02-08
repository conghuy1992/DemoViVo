package com.mobile.vivo.Controller.Live.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Model.CommentDto;
import com.mobile.vivo.Model.LiveDto;
import com.mobile.vivo.R;

/**
 * Created by android on 28/12/2017.
 */

public class LiveUserCommentVH extends RecyclerView.ViewHolder {
    private TextView tvName, tvComment, tvLike, tvReply;
    private Context context;

    public LiveUserCommentVH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvComment = (TextView) itemView.findViewById(R.id.tvComment);
        tvLike = (TextView) itemView.findViewById(R.id.tvLike);
        tvReply = (TextView) itemView.findViewById(R.id.tvReply);
    }

    public void handler(CommentDto dto, int position) {
        if (dto == null) return;

        tvName.setText(dto.name);

        tvComment.setText(dto.comment);

        tvLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Const.showMsg(context, "LIKE");
            }
        });

        tvReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Const.showMsg(context, "REPLY");
            }
        });
    }
}
