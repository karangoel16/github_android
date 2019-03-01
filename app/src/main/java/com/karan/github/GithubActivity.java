package com.karan.github;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 *
 */
public class GithubActivity  extends BaseActivity{
    @Nullable
    String username;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            this.username="karangoel16";
            bindFragment(R.id.fragment_container,GithubFragment.newInstance());
        }
    }

}
