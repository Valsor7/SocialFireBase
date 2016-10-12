package com.socialfirebase.yaroslav.socialfirebase.global;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.AuthCredential;
import com.socialfirebase.yaroslav.socialfirebase.helpers.FireBaseAuthHelper;
import com.socialfirebase.yaroslav.socialfirebase.view.HomeActivity;
import com.socialfirebase.yaroslav.socialfirebase.view.LoginActivity;

import static com.facebook.FacebookSdk.sdkInitialize;

/**
 * Created by yaroslav on 11.10.16.
 */

public class MainApp extends Application {
    private static final String TAG = "MainApp";

    private static MainApp mainApp;

    private FireBaseAuthHelper mAuthHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mainApp = this;
        sdkInitialize(this);
        mAuthHelper = new FireBaseAuthHelper(this);
    }
    public static synchronized MainApp getInstance() {
        return mainApp;
    }

    public void signIn(AuthCredential credential){
        Log.d(TAG, "Sign in");
        mAuthHelper.signIn(credential);
    }

    public void signIn(){
        Log.d(TAG, "Sign in");
        mAuthHelper.signInAnonim();
    }

    public void signOut(){
        Log.d(TAG, "Sign out");
        mAuthHelper.signOut();
        LoginManager.getInstance().logOut();
    }

    public void notifyLoginStatus(boolean loggedIn) {
        if (loggedIn){
            startActivity(new Intent(this, HomeActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }


}
