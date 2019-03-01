package com.karan.github.feature.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class UserFeatureViewHolder extends RecyclerView.ViewHolder {

    public UserFeatureViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract int getViewType();
    public abstract void bind();
}
