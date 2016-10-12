package com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.anonymous;

import android.app.Activity;

import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.view.LoginActivity;

/**
 * Created by yaroslav on 11.10.16.
 */

public class AnonymousPresenter {
    private static final String TAG = "AnonymousPresenter";

    private MainApp mMainApp;
    private LoginActivity mActivity;

    public AnonymousPresenter(Activity activity){
        mActivity = (LoginActivity) activity;
        mMainApp = MainApp.getInstance();
    }

    public void signIn(){
        mMainApp.signIn();
    }

    public void onStart(){

    }

    public void onStop(){

    }

}
