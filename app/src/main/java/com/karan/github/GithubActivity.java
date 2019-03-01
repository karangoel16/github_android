package com.karan.github;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.karan.github.feature.user.UserFeatureViewAdapter;

/**
 *
 */
public class GithubActivity  extends BaseActivity implements GithubFragment.OnItemClickListener{
    
    private static final String TAG = GithubActivity.class.getSimpleName();
    @Nullable
    String username;

    UserFeatureViewAdapter userFeatureViewAdapter;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public void initUI() {
        userFeatureViewAdapter=new UserFeatureViewAdapter();


    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            this.username="karangoel16";
            bindFragment(R.id.fragment_container,GithubFragment.newInstance());
        }
    }


    @Override
    public void onSearchUserListener() {
        Log.d(TAG,"hello");
    }
}
