package com.karan.github.feature.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.karan.github.GithubFragment;
import com.karan.github.R;

import java.util.ArrayList;
import java.util.List;

public class UserFeatureViewAdapter extends RecyclerView.Adapter<UserFeatureViewHolder> {

    List<Integer> userFeatureViewHolders;

    //This is for user search feature
    public static final int USER_SEARCH = 0;

    public static final int DEFAULT = -1;

    GithubFragment.OnItemClickListener listener;

    public UserFeatureViewAdapter() {
        userFeatureViewHolders = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserFeatureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        UserFeatureViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (userFeatureViewHolders.get(i)) {
            case USER_SEARCH:
                viewHolder = new UserSearchViewHolder(inflater.inflate(R.layout.item_user_search, viewGroup, false),listener);
                break;

        }
        return viewHolder;
    }

    public UserFeatureViewAdapter setParam(List<Integer> userFeatureViewHolders, GithubFragment.OnItemClickListener listener) {
        this.userFeatureViewHolders = userFeatureViewHolders;
        this.listener=listener;
        return this;
    }

    @Override
    public void onBindViewHolder(@NonNull UserFeatureViewHolder userFeatureViewHolder, int i) {
        switch (userFeatureViewHolders.get(i)) {
            case USER_SEARCH:
                ((UserSearchViewHolder) userFeatureViewHolder).bind();
                break;
            default:
        }
    }

    @Override
    public int getItemCount() {
        return userFeatureViewHolders.size();
    }
}
