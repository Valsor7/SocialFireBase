package com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.anonymous;

import android.app.Activity;
import android.util.Log;

import com.facebook.AccessToken;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.view.LoginActivity;

/**
 * Created by yaroslav on 11.10.16.
 */

public class AnonymusPresenter {
    private static final String TAG = "FacebookPresenter";

    private MainApp mMainApp;
    private LoginActivity mActivity;

    public AnonymusPresenter(Activity activity){
        mActivity = (LoginActivity) activity;
        mMainApp = MainApp.getInstance();
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());

    }

    public void signIn(){
    }

    public void onStart(){

    }

    public void onStop(){

    }

}
