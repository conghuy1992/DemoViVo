package com.mobile.vivo.Controller.Account.Profile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.vivo.Common.interfaces.Statics;
import com.mobile.vivo.Controller.Account.Profile.ViewHolder.ProfileCoverVH;
import com.mobile.vivo.Controller.Account.Profile.ViewHolder.ProfileMenuVH;
import com.mobile.vivo.Model.ProfileDto;
import com.mobile.vivo.R;

import java.util.List;

/**
 * Created by android on 26/12/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ProfileDto> profileDtoList;
    private String TAG = "ProfileAdapter";

    public ProfileAdapter(Context context, List<ProfileDto> profileDtoList) {
        this.context = context;
        this.profileDtoList = profileDtoList;
    }

    public void update(List<ProfileDto> profileDtoList) {
        if (profileDtoList == null) return;
        this.profileDtoList = profileDtoList;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == Statics.PROFILE_COVER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.profile_cover, parent, false);
            vh = new ProfileCoverVH(v);
        } else {//PROFILE_MENU
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.profile_menu, parent, false);
            vh = new ProfileMenuVH(v,context);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProfileDto tvShowDto = profileDtoList.get(position);
        if (holder instanceof ProfileCoverVH) {
            ((ProfileCoverVH) holder).handler(tvShowDto, position);
        } else if (holder instanceof ProfileMenuVH) {
            ((ProfileMenuVH) holder).handler(tvShowDto, position);
        }
//        else if (holder instanceof TVShowLoadMoreVH) {
//            ((TVShowLoadMoreVH) holder).handler(tvShowDto, position);
//        }


    }

    @Override
    public int getItemViewType(int position) {
        return profileDtoList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return profileDtoList.size();
    }
}