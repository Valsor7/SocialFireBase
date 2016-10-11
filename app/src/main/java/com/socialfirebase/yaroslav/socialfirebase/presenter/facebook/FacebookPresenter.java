package com.socialfirebase.yaroslav.socialfirebase.presenter.facebook;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.helpers.FireBaseAuthHelper;
import com.socialfirebase.yaroslav.socialfirebase.view.LoginActivity;

/**
 * Created by yaroslav on 11.10.16.
 */

public class FacebookPresenter {

    private static final String TAG = "FacebookPresenter";

    private CallbackManager mFbCallBackManager;
    private MainApp mMainApp;
    private LoginActivity mActivity;

    private FacebookCallback<LoginResult> mFbCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult result) {
            handleFacebookAccessToken(result.getAccessToken());
        }

        @Override
        public void onCancel() {
            mActivity.showError();
        }

        @Override
        public void onError(FacebookException error) {
            mActivity.showError();
        }
    };

    public FacebookPresenter(Activity activity){
        mActivity = (LoginActivity) activity;
        mMainApp = MainApp.getInstance();
        mFbCallBackManager = CallbackManager.Factory.create();
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mMainApp.signIn(credential);
    }

    public void onStart(){

    }

    public void onStop(){

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFbCallBackManager.onActivityResult(requestCode, resultCode, data);
    }


    public FacebookCallback<LoginResult> getFbCallback() {
        return mFbCallback;
    }

    public CallbackManager getFbCallBackManager() {
        return mFbCallBackManager;
    }
}
