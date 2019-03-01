package com.karan.github;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        this.initializeActivity(savedInstanceState);
    }

    public void setTitle(String title){
        ActionBar supportActionBar= getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setTitle(title);
        }
    }

    @LayoutRes
    protected int layoutId(){return R.layout.activity_main;}

    protected abstract void initializeActivity(Bundle savedInstanceState);

    protected void bindFragment(int layoutId, Fragment fragment){
        this.getSupportFragmentManager().beginTransaction().replace(layoutId,fragment).commit();
    }
}
