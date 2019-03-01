package com.karan.github.feature.user;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.karan.github.GithubFragment;

public class UserSearchViewHolder extends UserFeatureViewHolder{
    GithubFragment.OnItemClickListener listener;
    public UserSearchViewHolder(@NonNull View itemView, GithubFragment.OnItemClickListener listener) {
        super(itemView);
        this.listener=listener;
    }

    @Override
    public int getViewType() {
        return UserFeatureViewAdapter.USER_SEARCH;
    }

    @Override
    public void bind() {
        itemView.setOnClickListener(listener->this.listener.onSearchUserListener());
    }

}
