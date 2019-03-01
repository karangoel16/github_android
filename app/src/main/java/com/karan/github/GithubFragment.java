package com.karan.github;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karan.github.feature.user.UserFeatureViewAdapter;
import com.karan.github.feature.user.UserFeatureViewHolder;
import com.karan.github.feature.user.UserSearchViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GithubFragment extends BaseFragment {

    UserFeatureViewAdapter userFeatureViewAdapter;
    RecyclerView recyclerView;
    Context context;
    List<Integer> userFeatureViewHolders;
    OnItemClickListener listener;
    public GithubFragment() {
        super();
        userFeatureViewHolders=new ArrayList<>();

    }


    public GithubFragment setParam(OnItemClickListener listener) {
        userFeatureViewAdapter.setParam(new ArrayList<>(), listener);
        this.listener=listener;
        return this;
    }

    public static GithubFragment newInstance() {
        return new GithubFragment();
    }

    @Override
    protected void bindView(View view) {
        recyclerView = view.findViewById(R.id.rv_user_search);
        recyclerView.setHasFixedSize(true);
        userFeatureViewAdapter = new UserFeatureViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(userFeatureViewAdapter);
        userFeatureViewHolders.add(UserFeatureViewAdapter.USER_SEARCH);
        userFeatureViewAdapter.setParam(userFeatureViewHolders, listener);
        userFeatureViewAdapter.notifyDataSetChanged();
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

    public interface OnItemClickListener {
        void onSearchUserListener();
    }

}
