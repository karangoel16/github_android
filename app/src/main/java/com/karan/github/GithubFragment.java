package com.karan.github;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 */
public class GithubFragment extends BaseFragment {

    public GithubFragment(){

    }
    public static GithubFragment newInstance() {
        return new GithubFragment();
    }

    @Override
    protected void bindView(View view) {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_container;
    }
}
